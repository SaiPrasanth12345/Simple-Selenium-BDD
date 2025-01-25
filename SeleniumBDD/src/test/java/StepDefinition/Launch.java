package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import setupDriver.login;

public class Launch {

	public WebDriver driver = DriverSetup.driver;
	public login loginPage = DriverSetup.loginPage;
	DriverSetup driversetup = new DriverSetup();

	public String search = "//textarea[@title='Search']";
	public String googleSearch = "//div[@jsname='VlcLAe']//input[@value='Google Search']";

	/*
	 * @Given("Get selenium driver") public void get_selenium_driver() {
	 * System.setProperty("webdriver.chrome.driver",
	 * "src/test/resources/drivers/chromedriver.exe"); driver = new ChromeDriver();
	 * driver.manage().window().maximize(); }
	 */

	@Given("Launch {string}")
	public void launch(String url) {
		loginPage.launchURL(url, driversetup.scenario);
		driversetup.attachScreenshot();
	}

	@Then("search with {string}")
	public void search_with(String searchValue) {
		System.out.println("***** -> " + searchValue);

		driver.findElement(By.xpath(search)).click();
		driver.findElement(By.xpath(search)).sendKeys(searchValue);
		driver.findElement(By.xpath(googleSearch)).click();
		driversetup.attachScreenshot();
	}

	@When("^login with (.*) and (.*)$")
	public void login_with_username_and_password(String username, String password) {
		loginPage.enterLoginDetails(username, password);
		loginPage.clickLoginBtn();
	}

	@Then("validate Login Succesful")
	public void validate_login_succesful() {
		driversetup.attachScreenshot();
		org.junit.Assert.assertTrue(loginPage.logoutDisplayed());
	}

}
