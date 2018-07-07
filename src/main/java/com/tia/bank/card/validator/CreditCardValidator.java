package com.tia.bank.card.validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.tia.bank.card.domain.CreditCard;

public class CreditCardValidator {

	public static final String VISA = "VISA";
	public static final String MASTER_CARD = "MSTR";
	public static final String AMEX = "AMEX";
	
	public static final String VALID = "VALID";
	public static final String INVALID = "INVALID";
	
	public List<CreditCard> validateCards(List<CreditCard> cards) {
		List<CreditCard> updatedCrds = new ArrayList<CreditCard>();
		if (cards != null && !cards.isEmpty()) {
			for (CreditCard inputCard : cards) {
				CreditCard validatedCard = validate(inputCard);
				if (VALID.equalsIgnoreCase(validatedCard.getStatus())) {
					validatedCard.setExpiryDate(new Date());
				}
				updatedCrds.add(validatedCard);
			}
			return updatedCrds;
		}
		return null;
	}

	public CreditCard validate(CreditCard cc) {
		
		String cardType = cc.getCardType();
		if (StringUtils.isNotBlank(cardType)) {
			if (VISA.equalsIgnoreCase(cardType) && cc.getCardNumber().startsWith("4")) {
				cc.setStatus(VALID);
				return cc;
			} else if (MASTER_CARD.equalsIgnoreCase(cardType) && cc.getCardNumber().startsWith("5")){
				cc.setStatus(VALID);
				return cc;
			} else if (AMEX.equalsIgnoreCase(cardType) && cc.getCardNumber().startsWith("37")){
				cc.setStatus(VALID);
				return cc;
			} else {
				cc.setStatus(INVALID);
				return cc;
			}
		} 
		return cc;
	}
}
