package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class Test1 extends BaseTest {
    private static final String  PRODUCT_PAGE_TITLE ="Продуктова страница | VIVACOM";
    private static final String  DEVICE_PAGE_TITLE ="Устройство | VIVACOM";
    //private static final String  TEXT_MOBILE_PHONE_MODEL ="APPLE IPHONE 12 PRO MAX 128GB";  //span[@id='summaryBarDevicePriceSpanId']
    private static final String  DEVICE_PRISE ="1979.98";



    @Test
    @DisplayName("Аdd a mobile phone to the cart")
    public void addMobilePhoneToTheCart()  {
        homePage.navigateTo();
        homePage.pressDevicesDropdownButton();
        homePage.pressMobilePhonesLink();
        Assertions.assertEquals(PRODUCT_PAGE_TITLE,productPage.getTitle());
        productPage.pressAppleCheckBoxButton();
        productPage.pressGoldCheckBoxButton();
        productPage.pressAppleIphone12ProMax128Gb();

        //Assertions.assertEquals(TEXT_MOBILE_PHONE_MODEL,devicePage.getMobilePhoneModel());
       // Assertions.assertEquals(DEVICE_PAGE_TITLE,devicePage.getTitle());

       devicePage.pressRadioButtonForOneTimePayment();
        //Assertions.assertEquals(DEVICE_PRISE,devicePage.getPriceOfTheDevice());








    }


}
