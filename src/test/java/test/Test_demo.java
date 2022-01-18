package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Test_demo
{
public static void main (String[] args) throws InterruptedException, AWTException
{
	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	WebDriver d= new ChromeDriver();
	d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	d.get("https://www.damytravel.com/");
	d.findElement(By.xpath("//label[normalize-space()='One way']")).click();
	WebElement from = d.findElement(By.xpath("//input[@id='airport_from']"));
	Robot r =new Robot();
	from.sendKeys("DXB");
	Thread.sleep(3000);
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	//from.sendKeys(Keys.ENTER);
	WebElement To = d.findElement(By.xpath("//input[@id='airport_to']"));
	To.sendKeys("CMB");
	Thread.sleep(4000);
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	//from.sendKeys(Keys.ENTER);
	Thread.sleep(4000);
	d.findElement(By.xpath("//input[@id='f-guests']")).click();
	d.findElement(By.xpath("(//span[contains(text(),'+')])[2]")).click();
	d.findElement(By.xpath("//div[@class='container search-box-width']//div[4]//div[1]//span[2]//button[1]//span[1]")).click();
	d.findElement(By.xpath("//a[normalize-space()='Submit']")).click();
	d.findElement(By.xpath("//input[@id='departure'])")).click();
	d.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
	d.findElement(By.xpath("//span@class='ui-icon ui-icon-circle-triangle-e']")).click();
	d.findElement(By.xpath("(//a[@href='#'][normalize-space()='8'])[2]")).click();
	d.findElement(By.xpath("//form[@id='flight_searchs']//button[@type='submit']")).click();
	Thread.sleep(5000);
	String actual_DEPART = d.findElement(By.xpath("(//p[contains(@class,'dest')][normalize-space()='DXB'])[1]")).getText();
	Assert.assertEquals("DXB", actual_DEPART);
	String actual_Araive = d.findElement(By.xpath("(//p[contains(@class,'dest')][normalize-space()='CMB'])[1]")).getText();
	Assert.assertEquals("DXB",actual_Araive );
	d.close();
	
	
}
}
