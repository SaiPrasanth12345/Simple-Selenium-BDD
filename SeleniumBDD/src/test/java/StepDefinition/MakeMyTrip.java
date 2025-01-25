package StepDefinition;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import setupDriver.flights;
import setupDriver.login;

public class MakeMyTrip {
	
	public WebDriver driver = DriverSetup.driver;
	public flights flightsPage = DriverSetup.flightsPage;
	DriverSetup driversetup = new DriverSetup();
	Scenario scenario = driversetup.scenario;
	public String fromDest;
	public String toDest;
	
	@Given("Launch MakeMyTrip Website")
	public void launch_make_my_trip_website() {
		flightsPage.launchFlightsURL("https://www.makemytrip.com/flights/", scenario);
	}
	
	@When("Select One way Flight")
	public void select_one_way_flight() {
	    flightsPage.selectOneWayFlight(scenario);
	}
	
	@When("Select the from Destination as {string} from {string} Airport")
	public void select_the_from_destination_as_from_airport(String fromDest, String fromAirport) {
		this.fromDest = fromDest;
	    flightsPage.selectFromFlightDestination(fromDest, fromAirport, scenario);
	}
	
	@When("Select the To Destination as {string} from {string} Airport")
	public void select_the_to_destination_as_from_airport(String toDest, String toAirport) {
		this.toDest = toDest;
		flightsPage.selectToFlightDestination(toDest, toAirport, scenario);
	}
	
	@Given("Select today as Travel date")
	public void select_today_as_travel_date() {
		LocalDate d= LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd yyyy");
		String date = d.format(dtf);
	    flightsPage.selectTravelDate(date);
	}
	
	@When("Search for flights")
	public void search_for_flights() {
	    flightsPage.searchFlights(fromDest, toDest);
	}

}
