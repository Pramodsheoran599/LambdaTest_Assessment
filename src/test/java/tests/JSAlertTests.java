package tests;

import CommonUtils.ExtentReportManager;
import Constants.FrameworkConstants;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class JSAlertTests extends BaseTest {

    @Test(groups = {"regression"}, dataProvider = "jsAlertDataProvider")
    public void verifyJSAlertAcceptFunctionality(String buttonText, String promptText, String expectedMessage) {

        getDriver().get(FrameworkConstants.JS_ALERT_URL);
        ExtentReportManager.logInfo("Opened URL");

        if(promptText.isEmpty())
            jsAlertsPageUtil.acceptJSAlert(buttonText);
        else
            jsAlertsPageUtil.sendPromptToAlert(buttonText, promptText);

        String resultText = commonUtil.findElement(jsAlertPage.resultText()).getText();
        Assert.assertEquals(resultText, expectedMessage, "Alert text is not matching");

        ExtentReportManager.logInfo("Alert text is matching");
    }


    @DataProvider(name = "jsAlertDataProvider")
    public Object[][] dataProvider() {

        return new Object[][]{

                {"Click for JS Alert",
                        "",
                        "You successfully clicked an alert"},

                {"Click for JS Confirm",
                        "",
                        "You clicked: Ok"},

                {"Click for JS Prompt",
                        "test",
                        "You entered: test"}
        };
    }
}