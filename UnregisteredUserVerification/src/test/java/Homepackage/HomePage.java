package Homepackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


import UserDefinedPackage.DriverSetUp;
import UserDefinedPackage.ExcelUtils;



public class HomePage extends DriverSetUp{

	public static String url="http://change2naturalfoods.com";
	public static WebDriver driver=DriverSetUp.getWebDriver("chrome");
	public static String[] data=new String[2];
	
		
	
	@Test(priority=1)
	public static void launch() {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
	}
	//CLICK ON LOGIN/REGISTER
	@Test(priority=2)
	public static void loginRegister() {
		driver.findElement(By.linkText("Login/Register")).click();
	}
	@Test(priority=3)
	public static void testcase1() {
		try {
			data= ExcelUtils.readexcel();
		}
		catch(Exception e){}
	}	
	//enter the EMAIL ADDRESS
	@Test(priority=4)
	public static void email() {
		WebElement ele=driver.findElement(By.id("email"));
		ele.sendKeys(data[0]);
	}
	//enter the password
	@Test(priority=5)
	public static void password(){
		WebElement ele=driver.findElement(By.id("password"));
		ele.sendKeys(data[1]);
	}
	//click on login button
	@Test(priority=6)
	public static void loginBtn() {
		WebElement ele=driver.findElement(By.xpath("//button[text()='Login']"));
		ele.click();
	}
	@Test(priority=7)
	public static void errormsg() {
		String err=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible fade show']")).getText();	
		System.out.println(err);
	}
	@Test(priority=8)
	public static void screenshot() {
		
		TakesScreenshot ss = ((TakesScreenshot) driver);
				File src=ss.getScreenshotAs(OutputType.FILE);
		try {
			File trg=new File("./testcase/Screenshot/image1.png");
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	@Test(priority=9)
	public static void closeBrowser() {
		DriverSetUp.closeDriver();
	}
	
}
