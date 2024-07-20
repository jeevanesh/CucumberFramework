package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "Email")
	WebElement email;
	
	@FindBy(id = "Password")
	WebElement password;
	
//	@FindBy(css = "button[type='submit']")
//	WebElement loginBtn;
	
	@FindBy(className = "login-button")
	WebElement loginBtn;
	
	@FindBy(linkText = "Logout")
	WebElement logoutBtn;
	
	public void enterEmail(String emailAdd) {
		email.clear();
		email.sendKeys(emailAdd);
	}
	
	public void enterPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickLogin() {
		loginBtn.click();
	}
	
	public void clickLogout() {
		logoutBtn.click();
	}
}
