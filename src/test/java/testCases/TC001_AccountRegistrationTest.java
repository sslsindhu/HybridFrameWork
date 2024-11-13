package testCases;



import org.testng.annotations.*;

import pageObjects.HomePage;


public class TC001_AccountRegistrationTest extends BaseClass 
{
	
	@Test(groups= {"Sanity","Regression","Master"})
	public void verifyAccount()
	{
	
		logger.info("***Started TestCase***");
		HomePage hp=new HomePage(driver);
		hp.clickOnAccount();
        hp.clickOnRegister();
		
		
	}
	
}
