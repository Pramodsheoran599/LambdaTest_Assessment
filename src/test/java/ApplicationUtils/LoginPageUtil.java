package ApplicationUtils;

import CommonUtils.ExtentReportManager;
import base.BaseTest;

public class LoginPageUtil extends BaseTest {

    public void login(String url, String username, String password) {

        driver.get().get(url);
        ExtentReportManager.logInfo("Opened URL");

        commonUtil.findElement(loginPage.usernameField()).sendKeys(username);
        ExtentReportManager.logInfo("Entered username");

        commonUtil.findElement(loginPage.passwordField()).sendKeys(password);
        ExtentReportManager.logInfo("Entered password");

        commonUtil.findElement(loginPage.loginButton()).click();
        ExtentReportManager.logInfo("Clicked login button");
    }
}
