import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UseFirefoxDriver {

	static String basePath = "/Users/aaron/eclipse/workspaces/hart/Selenium3Test/src/main/resources";
	static String geckoDriverPath = basePath + "/geckodriver/geckodriver-0.10.0-mac32";

	static String hartBaseUrl = "https://today-red.hart.com";
	
	public static void main(String[] args) {
		System.out.println("I'm going to use Selenium 3 with Firefox");
		
		System.out.println("I'll need to add the Java bindings to the build path...");
		System.out.println("selenium-java-3.0.0-beta2/client-combined-3.0.0-beta2-nodeps.jar");
		System.out.println("And I'll need all the dependencies for the java bindings...");
		System.out.println("selenium-java-3.0.0-beta2/lib/*.jar");
		
		System.out.println("Create a new WebDriver object");
		WebDriver driver;		
				
		System.out.println("To use FirefoxDriver");
		System.out.println("I need to set the geckodriver path to webdriver.gecko.driver");
		System.setProperty("webdriver.gecko.driver", geckoDriverPath);
		
		System.out.println("When I instantiate FirefoxDriver -- it should start the Marionette service and launch the browser");
		driver = new FirefoxDriver();
				
		driver.get(hartBaseUrl);
		System.out.println("title: " + driver.getTitle());
		
		try {
			Thread.currentThread().sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("title: " + driver.getTitle());

		
//		driver.close(); //doesn't respond
		driver.quit();
	}
}
