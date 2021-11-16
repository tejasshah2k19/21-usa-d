package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DbConnection;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int userId = Integer.parseInt(request.getParameter("userId"));
		String firstName = request.getParameter("firstName");
		String email = request.getParameter("email");

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con
					.prepareStatement("update users set firstName = ? , email = ? where userId = ?");

			pstmt.setString(1, firstName);
			pstmt.setString(2, email);
			pstmt.setInt(3, userId);

			pstmt.executeUpdate();

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("ListAllUsersServlet");
	
	}

}
