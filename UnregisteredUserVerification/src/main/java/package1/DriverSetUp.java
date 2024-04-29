package package1;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;

	public class DriverSetUp {
		public static WebDriver driver;
		public static String exePath;
		public static String url = "http://change2naturalfoods.com/";
		public static String browsertype;

		public static WebDriver driverInstantiate(String browser) {
			browsertype = browser;
			
			if(browsertype.equalsIgnoreCase("edge")) {
				exePath = "C:\\Users\\2111516\\Downloads\\edgedriver_win64 (1)\\msedgedriver.exe";
				System.setProperty("webdriver.edge.driver", exePath);
				driver = new EdgeDriver();
			} 
			else if(browser.equalsIgnoreCase("chrome")) {
				exePath = "C:\\Users\\2111516\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", exePath);
				driver = new ChromeDriver();
			}
			// driver.manage().window().maximize();
			// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			// driver.get(url);
			// driver.manage().deleteAllCookies();
			return driver;
		}

		public static void driverClose() {

			driver.close();
		}

	}
