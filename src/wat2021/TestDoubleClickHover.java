// cift tiklayinca sari kutu kirmiziya donuyor

package wat2021;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class TestDoubleClickHover {
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
	// cift tiklayinca sari kutu kirmiziya donuyor. Bunu test edecegiz.

	public void testDoubleClick() {
		driver.get("http://localhost:8080/workspace/dblclick.html");
		WebElement square = driver.findElement(By.id("square"));
		
		//sari oldugunu kontrol ediyoruz
		assertEquals("rgba(255, 255, 0, 1)", square.getCssValue("background-color"));
		
		//cift tiklamak icin bir action yapiyoruz.
		Actions builder = new Actions(driver);
		builder.doubleClick(square).perform();
		
		// backround renginin kirmiziya donup donmedigini kontrol ediyoruz.
		assertEquals("rgba(255, 0, 0, 1)", square.getCssValue("background-color"));
		}
	
	//
	@Test
	
	// elementin fareyle uzerine gelmek icin 
	public void testHover() {
			driver.get("http://localhost:8080/workspace/hover.html");
			WebElement square = driver.findElement(By.id("square"));
			
			//Backround kontrolu yap,
			assertEquals("rgba(255, 255, 0, 1)", square.getCssValue("background-color"));
			
			//hover icin farkli olarak sadece moveToElement yaziyoruz
			Actions builder = new Actions(driver);
			builder.moveToElement(square).perform();
			assertEquals("rgba(255, 0, 0, 1)", square.getCssValue("background-color"));
			}
		}
