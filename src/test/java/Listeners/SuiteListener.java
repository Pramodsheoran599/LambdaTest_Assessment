package Listeners;

import CommonUtils.ExtentReportManager;
import Constants.FrameworkConstants;
import org.testng.ISuiteListener;
import org.testng.ISuite;

import java.nio.file.Paths;

public class SuiteListener implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        System.out.println("Suites started: " + suite.getName());
        ExtentReportManager.initReports(FrameworkConstants.REPORT_NAME);
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("Suites finished: " + suite.getName());
        // Flush the Extent Report
        ExtentReportManager.flushReports();

        System.out.println("==============================================================");
        String rootPath = Paths.get("").toAbsolutePath().toString();
        System.out.println("Report URL : " + rootPath + "/" + FrameworkConstants.REPORT_NAME);
        System.out.println("==============================================================");


    }
}
