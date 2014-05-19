package com.example.card.client;

import com.example.card.shared.CardData;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CardServiceAsync {

	void getCard(AsyncCallback<CardData> callback);

	void setCard(CardData c, AsyncCallback<Void> callback);

}
