package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseTest {
	
	public static WebDriver driver;
	public static Properties config=new Properties();
	public static Properties locators=new Properties();
	public static FileReader fr1;
	public static FileReader fr2;

	public static Logger log= LogManager.getLogger(BaseTest.class.getName());
	
	@BeforeAll
	public static void setUp() throws IOException {
		
		if (driver==null) {

			//Load the config file from folder: resources/configFiles
			FileReader fr1=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configFiles\\config.properties");
			config.load(fr1);
			log.info("config.properties file has been loaded");
			//Load the locators file from folder: resources/configFiles
			FileReader fr2=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configFiles\\locators.properties");
			locators.load(fr2);
			log.info("locators.properties file has been loaded");
		}

		if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
			log.debug("Chrome launched");
		}
		else if(config.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
			log.debug("firefox launched");
		}
		
		driver.get(config.getProperty("url"));
		log.info("Test Site Url is launched");

	}
	
	@AfterAll
	public static void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
		log.info("Test execution completed");
	}

}
