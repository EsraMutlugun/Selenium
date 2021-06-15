package wat2021;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

@RunWith(Parameterized.class)

public class BmiCsvTest {
	private WebDriver driver;
	private String height;
	private String weight;
	private String bmi;
	private String bmiCategory;
	
	
	public BmiCsvTest(String height, String weight, String bmi, String bmiCategory) {
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.bmiCategory = bmiCategory;
		}
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/workspace/bmicalculator.html");
	}
	
	@After
	public void tearDown() {driver.quit();
	}
	
	@Parameters
	//csv dosyasi ve format icin exception atti
	public static List<String[]> getBmiTestData() throws IOException, CsvException {
		//datanin altindaki csv dosyasini al demek
		
		String filename = "./data/bmi.csv";
		CSVReader reader = new CSVReader(new FileReader(filename));
		List<String[]> entries = reader.readAll();
		reader.close();
		return entries;
	}
}

