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
	public class FindByCssAttribute {

		private WebDriver driver;
		
		@Before
		public void setUp() 
		{System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver = new ChromeDriver();
		}
		
		@After
		public void tearDown() 
		{driver.quit();
		}
		@Test
		// Name should be in bracelet and value in a single quotation mark
		public void testFindElementByName() {
			driver.get("http://localhost:8080/workspace/search.html");
			WebElement input = driver.findElement(By.cssSelector("[name='keyword']"));
			assertEquals("Type in your keyword", input.getAttribute("value"));
			}
		
		@Test
		// The for loop is run to find all the Target links in it.
		public void testFindLinksWithTarget() {
			driver.get("http://localhost:8080/workspace/links.html");
			List<WebElement> links = driver.findElements(By.cssSelector("a[target]"));
			String[] expected = {"Google site" , "MSN Link"};
			List<String> actual = new ArrayList();
			for(WebElement link : links) {
				actual.add(link.getText());
			}
			
			assertArrayEquals(expected, actual.toArray());	
		}
		
		@Test
		public void testFindLinksOpensNewTab() {
			driver.get("http://localhost:8080/workspace/links.html");
			WebElement link = driver.findElement(By.cssSelector("a[target='_blank']"));
			assertEquals("MSN Link"	, link.getText());
}
		@Test
		// Find first secure links in global page  mean that which are start with "https" not "http" first because findElement find first one
		public void testFindFirstSecureLink() {
			driver.get("http://localhost:8080/workspace/links.html");
			WebElement link = driver.findElement(By.cssSelector("a[href^='https']"));
			assertEquals("Google site", link.getText());
		}
		@Test
		// Find first secure links inside a list 
		//1. yol :first find list then inside the subtree find first secure link
		public void testFindFirstSecureLinkInList() {
			driver.get("http://localhost:8080/workspace/links.html");
			WebElement ol = driver.findElement(By.id("list2"));
			WebElement link = ol.findElement(By.cssSelector("a[href^='https']"));
			assertEquals("Facebook", link.getText());
	}
		// 2. yol Find first secure links inside a list 
		//use driver method to do that
		//       public void testFindFirstSecureLinkInList() {
		//       driver.get("http://localhost:8080/workspace/links.html");
		//       WebElement link = driver.findElement(By.id("list2"))
		//                        .findElement(By.cssSelector("a[href^='https']"));
		//       assertEquals("Facebook", link.getText());
		//3. yol 
		//       WebElement link = driver.findElement(By.cssSelector("#list2 a[href^='https']"));
		//       assertEquals("Facebook", link.getText());
		@Test
		// Find first pdf link
		public void testFindFirstPDFLink() {
			driver.get("http://localhost:8080/workspace/links.html");
			WebElement link = driver.findElement(By.cssSelector("a[href$='.pdf']"));
			assertEquals("Contract draft", link.getText());
		
	}	
		@Test
		// test password box
		public void testFindPasswordField() {
			driver.get("http://localhost:8080/workspace/xpath.html");
			WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
			assertEquals("secret", password.getAttribute("value"));
		
		
	}
}	

			
