package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DevicePage {

    public static final By LOC_TEXT_MOBILE_PHONE_MODEL = By.cssSelector("#summaryBarOfferTitleSpanId");

    private WebDriver driver;

    public DevicePage(WebDriver driver) {
        this.driver = driver;
    }


    public String getTitle() {


        return driver.getTitle().trim();
    }

    public String getMobilePhoneModel() {
        return driver.findElement(By.cssSelector("#summaryBarOfferTitleSpanId")).getText().trim();
    }


    public void pressRadioButtonForOneTimePayment() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement radioButton = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By
                        .xpath(" (//span[@class='simple-radio-btns-wrapper-span'])[2]")));
        if (!radioButton.isSelected()) {
            radioButton.click();
        }


    }

    public String getPriceOfTheDevice() {
        return driver.findElement(By.id("summaryBarDevicePriceSpanId")).getText().trim();
    }

}

