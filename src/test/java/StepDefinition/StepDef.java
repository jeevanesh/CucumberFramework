package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import PageObject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef {
	
	public WebDriver driver;
	public LoginPage loginPg;
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-web-security");
	options.addArguments("--allow-running-insecure-content");
	options.addArguments("--remote-allow-origins=*");
	options.addArguments("--disable-gpu");
	
	driver = new ChromeDriver(options);
//	driver = new ChromeDriver();
	loginPg = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);

	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailAdd, String pwd) {
		
		loginPg.enterEmail(emailAdd);
		loginPg.enterPassword(pwd);
	}

	@When("Click on Login")
	public void click_on_login() {
		loginPg.clickLogin();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String ExpectedTitle) {
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(ExpectedTitle)) {
			Assert.assertTrue(true); //Pass
		}
		else {
			Assert.assertTrue(false);//Fail
		}
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
		loginPg.clickLogout();
	}

	@Then("close browser")
	public void close_browser() {
	   driver.quit();
	}
}
