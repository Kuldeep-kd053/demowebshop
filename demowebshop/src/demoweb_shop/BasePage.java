package demoweb_shop;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public static WebDriver driver;
    public static String Laning_Page_URL= "https://demowebshop.tricentis.com/";
    @BeforeClass

    public static void LaunchBrowser() throws InterruptedException {
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(Laning_Page_URL);
        Reporter.log("Chrome Invoked and navigated to URL: " + Laning_Page_URL + "<br>", true);

    }
    @AfterClass
    public static void close_browser(){
        driver.close();
    }
}
