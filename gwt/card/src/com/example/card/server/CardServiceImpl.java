package com.example.card.server;

import com.example.card.client.CardService;
import com.example.card.shared.CardData;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class CardServiceImpl extends RemoteServiceServlet implements CardService {

	private static final long serialVersionUID = 1L;
	
	private CardData data = new CardData("nazwa firmy", "nasz super adres", "nasz super opis", "Gdańsk, Wita Stwosza 48", "(+66) 666 666 666", "ug@ug.edu.pl");

	@Override
	public CardData getCard() {
		return data;
	}

	@Override
	public void setCard(CardData c) {
		data.setNazwa(c.getNazwa());
		data.setOpis(c.getOpis());
		data.setOferta(c.getOferta());
		data.setAdres(c.getAdres());
		data.setTelefon(c.getTelefon());
		data.setMail(c.getMail());
	}
	

}