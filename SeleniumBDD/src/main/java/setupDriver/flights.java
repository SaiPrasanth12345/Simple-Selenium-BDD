package setupDriver;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class flights {
	WebDriver driver;

	private String closePopup = "//span[@data-cy='closeModal']";
	private String flightsBtn = "//li[@data-cy='menu_Flights']//span[text()='Flights'][1]";
	private String oneWayBtn = "//li[@data-cy='oneWayTrip']//span";
	private String Btn_From = "//label[@for='fromCity']/span[.='From']";
	private String search_From = "//label[@for='fromCity']/following-sibling::div//input[@placeholder='From']";
	private String select_From = "//*[.='fromAirport']/ancestor::li";
	private String Btn_To = "//label[@for='toCity']/span[.='To']";
	private String search_To = "//label[@for='toCity']//input[@id='toCity']";
	private String select_To = "//*[.='toAirport']/ancestor::li";
	private String travel_date = "//div[contains(@aria-label,'travelDate')]";
	private String search_btn = "//p[@data-cy='submit']/a[.='Search']";
	private String flightComparisionPopup = "//div[@class='fliCompCoachmark']//span[.='GOT IT']";
	private String flightsPageLoaded = "//span[.='Flights from fromDest to toDest']";
	private String first_flightSelect = "//div[@class=' '][1]//div[contains(@class,'listingCard')]//span[.='VIEW PRICES']";
	private String bookNowBtn = "//div[contains(@class,'fareFamilyCardWrapper')][1]//button[.='BOOK NOW']"; 

	public flights(WebDriver getdriver) {
		driver = getdriver;
	}

	public void launchFlightsURL(String url, Scenario scenario) {
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);

		// close popup
		driver.findElement(By.xpath(closePopup)).click();
	}

	public void selectOneWayFlight(Scenario scenario) {
		// flights Click
		driver.findElement(By.xpath(flightsBtn)).click();

		// one way button
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(oneWayBtn)));
		driver.findElement(By.xpath(oneWayBtn)).click();
	}

	public void selectFromFlightDestination(String fromDest, String fromAirport, Scenario scenario) {
		// Select from
		driver.findElement(By.xpath(Btn_From)).click();
		driver.findElement(By.xpath(search_From)).sendKeys(fromDest);
		select_From = select_From.replace("fromAirport", fromAirport);
		driver.findElement(By.xpath(select_From)).click();
	}

	public void selectToFlightDestination(String toDest, String toAirport, Scenario scenario) {
		// Select To
		driver.findElement(By.xpath(Btn_To)).click();
		driver.findElement(By.xpath(search_To)).sendKeys(toDest);
		select_To = select_To.replace("toAirport", toAirport);
		driver.findElement(By.xpath(select_To)).click();
	}
	
	public void selectTravelDate(String date) {
		travel_date = travel_date.replace("travelDate", date);
		driver.findElement(By.xpath(travel_date)).click();
	}
	
	public void searchFlights(String fromDest, String toDest) {
		// click on Search
		driver.findElement(By.xpath(search_btn)).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		flightsPageLoaded = flightsPageLoaded.replace("fromDest", fromDest).replace("toDest", toDest);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(flightsPageLoaded)));
		
		// Click got it on flights Compare popup
		WebElement flightCompare = driver.findElement(By.xpath(flightComparisionPopup));
		if(flightCompare.isDisplayed()) {
			flightCompare.click();
		}
	}
	
	public void selectFirstFlight() {
		// click on first flight
		driver.findElement(By.xpath(first_flightSelect)).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable (By.xpath(bookNowBtn)));
		driver.findElement(By.xpath(bookNowBtn)).click();
	}
}
