package xom.cg.Hubshot.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cg.Hubshot.Base.Base;



public class Home_page extends Base {

//----------------------Marketing-------------------------------------------//
	@FindBy(id="nav-primary-marketing-branch")
	WebElement marketing1;
	
	@FindBy(id="nav-secondary-ads-free")
	WebElement marketing2;
//----------------------Sales-----------------------------------------------//
	
	@FindBy(id="nav-primary-sales-branch")
	WebElement sales1;
	
	@FindBy(css=".active #nav-secondary-tasks")
	WebElement sales2;
	
	
	
//--------------------Service----------------------------------------------//
	
	@FindBy(id="nav-primary-service-branch")
	WebElement service1;
	
	@FindBy(xpath="//a[@id='nav-secondary-tickets']/div")
	WebElement service2;
	
//----------------------Automation----------------------------------------//
	@FindBy(id="nav-primary-automation-branch")
	WebElement automation1;
	
	@FindBy(css=".active #nav-secondary-sequences > div:nth-child(1)")
	WebElement automation2;
//----------------------Reports-------------------------------------------//
	@FindBy(id="nav-primary-reports-branch")
	WebElement report1;
	
	@FindBy(css=".active #nav-secondary-analytics-tools > div:nth-child(1)")
	WebElement report2;
	@FindBy(xpath="/html/body/div[3]/main/div/div/section/header/div/div/h1/i18n-string")
	WebElement reportsdisplay;

//--------------------------Conversation-----------------------------------//
	@FindBy(id="nav-primary-conversations-branch")
	WebElement conversation1;
	
	@FindBy(css=".active #nav-secondary-inbox")
	WebElement conversation2;
	
//---------------------------Contact------------------------------------//
	@FindBy(id="nav-primary-contacts-branch")
	WebElement contactMain;
	
	@FindBy(xpath="//*[@id='nav-secondary-contacts']/div[1]")
	WebElement subcontact;
	
	public Home_page() {
		PageFactory.initElements(driver, this);
	}

	public String Title() {

		return driver.getTitle();
	}

	/*public Boolean verifyuser() {

		return admin.isDisplayed();

	}*/

	public marketing_Pages verifymarketing() {

		marketing1.click();
		marketing2.click();

		return new marketing_Pages();

	}

	public Sales_pages verifySales(){
		
		sales1.click();
	//	sales2.click();
		
		return new Sales_pages();
	}
	
	public  boolean salesdisplaied(){
		
		return reportsdisplay.isDisplayed();
		
	}
  public Service_pages verifyService(){
		
		service1.click();
		service2.click();
		return new Service_pages();
	}
  
  public Reports_pages verifyReports(){
		
		report1.click();
		report2.click();
		return new Reports_pages();
	}

 public Contact verifyContact(){
	 
	 contactMain.click();
	 subcontact.click();
	
	 return new Contact();
	
}
	
}
