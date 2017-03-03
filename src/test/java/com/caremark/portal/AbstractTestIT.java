package com.caremark.portal;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import swb.framework.BrowserConfig;
import swb.framework.ScreenshotTaker;

@ContextConfiguration(classes = BrowserConfig.class)
@TestExecutionListeners(listeners = {ScreenshotTaker.class, DependencyInjectionTestExecutionListener.class})
public class AbstractTestIT extends AbstractTestNGSpringContextTests {

}
