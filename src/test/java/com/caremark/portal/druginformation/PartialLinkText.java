package com.caremark.portal.druginformation;

import org.openqa.selenium.By;

import java.util.function.Supplier;

import static org.openqa.selenium.By.partialLinkText;

/**
 * This enum is a Supplier of ByCssSelector from Selenium By API.
 */
public enum PartialLinkText implements Supplier<By> {

	HEART_ARREST("heart arrest"),
    MEXICO("MEXICO"),
    CANCUN("Cancun"),
    REGISTER("Register");

    ;

    private final By by;

    PartialLinkText(String id) {
        this.by = partialLinkText(id);
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
