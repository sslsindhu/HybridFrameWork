package testCases;



import org.testng.annotations.*;

import pageObjects.HomePage;


public class TC002_LoginTest extends BaseClass 
{
	
	@Test(groups= {"Sanity","Regression","Master"},dataProvider="loginTestData",dependsOnMethods="false")
	public void verifyAccount()
	{
	
		logger.info("***Started TestCase***");
		HomePage hp=new HomePage(driver);
		hp.clickOnAccount();
        hp.clickOnRegister();
		
		
	}
	@DataProvider(name="loginTestData")
	public String[][]loginData()
	{
		String[][]data= {
				
				{"john.don123@example.com","test123"},
				{"john.don123@example.com","test1234"}
				
				};
		
		
		return data;
		
	}
	
}
