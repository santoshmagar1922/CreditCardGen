package com.tia.bank.card.controller;

import java.util.List;

import com.tia.bank.card.domain.CreditCard;
import com.tia.bank.card.service.CreditCardService;
import com.tia.bank.card.validator.CreditCardValidator;

public class CreditCardController {

	private CreditCardValidator cardValidator;
	private CreditCardService cardService;
	
	public List<CreditCard> saveCreditCards(int totalCards, String cardType) {
		List<CreditCard> cards = cardService.createCreditCards(totalCards, cardType);
		List<CreditCard> returnedCards = cardValidator.validateCards(cards);

		/*for (CreditCard cc: returnedCards) {
			cc.setExpiryDate(new Date());
		}*/
		return returnedCards;
	}
	
}
