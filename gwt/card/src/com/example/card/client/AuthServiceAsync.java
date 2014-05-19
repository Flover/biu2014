package com.example.card.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AuthServiceAsync {

	void authorize(String login, String passwd, AsyncCallback<Boolean> callback);

}
