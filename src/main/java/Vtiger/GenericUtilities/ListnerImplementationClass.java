package Vtiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * This class provides implementation to ITestListner Interface of TestNG
 * @author girix
 *
 */

public class ListnerImplementationClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println("---Execution Started---"+methodName);
		
		test=report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
	String methodName = result.getMethod().getMethodName();
	//System.out.println("---PASS---"+methodName);
	test.log(Status.PASS,"---PASS---"+methodName );
	}

	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		//System.out.println("---FAIL---"+methodName);
		test.log(Status.FAIL,"---FAIL---"+methodName );
		//System.out.println(result.getThrowable());
		test.log(Status.INFO,result.getThrowable());
		/*Take screenshot for failed testscript-to attach with bug raising*/	
		
		WebDriverUtility wu=new WebDriverUtility();
		JavaUtility ju=new JavaUtility();
		
		String screenShotName=methodName+ju.getSystemDateInFormat();
		
		/*Take screenshot for failed test scripts-to attach with bug raising*/
		try {
			String path=wu.takeScreenShot(BaseClass.sdriver, screenShotName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		//System.out.println("---SKIP---"+methodName);
		test.log(Status.SKIP,"---SKIP---"+methodName );
		
		//System.out.println(result.getThrowable());
		test.log(Status.INFO,result.getThrowable());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// start of <suit> @BeforeSuite
		System.out.println("---Suit execution started---");
		
		//configure the extent report
		ExtentSparkReporter htmlreport=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlreport.config().setDocumentTitle("Vtiger Execution Report");
		htmlreport.config().setReportName("Build 3 Vtiger Execution report");
		htmlreport.config().setTheme(Theme.DARK);
		
		//Report Generation
		 report=new ExtentReports();
		 report.attachReporter(htmlreport);
		report.setSystemInfo("BaseBrowser","chrome");
		report.setSystemInfo("Baseplatform","Testing-Env");
		report.setSystemInfo("BaseURL ","http://localhost:8888/");
		report.setSystemInfo("BaseOS","Windows");
		report.setSystemInfo("Reporter","sunita");
		
	}

	public void onFinish(ITestContext context) {
		// End of  <suit> @AfterSuite
		System.out.println("---Suit execution ended---");
		//report generation
		report.flush();
	}
	
	

}
