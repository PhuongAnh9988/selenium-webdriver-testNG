package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Web_Browser_Part_2{
    WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("http://live.techpanda.org/");
	}

	@Test
	public void TC_01_Verify_Url() {
		driver.get("http://live.techpanda.org/");
		
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");
		
		driver.findElement(By.xpath("//a[@title='Creat an Account']")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");
		
		

	}

	@Test
	public void TC_02_Verify_Title() {
        driver.get("http://live.techpanda.org/");
		
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		Assert.assertEquals(driver.getTitle(), "Customer Login");
		
		driver.findElement(By.xpath("//a[@title='Creat an Account']")).click();
		Assert.assertEquals(driver.getTitle(),"Customer Login");
		

	}

	@Test
	public void TC_03_Navigate_Fution() {
      driver.get("http://live.techpanda.org/");
        
      driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
      driver.findElement(By.xpath("//a[@title='Creat an Account']")).click();
      driver.navigate().back();
      
      Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.phb/customer/account/login/");
      
      driver.navigate().forward();
      Assert.assertEquals(driver.getTitle(),"creat New Customer Account");
      
      
	}
	@Test
	public void TC_04_Get_Page_Source_Code() {
      driver.get("http://live.techpanda.org/");
        
      driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
      
      String loginPageSource=driver.getPageSource();
      Assert.assertTrue(loginPageSource.contains("Login or Creat an Account"));
      
      driver.findElement(By.xpath("//a[@title='Creat an Account']")).click();
       String registerPageSource = driver.getPageSource();
       
      Assert.assertTrue(registerPageSource.contains("Creat New Customer Account"));
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