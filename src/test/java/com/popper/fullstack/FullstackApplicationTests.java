package com.popper.fullstack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.popper.fullstack.web.i18n.I18NService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FullstackApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Autowired
	private I18NService i18NService;
	
	@Test
	public void testMessageByLocaleService() {
		String expectedResult = "Bootstrap starter template";
		String messageId = "index.main.callout";
		String actual = i18NService.getMessage(messageId);
		Assert.assertEquals("Don't match",expectedResult, actual);
	}
	
}
