package ze.testcases;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ze.pageobjects.landing.HomePage;

/**
 * This class is aimed to set up the environment and end the test
 * 
 * @author Marcio Fernando
 *
 */
public class Hooks {

	protected WebDriver driver;
	private static final String URL = "https://www.ze.delivery/";
	private static String BROWSER = "Chrome";
	protected HomePage home; 

 
	@Before
	public void setUp() {
		System.out.println("********* Set up the environment *********");
			
		System.out.println(">>>> Browser: " + BROWSER.toUpperCase());	
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.navigate().to(URL);
		driver.manage().window().maximize();
		
		home = new HomePage(driver);
	}
 
	@After
	public void tearDown() {
		System.out.println("********* Ending Test Case *********\n\n");
		driver.quit();
	}

}
