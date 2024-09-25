package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ReportingUtil.Reporters;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver,Reporters R) {
		super(driver,R);
	}
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement btnLogin;

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
    public void setPwd(String pwd) throws InterruptedException {
    	txtPassword.sendKeys(pwd);
    	Thread.sleep(3000);
	}

    public void setLogin() throws InterruptedException, IOException {
    	R.logger(driver, "Login Page", "Login Details");
    	btnLogin.click();
    }
	
}
