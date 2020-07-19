package com.cg.Hubshot.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import xom.cg.Hubshot.util.TestUtil;
import xom.cg.Hubshot.util.WebEventListener;

public class Base {
	public String projectpath = System.getProperty("user.dir");
	public String chromedriverpath = projectpath + "/Drivers/chromedriver.exe";

	public static WebDriver driver;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static Properties properties;

	public Base() {
		try {
			properties = new Properties();
			FileInputStream is = new FileInputStream(
					"./src/main/java/xom/cg/Hubshot/config/config.properties");
			properties.load(is);

		}

		catch (FileNotFoundException file) {

			file.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
		}

	}

	
	public void intialize() {
        String browsername="chrome";//properties.getProperty("Browser");
        String getbrowser= "https://app.hubspot.com/login?hubs_signup-url=www.hubspot.com/&hubs_signup-cta=cta--small";//properties.getProperty("URL");
        
      //  if(browsername.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", chromedriverpath);
		 driver = new ChromeDriver();
		
       /* }else if(browsername.equals("firefox")) {
        	
        	System.setProperty("webdriver.geko.driver","./gekodriver");
        }*/
        driver.get(getbrowser);
        
        
        e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
        
        
		// To maximize the browser
		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout,TimeUnit.SECONDS);

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait_Timeout, TimeUnit.SECONDS);
		
		// Open the Browser
		
	}

}


