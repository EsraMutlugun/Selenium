package JUnitTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class IndeedJobSearchResultPage {
	@FindAll({ @FindBy(xpath = "//div[@class='jobsearch-SerpJobCard unifiedRow row result clickcard']") })
	
	private List<WebElement> results;
	
	public IndeedJobSearchResultPage(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);

	}

	public void printResults() {
		for (WebElement result: results) {
			WebElement jobTitle = result.findElement(By.cssSelector("h2>a:nth-child(1)"));
			WebElement company = result.findElement(By.cssSelector("span[class='company']"));
			WebElement location = result.findElement(By.cssSelector("div.sjcl>:nth-child(3)"));
			System.out.println(jobTitle.getText()+"\n" + company.getText()+"\n"+location.getText()+"\n"+"========");		
		}
		
	}

}

