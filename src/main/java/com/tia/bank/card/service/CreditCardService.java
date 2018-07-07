package com.tia.bank.card.service;

import java.util.ArrayList;
import java.util.List;

import com.tia.bank.card.domain.CreditCard;
import com.tia.bank.card.validator.CreditCardValidator;

public class CreditCardService {

	public List<CreditCard> createCreditCards(int totalCards, String cardType) {
		List<CreditCard> cards = new ArrayList<CreditCard>();
		
		for (int i=0;i<totalCards;i++) {
			CreditCard cc = createCreditCard(cardType);
			cards.add(cc);
		}
		return cards;
	}

	private CreditCard createCreditCard(String cardType) {
		CreditCard cc = new CreditCard();
		cc.setCardType(cardType);
		return cc;
	}

}
