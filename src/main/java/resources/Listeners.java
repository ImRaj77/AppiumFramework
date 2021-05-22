package resources;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import practice.AppiumFramework.BaseTest;

public class Listeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		// Screenshot Mechanism development
		String name = result.getName();
		try {
			BaseTest.getScreenshot(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		String name = result.getName();
		try {
			BaseTest.getScreenshot(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}

}
