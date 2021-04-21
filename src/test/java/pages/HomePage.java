package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.BaseTest;

public class HomePage extends BasePage {

    private static final By LOC_DEVICE_DROPDOWN_BUTTON = By
            .xpath("//a[@class='dropdown-toggle' and contains(text(), 'Устройства')]");
    private static final By LOC_MOBILE_PHONES_BUTTON = By
            .xpath("//a[@title='Мобилни телефони']");
    private static final By LOC_ACCESSORIES_BUTTON = By
            .xpath("//a[@href='/online/bg/shop/devices/listing?navigation=product-category-accessories']");


    private WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public HomePage navigateTo() {
        System.out.println("Navigating to Vivacom home page");
        driver.navigate().to(Defaults.BASE_URL);
        return this;
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
