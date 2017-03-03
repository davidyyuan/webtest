package com.davidyuan.portal;

import org.openqa.selenium.By;

import java.util.function.Supplier;

import static org.openqa.selenium.By.id;

public enum Id implements Supplier<By> {

   

    LOCATION("location"),
    USERNAME("userid"),
    PASSWORD("password"),
    FAST_CONTAINER("fast-container"),
    IFRAME("iframe"),
    MC_FOOTER_DRUGREFERENCE("MC_Footer_DrugReference")
    ;

    private final By by;

    Id(String id) {
        this.by = id(id);
    }

    @Override
    public By get() {
        return by;
    }

    @Override
    public String toString() {
        return by.toString();
    }
}