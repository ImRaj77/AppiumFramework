package practice.AppiumFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FirstTest extends BaseTest {
	public static void main(String[] args) throws IOException {
		AndroidDriver<AndroidElement> driver = capabilities("OriginalAppApk");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.hideKeyboard();
		
	}
}
