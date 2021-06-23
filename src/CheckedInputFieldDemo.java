// Test for Amazon page checking whether the checkbox box marked.

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckedInputFieldDemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/workspace/checkbox.html");
		
		// Find all CheckBoxes box and adds to the list
		List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
		
		// checks if the checkboxes in the list are checked.
		for (WebElement checkbox : checkboxes) {
			System.out.println(checkbox.getAttribute("checked"));
		}
	}
}
