package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class ShoppingBagPage extends BasePage {

    private static final By LOC_BUTTON_CONTINUE_SHOPPING = By
            .xpath("//a[@href='/online/bg/shop/devices/listing']");
    private static final By LOC_TEXT_SHOPPING_BAG = By
            .xpath("//h2[text()='Моята кошница']");
    private static final By LOC_TEXT_TOTAL_AMOUNT = By
            .xpath("//span[@class='summarize-order-price']//span[contains(@class,'prices-28 js-limit-exceed')]");
    private static final By LOC_FIRST_ITEM_FROM_SHOPPING_BAG = By
            .xpath("//em[@class='vivacom-icons icon-close_x' and @aria-hidden='true']");
    private static final By LOC_CHECKBOX_BUTTON_GENERAL_CONDITION = By
            .cssSelector("em[class='vivacom-icon icon-box_empty']");
    private static final By LOC_CONTINUE_AS_COSTUMER = By
            .xpath("//button[text()='Продължи като клиент']");
    private static final By LOC_CONTINUE_AS_GUEST = By
            .xpath("//button[text()='Продължи като гост']");

    private static final By LOC_FIRST_MESSAGE_FROM_EMPTY_SHOPPING_BAG = By
            .xpath("//h3[text()='В момента кошницата ви е празна']");

    private static final By LOC_SECOND_MESSAGE_FROM_EMPTY_SHOPPING_BAG = By
            .xpath("//p[contains(text(),'Вижте актуалните ни оферти')]");


    public ShoppingBagPage(WebDriver driver) {
        super(driver);


    }


    public void pressButtonContinueShopping() {
        System.out.println("Pressing Continue Shopping button");
        clickButton(LOC_BUTTON_CONTINUE_SHOPPING);


    }

    public String getH2Text() {
        return getText(LOC_TEXT_SHOPPING_BAG);
    }

    public void checkTotalAmount() {
        String totalAmount = getText(LOC_TEXT_TOTAL_AMOUNT);
        double maxLimit = 2000;

        double totalPrice = Double.parseDouble(totalAmount);
        if (totalPrice > maxLimit) {
            removeFirstItemFromShoppingBag();
        }
    }


    public void verifyCheckboxIsDisplayed() {
        elementIsDisplayed(LOC_CHECKBOX_BUTTON_GENERAL_CONDITION);
    }

    public void buttonContinueAsCustomerIsNotEnabled() {
        elementIsNotEnabled(LOC_CONTINUE_AS_COSTUMER);
    }

    public void buttonContinueAsGuestIsNotEnabled() {
        elementIsNotEnabled(LOC_CONTINUE_AS_GUEST);
    }

    public void buttonContinueAsCustomerIsEnabled() {
        elementIsEnabled(LOC_CONTINUE_AS_COSTUMER);


    }

    public void buttonContinueAsGuestIsEnabled() {
        elementIsEnabled(LOC_CONTINUE_AS_GUEST);
    }


    public void pressCheckBoxGeneralConditionsForMobileServices() {
        System.out.println("Pressing General Conditions check box  button from shopping bag");
        waitForElement(LOC_CHECKBOX_BUTTON_GENERAL_CONDITION);
        clickButton(LOC_CHECKBOX_BUTTON_GENERAL_CONDITION);


    }


    public void removeFirstItemFromShoppingBag() {
        System.out.println("Pressing Close button from shopping bag ");
        clickButton(LOC_FIRST_ITEM_FROM_SHOPPING_BAG);


    }


    public void verifyThatTheShoppingBagIsEmpty() {
        Assertions.assertEquals(getText(LOC_FIRST_ITEM_FROM_SHOPPING_BAG), "В момента кошницата ви е празна");
        Assertions.assertEquals(getText(LOC_SECOND_MESSAGE_FROM_EMPTY_SHOPPING_BAG),
                "Вижте актуалните ни оферти и изберете най-подходящата за вас. Ако искате да разгледате предходно добавени продукти, натиснете \"Вход\".");

    }
}
