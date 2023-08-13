package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	static WebDriver driver;
	
	static File file = new File ("./driver/conf.properties");
    static FileInputStream fis= null;
    static Properties prop = new Properties();

    static {

        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

        try {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	@BeforeMethod
	public static void openUrl() {

//		System.setProperty(prop.getProperty("chromeDriverProperty"),prop.getProperty("chromeDriverPath") );
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("headless");
		System.setProperty("webdriver.edge.driver","C:\\Users\\viveksharma11\\Downloads\\DevTestOps\\DevTestOps\\driver\\msedgedriver.exe");
		driver = new EdgeDriver();	
		 driver.get("http://amazon.in/"); 
		
	}
	
	@AfterMethod
	public static void close() {
		driver.close();
		driver.quit();
	}
	
	public static void main(String args[]) {
		openUrl();
		SearchTest.search();
		close();
	}

}
