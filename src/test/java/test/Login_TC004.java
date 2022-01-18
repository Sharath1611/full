//To check that super admin is able to login to application
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

public class Login_TC004 extends Base
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
public void SuperAdminLogin() throws IOException, InterruptedException
{
	 d=new Dashboard(driver);
	Login_screen l=new Login_screen(driver);
	l.userName().sendKeys(pr.getProperty("super_user(id_100)"));
	l.password().sendKeys(pr.getProperty("super_password(id_100)"));
	l.loginButton().click();
	Thread.sleep(7000);
	Assert.assertEquals(driver.getCurrentUrl(),pr.getProperty("dash_board_URL") );
	int count = d.CompanyDropDownS().size();
	Assert.assertEquals(count, 1);
	log.info("TC004 pass");
}
@AfterTest
public void tearDown()
{
	d.HamburgerMenu().click();
	d.SignOut().click();
	driver.close();
}
}
