package com.example.card.client;

import com.example.card.shared.CardData;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("data")
public interface CardService extends RemoteService {
	CardData getCard();
	void setCard(CardData c);
}
