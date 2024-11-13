package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	public org.apache.logging.log4j.Logger logger;
	public Properties p;
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setUp(String os,String br) throws InterruptedException, IOException
	{
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		switch(br.toLowerCase())
		{
		case "chrome":driver=new ChromeDriver(); break;
		case "edge":driver=new EdgeDriver();break;
		case "Firefox":driver=new FirefoxDriver();break;
		default:System.out.println("Invalid browser name..");
		return; //Programs terminates without executing next lines
		
		}
		logger=LogManager.getLogger(this.getClass());
		//driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appURL1"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	
	public String captureScreenshot(String tname)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File Sourcefile=ts.getScreenshotAs(OutputType.FILE);
		
		String targetfilepath=System.getProperty("user.dir"+"\\screenshots\\");
		File targetfile=new File(targetfilepath);
		Sourcefile.renameTo(targetfile);
		
		return targetfilepath;
		
	}
}
