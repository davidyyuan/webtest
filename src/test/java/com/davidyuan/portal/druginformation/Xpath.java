package com.davidyuan.portal.druginformation;

import org.openqa.selenium.By;

import java.util.function.Supplier;

import static org.openqa.selenium.By.xpath;;

/**
 * This enum is a Supplier of ByCssSelector from Selenium By API.
 */
public enum Xpath implements Supplier<By> {

    SEARCH("//*[@id='searchForm']/div/button")


    ;

    private final By by;

    Xpath(String id) {
        this.by = xpath(id);
    }

    /**
     * @return the by instance variable which is a ByCssSelector.
     */
    @Override
    public By get() {
        return by;
    }

    @Override
    public String toString() {
        return by.toString();
    }
}
