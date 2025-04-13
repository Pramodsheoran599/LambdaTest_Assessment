package ApplicationUtils;

import CommonUtils.ExtentReportManager;
import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JSAlertsPageUtil extends BaseTest {

    public void acceptJSAlert(String buttonText) {

        commonUtil.findElement(jsAlertPage.jsButton(buttonText)).click();
        ExtentReportManager.logTextInfo("Clicked "+ buttonText +" button");

        explicitWait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.get().switchTo().alert();
        ExtentReportManager.logTextInfo("Alert Received");
        alert.accept();
    }


    public void sendPromptToAlert(String buttonText, String prompt) {

        commonUtil.findElement(jsAlertPage.jsButton(buttonText)).click();
        ExtentReportManager.logTextInfo("Clicked "+ buttonText +" button");

        explicitWait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.get().switchTo().alert();
        alert.sendKeys(prompt);
        ExtentReportManager.logTextInfo("Entered prompt in alert");

        alert.accept();
    }

}
