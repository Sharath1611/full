package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base 
{
	public WebDriver driver;
	public Properties pr;
public WebDriver browserInvocation() throws IOException
{
	pr =new Properties();
	FileInputStream fil=new FileInputStream("C:\\Users\\SHARATH\\eclipse-workspace\\E2E project\\Portal\\src\\main\\java\\Base\\environment.properties");
    pr.load(fil);
   String browser=pr.getProperty("browser");
   if(browser.equals("chrome"))
   {
	 System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	 driver=new ChromeDriver();
   }
   else if(browser.equals("firefox"))
   {
	   System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
	   driver=new FirefoxDriver();
   }
   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   return driver;
}
public static void getScreenShot(String ftestCaseName,WebDriver driver) throws IOException
{
	TakesScreenshot src=(TakesScreenshot) driver; 
	File temp = src.getScreenshotAs(OutputType.FILE);
	String path = System.getProperty("user.dir")+"\\Reports\\"+ftestCaseName+".png";
	FileUtils.copyFile(temp, new File(path));
}
}