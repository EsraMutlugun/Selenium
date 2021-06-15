package hw;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class AssignmentExpedia2 {
private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

		driver = new ChromeDriver();
		driver.get("https://www.expedia.com/");
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);  
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

@Test
	
	public void flight() throws InterruptedException {
	
	 WebElement icon = driver.findElement(By.xpath("//span[contains(text(),'Flights')]"));
     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
     icon.click();
	
	
	WebElement leavingbutton = driver.findElement( By.cssSelector ("button[class='uitk-faux-input']"));
	 leavingbutton.sendKeys("sfo");
	 
	 WebDriverWait wait = new WebDriverWait(driver, 10);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[class='uitk-typeahead-result-item has-subtext']")));	
	 
	 // Write sfo to leaving button
	 
	 leavingbutton.sendKeys(Keys.ARROW_DOWN);
	 WebElement sfo = driver.findElement(By.cssSelector("div[class='truncate']"));
	 sfo.click();
	 
	 
	 
	 WebElement goingbutton = driver.findElement(By.xpath("//button[@aria-label='Going to']"));
     goingbutton.sendKeys("nyc");
     
     WebDriverWait wait2 = new WebDriverWait(driver, 10);
     wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-stid='location-field-leg1-destination-result-item-button']")));
     
     goingbutton.sendKeys(Keys.ARROW_DOWN);
     WebElement nyc = driver.findElement(By.xpath("//*[contains(text(),'New York (NYC - All Airports)')]"));
     
     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 nyc.click();
		
	 //Clicking Search Button
	 
	  WebDriverWait wait3 = new WebDriverWait(driver, 10);
	  WebElement search =wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='submit']")));	
	 
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	  search.click();
	  
//	  //Click Show  More Button
	  
	  WebDriverWait wait4 = new WebDriverWait(driver, 10);
	  WebElement showmore=wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Show More']")));	
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  showmore.click();
	
	

	  List<WebElement> results = driver.findElements(By.cssSelector(
 			 "li[data-test-id='offer-listing'] > [data-test-id='intersection-observer']"));
	  System.out.println(results.size());
	  for (WebElement result: results){
		  WebElement date = result.findElement(By.cssSelector("[data-test-id='arrival-time'] [data-test-id='departure-time']"));
		  WebElement price = result.findElement(By.cssSelector(".uitk-lockup-price"));
		
		  try {
				result.findElement(By.cssSelector("sup[data-test-id='arrives-next-day']"));
			} catch (Exception e) {
				System.out.println(date.getText()+ "\n" + price.getText());
				continue;
			}
			
			System.out.println(date.getText()+ " (next day)\n " + price.getText());

		}
		  
		  
	  }
	 

}









