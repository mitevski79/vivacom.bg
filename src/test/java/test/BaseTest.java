package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DevicePage;
import pages.HomePage;
import pages.ProductPage;
import pages.ShoppingBagPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;
    protected ProductPage productPage;
    protected DevicePage devicePage;
    protected ShoppingBagPage shoppingBagPage;


    @BeforeAll
    public static void beforeAll() {
        //Download and setup driver
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeEach() {
        //Start browser instance
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        devicePage =new DevicePage(driver);
        shoppingBagPage = new ShoppingBagPage(driver);

    }

    @AfterEach
    public void afterEach() {
        //Kills browser instance
        //driver.quit();
    }
}
