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
        driver.findElement(By.name("vivacom-cart-link-button-continue-shopping")).click();
    }

    public String getH2Text() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Моята кошница']")));
        return driver.findElement(By.xpath("//h2[text()='Моята кошница']")).getText();
    }

    public void checkTotalAmount() {
        String totalAmount = driver.findElement(By.xpath("//span[contains(@class,'e-care-home-big-bill-price-digits js-limit-exceed')]")).getText();
        int maxLimit =2000;

            int totalPrice = parseInt(totalAmount);
            if( totalPrice > maxLimit){
                WebElement removeItem = driver.findElement(By.xpath("(//em[@class='vivacom-icons icon-close_x'])[3]"));
                removeItem.click();

            }



        //driver.findElement(By.xpath("//form[@id='jsRemoveItemForm-1236444']//button")).click();

    }

    public void removeHeadphonesFromShoppingBag() {
        WebElement removeItem = driver.findElement(By.xpath("(//em[@class='vivacom-icons icon-close_x'])[3]"));
        removeItem.click();
       /* WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement remove = wait.until(ExpectedConditions.visibilityOfEl;ementLocated(By.xpath("//form[@id='jsRemoveItemForm-1236444']//button//em[@class='vivacom-icons icon-close_x'")));
        remove.click();*/

    }

    public void pressCheckBoxGeneralConditionsForMobileServices() {

        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement checkBox= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//em[@class='vivacom-icon icon-box_empty']")));

        if(!checkBox.isSelected()){
            checkBox.click();
        }
    }

    public void verifyCheckBoxIsDisplayed() {
        WebElement checkBox = driver.findElement(By.xpath("//input[@id='mobile-termes-and-conditions']/.."));
        Assertions.assertTrue(checkBox.isDisplayed());
    }

    public void verifyButtonsContinueAsCustomerOrGuestIsNotEnable() {
        Assertions.assertFalse(driver.findElement(By.xpath("//button[text()='Продължи като клиент']")).isEnabled());
        Assertions.assertFalse(driver.findElement(By.xpath("//button[text()='Продължи като гост']")).isEnabled());
    }
}
