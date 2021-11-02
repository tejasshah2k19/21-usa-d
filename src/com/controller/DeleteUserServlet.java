package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DbConnection;

@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int userId = Integer.parseInt(request.getParameter("userId"));

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from users where userId = ?");
			pstmt.setInt(1, userId);

			int i = pstmt.executeUpdate();

			if (i == 0) {
				System.out.println("no record deleted");
			} else {
				System.out.println(i + " record(s) deleted....");
			}

			RequestDispatcher rd = request.getRequestDispatcher("ListAllUsersServlet");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
