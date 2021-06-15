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
public class FindElementDemo {
	private WebDriver driver;
	
	@Before
	public void setUp() {System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
	
	driver = new ChromeDriver();
	}
	@After
	public void tearDown() 
	{driver.quit();
	}
	@Test
	// Check the text match with original one.
	// If <h1>Hello World</h1> is a text file should use get.Text method
	public void testFindElementById(){
		driver.get("http://localhost:8080/workspace/helloworld.html");
		WebElement h1 = driver.findElement(By.id("title"));
		assertEquals("Hello World", h1.getText());
		}
	@Test
	// Check search button with by.name if there is more than one in same name always return the first one.
	// If <input type="text" value ="hello/> there isn't child and should use get.Attribute method
	
	public void testFindElementByName() {
		driver.get("http://localhost:8080/workspace/search.html");
		WebElement input = driver.findElement(By.name("keyword"));
		assertEquals("Type in your keyword", input.getAttribute("value"));
	}
	@Test
	// I want to find element by labels FindElement search a key
	public void testFindElementByTagName() {
		driver.get("http://localhost:8080/workspace/search.html");
		WebElement label = driver.findElement(By.tagName("label"));
		// Now inside the label element to find
		assertEquals("Search2", label.getText());
		
	}
	@Test
	// Find all elements by tag names use for loop to check all of them FindElements search a list
	public void testFindElementsByTagName() {
		driver.get("http://localhost:8080/workspace/search.html");
		List<WebElement> labels = driver.findElements(By.cssSelector("label"));
		assertEquals(2, labels.size());
		String[] expected = {"Search2" , "Search"};
		List<String> actual = new ArrayList();
		for(WebElement label : labels) {
			actual.add(label.getText());
		}
		
		assertArrayEquals(expected, actual.toArray());	
	}
	
}
    

