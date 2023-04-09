package com.api.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/api/bank")
public class BankController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	BankDAO dao;
    public BankController() {
        super();
        dao = Factory.bank();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow_origin", "*");
		response.setCharacterEncoding("UTF-8");
		
		String data = new Gson().toJson(dao.doGet());
		PrintWriter out = response.getWriter();
		out.print(data);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("UTF-8");
		
		String body = request.getReader().lines().collect(Collectors.joining());
		Bank data = new Gson().fromJson(body, Bank.class);
		
		PrintWriter out = response.getWriter();
		try {
			dao.doPost(data);
			dao.doCommit();
			out.print("Bank persisted with success");
		} catch (Exception e) {
			out.print(e.getStackTrace());
		}
	}

}
