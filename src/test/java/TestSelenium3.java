import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestSelenium3 {

	static String basePath = "/Users/aaron/eclipse/workspaces/hart/Selenium3Test/src/main/resources";
	static String geckoDriverPath = basePath + "/geckodriver/geckodriver-0.10.0-mac32";
	static String chromeDriverPath = basePath + "/chromedriver/chromedriver-2.22-mac32";
	
	static String url = "https://today-red.hart.com";

	WebDriver driver;
	static ChromeDriverService service;
	
	@BeforeClass
	static public void init() throws IOException {
//		service = startChromeDriverService();
//		String remoteWebDriverUrl = service.getUrl().toString();
		String remoteWebDriverUrl = "http://0.0.0.0:4444/wd/hub";
		
		System.setProperty("webdriver.gecko.driver", geckoDriverPath);
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		System.setProperty("webdriver.remote.url", remoteWebDriverUrl);
	}
	
	static ChromeDriverService startChromeDriverService() throws IOException {
		System.out.println("start chromedriver service for use by remote webdriver");
		System.out.println("using chromeDriverPath: " + chromeDriverPath);
		
		File chromeDriverExecutable = new File(chromeDriverPath);
		ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(chromeDriverExecutable).build();
		service.start();
		
		System.out.println("ChromeDriverService URL: " + service.getUrl());
		
		return service;
	}
	
	@AfterClass
	static public void cleanup() {
		if (service != null) {
			service.stop();
		}
	}
	
	@Before
	public void before() {
		driver = null;
	}
	
	@After
	public void after() {
		System.out.println("wait a second before closing");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (driver != null) {
			System.out.println("close browser");
			driver.quit();
		}
	}
	
	@Test
	public void usingGeckoDriver() {
		System.out.println("use GeckoDriver for Firefox");
		System.out.println("set environment variable webdriver.gecko.driver: " + System.getProperty("webdriver.gecko.driver") );
		
		System.out.println("instantiate FirefoxDriver");
		driver = new FirefoxDriver();
		
		driver.get(url);
		
		String title = driver.getTitle();
		System.out.println("got title: " + title);
		
		assertNotNull(title);
	}

	@Test
	public void usingChromeDriver() {
		System.out.println("use ChromeDriver");
		
		System.out.println("set environment variable webdriver.chrome.driver: " + System.getProperty("webdriver.chrome.driver") );
		
		System.out.println("instantiate ChromeDriver");
		driver = new ChromeDriver();
		
		driver.get(url);
		
		String title = driver.getTitle();
		System.out.println("got title: " + title);
		
		assertNotNull(title);
	}
	
	@Test
	public void usingRemoteWebDriver() throws MalformedURLException {
		System.out.println("use RemoteWebDriver");
		
		URL remoteWebDriverUrl = new URL(System.getProperty("webdriver.remote.url"));
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		
		driver = new RemoteWebDriver(remoteWebDriverUrl, capabilities);
		
		driver.get(url);
		
		String title = driver.getTitle();
		System.out.println("got title: " + title);
		
		assertNotNull(title);
		
	}
}
