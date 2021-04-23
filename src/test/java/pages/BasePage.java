package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {


    private WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;

    }


    public BasePage navigateTo() {
        System.out.println("Navigating to https://www.vivacom.bg/bg/");
        driver.navigate().to(Defaults.BASE_URL);
        return this;
    }


    public String getTitle() {
       driver.switchTo().activeElement();
        return driver.getTitle().trim();
    }

    public String getText(By by) {
        waitForElementVisibility(by);
        return driver.findElement(by).getText().trim();
    }


    protected WebElement waitForElementToBeClickable(By by) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 25);
        WebElement foundElementAfterWait = wait
                .until(ExpectedConditions.elementToBeClickable(by));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return foundElementAfterWait;
    }

    protected WebElement waitForElementVisibility(By by) {
        waitForFullPageOrJsAjaxToLoad();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement foundElementAfterWait = wait.until(ExpectedConditions
                .visibilityOf(driver.findElement(by)));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return foundElementAfterWait;

    }



    public void clickButton(By by) {

        waitForElementToBeClickable(by);
        driver.findElement(by).click();
    }

    public boolean elementIsDisplayed(By by) {
        waitForElementVisibility(by);
        return driver.findElement(by).isDisplayed();
    }

    public boolean elementIsEnabled(By by) {
        waitForElementVisibility(by);
        return driver.findElement(by).isEnabled();
    }

    public boolean elementIsNotEnabled(By by) {
        waitForElementVisibility(by);
        return !driver.findElement(by).isEnabled();
    }

    public boolean waitForFullPageOrJsAjaxToLoad() {

        WebDriverWait wait = new WebDriverWait(driver, 30);

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = driver -> {
            try {
                if (driver != null) {
                    return ((Long) ((JavascriptExecutor) driver)
                            .executeScript("return jQuery.active") == 0);
                }
            } catch (Exception e) {
                // no jQuery present
                return true;
            }
            return null;
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = driver -> {
            if (driver != null) {
                return ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .toString().equals("complete");
            }
            return null;
        };

        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }


}