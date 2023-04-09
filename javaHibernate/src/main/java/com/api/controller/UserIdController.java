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

import com.api.bean.User;
import com.api.dao.UserDAO;
import com.api.factory.Factory;
import com.google.gson.Gson;

@WebServlet("/api/user/*")
public class UserIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserDAO dao;
    public UserIdController() {
        super();
        dao = Factory.user();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		List<String> uriAsList = Arrays.asList(uri.split("/"));
		int userId = Integer.parseInt(uriAsList.get(uriAsList.size()-1));
		
		String data = new Gson().toJson(dao.doGetById(userId));
		PrintWriter out = response.getWriter();
		out.print(data);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("UTF-8");
		
		String url = request.getRequestURI();
		List<String> urlAsList = Arrays.asList(url.split("/"));
		int userId = Integer.parseInt(urlAsList.get(urlAsList.size()-1));
		
		String body = request.getReader().lines().collect(Collectors.joining());
		User data = new Gson().fromJson(body, User.class);
		
		PrintWriter out = response.getWriter();
		try {
			dao.doUpdate(userId, data);
			dao.doCommit();
			out.print("User updated with success");
		} catch (Exception e) {
			out.print(e.getStackTrace());
		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("UTF-8");
		
		String url = request.getRequestURI();
		List<String> urlAsList = Arrays.asList(url.split("/"));
		int userId = Integer.parseInt(urlAsList.get(urlAsList.size()-1));
		
		PrintWriter out = response.getWriter();
		try {
			dao.doRemove(userId);
			dao.doCommit();
			out.print("User deleted with success");
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

}
