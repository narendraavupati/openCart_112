package testBase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import ReportingUtil.Reporters;

public class BaseClass {
	public WebDriver driver = null;
	public Logger logger=null;
	public Properties p;
	public Reporters R;

	@BeforeClass(groups= {"Master"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws Throwable {
		FileInputStream file = new FileInputStream("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		logger=LogManager.getLogger(this.getClass());
		
		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("invalid browser");
			return;
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(p.getProperty("appURL"));
		Thread.sleep(2000);
		R = new Reporters();
		R.CreateHTMLReport("OpenCart report");
		R.logger(driver, "open URL", "launch browser");
	}

	@AfterClass(groups= {"Master"})
	public void teardown() {
//		   driver.quit();
		R.closeReport();
	}

	public String randomstring() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;

	}

	public String randomNumeric() {
		String generatedNumber = RandomStringUtils.randomNumeric(5);
		return generatedNumber;

	}

	public String randomalphaNumeric() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		String generatedNumber = RandomStringUtils.randomNumeric(5);
//			String generatedString = RandomStringUtils.randomAlphanumeric(3);
		return (generatedString +"_$#&^"+ generatedNumber);

	}

}
