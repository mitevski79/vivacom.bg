package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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
        /*String totalAmount = driver.findElement(By.xpath("//span[contains(@class,'e-care-home-big-bill-price-digits js-limit-exceed')]")).getText();
        int maxLimit =2000;
        try {
            int totalPrice = Integer.parseInt(totalAmount);
            if( totalPrice > maxLimit){
                driver.findElement(By.xpath("//form[@id='jsRemoveItemForm-1236444']//button")).click();
            }

        }
        catch (NumberFormatException e){
            System.out.println("not a number");

        }*/
        driver.findElement(By.xpath("//form[@id='jsRemoveItemForm-1236444']//button")).click();

    }

    public void removeHeadphonesFromShoppingBag() {
        driver.findElement(By.xpath("em[class='vivacom-icons icon-close_x']")).click();
       /* WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement remove = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='jsRemoveItemForm-1236444']//button//em[@class='vivacom-icons icon-close_x'")));
        remove.click();*/

    }
}
