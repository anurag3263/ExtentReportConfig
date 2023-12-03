package stepDefinition;

import java.time.Duration;


import org.openqa.selenium.By;
import org.testng.Assert;

import com.basePackage.BaseClass;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FaceboolStepDef extends BaseClass {
private Scenario scenario;

	//	static WebDriver driver;
	// ChromeOptions chromeOptions = new ChromeOptions();
	// chromeOptions.addArguments("--headless");
	@Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }


	@Given("open the facebbok url")
	public void open_the_facebbok_url() {

//		WebDriverManager.chromedriver().setup();

//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("start-maximized"); // open Browser in maximized mode
//		options.addArguments("disable-infobars"); // disabling Infobars
//		options.addArguments("--disable-extensions"); // disabling extensions
//		options.addArguments("--disable-gpu"); // applicable to windows os only
//		options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
//		options.addArguments("--no-sandbox"); // Bypass OS security model
//		WebDriver driver = new ChromeDriver(options);
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
		setup();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Utils.attach(scenario);
	}

	@When("navigated to home page")
	public void navigated_to_home_page() {
		String title = driver.getTitle();
		System.out.println(title);

		String expected = "Facebook – log in or sign up";
		Utils.attach(scenario);
		Assert.assertEquals(expected, title);
	}

	@Then("enter user name {string} and Passcode {string}")
	public void enter_user_name_and_passcode(String string, String string2) {
		driver.findElement(By.name("email")).sendKeys(string);
		driver.findElement(By.name("pass")).sendKeys(string2);
		Utils.attach(scenario);
		driver.findElement(By.name("login")).click();
	}

	@Then("it should show the error message")
	public void it_should_show_the_error_message() throws Exception {
		Thread.sleep(3000);
		Utils.attach(scenario);
	//	takeSnapShot("ErrorFacebookAttach");
		Assert.assertFalse(driver.findElement(By.xpath("(//a[contains(.,'Forgotten')])[1]")).isDisplayed());
		tearDown();
	}

}
