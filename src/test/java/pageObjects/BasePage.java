package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ReportingUtil.Reporters;

public class BasePage {
   WebDriver driver;
   Reporters R;
   public BasePage(WebDriver driver,Reporters R) {
	   this.driver=driver;
	   this.R=R;
	   PageFactory.initElements(driver,this);
   }
}
