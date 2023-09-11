package stepDefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddHighestPriceProduct {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		ChromeOptions options=new ChromeOptions();
//		options.setBrowserVersion("Stable");
		options.addArguments("--remote-allow-origins=*");
	    driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/v1/inventory.html");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		System.out.println("Title Of page : "+driver.getTitle());
		List<WebElement> pricelist=driver.findElements(By.className("inventory_item_price"));
		
		double maxPrice=0;
		for(WebElement e: pricelist) {
		double	price=Double.parseDouble(e.getText().replace("$", ""));
			
			if(maxPrice < price) {
				maxPrice=price;
			}
		}
		
		System.out.println("Highest price : "+maxPrice);
		WebElement maxPriceAddToCart=driver.findElement(By.xpath("//div[normalize-space()='$"+maxPrice+"']/following-sibling::button[.='ADD TO CART']"));	
		
		maxPriceAddToCart.click();
		
		System.out.println("----------------------");
		
		double minPrice=Double.parseDouble(pricelist.get(0).getText().replace("$", ""));
		for(WebElement e: pricelist) {
		double	price=Double.parseDouble(e.getText().replace("$", ""));
		
			
			if(minPrice > price) {
				minPrice=price;
			}
		}
		
		System.out.println("Minumum price : "+minPrice);
		 WebElement minPriceAddToCart=driver.findElement(By.xpath("//div[normalize-space()='$"+minPrice+"']/following-sibling::button[.='ADD TO CART']"));	
			
	        minPriceAddToCart.click();
	        
	//	driver.close();
	}

}
