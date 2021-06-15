
// bazen coklu secim yaparken shifte basip rowlarin bir kac tanesini secmek durumunda kalabiliriz. O zaman 
//asagidaki yontemi kullanmaliyiz.

package wat2021;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class TestMouseKeyCombination {
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
	 
	public void testShiftClick() {
		driver.get("http://localhost:8080/workspace/longselect.html");
		
		// tag name ile aldik cunku sadece bir tag var.
		WebElement list = driver.findElement(By.tagName("select"));
		
		//once row3 elementini ariyoruz sonra row5'e kadar onu secmemiz gerekecek
		//listenin icinde elementi aradigimiz icin noktayla basliyoruz. immidiate child aradigimiz icin noktadan sonra tek slash koyup text ile cagiriyoruz.
		WebElement row3 = list.findElement(By.xpath("./option[text()='row 3']"));
		WebElement row5 = list.findElement(By.xpath("./option[text()='row 5']"));
		
		//click row3 sonra click row 5 sonrada shift basip aradakileri secmek icin Keys.shift metodunu kullaniyoruz
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.SHIFT).click(row5).click(row3).keyUp(Keys.SHIFT).perform();
		
		//gelip gelmedigini test etmek icin
		String[] expected = {"row 3", "row 4", "row 5"};
		
		Select select = new Select(list);
		List<String> actual = new ArrayList();
		
		for (WebElement option: select.getAllSelectedOptions()) {
			actual.add(option.getText());
			}
		assertArrayEquals(expected, actual.toArray());
			}}
