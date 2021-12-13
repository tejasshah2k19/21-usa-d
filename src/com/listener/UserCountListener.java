package com.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class UserCountListener implements HttpSessionListener {

	int totalUser = 0;

	public void sessionCreated(HttpSessionEvent arg0) {
		totalUser++;
		System.out.println("User IN " + totalUser);
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		totalUser--;
		System.out.println("User out " + totalUser);
	}
}
