package practice.AppiumFramework;

import java.time.Duration;

import org.openqa.selenium.Dimension;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumUtilities {

	AndroidDriver<AndroidElement> driver;

	public AppiumUtilities(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	/*
	 * Scroll the screen UP to show the options at the bottom of the screen
	 * Scrolls Frame by Frame
	 */
	public void scrollUp() {

		Dimension size = driver.manage().window().getSize();

		int startX = size.getWidth() / 2;
		int endX = startX ;
		int startY = (int) (size.getHeight() * 0.9);
		int endY = size.getHeight() / 2;

		new TouchAction(driver).press(PointOption.point(startX, startY))
				.waitAction(new WaitOptions().withDuration(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(endX, endY)).release().perform();
	}

	/*
	 * Scroll the screen DOWN to show the options at the top of the screen
	 * Scrolls Frame by Frame
	 */
	public void scrollDown() {
		
		Dimension size = driver.manage().window().getSize();

		int startX = (int) (size.getWidth() * 0.1);
		int endX = startX;
		int startY = size.getHeight() / 2;
		int endY = (int) (size.getHeight() * 0.9);

		new TouchAction(driver).press(PointOption.point(startX, startY))
				.waitAction(new WaitOptions().withDuration(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(endX, endY)).release().perform();
	}
}
