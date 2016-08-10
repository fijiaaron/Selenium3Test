import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UseChromeDriver {

	static String basePath = "/Users/aaron/eclipse/workspaces/hart/Selenium3Test/src/main/resources";
	static String chromeDriverPath = basePath + "/chromedriver/chromedriver-2.22-mac32";

	static String hartBaseUrl = "https://today-red.hart.com";
	
	public static void main(String[] args) {
		System.out.println("I'm going to use Selenium 3 with Chrome");
		
		System.out.println("I'll need to add the Java bindings to the build path...");
		System.out.println("selenium-java-3.0.0-beta2/client-combined-3.0.0-beta2-nodeps.jar");
		System.out.println("And I'll need all the dependencies for the java bindings...");
		System.out.println("selenium-java-3.0.0-beta2/lib/*.jar");
		
		
		System.out.println("First create a new WebDriver object");
		WebDriver driver;		
		
		
		System.out.println("Now let's instantiate it as a chromedriver instance");

		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		driver = new ChromeDriver();
		
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
	

	public static void sleep(long milliseconds) {
		try {
			Thread.currentThread().sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
