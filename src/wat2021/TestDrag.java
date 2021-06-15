package wat2021;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import com.google.common.io.Files;
public class TestDrag {
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
	public void testDrag() throws IOException {
		driver.get("http://www.dhtmlgoodies.com/scripts/dg-crop/dg-crop.html");
		
		//webelementi parent id numarasi ile aldik aslinda kendi class name vardi ama id her zamana daha iyi
		WebElement drag = driver.findElement(By.cssSelector("#cropImage .dg-crop"));
		
		//once screenshot aliyoruz drag etmeden,
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(srcFile, new File("./screenshots/before-drag.png"));
		
		//pozisyonu gormek icin test ediyoruz.onceki expected value olmali sonraki gercek value konulmali test edilmek istenen.
		assertEquals("absolute", drag.getCssValue("position"));
		assertEquals("66px", drag.getCssValue("top"));
		assertEquals("66px", drag.getCssValue("left"));
		
		// drag etmek icin click and hold kullaniyoruz ve elle giriyotuz hareketini
		Actions builder = new Actions(driver);builder.clickAndHold(drag).moveByOffset(100, 50).release().perform();
		
		// Degisimi gormek icin tekrar screenshot alabiliriz.
		srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(srcFile, new File("./screenshots/after-drag.png"));
		
		// test ediyoruz konum pozisyon dogru mu diye?
		assertEquals("116px", drag.getCssValue("top"));
		assertEquals("166px", drag.getCssValue("left"));
		}
	}

