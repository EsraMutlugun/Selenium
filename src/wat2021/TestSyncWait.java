//After submitted we need to wait for other page loading

package wat2021;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSyncWait {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver = new ChromeDriver();
		}
	
	@After
	public void tearDown() {
		driver.quit();
		}
	
	@Test
	public void testSubmit() {
		driver.get("http://localhost:8080/workspace/wait.php");
		
		// I am in the first page
		WebElement input = driver.findElement(By.id("name"));
		input.clear();
		input.sendKeys("John");
		input.submit();
		
		// Selenium waits for 5 seconds !otomaticly
		// I am in the second page
		//fakat bu yontem cok populer degil cunku selenium javascript ile ilgili waiting islemlerinde iyi degil
		//gunumuzde browserdan degil javascript ile get post request yapiliyor o yuzden selenium onda degil single web
		// ile daha iyi.
		
		WebElement display = driver.findElement(By.id("display"));
		assertEquals("John", display.getText());
		}
	
	}
