package com.caremark.portal.poc.datepicker.bootstrap;

import swb.framework.Browser;
import swb.framework.datepicker.Calendar;
import swb.framework.datepicker.CalendarPicker;
import swb.framework.datepicker.Datepicker;

import java.time.Month;

import static com.caremark.portal.poc.datepicker.bootstrap.BootstrapCalendarControls.*;
import static com.caremark.portal.poc.datepicker.bootstrap.BootstrapCalendarDisplayValue.DISPLAY_MONTH;
import static com.caremark.portal.poc.datepicker.bootstrap.BootstrapCalendarDisplayValue.DISPLAY_YEAR;
import static swb.locators.bootstrap.BootstrapByClassName.TRIGGER_BY;

public class BootstrapDatepickerPage {

    private final Browser browser;
    private final Datepicker datepicker;

    public BootstrapDatepickerPage(Browser browser) {
        this.browser = browser;
        this.datepicker = new Datepicker(
            new Calendar(browser, TRIGGER),
            new CalendarPicker(browser, PREVIOUS_YEAR, NEXT_YEAR, DISPLAY_YEAR),
            new CalendarPicker(browser, PREVIOUS_MONTH, NEXT_MONTH, DISPLAY_MONTH),
            new BootstrapDayPicker(browser)
        );
    }

    public void pick(Month month, int day, int year) {
        datepicker.pick(month, day, year);
    }

    public String getDate() {
        return browser.getInputText(TRIGGER_BY);
    }

}
