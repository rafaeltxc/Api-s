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

import com.api.bean.Bank;
import com.api.dao.BankDAO;
import com.api.factory.Factory;
import com.google.gson.Gson;

@WebServlet("/api/bank/*")
public class BankIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	BankDAO dao;
    public BankIdController() {
        super();
        dao = Factory.bank();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow_origin", "*");
		response.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		List<String> uriAsList = Arrays.asList(uri.split("/"));
		int bankId = Integer.parseInt(uriAsList.get(uriAsList.size()-1));
		
		String data = new Gson().toJson(dao.doGetById(bankId));
		PrintWriter out = response.getWriter();
		out.print(data);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow_origin", "*");
		response.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		List<String> uriAsList = Arrays.asList(uri.split("/"));
		int bankId = Integer.parseInt(uriAsList.get(uriAsList.size()-1));
		
		String body = request.getReader().lines().collect(Collectors.joining());
		Bank data = new Gson().fromJson(body, Bank.class);
		
		PrintWriter out = response.getWriter();
		try {
			dao.doUpdate(bankId, data);
			dao.doCommit();
			out.print("Account updated with success");
		} catch (Exception e) {
			out.print(e.getStackTrace());
		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow_origin", "*");
		response.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		List<String> uriAsList = Arrays.asList(uri.split("/"));
		int bankId = Integer.parseInt(uriAsList.get(uriAsList.size()-1));
		
		PrintWriter out = response.getWriter();
		try {
			dao.doRemove(bankId);
			dao.doCommit();
			out.print("Account deleted with success");
		} catch (Exception e) {
			out.print(e.getStackTrace());
		}
	}

}
