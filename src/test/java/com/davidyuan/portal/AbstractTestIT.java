package com.davidyuan.portal;

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
import org.testng.annotations.BeforeClass;

import com.davidyuan.portal.druginformation.CaremarkDrugInformationIT;
import com.davidyuan.portal.druginformation.PartialLinkText;

import swb.framework.Browser;
import swb.framework.BrowserConfig;
import swb.framework.Element;
import swb.framework.ScreenshotTaker;

@ContextConfiguration(classes = BrowserConfig.class)
@TestExecutionListeners(listeners = {ScreenshotTaker.class, DependencyInjectionTestExecutionListener.class})
public abstract class AbstractTestIT extends AbstractTestNGSpringContextTests {
	
	private final static Logger logger = LoggerFactory.getLogger(AbstractTestIT.class);
	
	@Inject
	protected Browser browser;

	@BeforeClass
	public void oneTimeSetUp() {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		Runnable task = () -> {
			logger.info("Scheduling task to dismiss all pesky popups started");
			Element registerLink = null;
			try {
				registerLink = browser.findElement(PartialLinkText.REGISTER);//TODO: fixme. need to find the real popup handles
				//registerLink.click();
			} catch (Exception e) {
				
			}
		};
		executor.scheduleWithFixedDelay(task, 0, 2, TimeUnit.SECONDS);
	}
}
