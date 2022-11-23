package theScore;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.common;

public class TheScore {
	common com = new common();
	WebDriver driver ;
	public static By leaguesIcon = By.xpath(
			"//android.widget.FrameLayout[@content-desc='Leagues']/android.widget.FrameLayout/android.widget.ImageView");
	public static By header = By.id("com.fivemobile.thescore:id/titleTextView");
	public static By nflLink = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/android.widget.TextView");
	public static By leaderTab = By
			.xpath("//android.widget.LinearLayout[@content-desc='Leaders']/android.widget.TextView");
	public static By passingYardText = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]");
	public static By navigateBack = By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");

	@BeforeClass
	public void setUp() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "12.0");
		capabilities.setCapability("deviceName", "vivo");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.fivemobile.thescore");
		capabilities.setCapability("appActivity", "ui.MainActivity");
		capabilities.setCapability("setNativeWebScreenshot", true);

		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void testCal() throws Exception {
		try {

			Thread.sleep(10000);
			com.presencewait(driver, leaguesIcon);
			driver.findElement(leaguesIcon).click();
			com.presencewait(driver, header);
			String header1 = driver.findElement(header).getText();
			if (header1.equalsIgnoreCase("Leagues")) {
				assertEquals(true, true);
				Reporter.log("Leagues page is navigated", true);
			} else {
				assertEquals(true, false);
				Reporter.log("Leagues page is navigated", false);
			}

			Thread.sleep(5000);
			com.presencewait(driver, nflLink);
			driver.findElement(nflLink).click();
			Thread.sleep(5000);
			String header2 = driver.findElement(header).getText();
			if (header2.equalsIgnoreCase("NFL")) {
				assertEquals(true, true);
				Reporter.log("NFL page is navigated", true);
			} else {
				assertEquals(true, false);
				Reporter.log("NFL page is navigated", false);
			}

			com.presencewait(driver, leaderTab);
			driver.findElement(leaderTab).click();
			Thread.sleep(5000);

			com.presencewait(driver, passingYardText);

			if (driver.findElement(header).isDisplayed()) {
				assertEquals(true, true);
				Reporter.log("Leader page is navigated", true);
			} else {
				assertEquals(true, false);
				Reporter.log("Leader page is navigated", false);
			}

			Thread.sleep(5000);

			com.presencewait(driver, navigateBack);
			driver.findElement(navigateBack).click();
			Thread.sleep(5000);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@AfterClass
	public void teardown() {
		// close the app
		driver.quit();
	}
}
