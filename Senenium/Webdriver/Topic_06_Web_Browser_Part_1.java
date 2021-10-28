package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Web_Browser_Part_1 {
    WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_() {
       // Mở 1 Page Url ra
	   driver.get("https://www.facebook.com/");
	   // Đóng trình duyệt nếu chỉ có 1 tab
	   // Đóng active tab nếu như trình duyệt đang có nhiều tab
	   // Xử lý tab/windowns
	   driver.close();
	   
	   // Đóng hết cả trình duyệt không quan tâm tab/windowns
	   driver.quit();
	   
	   // Trả về Url của page hiện tại
	   driver.getCurrentUrl();
	   
	   // Trả về Page source code (HTML/Css/JS/,...)page hiện tại
	   driver.getPageSource().contains("Facebook helps you connect anh share with the people in your life");
	   // Verify tương đối
	   // Trả về page title hiện tại
	   driver.getTitle();
	   System.out.println();
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