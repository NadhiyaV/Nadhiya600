package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"-- start");
		test = report.createTest(methodname);
		test.log(Status.PASS, "--start");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"-- success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"-- Failure");
		WebDriverUtility wdu= new WebDriverUtility();
		javaUtility ju= new javaUtility();
		String screenshotname = methodname+" "+ju.toGetSystemDateandTime();
		try {
			
			String path=wdu.toTakeScreenShot(BaseClass.sDriver, screenshotname);
			test.addScreenCaptureFromPath(path);
			test.log(Status.FAIL,"--failed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"-- skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("-- suite execution started");
		ExtentSparkReporter htmlreport=new ExtentSparkReporter(".\\ExtentReport\\Report-"+new  javaUtility().toGetSystemDateandTime()+".html");
		htmlreport.config().setDocumentTitle("VTIGER EXECTION REPORT");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("VTIGER REPORTS");
		
		report= new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Url", "http://localhost:8888/");
		report.setSystemInfo("BaseBrowser","chrome");
		report.setSystemInfo("Reporter name","Nadhiya");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("-- suite execution stoped");
		report.flush();
	}

}
