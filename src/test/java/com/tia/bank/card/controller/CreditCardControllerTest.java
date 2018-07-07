package com.tia.bank.card.controller;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tia.bank.card.domain.CreditCard;
import com.tia.bank.card.service.CreditCardService;
import com.tia.bank.card.validator.CreditCardValidator;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class CreditCardControllerTest {

	@Mock
	private CreditCardService service;
	@Mock
	private CreditCardValidator validator;

	@InjectMocks
	private CreditCardController creditCardController = new CreditCardController();
	
	@Test
	public void checkIfCreditCardGeneratorGeneartesOneValidVisaCard() {
		
		int totalCards = 1;
		String cardType = "VISA";
		List<CreditCard> cards = new ArrayList<CreditCard>();
		cards.add(createCreditCard(cardType, "4111333344447777"));
		
		when(service.createCreditCards(totalCards, cardType)).thenReturn(cards);
		when(validator.validateCards(cards)).thenReturn(cards);
		
		List<CreditCard> cardsReturned = creditCardController.saveCreditCards(totalCards, cardType);
		assertEquals(1, cards.size());
		assertEquals("VALID", ((CreditCard) cardsReturned.get(0)).getStatus());
		assertEquals(new Date().getDate(), ((CreditCard)cardsReturned.get(0)).getExpiryDate().getDate());
	}
	
	private CreditCard createCreditCard(String cardType, String cardNumber) {
		CreditCard cc = new CreditCard();
		cc.setCardType(cardType);
		cc.setCardNumber(cardNumber);
		cc.setStatus("VALID");
		cc.setExpiryDate(new Date());
		return cc;
	}
		
	
}
