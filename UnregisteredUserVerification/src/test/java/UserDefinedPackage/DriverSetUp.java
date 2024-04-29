package UserDefinedPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetUp {

	public static WebDriver driver;
	public static String exepath;
	public static String browserType;
	
public static WebDriver getWebDriver(String browser) {
  
  browserType=browser;
  if(browserType.equalsIgnoreCase("edge")) {
	  /*exepath=System.getProperty("user.dir")+"\\EdgePath\\msedgedriver.exe";
	  System.setProperty("webdriver.edge.driver",exepath);*/
	  driver=new EdgeDriver();
  }
  else if(browserType.equalsIgnoreCase("chrome")){
//	  exepath=System.getProperty("user.dir")+"\\ChromePath\\chromedriver.exe";
//	  System.setProperty("webdriver.chrome.driver",exepath);
	  driver=new ChromeDriver();
  }
  return driver;
}

		public static void closeDriver() {
			driver.close();
}
}
