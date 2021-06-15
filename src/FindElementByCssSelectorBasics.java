

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
	public class FindElementByCssSelectorBasics {
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
		// If <h1>Hello World</h1> is a text file should use get.Text method and if I use cssSelector for id add # symbol
		public void testFindElementById(){
			driver.get("http://localhost:8080/workspace/helloworld.html");
			WebElement h1 = driver.findElement(By.cssSelector("#title"));
			assertEquals("Hello World", h1.getText());
			}

		
		@Test
		// I want to find element by labels and if i use tag name in cssSelector  dont need to use any symbol just name
		public void testFindElementByTagName() {
			driver.get("http://localhost:8080/workspace/search.html");
			WebElement label = driver.findElement(By.cssSelector("label"));
			// Now inside the label element to find
			assertEquals("Search2", label.getText());	
			
		    }
		@Test
		
		// I if I use cssSelector for class name selector should  add . symbol
		public void testFindElementByClassNmae(){
			driver.get("http://localhost:8080/workspace/search.html");
			WebElement label = driver.findElement(By.cssSelector(".label"));
			assertEquals("Search", label.getText());
			}
	}
	
