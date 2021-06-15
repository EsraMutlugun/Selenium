package hw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IndeedSearchBar {
	private WebDriver driver;
	
	@FindBy(xpath="//input[@id='text-input-what']")
	public WebElement searchBoxWhat;
	
	@FindBy(xpath="//input[@id='text-input-where']")
	public WebElement searchBoxWhere;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement findButton;
	
	public IndeedSearchBar(WebDriver driver) {
		this.driver=driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	

	}	
	public IndeedResultPage search(String what, String where) {
		
		searchBoxWhat.sendKeys(what);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		searchBoxWhere.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
		searchBoxWhere.sendKeys(where);
		
		findButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return new IndeedResultPage(driver);	
	}

}
