package JUnitTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndeedTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		IndeedJobSearchHomePage page = new IndeedJobSearchHomePage(driver);
		IndeedJobSearchBar bar = page.getSearchbar();
		IndeedJobSearchResultPage resultPage = bar.search("QA", "San Jose,CA");
		resultPage.printResults();
		driver.quit();		
	}	

}
