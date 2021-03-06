package wat2021;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class TestPrompt {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/workspace/prompt.html");
		}
	
	@After
	public void tearDown() {
		driver.quit();
		}
	
	@Test
	public void testAccept() {
		//butonu bulup tiklayip gelen kutuya ismimizi yazacagiz
		WebElement btn = driver.findElement(By.cssSelector("[value='What is your name?']"));
		btn.click();
		
		//kutudaki ismin yazilmasi icin bekleme yapmak he zaman daha mantikli
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		
		//kutudaki alerti mesaja donduruyoruz
		Alert alert = driver.switchTo().alert();
		assertEquals("What is your name?", alert.getText());
		
		//kabul ettigimiz icin ismimizi girip yolluyoruz
		alert.sendKeys("John");
		alert.accept();
		
		//ismi girincehello john yazmasi gerek onu test ediyoruz
		WebElement message = driver.findElement(By.tagName("p"));
		assertEquals("Hello John", message.getText());
		}
	
	@Test
	public void testDismiss() {
		WebElement btn = driver.findElement(By.cssSelector("[value='What is your name?']"));
		btn.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
	

		Alert alert = driver.switchTo().alert();
		assertEquals("What is your name?", alert.getText());
		alert.sendKeys("John");
		alert.dismiss();
		
		WebElement message = driver.findElement(By.tagName("p"));
		assertEquals("Hello World", message.getText());
   }
	}