package Section16CodeTestNG;

import java.text.MessageFormat;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Section16CodeTestNG05_Listeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		String messageString = "onTestStart";
		System.out.println(MessageFormat.format("On Test Start: {0}", messageString));
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String messageString = "onTestSuccess";
		System.out.println(MessageFormat.format("Test Success: {0} for {1}", messageString, result.getName()));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String messageString = "onTestFailure";
		System.out.println(MessageFormat.format("Test Failure: {0} for {1}", messageString, result.getName()));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String messageString = "onTestSkipped";
		System.out.println(MessageFormat.format("Test skipped: {0}", messageString));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		String messageString = "onTestFailedButWithinSuccessPercentage";
		System.out.println(MessageFormat.format("Test Failed: {0}", messageString));
	}

	@Override
	public void onStart(ITestContext context) {
		String messageString = "onStart";
		System.out.println(MessageFormat.format("On Start: {0}", messageString));
	}

	@Override
	public void onFinish(ITestContext context) {
		String messageString = "onFinish";
		System.out.println(MessageFormat.format("On Finish: {0}", messageString));
	}

}
