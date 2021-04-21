package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DevicePage extends BasePage {

    private static final By LOC_TEXT_PRODUCT_MODEL = By
            .cssSelector("a[href*='lightning-connector']");
    private static final By LOC_RADIO_BUTTON_ONE_TIME_PAYMENT = By
            .xpath("//span[contains(@class,'cash-price-span') and contains(text(),'1979')]");
    private static final By LOC_GET_PRICE_OF_THE_DEVICE = By
            .id("summaryBarDevicePriceSpanId");
    private static final By LOC_BUTTON_SHOPPING_CARD = By
            .cssSelector("button[class='btn btn-success js-add-to-cart-btn js-prevent-dblclick']");


    public DevicePage(WebDriver driver) {
        super(driver);

    }

    public String getProductModel() {
        return getText(LOC_TEXT_PRODUCT_MODEL);
    }


    public void pressRadioButtonForOneTimePayment() {
        System.out.println("Pressing radio button cash price from the  menu");
        clickButton(LOC_RADIO_BUTTON_ONE_TIME_PAYMENT);
    }

    public String getPriceOfTheDevice() {
        return getText(LOC_GET_PRICE_OF_THE_DEVICE);
    }

    public void pressButtonShoppingCart() {
        System.out.println("Pressing Shopping Cart button");
        clickButton(LOC_BUTTON_SHOPPING_CARD);
    }
}

