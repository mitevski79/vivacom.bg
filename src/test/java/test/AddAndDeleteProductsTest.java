package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class AddAndDeleteProductsTest extends BaseTest {
    private static final String PRODUCT_PAGE_TITLE = "Продуктова страница | VIVACOM";
    private static final String DEVICE_PAGE_TITLE = "Устройство | VIVACOM";
    private static final String TEXT_MOBILE_PHONE_MODEL = "APPLE IPHONE 12 PRO MAX 128GB";
    private static final String DEVICE_PRISE = "1979.98";
    private static final String SHOPPING_BAG_PAGE_TITLE = "Кошница | VIVACOM";
    private static final String TEXT_HEADPHONES_MODEL = "APPLE СЛУШАЛКИ с LIGHTNING CONNECTOR";


    @Test
    @DisplayName("Аdd and delete products in shopping bag")
    public void addAndDeleteProductsInShoppingBag() {
        basePage.navigateTo();
        homePage.pressDevicesDropdownButton();

        homePage.pressMobilePhonesLink();
        Assertions.assertEquals(PRODUCT_PAGE_TITLE, basePage.getTitle());

        productPage.pressAppleCheckBoxButton();
        productPage.pressGoldCheckBoxButton();

        productPage.pressAppleIphone12ProMax128Gb();
        Assertions.assertEquals(DEVICE_PAGE_TITLE, basePage.getTitle());
        Assertions.assertEquals(TEXT_MOBILE_PHONE_MODEL, devicePage.getProductModel());

        devicePage.pressRadioButtonForOneTimePayment();
        Assertions.assertEquals(DEVICE_PRISE, devicePage.getPriceOfTheDevice());
        devicePage.pressButtonShoppingCart();
        Assertions.assertEquals("Моята кошница", shoppingBagPage.getH2Text());
        Assertions.assertEquals(SHOPPING_BAG_PAGE_TITLE, basePage.getTitle());

        shoppingBagPage.pressButtonContinueShopping();
        Assertions.assertEquals(PRODUCT_PAGE_TITLE, basePage.getTitle());

        homePage.pressDevicesDropdownButton();
        homePage.pressAccessoriesLinkButton();

        productPage.pressAppleCheckBoxButton();
        productPage.pressPriceCheckBoxButton();
        productPage.pressAppleHeadphonesWithLightningConnector();
        Assertions.assertEquals(DEVICE_PAGE_TITLE,
                basePage.getTitle());
        Assertions.assertEquals(TEXT_HEADPHONES_MODEL,
                devicePage.getProductModel());

        devicePage.pressButtonShoppingCart();
        Assertions.assertEquals("Моята кошница",
                shoppingBagPage.getH2Text());
        Assertions.assertEquals(SHOPPING_BAG_PAGE_TITLE,
                basePage.getTitle());

        shoppingBagPage.checkTotalAmount();

        shoppingBagPage.verifyCheckboxIsDisplayed();

        shoppingBagPage.buttonContinueAsCustomerIsNotEnabled();
        shoppingBagPage.buttonContinueAsGuestIsNotEnabled();

        shoppingBagPage.pressCheckBoxGeneralConditionsForMobileServices();
        shoppingBagPage.buttonContinueAsCustomerIsEnabled();
        shoppingBagPage.buttonContinueAsGuestIsEnabled();

        shoppingBagPage.removeFirstItemFromShoppingBag();
        shoppingBagPage.verifyThatTheShoppingBagIsEmpty();



    }



}
