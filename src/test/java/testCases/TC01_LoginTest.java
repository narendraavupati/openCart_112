package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;


@Test(groups= {"Sanity"})
public class TC01_LoginTest extends BaseClass {
	public void verify_login() throws Throwable {
		logger.info("**** Starting Login Test ****");
		try {
			HomePage hp = new HomePage(driver,R);
			hp.clickCheckout();
			logger.info("**** Clicked Checkout Link ****");
			hp.clickmyAccount();
			logger.info("**** Clicked My Account Link ****");
			hp.clickLogin();
			logger.info("**** Clicked Login Link ****");

			LoginPage lp = new LoginPage(driver,R);
			lp.setEmail(p.getProperty("username"));
			lp.setPwd(p.getProperty("password"));
			lp.setLogin();

			MyAccountPage myac = new MyAccountPage(driver,R);
			boolean targetpage = myac.isMyAcntExist();
			Assert.assertTrue(targetpage);
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("**** Test Finished ****");

	}
}
