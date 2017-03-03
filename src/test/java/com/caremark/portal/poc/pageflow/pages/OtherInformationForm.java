package com.caremark.portal.poc.pageflow.pages;

import swb.framework.Browser;

import static swb.locators.Id.*;
import static swb.locators.Name.MAILING_OPTION;

import com.caremark.portal.poc.pageflow.domain.OtherInformation;

public class OtherInformationForm {

    private Browser browser;

    public OtherInformationForm(Browser browser) {
        this.browser = browser;
    }

    public void setOtherInformation(OtherInformation info) {
        browser.setInputText(COUPON_CODE, info.couponCode);
        browser.setInputText(BILLING_EMAIL, info.email);
        browser.setInputText(COMMENTS, info.comments);
        browser.setCheckboxValue(CONFIRM_EMAIL, info.sendOrdersToEmail);
        browser.setCheckboxValue(RATINGS, info.sendRatingEmail);
        browser.setRadio(MAILING_OPTION, info.mailingOption);
    }
}
