package com.cg.Hubshot.Testcases;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cg.Hubshot.Base.Base;

import xom.cg.Hubshot.Pages.Contact;
import xom.cg.Hubshot.Pages.Home_page;
import xom.cg.Hubshot.Pages.login_page;
import xom.cg.Hubshot.util.TestUtil;

public class contacts_testcase extends Base{

	login_page login;
	TestUtil util;
    Home_page home;
    
    Contact contac;
    String sheetName = "Contacts";

	public contacts_testcase(){
		
		super();
	}
	
	@BeforeMethod
	public void setup() {
		intialize();
		login = new login_page();
		util=new TestUtil();
		home=new Home_page();
		home=login.LoginPage(properties.getProperty("username"), properties.getProperty("password"));
		contac=new Contact();
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1, dataProvider="getCRMTestData")
	public void verifyCreateContact(String emails,String Fnames,String Lnames,String Jobs, String mobs ){
		
		home.verifyContact();
		
		contac.submitcontacts(emails, Fnames, Lnames, Jobs, mobs);
		
		
	}
	
	
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
}
