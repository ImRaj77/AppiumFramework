package practice.AppiumFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseTest {

	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;

	/*
	 * Starts the Appium server
	 */
	/*
	 * public AppiumDriverLocalService startServer() { // It will help us to start
	 * the server boolean flag = checkIfServerIsRunnning(4723); if(!flag) { service
	 * = AppiumDriverLocalService.buildDefaultService(); service.start(); } return
	 * service; }
	 */

	/*
	 * Java socket programming Check if the Appium Server is already running
	 */
	/*
	 * public static boolean checkIfServerIsRunnning(int port) { boolean
	 * isServerRunning = false; ServerSocket serverSocket; try { serverSocket = new
	 * ServerSocket(port);
	 * 
	 * serverSocket.close(); } catch (IOException e) { // If control comes here,
	 * then it means that the port is in use isServerRunning = true; } finally {
	 * serverSocket = null; } return isServerRunning; }
	 */

	/*
	 * 
	 */
	public static AndroidDriver<AndroidElement> capabilities(String apkName) throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/practice/AppiumFramework/global.properties");
		Properties prop = new Properties();
		prop.load(fis);

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

	/*
	 * It will take Screenshot after the failure of test case
	 */
	public static void getScreenshot(String testName) throws IOException {
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir") + "/" + testName + ".png"));
	}
}
