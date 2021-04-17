package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProductPage {

    public static final By LOC_MOBILE_PHONES_LIST = By.cssSelector("div[class='list-compare-devices link-box-device-wrapper product-listing-container row']");
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle().trim();
    }

    public void pressAppleCheckBoxButton() {

        System.out.println("Pressing APPLE check box  button from the manufacturer menu");
        WebElement buttonApple = driver.findElement(By.xpath("//span[@class='analytics-skip'and text()='APPLE']//..//em"));
        if (!buttonApple.isSelected()) {
            buttonApple.click();

        }


    }

    public void pressGoldCheckBoxButton() {
        System.out.println("Pressing GOLD check box  button from the manufacturer menu");
        WebElement buttonGold = driver.findElement(By.xpath(" //span[@class='analytics-skip'and text()='GOLD']//..//em"));
        if (!buttonGold.isSelected()) {
            buttonGold.click();
        }
        // Assertions.assertTrue(buttonGold.isSelected());
    }


    public void pressAppleIphone12ProMax128Gb() {
        //String currentWindowId = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement radioButton = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By
                        .cssSelector("a[href*='apple-iphone-12-pro-max-128gb']")));
        radioButton.click();
        driver.switchTo().frame("addToCardForm");

        // driver.findElement(By.cssSelector("a[href*='apple-iphone-12-pro-max-128gb']")).click();

      /*  Set<String> allWindows = driver.getWindowHandles();
        if (!allWindows.isEmpty()) {
            for (String windowId : allWindows) {
                driver.switchTo().window(windowId);
                if (driver.getPageSource().trim().contains("Влезте в профила си, за да виждате офертите специално за вас")) {
                    WebDriverWait wait = new WebDriverWait(driver, 15);
                    WebElement radioButton = wait.until(ExpectedConditions.
                            visibilityOfElementLocated(By
                                    .xpath(" (//span[@class='simple-radio-btns-wrapper-span'])[2]")));
                    if (!radioButton.isSelected()) {
                        radioButton.click();
                    }

                }

        /*Set<String> allWindows = driver.getWindowHandles();
        for (String windowId : allWindows){
            if (driver.switchTo().window(windowId).getTitle().trim().equals("Устройство | VIVACOM")) {
                //Close the Visit Us Popup Window
                //driver.close();
                break;
            }
        }*/
       /*
        System.out.println("Pressing Apple Iphone 12 pro max 128 GB  from the  menu");
        List<WebElement> allLinks = driver.findElements(LOC_MOBILE_PHONES_LIST);

        for (WebElement element : allLinks) {
            if (element.getText().contains("APPLE IPHONE 12 PRO MAX 128G")) {
                element.click();
            }
        }*/
    }


}