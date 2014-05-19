package com.example.card.shared;

import java.io.Serializable;

public class CardData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String nazwa;
	String oferta;
	String opis;
	String adres;
	String telefon;
	String mail;
	
	public CardData() {
	}
	
	public CardData(String nazwa, String oferta, String opis, String adres, String telefon, String mail) {
		super();
		this.nazwa = nazwa;
		this.oferta = oferta;
		this.opis = opis;
		this.adres = adres;
		this.telefon = telefon;
		this.mail = mail;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public String getOferta() {
		return oferta;
	}
	public void setOferta(String oferta) {
		this.oferta = oferta;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	
}
