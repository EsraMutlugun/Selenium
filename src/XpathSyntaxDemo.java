

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class XpathSyntaxDemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/workspace/divs.html");
		
		//WebElement p = driver.findElement(By.xpath("//p")); herhangi bir paragrafi bulmak icin kullanilir.(ilk bulunan)
		// bunu yazdirmak istersek System.out.println(p.getText()); kullanabiliriz.
		
		// By.id ile bulmak istersek asagidaki kodu kullaniriz. Xpath ile farkli yollarla da bulabiliriz.
		WebElement id1 = driver.findElement(By.id("id1"));
		//WebElement p = id1.findElement(By.xpath("/p"));
		// ustteki kod NoSuchElementException verdi.//
		
		WebElement p = id1.findElement(By.xpath("//p"));
		// ustteki kod sadece Hello verdi. basta . kullanilmaz sadece slash olursa global bir search yapar.
		
		//WebElement p = id1.findElement(By.xpath("./p")); 
		// Ustteki kod id1 icinde olan World kelimesini dogru verdi.
		
		
		// WebElement p = id1.findElement(By.xpath(".//p"));
		//ustteki kodda Worl kelimesini dogru verdi. eger current elementi bulmak istiyorsan xpath . ile baklamali
		
		
		System.out.println(p.getText());
		driver.quit();}
//bu ekrana sadece basmak icin.
}

