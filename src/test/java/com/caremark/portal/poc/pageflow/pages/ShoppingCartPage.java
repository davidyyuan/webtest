package com.caremark.portal.poc.pageflow.pages;

import swb.framework.Browser;

import static swb.locators.CssSelector.CONFIRM;

import com.caremark.portal.poc.pageflow.domain.Address;
import com.caremark.portal.poc.pageflow.domain.CreditCard;
import com.caremark.portal.poc.pageflow.domain.OtherInformation;

public class ShoppingCartPage {

    private final BillingAddressForm billingAddressForm;
    private final CreditCardForm creditCardForm;
    private final OtherInformationForm otherInformationForm;
    private final Browser browser;

    public ShoppingCartPage(Browser browser) {
        this.browser = browser;
        this.otherInformationForm = new OtherInformationForm(browser);
        this.billingAddressForm = new BillingAddressForm(browser);
        this.creditCardForm = new CreditCardForm(browser);
    }

    public void setOtherInformation(OtherInformation otherInformation) {
        otherInformationForm.setOtherInformation(otherInformation);
    }

    public void setBillingAddress(Address address) {
        billingAddressForm.setBillingAddress(address);
    }

    public void setCreditCard(CreditCard card) {
        creditCardForm.setCreditCard(card);
    }

    public void confirm() {                 //<1>
        browser.click(CONFIRM);
    }
}