package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;


public class LambdaTestManager extends BaseTest{

    public static String hubURL = "https://hub.lambdatest.com/wd/hub";

    public ChromeOptions setLambdaTestCapabilities(){

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("135");

        HashMap<String, Object> ltOptions = new HashMap<>();

        ltOptions.put("username", dotenv.get("LT_USERNAME"));
        ltOptions.put("accessKey", dotenv.get("LT_ACCESS_KEY"));

        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("resolution", "1920x1080");
        ltOptions.put("build", "Lambda Test Assessment");
        ltOptions.put("project", "Lambda Test Assessment");
        ltOptions.put("smartUI.project", "Lambda Test Assessment");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);

        browserOptions.setCapability("LT:Options", ltOptions);

        return browserOptions;
    }


    public ChromeOptions setLocalTestCapabilities(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        return options;
    }


    public void initializeDriver(){

        String runMode = dotenv.get("RUN_MODE", "local");

        if(runMode.equalsIgnoreCase("lambda_test")) {

            try {
                driver.set(new RemoteWebDriver(URI.create(hubURL).toURL(), setLambdaTestCapabilities()));

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Driver initialized");
        }

        else {

            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver(setLocalTestCapabilities()));
        }
    }
}
