package practice.AppiumFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {
	
	public static AndroidDriver<AndroidElement> capabilities(String apkName) throws IOException{
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/practice/AppiumFramework/global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		AndroidDriver<AndroidElement> driver ;
		File appDirectory = new File("src");
		File app = new File(appDirectory, (String) prop.get(apkName));
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.get("PlatformName"));
		caps.setCapability("udid", prop.get("Udid"));
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, prop.get("DeviceName"));
		caps.setCapability(MobileCapabilityType.NO_RESET, true);
		
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		
		return driver;
	}
}
