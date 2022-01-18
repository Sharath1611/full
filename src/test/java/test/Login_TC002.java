//To check dev(id=100) user is able to log in
package test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.Dashboard;
import pageObjects.Login_screen;

public class Login_TC002 extends Base
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
public void dev_userLogIn() throws IOException, InterruptedException
{
	 d=new Dashboard(driver);
	Login_screen l=new Login_screen(driver);
	l.userName().sendKeys(pr.getProperty("super_user(dev)"));
	l.password().sendKeys(pr.getProperty("super_password(dev)"));
	l.loginButton().click();
	Thread.sleep(3000);
	String Url = driver.getCurrentUrl();
	Assert.assertEquals(pr.getProperty("dash_board_URL"), Url);
	Assert.assertTrue(d.HeaderLOGO().isDisplayed());
	log.info("TC002 pass");
	}
	@AfterTest
	public void tearDown()
	{
		d.HamburgerMenu().click();
		d.SignOut().click();
		driver.close();
	}

}
