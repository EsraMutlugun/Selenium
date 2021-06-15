
//Kendi expectationimizi yazabiliriz.aIstedigimiz  yrde istedigimiz sekilde b 

package wat2021;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
public class TestAsync4 {private WebDriver driver;

@Before
public void setUp() {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


@After
public void tearDown() {
	driver.quit();
	}

@Test
public void testSubmit() {
	driver.get("http://localhost:8080/workspace/jswaitec.html");
	WebElement input = driver.findElement(By.id("name"));
	input.clear();
	input.sendKeys("John");
	WebElement btn = driver.findElement(By.id("btn"));
	btn.click();
	
	// I want Selenium to wait until <p id="display"> has non-empty-string text
	//Ne yazacagi onemli degil sadece text kisminin bos olmamasini kontrol ediyorum cunku daha sonra cikan texti
	//assertequal ile kontrol edecegim.
	WebElement display = driver.findElement(By.id("display"));
	WebDriverWait wait = new WebDriverWait(driver, 60);
	wait.until(
			//<Boolean> istedigimiz return type kismini yazdik.true ya da false olarak donecek bize
			new ExpectedCondition<Boolean>() {
		public Boolean apply(WebDriver d) {
			WebElement display = driver.findElement(By.id("display"));
			return !display.getText().equals("");
			}});
	assertEquals("John", display.getText());
	}
}

