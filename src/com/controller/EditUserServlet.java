package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DbConnection;

@WebServlet("/EditUserServlet")
public class EditUserServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int userId = Integer.parseInt(request.getParameter("userId"));

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users where userId = ?");
			pstmt.setInt(1, userId);

			ResultSet rs = pstmt.executeQuery();
			RequestDispatcher rd = null;
			if (rs.next()) {

				String firstName = rs.getString("firstName");
				String email = rs.getString("email");

				request.setAttribute("firstName", firstName);
				request.setAttribute("email", email);
				request.setAttribute("userId", userId);
				
				
				rd = request.getRequestDispatcher("EditUser.jsp");
			} else {
				request.setAttribute("error", "No user found");
				rd = request.getRequestDispatcher("Fail.jsp");
			}

			rd.forward(request, response);

		} catch (Exception e) {

		}
	}

}
