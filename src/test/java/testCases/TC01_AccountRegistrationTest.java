package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC01_AccountRegistrationTest extends BaseClass {
	@Test(groups= {"Regression"})
	public void verify_account_registration() throws Throwable {
		logger.info("**** Starting TC01_AccountRegistrationTest ****");
		try {

			HomePage hp = new HomePage(driver,R);
			hp.clickCheckout();
			logger.info("**** Clicked Checkout Link ****");
			hp.clickmyAccount();
			
			logger.info("**** Clicked My Account Link ****");
			hp.clickRegister();
			logger.info("**** Clicked Register Link ****");
//			hp.clickLogin();
//			logger.info("**** Clicked My Account Link ****");
			
			
			

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver,R);
			logger.info("**** Providing customer details ****");
			regpage.chkFirstName(randomstring().toUpperCase());
			regpage.chkLastName(randomstring().toUpperCase());
			regpage.chkEmail(randomstring() + "@gmail.com");
			regpage.chkPwd(randomalphaNumeric());
			regpage.chkPolicy();
			regpage.chkContinue();

			logger.info("**** Validating Expected Message ****");

			String confirmMsg = regpage.getCnfMsg();
			if (confirmMsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test Failed");
				logger.debug("Debug Logs");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {

			Assert.fail();
		}
		logger.info("**** Test Finished ***");
	}
}
