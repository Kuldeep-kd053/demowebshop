package demoweb_shopTests;

import demoweb_shop.Login_SignUpPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Login_signUpTest extends Login_SignUpPage {

    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
    Take_ScreenShot takeSnapShot = new Take_ScreenShot();

    static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    // profile section
    @FindBy(how = How.XPATH, using = "(//a[@class='account'])[1]")
    public WebElement userProfile;


    @Test(priority = 1)
    public void register_test() throws Exception {
        Login_signUpTest login_signUpTest = PageFactory.initElements(driver, Login_signUpTest.class);
        Login_SignUpPage login_signUpPage= new Login_SignUpPage();
        String email = "Vikash"+timeStamp+"jha.com";
        register_user("Vikash","Kumar",email,"Vikash@kumar"
                ,"Vikash@kumar");
        System.out.println("Registeration successful with account: "+ email);
        takeSnapShot.takeSnapShot(driver, "D://automation//save screen shot//"+sdf.format(d)+".png");

    }

    @Test(priority = 2)

    public void Login_test() throws Exception {
        Login_signUpTest login_signUpTest = PageFactory.initElements(driver, Login_signUpTest.class);
        login("Vikash@Kumar.com","Vikash@kumar");
        System.out.println("Login succesfull");
        takeSnapShot.takeSnapShot(driver, "D://automation//save screen shot//"+sdf.format(d)+"Kuldeep"+".png");
    }
}
