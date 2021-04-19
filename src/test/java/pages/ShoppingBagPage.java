package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Integer.parseInt;


public class ShoppingBagPage {


    private WebDriver driver;

    public ShoppingBagPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle().trim();
    }

    public void pressButtonContinueShopping() {
        System.out.println("Pressing Continue Shopping button");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Моята кошница']")));
        //driver.findElement(By.name("vivacom-cart-link-button-continue-shopping")).click();
        driver.findElement(By.xpath("//a[@href='/online/bg/shop/devices/listing']")).click();
    }

    public String getH2Text() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Моята кошница']")));
        return driver.findElement(By.xpath("//h2[text()='Моята кошница']")).getText();
    }

    public void checkTotalAmount() {
        String totalAmount = driver.findElement(By.xpath("//span[@class='summarize-order-price']//span[contains(@class,'prices-28 js-limit-exceed')]")).getText();
        double maxLimit = 2000;

        double totalPrice = Double.parseDouble(totalAmount);
        if (totalPrice > maxLimit) {
            WebElement removeItem = driver.findElement(By.xpath("//em[@class='vivacom-icons icon-close_x' and @aria-hidden='true']"));
            removeItem.click();
        }
    }


    public boolean verifyCheckBoxIsDisplayed() {

        return driver.findElement(By.xpath("//em[@class='vivacom-icon icon-box_empty']")).isDisplayed();
    }

    public boolean buttonContinueAsCustomerIsNotEnabled() {

        return !driver.findElement(By.xpath("//button[text()='Продължи като клиент']")).isEnabled();
    }

    public boolean buttonContinueAsGuestIsNotEnabled() {

        return !driver.findElement(By.xpath("//button[text()='Продължи като гост']")).isEnabled();
    }

    public boolean buttonContinueAsCustomerIsEnabled() {

        return driver.findElement(By.xpath("//button[text()='Продължи като клиент']")).isEnabled();
    }

    public boolean buttonContinueAsGuestIsEnabled() {

        return driver.findElement(By.xpath("//button[text()='Продължи като гост']")).isEnabled();
    }

    public void verifyButtonsContinueAsCustomerOrGuestIsNotEnable() {
        buttonContinueAsCustomerIsNotEnabled();
        buttonContinueAsGuestIsNotEnabled();

    }

    public void pressCheckBoxGeneralConditionsForMobileServices() {
        System.out.println("Pressing General Conditions check box  button from shopping bag");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement checkBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//em[@class='vivacom-icon icon-box_empty']")));

        if (!checkBox.isSelected()) {
            checkBox.click();
        }


    }

    public void verifyButtonsContinueAsCustomerOrGuestIsEnable() {
        buttonContinueAsCustomerIsEnabled();
        buttonContinueAsGuestIsEnabled();
    }

    public void removeFirstItemFromShoppingBag() {
        System.out.println("Pressing Close button from shopping bag ");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement removeItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//em[@class='vivacom-icons icon-close_x' and @aria-hidden='true']")));
        // WebElement removeItem = driver.findElement(By.xpath("//em[@class='vivacom-icons icon-close_x' and @aria-hidden='true']"));
        removeItem.click();


    }


    public void verifyThatTheShoppingBagIsEmpty() {
        WebElement textOne = driver.findElement(By.xpath("//h3[text()='В момента кошницата ви е празна']"));
        Assertions.assertEquals(textOne.getText(), "В момента кошницата ви е празна");
        WebElement textTwo = driver.findElement(By.xpath("//p[contains(text(),'Вижте актуалните ни оферти')]"));
        Assertions.assertEquals(textTwo.getText(),
                "Вижте актуалните ни оферти и изберете най-подходящата за вас. Ако искате да разгледате предходно добавени продукти, натиснете \"Вход\".");

    }
}
