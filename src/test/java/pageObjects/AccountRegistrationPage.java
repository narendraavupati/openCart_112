package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import ReportingUtil.Reporters;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver,Reporters R) {
		super(driver, R);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtfirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtlastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpwd;
	
	@FindBy(xpath="(//input[@name='agree'])[1]")
	WebElement chkedpolicy;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement btncontinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void chkFirstName(String fname) {
		txtfirstname.sendKeys(fname);
	}
	
	public void chkLastName(String lname) {
		txtlastname.sendKeys(lname);
	}

	public void chkEmail(String email) {
		txtemail.sendKeys(email);
	}

	public void chkPwd(String pwd) {
		txtpwd.sendKeys(pwd);
	}

	public void chkPolicy() throws Throwable {
		Actions act = new Actions(driver);
	    act.moveToElement(chkedpolicy).click().perform();
	    Thread.sleep(3000);
	}
	
	public void chkContinue() throws Throwable, Throwable {
		R.logger(driver, "Registration page", "Registration Details");
		btncontinue.click();
	}
	
	public String getCnfMsg() throws Throwable, Throwable {
		R.logger(driver,"Registration cnfm page","Registration confirmed");
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
		
		
	}
}
