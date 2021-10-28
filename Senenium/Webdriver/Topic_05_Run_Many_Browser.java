package Webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Topic_05_Run_Many_Browser {
    WebDriver driver;
	String projectPath = System.getProperty("user.dir");


	@Test
	public void TC_01_Run_on_Firefox() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.get("https://www.facebook.com/");
		sleepInSecond(5);
		
		driver.quit();
	}

	@Test
	public void TC_02_Run_on_Chrome() {
			System.setProperty("webdriver.chrome.driver",projectPath + "\\browserDrivers\\chromerdriver.exe");
			driver = new ChromeDriver();
			
			driver.get("https://www.facebook.com/");
			sleepInSecond(5);
			
			driver.quit();
		}


	@Test
	public void TC_03_Run_on_Edge_Chromium() {
		System.setProperty("webdriver.chrome.driver",projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		
		driver.get("https://www.facebook.com/");
		sleepInSecond(5);
		
		driver.quit();

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}