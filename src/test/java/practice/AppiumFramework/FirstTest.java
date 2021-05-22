package practice.AppiumFramework;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.HomePgae;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FirstTest extends BaseTest {
	
	/*
	 * It will kill all the Appium services before the test framework execution
	 */
	/*@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException {
		// For Mac OS
		Runtime.getRuntime().exec("killall node");
		// For Windows OS
		Runtime.getRuntime().exec("taskkill /F /IM  node.exe");
		Thread.sleep(5000);
	}*/
	
	@Test
	public void apiDemoTest() throws IOException {
		
		// It will start the Appium server
		//service = startServer();
		
		AndroidDriver<AndroidElement> driver = capabilities("OriginalAppApk");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AppiumUtilities utils = new AppiumUtilities(driver);
		HomePgae page = new HomePgae(driver);
		driver.hideKeyboard();
		
		page.getGraphicsOption().click();
		utils.scrollUp();
		utils.scrollDown();
		
		// It will stop and clean all Appium services
		//service.stop();
	}
	
	
	@Test(dataProvider = "InputData",dataProviderClass = TestData.class)
	public void dataProviderTest(String input) {
		Assert.assertEquals("Hello", input);
	}
}
