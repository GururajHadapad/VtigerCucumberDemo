package StepDefinationsAndHooksClasses;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import BaseInjector.Based;
import BaseInjector.Pages;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import vtigerCucumber.generics.FileUtility;

public class Hook extends Based{
	
	Based base;
	
	public Hook(Based base) {
		this.base=base;
	}

	@Before
	public void SetUp() throws Throwable {
		String browser = FileUtility.readDataFromPropertyFile("browser");
		String url = FileUtility.readDataFromPropertyFile("url");
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 base.driver=new ChromeDriver();
			 base.driver.manage().window().maximize();
			 base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			 base.driver.get(url);
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 base.driver=new FirefoxDriver();
			 base.driver.manage().window().maximize();
			 base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 base.driver.get(url);
		}
		else {
			System.out.println("Enter Valid Browser Name");
		}
		Pages.loadPages(base.driver);
	}
	@After
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			 TakesScreenshot takeScreenShot = (TakesScreenshot)base.driver;
			 byte[] screenShot = takeScreenShot.getScreenshotAs(OutputType.BYTES);
			 scenario.attach(screenShot, "image/png",scenario.getName());
		}
		
		base.driver.quit();
	}
}
