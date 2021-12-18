package com.stag;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//implements SimpleTag
public class GreetTag extends SimpleTagSupport { // SimpleTag

	// logic
	public void doTag() throws JspException, IOException {

		JspWriter out = getJspContext().getOut();// to print data on jsp page

		Date d = new Date();
		int h = d.getHours();

		if (h >= 1 && h <= 11) {
			out.print("Good Morning"); // this will print on jsp page
		} else if (h > 11 && h <= 17) {
			out.print("Good Noon");// this will print on jsp page
		} else {
			out.print("Good Evening");// this will print on jsp page
		}
	}
}
