package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {

    private static final By LOC_DEVICE_DROPDOWN_BUTTON = By
            .xpath("//a[@class='dropdown-toggle' and contains(text(), 'Устройства')]");
    private static final By LOC_MOBILE_PHONES_BUTTON = By
            .xpath("//a[@title='Мобилни телефони']");
    private static final By LOC_ACCESSORIES_BUTTON = By
            .xpath("//a[@href='/online/bg/shop/devices/listing?navigation=product-category-accessories']");


    public HomePage(WebDriver driver) {
        super(driver);

    }


    public void pressDevicesDropdownButton() {
        System.out.println("Pressing Device dropdown button from the menu");
        clickButton(LOC_DEVICE_DROPDOWN_BUTTON);

    }

    public void pressMobilePhonesLink() {
        System.out.println("Pressing Mobile phones link  from  Device dropdown menu");
        clickButton(LOC_MOBILE_PHONES_BUTTON);

    }


    public void pressAccessoriesLinkButton() {
        System.out.println("Pressing Accessories link  from  device dropdown menu");
        clickButton(LOC_ACCESSORIES_BUTTON);

    }
}
