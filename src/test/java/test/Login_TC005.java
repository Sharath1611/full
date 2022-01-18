//To check that manager is able to login to application
package test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.Dashboard;
import pageObjects.Login_screen;

public class Login_TC005 extends Base 
{
	WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	Dashboard d;
	@BeforeTest
	public void intialization() throws IOException
	{
		driver=browserInvocation();
		driver.get(pr.getProperty("base_URL"));
	}

	
	
@Test
	public void managerLogin() throws IOException, InterruptedException
	{
		 d=new Dashboard(driver);
		Login_screen l=new Login_screen(driver);
		l.userName().sendKeys(pr.getProperty("user_storemanager(id_5)"));
		l.password().sendKeys(pr.getProperty("storemanager_password(id_5)"));
		l.loginButton().click();
		Thread.sleep(5000);
		Assert.assertEquals(pr.getProperty("dash_board_URL"), driver.getCurrentUrl());
		int count = d.CompanyDropDownS().size();
		Assert.assertEquals(count, 0);
		log.info("TC005 pass");
	}
@AfterTest
public void tearDown()
{
	d.HamburgerMenu().click();
	d.SignOut().click();
	driver.close();
}

}

