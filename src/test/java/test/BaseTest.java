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

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;
    protected ProductPage productPage;
    protected DevicePage devicePage;


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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
    }

    @AfterEach
    public void afterEach() {
        //Kills browser instance
        //driver.quit();
    }
}
