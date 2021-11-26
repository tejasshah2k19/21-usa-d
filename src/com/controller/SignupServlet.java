package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

public class SignupServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserBean userBean = new UserBean();
		userBean.setFirstName(firstName);
		userBean.setEmail(email);
		userBean.setPassword(password);

		// validation

		// db store
		// mysql* - oracle** - pg*

		// insert

		// open connection -- insert

		UserDao userDao = new UserDao();
		int status = userDao.insertUser(userBean);

		if (status == 0) {
			request.setAttribute("error", "Something went wrong Please try again");
		} else {
			request.setAttribute("msg", "User added");
		}
		RequestDispatcher rd = request.getRequestDispatcher("Signup.jsp");
		rd.forward(request, response);

	}
}
