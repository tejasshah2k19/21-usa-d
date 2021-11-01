package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.util.DbConnection;

public class SignupServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// validation

		// db store
		// mysql* - oracle** - pg*

		// insert

		// open connection -- insert

		try {

			Connection con = DbConnection.getConnection();

			PreparedStatement pstmt = con
					.prepareStatement("insert into users (firstName,email,password) values (?,?,?)");

			pstmt.setString(1, firstName);
			pstmt.setString(2, email);
			pstmt.setString(3, password);

			// run query

			// executeUpdate() -> insert update delete
			// executeQuery() -> select

			int i = pstmt.executeUpdate();// query -> db -> run
			if (i == 0) {
				System.out.println("record not inserted....");
			} else {
				System.out.println("record inserted....");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("Signup.jsp");
		rd.forward(request, response);

	}
}
