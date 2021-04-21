package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductPage extends BasePage{


    private static final By LOC_APPLE_CHECKBOX_BUTTON = By
            .xpath("//span[@class='analytics-skip'and text()='APPLE']//..//em");
    private  static final By LOC_GOLD_CHECKBOX_BUTTON = By
            .xpath("//span[@class='analytics-skip'and text()='GOLD']//..//em");
    private  static final By LOC_BUTTON_APPLE_IPHONE_12_PRO_MAX_128GB = By
            .xpath("//h3[text()='APPLE IPHONE 12 PRO MAX 128GB']");
    private  static final By LOC_PRICE_CHECKBOX_BUTTON = By
            .xpath("//span[text()='между 5 и 40 лв.']//..//em");
    private static final By LOC_APPLE_HEADPHONES_BUTTON = By
            .cssSelector("a[href*='lightning-connector']");


    WebDriver driver;

    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver= driver;

    }



    public void pressAppleCheckBoxButton() {
        System.out.println("Pressing APPLE checkbox  button from the manufacturer menu");
        waitForElementVisibility(LOC_APPLE_CHECKBOX_BUTTON);
        if(! driver.findElement(LOC_APPLE_CHECKBOX_BUTTON).isSelected()){
            clickButton(LOC_APPLE_CHECKBOX_BUTTON);
        }


    }

    public void pressGoldCheckBoxButton() {
        System.out.println("Pressing GOLD checkbox  button from the manufacturer menu");
        waitForElementVisibility(LOC_GOLD_CHECKBOX_BUTTON);
        if(! driver.findElement(LOC_GOLD_CHECKBOX_BUTTON).isSelected()){
            clickButton(LOC_GOLD_CHECKBOX_BUTTON);
        }

    }


    public void pressAppleIphone12ProMax128Gb() {
        System.out.println("Pressing link phone model Apple Iphone 12 Pro Max 128 GB");
       clickButton(LOC_BUTTON_APPLE_IPHONE_12_PRO_MAX_128GB);

    }


    public void pressPriceCheckBoxButton() {
        System.out.println("Pressing GOLD checkbox  button from the manufacturer menu");
        waitForElementVisibility(LOC_PRICE_CHECKBOX_BUTTON);
        if(! driver.findElement(LOC_PRICE_CHECKBOX_BUTTON).isSelected()){
            clickButton(LOC_PRICE_CHECKBOX_BUTTON);
        }
    }

    public void pressAppleHeadphonesWithLightningConnector() {
        System.out.println("Pressing link phone Headphones model Apple ");
        clickButton(LOC_APPLE_HEADPHONES_BUTTON);

    }
}