	import java.util.List;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	public class XpathAxisDemo2 {
		public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
			
			WebDriver driver = new ChromeDriver();
			driver.get("http://localhost:8080/workspace/xpath.html");
			
			//WebElement mystery = driver.findElement(By.xpath("//p[@id='bye']/ancestor::div")) outer verir.
			//cunku findElement ilk elementi getirir,ilk parent outer oldugu icin en ustteki gelir.
			
			
			//this gives outmost en ustteki en distakini yani verir.
			WebElement mystery = driver.findElement(By.xpath("//p[@id='bye']/ancestor::*"));
			System.out.println(mystery.getTagName());
			
			
			// bu kod innermost en yakin parenti verir.
		    WebElement parent = driver.findElement(By.xpath("//p[@id='bye']/ancestor::*[1]"));
		    System.out.println(parent.getAttribute("id"));
			
			
			System.out.println("========");
			
			
			//Butun ancestorlari getiriyor.liste icine atiyor.En distan sirayla gorebilirsin.
			List<WebElement> ancestors = driver.findElements(By.xpath("//p[@id='bye']/ancestor::*"));
			
			for (WebElement ancestor: ancestors) {
				System.out.println(ancestor.getTagName() + ": " + ancestor.getAttribute("id"));
				}
			driver.quit();
			}
		
		
	}

