package com.vtiger.genericLib;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class ListenerImp implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
		String failedTestCaseName = result.getMethod().getMethodName();
		String currentDate = new Date().toString().replace(" ", "_").replace(":", "_");
		EventFiringWebDriver ed = new EventFiringWebDriver(BaseClass.driver);
		File src = ed.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Screenshots/"+failedTestCaseName+currentDate+".PNG");
		try {
			Files.copy(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//By TypeCasting Method
		
//		Object screenshotpath = "./screenshots/"+result.getName()+currentDate+".PNG";
//		TakesScreenshot ts = (TakesScreenshot)BaseClass.driver;
//		File srcImg=ts.getScreenshotAs(OutputType.FILE);
//		File dstImg = new File(screenshotpath);
		
		
		
//		try {
//			FileUtils.copyFile(src, dst);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	

}
