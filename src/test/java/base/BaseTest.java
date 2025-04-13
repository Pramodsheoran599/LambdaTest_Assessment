package base;

import ApplicationUtils.JSAlertsPageUtil;
import ApplicationUtils.LoginPageUtil;
import CommonUtils.CommonUtil;
import Constants.FrameworkConstants;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.JSAlertPage;
import pages.LoginPage;

import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {

    //Made the driver as ThreadLocal to ensure safe Parallel Testing
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected Dotenv dotenv = Dotenv.load();


    protected static FluentWait<WebDriver> fluentWait;
    protected static WebDriverWait explicitWait;


    //Page Objects (static objects as driver instance is not required, just for storing locators
    protected static LoginPage loginPage = new LoginPage();
    protected static JSAlertPage jsAlertPage = new JSAlertPage();


    //Util Objects (non-static objects as these will require driver instance
    protected static LoginPageUtil loginPageUtil;
    protected static JSAlertsPageUtil jsAlertsPageUtil;
    protected static CommonUtil commonUtil;
    protected static LambdaTestManager lambdaTestManager;


    //Getter Method to get driver
    public static WebDriver getDriver() {
        return driver.get();
    }


    @BeforeSuite
    public void setupUtilObjects(){

        loginPageUtil = new LoginPageUtil();
        jsAlertsPageUtil = new JSAlertsPageUtil();
        commonUtil = new CommonUtil();
        lambdaTestManager = new LambdaTestManager();
    }


    @BeforeMethod
    public void setUp(Method method){

        lambdaTestManager.initializeDriver();
        getDriver().manage().window().maximize();

        fluentWait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(FrameworkConstants.TIME_OUT_IN_SECONDS))
                .pollingEvery(Duration.ofMillis(FrameworkConstants.POLLING_WAIT_IN_MILLIS))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        explicitWait = new WebDriverWait(getDriver(), Duration.ofSeconds(FrameworkConstants.TIME_OUT_IN_SECONDS));
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}