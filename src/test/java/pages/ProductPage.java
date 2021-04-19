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

    }


    public void pressAppleIphone12ProMax128Gb() {
        System.out.println("Pressing link phone model Apple Iphone 12 Pro Max 128 GB");
       WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement radioButton = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By
                        .xpath("//h3[text()='APPLE IPHONE 12 PRO MAX 128GB']")));
        radioButton.click();

        //driver.findElement(By.cssSelector("a[href*='apple-iphone-12-pro-max-128gb']")).click();


        /*System.out.println("Pressing Apple Iphone 12 pro max 128 GB  from the  menu");
        List<WebElement> allLinks = driver.findElements(LOC_MOBILE_PHONES_LIST);

        for (WebElement element : allLinks) {
            if (element.getText().contains("APPLE IPHONE 12 PRO MAX 128G")) {
                element.click();
            }
        }*/
    }


    public void pressPriceCheckBoxButton() {
        System.out.println("Pressing Price check box  button from the manufacturer menu");
        WebElement buttonPrice = driver.findElement(By.xpath("//span[text()='между 5 и 40 лв.']//..//em"));
        if (!buttonPrice.isSelected()) {
            buttonPrice.click();

        }
    }

    public void pressAppleHeadphonesWithLightningConnector() {
        System.out.println("Pressing link phone Headphones model Apple ");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement button = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By
                        .cssSelector("a[href*='lightning-connector']")));
        button.click();

    }
}