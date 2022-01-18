package pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Add_brandFlow {
	WebDriver driver;
	By AddBrandButton=By.xpath("//a[@href='/brand/add']");
	By Brand_name=By.xpath("//input[@name='name']");
	By Brand_phNumber=By.xpath("//input[@name='supportPhoneNumber']");
	By Brand_Description=By.xpath("//textarea[@name='description']");
	By Brand_save=By.xpath("//button[normalize-space()='Save']");
	By Brand_successMSG=By.xpath("//span[.='Brand added successfully']");
	
	public Add_brandFlow(WebDriver driver)
	{
		this.driver=driver;
	}
	public WebElement AddBrand_b()
	{
		return driver.findElement(AddBrandButton);
	}
	public WebElement Brand_Name()
	{
		return driver.findElement(Brand_name);
	}
	public WebElement Brand_phNUMBER()
	{
		return driver.findElement(Brand_phNumber);
	}
	public WebElement Brand_Descripn()
	{
		return driver.findElement(Brand_Description);
	}
	public WebElement Brand_save_b()
	{
		return driver.findElement(Brand_save);
	}
	public WebElement Brand_success()
	{
		return driver.findElement(Brand_successMSG);
	}
}
