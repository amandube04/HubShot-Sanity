package xom.cg.Hubshot.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cg.Hubshot.Base.Base;



public class login_page extends Base{
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[@id='loginBtn']")
	WebElement Login;

	@FindBy(xpath="//div[@class='UIHeader__Inner-h31ohy-1 dYEzKo private-header__inner']")
	WebElement verifypage;
	
	
	
	public login_page() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String validatePage() {
		
		return driver.getTitle();
	}
	
	public boolean Hubspot() {
		
		return verifypage.isDisplayed();
		
	}
	
	public Home_page LoginPage(String user,String pwd) {
		
		username.sendKeys(user);
		password.sendKeys(pwd);
		Login.click();
		
		return new Home_page();
	}
	
	
}
