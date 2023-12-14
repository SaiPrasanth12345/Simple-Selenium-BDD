package setupDriver;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	WebDriver driver;	

	public Screenshot(WebDriver getdriver) {
		driver = getdriver;
	}
	
	public byte[] screnshotTake() {
		TakesScreenshot scrnsht = (TakesScreenshot)driver;
		return scrnsht.getScreenshotAs(OutputType.BYTES);
	}

}
