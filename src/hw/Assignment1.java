package hw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				"./drivers/chromedriver"
				);
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.com");

		
		WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
		input.sendKeys("Selenium Webdriver Book");
		
		WebElement searchIcon = driver.findElement(By.id("nav-search-submit-button"));
		searchIcon.click();
		List<WebElement> books = driver.findElements(By.xpath("//div[@class='s-result-item s-asin sg-col-0-of-12 sg-col-16-of-20 sg-col sg-col-12-of-16']"));
		
		for (WebElement book: books) {
			WebElement bookname = book.findElement(By.cssSelector("span[class='a-size-medium a-color-base a-text-normal']"));
			System.out.println(bookname.getText());
			
			List<WebElement> types = book.findElements(By.cssSelector("div[class='a-section a-spacing-none a-spacing-top-small']"));
			boolean found = false;
			for (WebElement type:types) {
				String all = type.getText();
				if (all.contains("Paperback")) {
					found = true;
					String[] splitted = all.split("\n");
					System.out.println(splitted[1] +"."+splitted[2]);
				}
			}
			if (!found) {
				System.out.println("No paperback price");
			}
		}
	driver.quit();
	}
	
}



 