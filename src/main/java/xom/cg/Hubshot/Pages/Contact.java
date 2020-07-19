package xom.cg.Hubshot.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cg.Hubshot.Base.Base;

public class Contact extends Base{
	
	
	
	@FindBy(xpath="//span[text()='Create contact']")
	WebElement createContact;
	
	@FindBy(id="UIFormControl-31")
	WebElement contactemail;
	
	@FindBy(id="UIFormControl-33")
	WebElement contactfname;
	
	@FindBy(id="UIFormControl-37")
	WebElement contactlname;
	
	@FindBy(id="UIFormControl-45")
	WebElement contactjob;
	
	@FindBy(id="UIFormControl-47")
	WebElement contactMob;
	
	@FindBy(xpath="//span[@class='private-loading-button__content private-button--internal-spacing' and text()='Create contact']")
	WebElement confirmContact;
	
	
	public Contact(){
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void submitcontacts(String email,String Fname,String Lname,String Job, String mob ){
		
		
		createContact.click();
		contactemail.sendKeys(email);
		contactfname.sendKeys(Fname);
		contactlname.sendKeys(Lname);
		contactjob.sendKeys(Job);
		contactMob.sendKeys(mob);
		confirmContact.click();
	}

}
