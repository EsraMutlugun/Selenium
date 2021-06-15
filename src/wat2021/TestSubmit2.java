
	package wat2021;

	import static org.junit.jupiter.api.Assertions.assertEquals;

	import org.junit.After;
	import org.junit.Before;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class TestSubmit2 {
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
			driver.get("http://localhost:8080/workspace/form.php");
			// I am in the first page with a blank form.First no text in it and I test it.
			WebElement display = driver.findElement(By.id("display"));
			assertEquals("", display.getText());
			
			// submitten once ve submitten sonra olmak uzere iki defa test edebiliriz.
			WebElement name = driver.findElement(By.id("id"));
			name.clear();
			name.sendKeys("John");
			WebElement btn = driver.findElement(By.id("btn"));
			btn.click();
			// I am in the second page with a blank form and a name displayed below fakat kod calismadi.Cunku display yoktu onu ekleyince calisacak
			// org.openqa.selenium.StaleElementReferenceException: 
			// 	stale element reference: element is not attached to the page document iki sayfa oldugu icin iki kere webelement kullandik.
			display = driver.findElement(By.id("display"));
			assertEquals("John", display.getText());
		}
	}


