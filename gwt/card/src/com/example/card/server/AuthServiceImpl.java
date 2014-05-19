package com.example.card.server;

import com.example.card.client.AuthService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class AuthServiceImpl extends RemoteServiceServlet implements AuthService {

	private static final long serialVersionUID = 1L;
	
	final static String userName = "kw";
	final static String userPassword = "test";
	
	@Override
	public Boolean authorize(String login, String passwd) {

		return (login.compareTo(userName) == 0 && passwd.compareTo(userPassword) == 0);
	}

}
