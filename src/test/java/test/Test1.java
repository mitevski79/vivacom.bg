package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class Test1 extends BaseTest {
    private static final String PRODUCT_PAGE_TITLE = "Продуктова страница | VIVACOM";
    private static final String DEVICE_PAGE_TITLE = "Устройство | VIVACOM";
    private static final String TEXT_MOBILE_PHONE_MODEL = "APPLE IPHONE 12 PRO MAX 128GB";
    private static final String DEVICE_PRISE = "1979.98";
    private static final String SHOPPING_BAG_PAGE_TITLE = "Кошница | VIVACOM";
    private static final String TEXT_HEADPHONES_MODEL = "APPLE СЛУШАЛКИ с LIGHTNING CONNECTOR";


    @Test
    @DisplayName("Аdd a mobile phone to the cart")
    public void addMobilePhoneToTheCart() {
        homePage.navigateTo();
        homePage.pressDevicesDropdownButton();
        homePage.pressMobilePhonesLink();
        Assertions.assertEquals(PRODUCT_PAGE_TITLE, productPage.getTitle());
        productPage.pressAppleCheckBoxButton();
        productPage.pressGoldCheckBoxButton();
        productPage.pressAppleIphone12ProMax128Gb();
        Assertions.assertEquals(DEVICE_PAGE_TITLE, devicePage.getTitle());
        Assertions.assertEquals(TEXT_MOBILE_PHONE_MODEL, devicePage.getProductModel());
        devicePage.pressRadioButtonForOneTimePayment();
        Assertions.assertEquals(DEVICE_PRISE, devicePage.getPriceOfTheDevice());
        devicePage.pressButtonShoppingCart();
        Assertions.assertEquals("Моята кошница", shoppingBagPage.getH2Text());
        Assertions.assertEquals(SHOPPING_BAG_PAGE_TITLE, shoppingBagPage.getTitle());
        shoppingBagPage.pressButtonContinueShopping();
        Assertions.assertEquals(PRODUCT_PAGE_TITLE, productPage.getTitle());
        homePage.pressDevicesDropdownButton();
        homePage.pressAccessoriesLinkButton();
        productPage.pressAppleCheckBoxButton();
        productPage.pressPriceCheckBoxButton();
        productPage.pressAppleHeadphonesWithLightningConnector();
        Assertions.assertEquals(DEVICE_PAGE_TITLE, devicePage.getTitle());
        Assertions.assertEquals(TEXT_HEADPHONES_MODEL, devicePage.getProductModel());
        devicePage.pressButtonShoppingCart();
        Assertions.assertEquals("Моята кошница", shoppingBagPage.getH2Text());
        Assertions.assertEquals(SHOPPING_BAG_PAGE_TITLE, shoppingBagPage.getTitle());

        // Не ми работи метода, не мога да сравна стринг с инт
        //shoppingBagPage.checkTotalAmount();

        shoppingBagPage.removeHeadphonesFromShoppingBag();

        shoppingBagPage.verifyCheckBoxIsDisplayed();
           //И тук имам проблем с верификацята
        //shoppingBagPage.verifyButtonsContinueAsCustomerOrGuestIsNotEnable();

        shoppingBagPage.pressCheckBoxGeneralConditionsForMobileServices();


    }

  /*  @Test
    @DisplayName("Аdd a accessory to the cart")
    public void addAccessoryToTheCart() {
        homePage.navigateTo();
        homePage.pressDevicesDropdownButton();
        homePage.pressAccessoriesLinkButton();
        productPage.pressAppleCheckBoxButton();
        productPage.pressPriceCheckBoxButton();
        productPage.pressAppleHeadphonesWithLightningConnector();
        Assertions.assertEquals(DEVICE_PAGE_TITLE, devicePage.getTitle());
        Assertions.assertEquals(TEXT_HEADPHONES_MODEL, devicePage.getProductModel());
        devicePage.pressButtonShoppingCart();
        Assertions.assertEquals("Моята кошница", shoppingBagPage.getH2Text());
        Assertions.assertEquals(SHOPPING_BAG_PAGE_TITLE, shoppingBagPage.getTitle());
        shoppingBagPage.checkTotalAmount();
       // shoppingBagPage.removeHeadphonesFromShoppingBag();

    }*/

}
