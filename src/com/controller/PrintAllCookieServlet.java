package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PrintAllCookieServlet")
public class PrintAllCookieServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// read all cookies from browser
		Cookie c[] = request.getCookies();

		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		
		for(int i=0;i<c.length;i++) {
			out.print(c[i].getName()+" == >"+ c[i].getValue()+"<br>");
		}
		
		out.print("</body></html>");

		
	}
}












