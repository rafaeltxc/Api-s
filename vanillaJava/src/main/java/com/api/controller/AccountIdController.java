package com.api.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.bean.Account;
import com.api.dao.AccountDAO;
import com.api.factory.ConnectionFactory;
import com.google.gson.Gson;

@WebServlet("/api/account/*")
public class AccountIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	AccountDAO dao;
    public AccountIdController() {
        super();
        dao = ConnectionFactory.acc();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		List<String> uriAsList = Arrays.asList(uri.split("/"));
		int accountId = Integer.parseInt(uriAsList.get(uriAsList.size()-1));
		
		String data = new Gson().toJson(dao.doGetById(accountId));
		PrintWriter out = response.getWriter();
		out.print(data);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		List<String> uriAsList = Arrays.asList(uri.split("/"));
		int accountId = Integer.parseInt(uriAsList.get(uriAsList.size()-1));
		
		String body = request.getReader().lines().collect(Collectors.joining());
		Account data = new Gson().fromJson(body, Account.class);
		
		PrintWriter out = response.getWriter();
		try {
			dao.doUpdate(accountId, data);
			out.print("Account updated with success");
		} catch (Exception e) {
			out.print(e.getStackTrace());
		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		List<String> uriAsList = Arrays.asList(uri.split("/"));
		int accountId = Integer.parseInt(uriAsList.get(uriAsList.size()-1));
		
		PrintWriter out = response.getWriter();
		try {
			dao.doDelete(accountId);
			out.print("Account deleted with success");
		} catch (Exception e) {
			out.print(e.getStackTrace());
		}
	}

}
