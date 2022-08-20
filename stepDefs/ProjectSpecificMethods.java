package stepDefs;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecificMethods extends  AbstractTestNGCucumberTests{

	public static ChromeDriver driver;
	public static Actions builder;

@BeforeMethod
	public void initSetup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		builder = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leaftaps.com/opentaps");

	}
@AfterMethod
	public void close(){
	
	driver.close();	
	}
	
}
