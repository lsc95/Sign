package com.coderli.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class checkSessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session被创建了");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session被销毁了");
	}


}
