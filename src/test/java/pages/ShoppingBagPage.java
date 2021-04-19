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
            WebElement removeItem = driver.findElement(By.xpath("(//em[@class='vivacom-icons icon-close_x'])[3]"));
            removeItem.click();
        }
    }


    public void verifyCheckBoxIsDisplayed() {
        WebElement checkBox = driver.findElement(By.xpath("//input[@id='mobile-termes-and-conditions']/.."));
        Assertions.assertTrue(checkBox.isDisplayed());
    }

    public boolean buttonContinueAsCustomerIsEnabled() {
        getH2Text();
        return driver.findElement(By.xpath("//button[text()='Продължи като клиент']")).isEnabled();
    }

    public void verifyButtonsContinueAsCustomerOrGuestIsNotEnable() {

        WebElement verifyOne = driver.findElement(By.xpath("//button[text()='Продължи като клиент']"));

        Assertions.assertTrue(verifyOne.isEnabled());


        WebElement verifyTwo = driver.findElement(By.xpath("//button[text()='Продължи като гост']"));
        Assertions.assertTrue(verifyTwo.isEnabled());


    }

    public void pressCheckBoxGeneralConditionsForMobileServices() {

        WebDriverWait wait = new WebDriverWait(driver, 10); //em[@class='vivacom-icon icon-box_empty']
        WebElement checkBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("//em[@class='vivacom-icon icon-box_empty']")));
        //WebElement checkBox = driver.findElement(By.xpath("//em[@class='vivacom-icon icon-box_empty']"));
        if (!checkBox.isSelected()) {
            checkBox.click();
        }
    }

    public void verifyButtonsContinueAsCustomerOrGuestIsEnable() {
        getH2Text();
        WebElement verifyOne = driver.findElement(By.xpath("//button[text()='Продължи като клиент']"));

        Assertions.assertTrue(!verifyOne.isEnabled());


        WebElement verifyTwo = driver.findElement(By.xpath("//button[text()='Продължи като гост']"));
        Assertions.assertTrue(!verifyTwo.isEnabled());


    }

    public void removeFirstItemFromShoppingBag() {
       getH2Text();
        WebDriverWait wait = new WebDriverWait(driver, 10);//form[id='jsRemoveItemForm-1238263'] button[class='btn-close'] em
        WebElement removeItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//em[@class='vivacom-icons icon-close_x' and @aria-hidden='true']")));
        // WebElement removeItem = driver.findElement(By.xpath("//em[@class='vivacom-icons icon-close_x' and @aria-hidden='true']"));
        removeItem.click();


    }


    public void verifyThatTheShoppingBagIsEmpty() {
        WebElement textOne = driver.findElement(By.xpath("//h3[text()='В момента кошницата ви е празна']"));
        Assertions.assertEquals(textOne.getText(), "В момента кошницата ви е празна");
        WebElement textTwo = driver.findElement(By.xpath("//p[contains(text(),'Вижте актуалните ни оферти')]"));
        Assertions.assertEquals(textOne.getText(),
                "Вижте актуалните ни оферти и изберете най-подходящата за вас. Ако искате да разгледате предходно добавени продукти, натиснете \"Вход\".");

    }
}
