package hw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndeedHomePage {
	private WebDriverWait wait;
	private WebDriver driver;
	private static final String URL ="https://www.indeed.com/";
	
	public IndeedHomePage(WebDriver driver) {
		this.driver = driver;
		this.driver.get(URL);
	}
		
	public IndeedSearchBar getSearchbar() {
		return new IndeedSearchBar(driver);
	}	
}