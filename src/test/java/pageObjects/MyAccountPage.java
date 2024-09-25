package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ReportingUtil.Reporters;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver,Reporters R) {
		super(driver,R);
	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement msgHeading;

	public boolean isMyAcntExist() throws InterruptedException, IOException {
		R.logger(driver, "Account Page", "Account Details");
		try {
			return msgHeading.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
