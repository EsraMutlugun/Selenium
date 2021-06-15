package hw; 
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {
public void getBooksInfo5(){
	System.setProperty("webdriver.chrome.driver", 
			"./drivers/chromedriver"
			);
	WebDriver driver = new ChromeDriver();
	driver.get("http://www.amazon.com");

	
	WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
	input.sendKeys("Selenium Webdriver Book");
	
	WebElement searchIcon = driver.findElement(By.id("nav-search-submit-button"));
	searchIcon.click();
		List<WebElement> books = driver.findElements(By.xpath(
						"//div[@class='s-result-item s-asin sg-col-0-of-12 sg-col-16-of-20 sg-col sg-col-12-of-16']"));
		System.out.println(books.size());
		    try {
		        if (books.size() > 0) {
		            String title, price = null;
		            int i = 0;
		            for (WebElement el : books) {
		                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", el);
		                i++;
		                title = el.findElement(By.cssSelector(
		              "span[class='a-size-medium a-color-base a-text-normal']"))
		                        .getText();
		                System.out.println("Title:"  + title);
		                if(el.findElements(By.xpath(".//a[text()='Paperback']/../following-sibling::[1]//[contains(@class,'a-price')]")).size()>0){
		                    price = el.findElement(By.xpath(".//a[text()='Paperback']/../following-sibling::[1]//[contains(@class,'a-price')]")).getText();
		                 
		                } if 
		                	(price.equals("Paperback")){
		                	
		                System.out.println("Price:" + (price));
		            }}
		        } else
		            System.out.println("No Paperback Price");
		    } catch (Exception e) {
		        System.out.println(e.getLocalizedMessage());
		    }}
		}
