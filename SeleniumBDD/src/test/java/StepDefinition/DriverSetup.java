package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import setupDriver.flights;
import setupDriver.login;

public class DriverSetup {
	public static WebDriver driver;
	public static login loginPage;
	public static flights flightsPage;	
	public static DriverSetup driverSetup = new DriverSetup();
	public static Scenario scenario;

	@Before
	public void driverSetup() {
		System.out.println("----->driverSetup");
		// Not required for above version 14
		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		// For chrome 11 version
		// options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		loginPage = new login(driver);
		flightsPage = new flights(driver);
	}

	// Configuring Scenario
	@Before(order = 1)
	public void orderExection(Scenario scenario) {
		this.scenario = scenario;
		System.out.println("----->Before Hook , Order = 1");
	}

	@After
	public void TearDown() {
		if (scenario.isFailed()) {
			attachScreenshot();
		}
		//  driver.quit();
	}

	public byte[] screnshotTake() {
		TakesScreenshot scrnsht = (TakesScreenshot) driver;
		return scrnsht.getScreenshotAs(OutputType.BYTES);
	}

	public void attachScreenshot() {
		byte[] scrnsht = screnshotTake();
		scenario.attach(scrnsht, "image/png", scenario.getName());
	}

	@Before(order = 0)
	public void orderExection0() {
		System.out.println("----->Before Hook , Order = 0");
	}

	@Before(order = -1)
	public void orderExectionnegative() {
		System.out.println("----->Before Hook , Order = -1");
	}

	@Before(value = "@test1 or @test2", order = -2)
	public void conditionalHooks() {
		System.out.println("----->Conditional Hook , only runs for @test1 & test2 tag, Order = -2");
	}

	@Before("@test1")
	public void conditionalHooksTest1() {
		System.out.println("----->Conditional Hook , only runs for @test1 tag");
	}

}
