package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("**** Starting TC_002_LoginTest ******");
		
		try {
		//Homepage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clicklogin();
		
		//MyaccountPage
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountExists();
		//Assert.assertEquals(targetpage, true,"Login Failed");
		Assert.assertTrue(targetpage);	
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("**** finished TC_002_LoginTest ******");
	}

}
