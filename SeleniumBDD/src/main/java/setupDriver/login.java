package setupDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class login {
	WebDriver driver;
	
	Screenshot screenshot = new Screenshot(driver);

	private String username_field = "//input[@name='uname']";
	private String password_field = "//input[@name='pass']";
	private String login_btn = "//input[@value='login']";
	private String logoutBtn = "//a[.='Logout test']";

	public login(WebDriver getdriver) {
		driver = getdriver;
	}
	
	public void launchURL(String url, Scenario scenario) {
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
	}
	
	public void enterLoginDetails(String username, String password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(username_field)));
		driver.findElement(By.xpath(username_field)).clear();
		driver.findElement(By.xpath(username_field)).sendKeys(username);
		driver.findElement(By.xpath(password_field)).clear();
		driver.findElement(By.xpath(password_field)).sendKeys(password);
	}

	public void clickLoginBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(login_btn)));
		driver.findElement(By.xpath(login_btn)).click();
	}

	public boolean logoutDisplayed() {
		List<WebElement> logoutele = driver.findElements(By.xpath(logoutBtn));
		return (logoutele.size() > 0);
	}
	
}
