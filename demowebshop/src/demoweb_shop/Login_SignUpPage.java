package demoweb_shop;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class Login_SignUpPage extends BasePage {

    // register
    @FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
    static WebElement registerButton;
    // select gender male
    @FindBy(how = How.XPATH, using = "//div[@class='gender']//input[@id='gender-male']")
    static WebElement genderMale;
    //select gender female
    @FindBy(how = How.NAME, using = "//input[@id='gender-female']")
    static WebElement genderFemale;
    // First name
    @FindBy(how = How.ID, using = "FirstName")
    static WebElement firstName;
    // Last name:
    @FindBy(how = How.ID, using = "LastName")
    static WebElement lastName;
    // Email
    @FindBy(how = How.XPATH, using = "//input[@name='Email']")
    static WebElement email;
    // Password
    @FindBy(how = How.XPATH, using = "//input[@name='Password']")
    static WebElement Password;
    // confirm Password
    @FindBy(how = How.XPATH, using = "//input[@name='ConfirmPassword']")
    static WebElement confirmPassword;
    // click on register
    @FindBy(how = How.XPATH, using = "//input[@id='register-button']")
    static WebElement finalRegister;
    // Login
    @FindBy(how = How.XPATH, using = "//a[@class='ico-login']")
    static WebElement loginButton;

    // email
    @FindBy(how = How.XPATH, using = "//input[@id='Email']")
    static WebElement emailLogin;
    // login pass
    @FindBy(how = How.XPATH, using = "//input[@id='Password']")
    static WebElement passLogin;
    // click on login
    @FindBy(how = How.XPATH, using = "//input[@class='button-1 login-button']")
    static WebElement clickLogin;
    // logout button
    @FindBy(how = How.XPATH, using = "//a[@href='/logout']")
    static WebElement logOut;


    static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());


    public static void register_user(String firstname, String lastname, String Email, String password, String confirmpass) throws InterruptedException {
        Login_SignUpPage login_signUpPage = PageFactory.initElements(driver, Login_SignUpPage.class);
        registerButton.click();
        genderMale.click();
        firstName.sendKeys("Vikash");
        lastName.sendKeys("Kumar");
        email.sendKeys("Vikash1" + timeStamp + "@b.com");
        Password.sendKeys("Vikash@kumar");
        confirmPassword.sendKeys("Vikash@kumar");
        finalRegister.click();
    }

    public static void login(String Email, String Password) throws InterruptedException {
        Login_SignUpPage login_signUpPage = PageFactory.initElements(driver, Login_SignUpPage.class);
        if(loginButton.isDisplayed()) {
            loginButton.click();
        }
        else
            logOut.click();
        loginButton.click();
        emailLogin.sendKeys("Vikash1@Kumar.com");
        passLogin.sendKeys("Vikash@kumar");
        clickLogin.click();
    }
}

