package com.tutorialninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
public static ExtentReports generateExtentReport(){
		
	ExtentReports extentReport=new ExtentReports();
	
	File extentReportFile= new File(System.getProperty("user.dir")+"//test-output//ExtentReports//extentReport.html");
	
    ExtentSparkReporter sparkReporter=new ExtentSparkReporter(extentReportFile);
    
    sparkReporter.config().setTheme(Theme.DARK);
    sparkReporter.config().setReportName("TutorialsNinja Test Automation Test Report");
    sparkReporter.config().setDocumentTitle("TN Automation Report");
    sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
    
    extentReport.attachReporter(sparkReporter);
    
    Properties configProp=new Properties();
    
    File file1 =new File(System.getProperty("user.dir") +"//src/main//java//com//tutorialsninja//qa//config//config.properties");
    
    try {
    
    FileInputStream fis=new FileInputStream(file1);
    
    configProp.load(fis);
    
    }catch(Throwable e){
    	e.printStackTrace();
    }
    
    extentReport.setSystemInfo("Application URL", configProp.getProperty("url"));
    extentReport.setSystemInfo("BrowserName", configProp.getProperty("browserName"));
    extentReport.setSystemInfo("ValidEmail", configProp.getProperty("validEmail"));
    extentReport.setSystemInfo("Password", configProp.getProperty("password"));
    extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
    extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
    extentReport.setSystemInfo("Username", System.getProperty("user.name"));
    
    return extentReport;
    
	}

	
	

}
