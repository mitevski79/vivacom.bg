package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.BaseTest;

public class HomePage {


    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage navigateTo() {
        System.out.println("Navigating to Vivacom home page");
        driver.navigate().to(Defaults.BASE_URL);
        return this;
    }

    public void pressDevicesDropdownButton() {
        System.out.println("Pressing Device dropdown button from the menu");
        driver.findElement(By.xpath("//a[@class='dropdown-toggle' and contains(text(), 'Устройства')]")).click();
    }

    public void pressMobilePhonesLink() {
        System.out.println("Pressing Mobile phones link  from  Device dropdown menu");
        driver.findElement(By.xpath("//a[@title='Мобилни телефони']")).click();

    }


    public void pressAccessoriesLinkButton() {
        driver.findElement(By.xpath("//a[@href='/online/bg/shop/devices/listing?navigation=product-category-accessories']")).click();
    }
}
