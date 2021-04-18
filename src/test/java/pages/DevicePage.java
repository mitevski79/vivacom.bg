package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DevicePage {

    public static final By LOC_TEXT_MOBILE_PHONE_MODEL = By.cssSelector("#summaryBarOfferTitleSpanId");

    private WebDriver driver;

    public DevicePage(WebDriver driver) {
        this.driver = driver;
    }


    public String getTitle() {
        return driver.getTitle().trim();
    }

    public String getProductModel() {
        return driver.findElement(By.cssSelector("#summaryBarOfferTitleSpanId")).getText().trim();
    }


    public void pressRadioButtonForOneTimePayment() {
        System.out.println("Pressing radio button cash price from the  menu");
        //driver.findElement(By.xpath("//span[contains(@class,'cash-price-span') and contains(text(),'1979')")).click();

        List<WebElement> radioButtons = driver.findElements(By.xpath("//span[@class='e-care-home-big-bill-price-digits js-related-offer-cash-price-span']"));

        for (WebElement element : radioButtons) {
            if (element.getText().contains("1979.98")) {
                element.click();
            }

        }
    }

    public String getPriceOfTheDevice() {
        return driver.findElement(By.id("summaryBarDevicePriceSpanId")).getText().trim();
    }

    public void pressButtonShoppingCart() {
        System.out.println("Pressing Shopping Cart button");
        driver.findElement(By.cssSelector("button[class='btn btn-success js-add-to-cart-btn js-prevent-dblclick']")).click();
    }
}

