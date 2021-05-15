package practice.AppiumFramework;

import org.testng.annotations.Test;

import PageObjects.HomePgae;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FirstTest extends BaseTest {
	
	@Test
	public void apiDemoTest() throws IOException {
		AndroidDriver<AndroidElement> driver = capabilities("OriginalAppApk");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AppiumUtilities utils = new AppiumUtilities(driver);
		HomePgae page = new HomePgae(driver);
		driver.hideKeyboard();
		
		page.getGraphicsOption().click();
		utils.scrollUp();
		utils.scrollDown();
				
	}
}
