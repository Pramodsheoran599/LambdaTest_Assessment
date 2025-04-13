package CommonUtils;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

public class CommonUtil extends BaseTest {

    public WebElement findElement(By locator) {

        return fluentWait.until(driver -> {

            WebElement element = driver.findElement(locator);
            if (element.isDisplayed()) {
                return element;
            }
            return null;
        });
    }

    public boolean isDisplayed(By locator) {
        try {
            WebElement element = findElement(locator);
            return element != null && element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
