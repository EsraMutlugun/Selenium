// checked box kutularinin isaretli olup olmadigini kontrol ediyor.
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
			// her checkbox kutusunu bulur ve listeye ekler
			List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
			//listedeki checkbox lari checked edilmis mi kontrol eder.
			for (WebElement checkbox: checkboxes) {
				System.out.println(checkbox.getAttribute("checked"));
				}
			}
		}
