package wat2021;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;import java.util.List;
import org.junit.After;import org.junit.Before;
import org.junit.Test;import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class TestSelect {private WebDriver driver;
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
public void testOptions() {
	driver.get("http://localhost:8080/workspace/select.html");
	//WebElement oldugu new element yapiyoruz.
	Select pickCar = new Select(driver.findElement(By.id("car")));
	List<WebElement> options = pickCar.getOptions();
	String[] expected = {"Pick a car", "Volvo", "Saab", "Mercedes", "Audi"};
	List<String> actual = new ArrayList<String>();
	for (WebElement option: options) {
		actual.add(option.getText());
		}
	assertArrayEquals(expected, actual.toArray());
	}
@Test
public void testSelect() {
	driver.get("http://localhost:8080/workspace/select.html");
	
	Select pickCar = new Select(driver.findElement(By.id("car")));
	WebElement display = driver.findElement(By.id("display"));
	
	//ilk sectigi webelementi doner. Cunku gorunen ilk element Pick a cardir.
	WebElement selected = pickCar.getFirstSelectedOption();
	assertEquals("Pick a car", selected.getText());
	
	// gorunen textten ilk arabayi secelim.
	pickCar.selectByVisibleText("Audi");
	selected = pickCar.getFirstSelectedOption();
	assertEquals("Audi", selected.getText());
	
	//lower case audi value oldugu icin get.attribute ile cagirabiliriz.
	assertEquals("audi", selected.getAttribute("value"));
	
	//Indexine gore secebiliriz
	pickCar.selectByIndex(3);
	selected = pickCar.getFirstSelectedOption();
	assertEquals("Mercedes", selected.getText());
	assertEquals("Mercedes", display.getText());
	assertEquals("mercedes", selected.getAttribute("value"));
 

}
}

