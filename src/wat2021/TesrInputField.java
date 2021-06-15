package wat2021;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesrInputField {
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
	public void testInput() {
		driver.get("http://localhost:8080/workspace/input.html");
		//id ile name kismini cagirdik
		WebElement name = driver.findElement(By.id("name"));
		//isim butonunda default olarak type your name yaziyordu onu temizlemek icin clear metodunu kullandik.
		name.clear();
		// isim butonuna isim girdik
		name.sendKeys("John");
		// id ile butonu cagirdik
		WebElement btn = driver.findElement(By.id("btn"));
		// butonu tikladik
		btn.click();
		// display kismini test ettik
		WebElement display = driver.findElement(By.id("display"));
		assertEquals("Hello John", display.getText());
		}
	}

