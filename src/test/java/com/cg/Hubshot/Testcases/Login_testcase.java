package com.cg.Hubshot.Testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cg.Hubshot.Base.Base;


import xom.cg.Hubshot.Pages.login_page;
import xom.cg.Hubshot.util.TestUtil;

public class Login_testcase extends Base{

	login_page login;
	TestUtil util;
     Logger log=Logger.getLogger(Login_testcase.class);
	public Login_testcase()

	{
		super();

	}
     
	@BeforeMethod
	public void setup() {
		intialize();
		login = new login_page();
		util=new TestUtil();
		log.info("Message passed throgh logs");
		log.fatal("Please see the correct title page");
	}

	@Test(priority = 1)
	public void verifyTitle() {
		log.info("------------------------Started------------------------");
		String validate = login.validatePage();
		
		Assert.assertEquals(validate, "Checking browsers");
		log.fatal("-----------------------Error----------------------");
		
		
	}

	
	@Test(priority = 2)
	public void HRMLogin() {
		login.LoginPage(properties.getProperty("username"), properties.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}

