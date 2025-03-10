package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


public class TC003_LoginDDT extends BaseClass {
	@Test (dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="DataDriven")//geting data providers from another class
	public void verify_loginDDT(String email,String pwd,String exp) throws InterruptedException
	{
		
		logger.info("****** Starting TC003LoginTest *****");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clicklogin();
		
		//MyaccountPage
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountExists();
		//Assert.assertEquals(targetpage, true,"Login Failed");
		
		
		/*Data is valid-login sucess-test pass -logout
		 * data is valid --login failed -test fail
		 * 
		 * data is invalid-login success -test fail -logout
		 * data is invalid -login failed -test passed
		 *  
		 * 
		 */
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(targetpage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
				
			}
			else 
			{
				Assert.assertTrue(false);
				
			}
		}
			
		
		if(exp.equalsIgnoreCase("Invalid")) 
			{
				if(targetpage==true)
				{
					macc.clickLogout();
					Assert.assertTrue(false);
				}
				else {
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		
		Thread.sleep(3000);
		logger.info("*** Finished TC003LoginTest *****");
		
		
		}
		
}
	
	


