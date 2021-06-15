

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class XpathAxisDemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/workspace/xpath.html");
		
		// bye kelimesini id ile bulmak icin // means anywhere in page p=paragraf @id=attribute ve koseli parantezle bul.
		//bye text oldugu icin get.text ile cagir
		WebElement bye = driver.findElement(By.xpath("//p[@id='bye']"));
		System.out.println(bye.getText());
		
		// ancestor kismina ulasmak icin usttekinin aynisini yazip sonuna slash ancestor yazip double iki nokta yazip 
		//ilk parent icin 1 yazariz alip almadigimizi anlamak icinde get.Attribute yazariz. 0 sayisi yoktur.
		WebElement parent = driver.findElement(By.xpath("//p[@id='bye']/ancestor::*[1]"));
		System.out.println(parent.getAttribute("id"));
		
		
		// grandparent icin iki ust nesil oldugundan [2] yazariz
		WebElement grandParent = driver.findElement(By.xpath("//p[@id='bye']/ancestor::*[2]"));
		System.out.println(grandParent.getAttribute("id"));
		
		//grandgrandparent icin 3 nesil ustte oldugu icin [3]yazariz.
		WebElement grandGrandParent = driver.findElement(By.xpath("//p[@id='bye']/ancestor::*[3]"));
		System.out.println(grandGrandParent.getAttribute("id"));
		
		//parenti bulmak icin diger yol slashtan sonra .. kullanmak
		WebElement parent2 = driver.findElement(By.xpath("//p[@id='bye']/.."));
		System.out.println(parent2.getAttribute("id"));
		
		// Eger tag onemli degil sadece parenti bulmak istiyorsak slashtan sonra sadece parent::* yazilir.Just give me the parent
		WebElement parent3 = driver.findElement(By.xpath("//p[@id='bye']/parent::*"));
		System.out.println(parent3.getAttribute("id"));
		driver.quit();
		}
}


