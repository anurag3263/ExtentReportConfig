package stepDefinition;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.basePackage.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;

public class Utils extends BaseClass {
		
	public static String GetCurrentDate() {
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMMM-dd-HH-mm-ss");
		String date = formatter.format(d);
		System.out.println(date);
		return date;

	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// Take a screenshot...
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			// embed it in the report.
			scenario.attach(screenshot, "image/png", scenario.getName());
			driver.quit();
		}
		if (scenario.getStatus()==Status.PASSED) {
			// Take a screenshot...
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			// embed it in the report.
			scenario.attach(screenshot, "image/png", scenario.getName());
			driver.quit();
		}

	}

}
