// to check that dev user is able to add brand
package test;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.Add_brandFlow;
import pageObjects.Dashboard;
import pageObjects.Login_screen;

public class ADD_TC006 extends Base
{
	Dashboard d;
	@BeforeTest
	public void intialization() throws IOException
	{
		driver=browserInvocation();
		driver.get(pr.getProperty("base_URL"));
	}
@Test
public void AddBrand() throws InterruptedException, IOException
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
	d.CompanyDropDown().sendKeys("S auto");
	d.CompanyDropDown().sendKeys(Keys.ENTER);
	Thread.sleep(3000);
	d.CompanySettingIcon().click();
	d.Brand().click();
	Thread.sleep(7000);
	Add_brandFlow b=new Add_brandFlow(driver);
	b.AddBrand_b().click();
	Thread.sleep(5000);
	Assert.assertEquals(pr.getProperty("Add_brandURL"), driver.getCurrentUrl());
	dataDriven dr=new dataDriven();
	ArrayList<String> data=dr.getData("Add brand");
	b.Brand_Name().sendKeys(data.get(1));
	b.Brand_Descripn().sendKeys(data.get(3));
	b.Brand_phNUMBER().sendKeys(data.get(2));
	b.Brand_save_b().click();
	Thread.sleep(2000);
	b.Brand_success().isDisplayed();
	
}
}
