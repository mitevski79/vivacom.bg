package pages;

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
        driver.findElement(By.name("vivacom-cart-link-button-continue-shopping")).click();
    }

    public String getH2Text() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Моята кошница']")));
        return driver.findElement(By.xpath("//h2[text()='Моята кошница']")).getText();
    }
}
