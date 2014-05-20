package com.example.card.client;

import com.example.card.shared.CardData;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class Card implements EntryPoint {
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";


	
	private final AuthServiceAsync authService = GWT.create(AuthService.class);
	private final CardServiceAsync cardService = GWT.create(CardService.class);

	public void fillData(final Label nameLbl, final Label offerLbl, final Label descrLbl, final Label contactLbl, final Label contactLbl1, final Label contactLbl2){
		cardService.getCard(new AsyncCallback<CardData>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(CardData result) {
				nameLbl.setText(result.getNazwa());
				offerLbl.setText(result.getOferta());
				descrLbl.setText(result.getOpis());
				contactLbl.setText(result.getAdres());
				contactLbl1.setText(result.getTelefon());
				contactLbl2.setText(result.getMail());
				
			}
		});

	}
	
	public void onModuleLoad() {
		
			
		final TextBox userNameTb = new TextBox();
		final TextBox nameTb = new TextBox();
		final TextBox offerTb = new TextBox();
		final TextBox contactTb = new TextBox();
		final TextBox descrTb = new TextBox();
		final TextBox contactTb1 = new TextBox();
		final TextBox contactTb2 = new TextBox();
		
		final PasswordTextBox passwdTb = new PasswordTextBox();
		
		Button authBtn = new Button("Zaloguj");
		Button saveBtn = new Button("Zapisz!");
		Button outBtn = new Button("Wyloguj");
		
		final Label infoLbl = new Label("Podaj login i hasło aby sie zalogować!");
		final Label nameLbl = new Label("");
		final Label offerLbl = new Label("");
		final Label contactLbl = new Label("");
		final Label contactLbl1 = new Label("");
		final Label contactLbl2 = new Label("");
		final Label descrLbl = new Label("");
		
		RootPanel.get("loginTbHolder").add(userNameTb);
		RootPanel.get("passwdTbHolder").add(passwdTb);
		RootPanel.get("sigInBtnHolder").add(authBtn);
		RootPanel.get("loginBox").add(infoLbl);
		
		RootPanel.get("nameHolder").add(nameLbl);
		RootPanel.get("descrHolder").add(descrLbl);
		RootPanel.get("offerHolder").add(offerLbl);
		RootPanel.get("contactHolder").add(contactLbl);
		RootPanel.get("contactHolder1").add(contactLbl1);
		RootPanel.get("contactHolder2").add(contactLbl2);
		
		RootPanel.get("nameTextBox").add(nameTb);
		RootPanel.get("descrTextBox").add(descrTb);
		RootPanel.get("offerTextBox").add(offerTb);
		RootPanel.get("contactTextBox").add(contactTb);
		RootPanel.get("contactTextBox1").add(contactTb1);
		RootPanel.get("contactTextBox2").add(contactTb2);
		RootPanel.get("saveBtnHolder").add(saveBtn);
		
		RootPanel.get("loggedinBox").add(outBtn);
		
		fillData(nameLbl, offerLbl, descrLbl, contactLbl, contactLbl1, contactLbl2);
		
		saveBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				String name = nameTb.getText();
				String offer = offerTb.getText();
				String descr = descrTb.getText();
				String contact = contactTb.getText();
				String contact1 = contactTb1.getText();
				String contact2 = contactTb2.getText();
				
				cardService.setCard(new CardData(name, offer, descr, contact, contact1, contact2), new AsyncCallback<Void>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(Void result) {
						fillData(nameLbl, offerLbl, descrLbl, contactLbl, contactLbl1, contactLbl2);
						DOM.getElementById("textEditHolder").getStyle().setDisplay(Display.NONE);
						DOM.getElementById("textHolder").getStyle().setDisplay(Display.BLOCK);
						
					}
				});
			}
		});
		
		authBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				String login = userNameTb.getText();
				String passwd = passwdTb.getText();
				
				authService.authorize(login, passwd, new AsyncCallback<Boolean>() {

					@Override
					public void onFailure(Throwable caught) {
						infoLbl.setText("STH WENT WRONG" + SERVER_ERROR);
						
					}

					@Override
					public void onSuccess(Boolean result) {
						if(result){
							infoLbl.setText("Zalogowałeś się poprawnie!");
							DOM.getElementById("textHolder").getStyle().setDisplay(Display.NONE);
							DOM.getElementById("textEditHolder").getStyle().setDisplay(Display.BLOCK);
							DOM.getElementById("loginBox").getStyle().setDisplay(Display.NONE);
							DOM.getElementById("loggedinBox").getStyle().setDisplay(Display.BLOCK);
							
							cardService.getCard(new AsyncCallback<CardData>() {

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
									
								}

								@Override
								public void onSuccess(CardData result) {
									nameTb.setText(result.getNazwa());
									offerTb.setText(result.getOferta());
									descrTb.setText(result.getOpis());
									contactTb.setText(result.getAdres());
									contactTb1.setText(result.getTelefon());
									contactTb2.setText(result.getMail());
									
									
								}
							});
							
						}
						else{
							infoLbl.setText("Go away! You don't exist!");
						}
						
					}
				});
				
			}
		});
		
		outBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				DOM.getElementById("loggedinBox").getStyle().setDisplay(Display.NONE);
				DOM.getElementById("loginBox").getStyle().setDisplay(Display.BLOCK);
				DOM.getElementById("textEditHolder").getStyle().setDisplay(Display.NONE);
				DOM.getElementById("textHolder").getStyle().setDisplay(Display.BLOCK);
				
			}
		});
		
	}
}
