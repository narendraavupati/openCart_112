package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ReportingUtil.Reporters;

public class HomePage extends BasePage{
   public HomePage(WebDriver driver,Reporters R){
	   super(driver,R);
   }
   
   @FindBy(xpath="//span[normalize-space()='Checkout']")
   WebElement lnkCheckout;
   
   @FindBy(xpath="(//span[normalize-space()='My Account'])[1]")
   WebElement lnkmyAccount;
   
   @FindBy(xpath="//a[normalize-space()='Register']")
   WebElement lnkmyRegister;
   
   @FindBy(linkText="Login")
   WebElement lnkLogin;
   
   public void clickCheckout() throws Throwable  {
	   lnkCheckout.click();
	   Thread.sleep(2000);
   }
   
   public void clickmyAccount() throws Throwable {
	   lnkmyAccount.click();
	   Thread.sleep(3000);
   }
   
   public void clickRegister() throws InterruptedException, IOException {
	   lnkmyRegister.click();
	   Thread.sleep(3000);
	   R.logger(driver, "Register Btn", "Register Click");
   }
   
   public void clickLogin() throws InterruptedException, IOException {
	   lnkLogin.click();
	   Thread.sleep(3000);
	   R.logger(driver, "Login Btn", "Login Click");
   }
}
