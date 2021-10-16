package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Xpath_Css_Part2 {
    WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://automationfc.github.io/basic-form/");
	}

	@Test
	public void TC_01_Text() {
		Assert.assertTrue(driver.findElement(By.xpath("h1[contains(string(),'SELENIUM WEBDRIVER API')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("h1[contains(.,'SELENIUM WEBDRIVER API')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("h1[contains(text(),'SELENIUM WEBDRIVER API')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("h1[text()='SELENIUM WEBDRIVER API')]")).isDisplayed());

	}

	@Test
	public void TC_02_() {

	}

	@Test
	public void TC_03_() {

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