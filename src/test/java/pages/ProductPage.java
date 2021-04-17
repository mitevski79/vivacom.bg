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

        driver.findElement(By.cssSelector(".accept-cookie-policy")).click();
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
        String winHadleBefore = driver.getWindowHandle();
        System.out.println("Pressing Apple Iphone 12 pro max 128 GB  from the  menu");
        List<WebElement> allLinks = driver.findElements(LOC_MOBILE_PHONES_LIST);

        for (WebElement element : allLinks) {
            if (element.getText().contains("APPLE IPHONE 12 PRO MAX 128G")) {
                element.click();
            }
        }

        driver.switchTo().window("https://www.vivacom.bg/online/shop/devices/product-category-smart-mobile-phones/apple-iphone-12-pro-max-128gb?offer=epc_kvr210408112430731635_so_zit210409143744776567");

    }


    public void switchToWindow() {
        String winHadleBefore = driver.getWindowHandle();
        for (String windowId : driver.getWindowHandles()) {
            driver.switchTo().window(windowId);


        }
    }
}