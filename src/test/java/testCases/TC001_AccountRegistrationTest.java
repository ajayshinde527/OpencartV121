package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest  extends BaseClass{
	
	
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
			logger.info("****  Starting TC001_AccountRegistrationTest ****");
			 
			try {
			
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount Link");
			hp.clickRegister();
			logger.info("Clicked on Register Link");
			AccountRegistrationPage repage=new AccountRegistrationPage(driver);
			logger.info("Providing Customer Details");
			repage.setFirstName(randomeString().toUpperCase());
			repage.setLastName(randomeString().toUpperCase());
			repage.setEmail(randomeString()+"@gmail.com");
			repage.setTelephone(randomenumber());
			String password=randomeAlphaNumberic();
			repage.setPassword(password);
			repage.setConfirmPassword(password);
			repage.setPrivacyPolicy();
			repage.clickContinue();
			
			logger.info("Validating excepted message");
			String confmsg=repage.getConfirmationMsg();
			if(confmsg.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Test Failed");
				logger.debug("Debug logs..");
				Assert.assertTrue(false);
			}
			//Assert.assertEquals(confmsg, "Your Account Has Been Created!!!");
			}
			catch(Exception e)
			{
				
				Assert.fail();
			}
			logger.info("***** Finished TC001_AccountRegistrationTest *****");
	}
	
	
	
}
