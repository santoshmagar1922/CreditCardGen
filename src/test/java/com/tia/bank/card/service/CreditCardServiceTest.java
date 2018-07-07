package com.tia.bank.card.service;

import static junit.framework.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.tia.bank.card.domain.CreditCard;
import com.tia.bank.card.service.CreditCardService;


@RunWith(MockitoJUnitRunner.class)
public class CreditCardServiceTest {

	private CreditCardService creditCardService = new CreditCardService();
	
	@SuppressWarnings("deprecation")
	@Test
	public void checkIfCreditCardGeneratorGeneartesOneCard() {
		
		int totalCards = 1;
		String cardType = "VISA";
		
		List<CreditCard> cards = creditCardService.createCreditCards(totalCards, cardType);
		assertEquals(1, cards.size());
		assertEquals("VISA", cards.get(0).getCardType());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void checkIfCreditCardGeneratorGeneartesMultipleCards() {
		
		int totalCards = 10;
		String cardType = "VISA";
		
		List<CreditCard> cards = creditCardService.createCreditCards(totalCards, cardType);
		assertEquals(10, cards.size());
		for (CreditCard card : cards) {
			assertEquals("VISA", card.getCardType());
		}
	}
	
	
}
