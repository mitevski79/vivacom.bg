package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {


    private WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;

    }

    public String getTitle() {
        return driver.getTitle().trim();
    }

    public String getText(By by) {
        waitForElementVisibility(by);
        return driver.findElement(by).getText().trim();
    }

    public void scrollToElement(By by) {
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public void waitForElementVisibility(By by) {
        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForElement(By by){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public void clickButton(By by) {
        scrollToElement(by);
        waitForElementVisibility(by);
        driver.findElement(by).click();
    }

    public boolean elementIsDisplayed(By by) {
        waitForElementVisibility(by);
        return driver.findElement(by).isDisplayed();
    }
    public boolean elementIsEnabled(By by){
        waitForElementVisibility(by);
        return driver.findElement(by).isEnabled();
    }

    public boolean elementIsNotEnabled(By by){
        waitForElementVisibility(by);
        return ! driver.findElement(by).isEnabled();
    }


}