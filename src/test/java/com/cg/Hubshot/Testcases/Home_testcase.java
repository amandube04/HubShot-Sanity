package com.cg.Hubshot.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.cg.Hubshot.Base.Base;
import xom.cg.Hubshot.Pages.Home_page;
import xom.cg.Hubshot.Pages.login_page;
import xom.cg.Hubshot.util.TestUtil;

public class Home_testcase extends Base {

	login_page login;
	TestUtil util;
	Home_page home;

	public Home_testcase()

	{
		super();

	}

	@BeforeMethod
	public void setup() {
		intialize();
		login = new login_page();
		util = new TestUtil();
		home = new Home_page();
		home = login.LoginPage(properties.getProperty("username"), properties.getProperty("password"));
	}

	@Test(priority = 1)
	public void marketClick() {

		// util.userFrame();
		home.verifymarketing();
		// driver.switchTo().defaultContent();

	}

	@Test(priority = 2)
	public void reportsClick() {

		// util.userFrame();
		home.verifyReports();
		boolean verify = home.salesdisplaied();
		Assert.assertTrue(verify);

		// driver.switchTo().defaultContent();

	}

	@Test(priority = 3)
	public void salesClick() {

		// util.userFrame();
		home.verifySales();

		// driver.switchTo().defaultContent();

	}

	@Test(priority = 4)
	public void serviceClick() {

		// util.userFrame();
		home.verifyService();
		// driver.switchTo().defaultContent();

	}

	@Test(priority = 5)
	public void verifycontacts() {
		home.verifyContact();
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
}
