package com.davidyuan.portal.druginformation;

import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;

import com.davidyuan.portal.AbstractTestIT;

import org.testng.annotations.BeforeMethod;
import java.net.URI;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

//import swb.ch15pageflow.pages.BookstoreHomepage;
import swb.framework.Browser;
import swb.framework.BrowserConfig;
import swb.framework.BrowserRunner;
import swb.framework.Element;
import swb.framework.ScreenshotTaker;

public class CaremarkDrugInformationIT extends AbstractTestIT {

	private final static Logger logger = LoggerFactory.getLogger(CaremarkDrugInformationIT.class);

	@Inject
	URI baseUrl;

	@BeforeMethod
	public void setup() {
		

	}

	@Test
	public void searchDrugByDrugName() {

		logger.debug("opening https://www.caremark.com");
		//Thread.sleep(10000);
		browser.get("https://www.caremark.com");
		logger.debug("click " + LinkText.Drug_Reference_Interactions);
		browser.click(LinkText.Drug_Reference_Interactions);

		logger.debug("Get handle: " + Name.SEARCHTYPE);
		browser.await(Name.SEARCHTYPE);
		logger.debug("Set radio button " + Name.SEARCHTYPE + " to drug");
		browser.setRadio(Name.SEARCHTYPE, "drug");
		logger.debug("Enter drug name Lipitor");
		browser.setInputText(Name.SEARCHDRUG, "Lipitor");
		logger.debug("Click button " + Xpath.SEARCH);
		browser.click(Xpath.SEARCH);
		assertTrue(browser.getPageSource().contains("Generic: Atorvastatin"));
		assertTrue(browser.getPageSource()
				.contains("ATORVASTATIN (a TORE va sta tin) is known as a HMG-CoA reductase inhibitor or 'statin'"));
	}

	@Test
	public void searchDrugByCondition() {
		browser.get("https://www.caremark.com");
		browser.click(LinkText.Drug_Reference_Interactions);

		browser.await(Name.SEARCHTYPE);
		browser.setRadio(Name.SEARCHTYPE, "condition");
		browser.setInputText(Name.SEARCHDRUG, "heart arrest");
		browser.click(Xpath.SEARCH);
		browser.click(PartialLinkText.HEART_ARREST);
		assertTrue(browser.getPageSource().contains("Please select a drug from the list below to view details"));

	}
}
