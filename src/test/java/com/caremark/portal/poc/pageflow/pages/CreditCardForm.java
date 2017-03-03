package com.caremark.portal.poc.pageflow.pages;

import swb.framework.Browser;

import static swb.locators.Id.*;

import com.caremark.portal.poc.pageflow.domain.CreditCard;

public class CreditCardForm {

    private Browser browser;

    public CreditCardForm(Browser browser) {
        this.browser = browser;
    }

    public void setCreditCard(CreditCard card) {
        browser.setInputText(CARD_NUMBER, card.cardNumber);
        browser.selectByVisibleText(CARD_TYPE, card.cardType);
        browser.selectByVisibleText(CARD_EXP_MONTH, card.expirationMonth);
        browser.selectByVisibleText(CARD_EXP_YEAR, card.expirationYear);
    }
}

