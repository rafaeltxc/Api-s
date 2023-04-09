package com.api.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.bean.User;
import com.api.dao.UserDAO;
import com.api.factory.ConnectionFactory;
import com.google.gson.Gson;

@WebServlet("/api/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserDAO dao;
    public UserController() {
        super();
        dao = ConnectionFactory.user();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("UTF-8");
		
		String data = new Gson().toJson(dao.doGet());
		PrintWriter out = response.getWriter();
		out.print(data);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("UTF-8");
		
		String body = request.getReader().lines().collect(Collectors.joining());
		User data = new Gson().fromJson(body, User.class);
		
		PrintWriter out = response.getWriter();
		try {
			dao.doPost(data);
			out.print("User persisted with success");
		} catch (Exception e) {
			out.print(e.getStackTrace());
		}
	}

}
