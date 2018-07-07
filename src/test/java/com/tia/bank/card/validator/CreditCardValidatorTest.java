package com.tia.bank.card.validator;

import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.tia.bank.card.domain.CreditCard;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class CreditCardValidatorTest {

	public static final String VALID = "VALID";
	public static final String INVALID = "INVALID";
	private CreditCardValidator CreditCardValidator = new CreditCardValidator();
	
	@Test
	public void checkIfVisaCreditCardGeneratedIsValid() {
		List<CreditCard> cards = new ArrayList<CreditCard>();
		CreditCard cc = createCreditCard("VISA", "4444111122223333");	
		cards.add(cc);
		
		List<CreditCard> cardsReturned= CreditCardValidator.validateCards(cards);
		assertEquals(VALID, cardsReturned.get(0).getStatus());
		assertEquals(new Date().getDate(), cardsReturned.get(0).getExpiryDate().getDate());
	}
	
	@Test
	public void checkIfVisaCreditCardGeneratedIsInValid() {
		List<CreditCard> cards = new ArrayList<CreditCard>();
		CreditCard cc = createCreditCard("VISA", "1444111122223333");	
		cards.add(cc);
		
		List<CreditCard> cardsReturned= CreditCardValidator.validateCards(cards);
		assertEquals(INVALID, cardsReturned.get(0).getStatus());
	}
	
	@Test
	public void checkIfMasterCardCreditCardGeneratedIsValid() {
		List<CreditCard> cards = new ArrayList<CreditCard>();
		CreditCard cc = createCreditCard("MSTR", "5555111122223333");
		cards.add(cc);
		
		List<CreditCard> cardsReturned= CreditCardValidator.validateCards(cards);
		assertEquals(VALID, cardsReturned.get(0).getStatus());
	}
	
	@Test
	public void checkIfMasterCardCreditCardGeneratedIsInValid() {
		List<CreditCard> cards = new ArrayList<CreditCard>();
		CreditCard cc = createCreditCard("MSTR", "1555111122223333");
		cards.add(cc);
		List<CreditCard> cardsReturned= CreditCardValidator.validateCards(cards);
		assertEquals(INVALID, cardsReturned.get(0).getStatus());
	}
	
	@Test
	public void checkIfAmericanExpressCreditCardGeneratedIsValid() {
		List<CreditCard> cards = new ArrayList<CreditCard>();
		CreditCard cc = createCreditCard("AMEX", "3755111122223333");
		cards.add(cc);
		List<CreditCard> cardsReturned = CreditCardValidator.validateCards(cards);
		assertEquals(VALID, cardsReturned.get(0).getStatus());
	}
	
	@Test
	public void checkIfAmericanExpressCreditCardGeneratedIsInValid() {
		List<CreditCard> cards = new ArrayList<CreditCard>();
		CreditCard cc = createCreditCard("AMEX", "4455111122223333");
		cards.add(cc);
		List<CreditCard> cardsReturned= CreditCardValidator.validateCards(cards);
		assertEquals(INVALID, cardsReturned.get(0).getStatus());
	}
	
	private CreditCard createCreditCard(String cardType, String cardNumber) {
		CreditCard cc = new CreditCard();
		cc.setCardType(cardType);
		cc.setCardNumber(cardNumber);
		return cc;
	}
}
