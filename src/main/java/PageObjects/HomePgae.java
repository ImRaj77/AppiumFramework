package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePgae {
	
	public HomePgae(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	// WebElements on the HomePage
	@AndroidFindBy(accessibility ="Accessibility")
	private WebElement accessibilityOption;
	
	@AndroidFindBy(accessibility ="Animation")
	private WebElement animationOption;
	
	@AndroidFindBy(accessibility ="Graphics")
	private WebElement graphicsOption;
	
	
	
	// Respective methods to find each WebElemnt on the HomePage
	public WebElement getAccessibilityOption() {
		System.out.println("Trying to find Accessibilty element");
		return accessibilityOption;
	}
	
	public WebElement getAnimationOption() {
		System.out.println("Trying to find Animation element");
		return animationOption;
	}	
	
	public WebElement getGraphicsOption() {
		System.out.println("Trying to find Graphics element");
		return graphicsOption;
	}	
}
