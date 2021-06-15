package hw;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentExpedia {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.expedia.com/");

		WebElement icon = driver.findElement(By.cssSelector("a[href='?pwaLob=wizard-flight-pwa']"));
		icon.click();

		WebElement leavingbutton = driver.findElement(By.cssSelector("button[aria-label='Leaving from']"));
		leavingbutton.sendKeys("sfo");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("li[class='uitk-typeahead-result-item has-subtext']")));

		leavingbutton.sendKeys(Keys.ARROW_DOWN);
		WebElement sfo = driver.findElement(By.cssSelector("div[class='truncate']"));
		sfo.click();

		WebElement goingbutton = driver.findElement(By.cssSelector("button[aria-label='Going to']"));
		goingbutton.sendKeys("nyc");

		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("button[data-stid='location-field-leg1-destination-result-item-button']")));

		goingbutton.sendKeys(Keys.ARROW_DOWN);
		WebElement nyc = driver.findElement(By.xpath("//span/strong[text()='New York (NYC - All Airports)']"));
		nyc.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}

		WebElement search = driver.findElement(By.cssSelector(
				"button[class='uitk-button uitk-button-large uitk-button-fullWidth uitk-button-has-text uitk-button-primary']"));
		search.click();

		

		List<WebElement> flights = driver
				.findElements(By.xpath("//div[@class='uitk-card-content-section uitk-card-content-section-padded']"));
				
		for (WebElement flight : flights) {
			WebElement price = flight.findElement(By.cssSelector("span[class='uitk-price-a11y is-visually-hidden']"));
			WebElement time = flight.findElement(By.cssSelector("span[class='uitk-text uitk-type-400 uitk-type-bold uitk-text-emphasis-theme']"));
			
			try {
				flight.findElement(By.cssSelector("span[class='uitk-text uitk-type-100 uitk-spacing uitk-spacing-margin-inlinestart-one uitk-text-negative-theme']"));
			} catch (Exception e) {
				System.out.println(time.getText()+ "\n"+ price.getText());
				continue;
			}
			
			System.out.println(time.getText()+ " (next day)\n "+ price.getText());

		}
		driver.quit();
	}
}
