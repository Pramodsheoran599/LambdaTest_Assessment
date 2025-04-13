package tests;

import CommonUtils.ExtentReportManager;
import Constants.FrameworkConstants;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {

    @Test(groups = {"smoke"}, dataProvider = "loginData", description = "Verify Login functionality")
    public void verifyLoginFunctionality(String testType, String username, String password, String expectedMessage) {

        loginPageUtil.login(FrameworkConstants.LOGIN_URL,username, password);

        String actualText = commonUtil.findElement(loginPage.flashMessage(testType)).getText().trim();
        Assert.assertTrue(actualText.contains(expectedMessage), "Login message is not matching");
        ExtentReportManager.logInfo("Login message is matching");
    }


    @DataProvider(name = "loginData")
    public Object[][] dataProvider() {

        return new Object[][]{

                {"success",
                        dotenv.get("APP_USERNAME"),
                        dotenv.get("APP_PASSWORD"),
                        "You logged into a secure area!"},

                {"error",
                        "wrongUser",
                        dotenv.get("APP_PASSWORD"),
                        "Your username is invalid!"},

                {"error",
                        dotenv.get("APP_USERNAME"),
                        "wrongPass",
                        "Your password is invalid!"}
        };
    }
}