package com.caremark.portal.poc.pageflow.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.caremark.portal.poc.pageflow.pages.BookstoreHomepage;

import swb.framework.Browser;
import swb.framework.BrowserRunner;

import javax.inject.Inject;

@RunWith(BrowserRunner.class)
public class BookstoreSearchIT {
    @Inject
    private Browser browser;

    @Test
    public void searchBook() {
        browser.get("/bookstore/");
        new BookstoreHomepage(browser) {{
            searchBook("Selenium WebDriver Book");
        }};
    }
}
