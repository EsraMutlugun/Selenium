package JUnitTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndeedJobSearchHomePage {
	private WebDriverWait wait;
	private WebDriver driver;
	private static final String URL ="https://www.indeed.com/";
	
	public IndeedJobSearchHomePage(WebDriver driver) {
		this.driver = driver;
		this.driver.get(URL);
	}
		
	public IndeedJobSearchBar getSearchbar() {
		return new IndeedJobSearchBar(driver);
	}	
}