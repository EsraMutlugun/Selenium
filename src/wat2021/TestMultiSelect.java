//Multiple select yapmak icin tablodan sectiklerimize click yapiyoruz.
//select byvalue, select byvisibletext, select byindex kullanabiliriz. can Not use simple clik

package wat2021;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.After; 
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class TestMultiSelect {
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
	public void testMultiSelect() {
		driver.get("http://localhost:8080/workspace/multiple.html");
		//tek ya da multiple olsa da fark etmez bir tane secme elementi yapmak lazim
		Select pick = new Select(driver.findElement(By.id("color")));
		//isMultiple multiple selecti destekler.
		assertEquals(true, pick.isMultiple());
		//sadece seciyoruz clik etmiyoruz. Bu aslinda user behaviri tam gostermez cunku kullanici bu sekilde secmiyor. Ama simulate etmek icin kullanilir
		pick.selectByVisibleText("Red");
		pick.selectByVisibleText("White");
		WebElement display = driver.findElement(By.id("display"));
		assertEquals("White,Red", display.getText());
		}
	
	//deselect fonksiyonu
	@Test
	public void testMultiSelect2() {
		driver.get("http://localhost:8080/workspace/multiple.html");
		Select pick = new Select(driver.findElement(By.id("color")));
		//once kirmizi ve beyazi seciyorsun
		pick.selectByVisibleText("Red");
		pick.selectByVisibleText("White");
		//sonra beyazi deselect yapiyorsun yani birakiyorsun
		pick.deselectByIndex(1);
		// sonra value ile kahverengiyi seciyorsun
		pick.selectByValue("rb");
		WebElement display = driver.findElement(By.id("display"));
		assertEquals("Red,Brown", display.getText());
		
		//Sonra butun secilmis objeleri bir listede topluyoruz.
		List<WebElement> selected = pick.getAllSelectedOptions();
		String[] expected = {"Red", "Brown"};
		List<String> actual = new ArrayList();
		for (WebElement option: selected) {
			actual.add(option.getText());
			}
		assertArrayEquals(expected, actual.toArray());
		}
	}


