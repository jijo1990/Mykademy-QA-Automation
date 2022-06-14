package mykademy.pages;

import mykademy.tests.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MykademySignUp {

    @FindBy(xpath = ".//a[@id='signup']")
    private WebElement signUp;
    @FindBy(xpath = ".//h2[text()='Sign up now for free']")
    private WebElement signUpHeader;
    @FindBy(xpath = ".//div[@class='form-group ']//input[@placeholder='Full name']")
    private WebElement signUpUsernameFld;
    @FindBy(xpath = ".//div[@class='form-group ']//input[@placeholder='Email address']")
    private WebElement signUpEmailFld;
    @FindBy(id = "country_code")
    private WebElement countryCode;
    @FindBy(xpath = ".//select[@id='country_code']//option[@value='+91']")
    private WebElement selectCountryCodeFromList;
    @FindBy(id = "number")
    private WebElement signUpPhoneNumberFld;
    @FindBy(id = "password")
    private WebElement signUpPasswordFld;
    @FindBy(xpath = ".//div[@class='form-group text-right']/a[text()='Join']")
    private WebElement btnJoin;
    @FindBy(xpath = ".//span[@id='error_message_captcha']")
    private WebElement captchaErrorMsg;

    private WebDriver driver = null;

    public MykademySignUp(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void launchApp(){
        driver.get("https://debug.mykademy.com/");
    }
    @Parameters({"signUpUsername","signUpEmail","signUpPhoneNumber","signUpPassword"})
    @Test(priority = 1)
    public void signUpTest(String signUpUsername, String signUpEmail, String signUpPhoneNumber, String signUpPassword) {

        signUp.click();
        signUpUsernameFld.sendKeys(signUpUsername);
        signUpEmailFld.sendKeys(signUpEmail);
        countryCode.click();
        selectCountryCodeFromList.click();
        signUpPhoneNumberFld.sendKeys(signUpPhoneNumber);
        signUpPasswordFld.sendKeys(signUpPassword);
        btnJoin.click();

        String expected_captcha = "Captcha cannot be empty";
        String captchaError = captchaErrorMsg.getText();
        captchaError.trim();

        if(expected_captcha.equals(captchaError)) {
            System.err.println("SignUp page Error check - PASSED");
        }else {
            System.out.println("SignUp page Error check - FAILED");
        }

    }
}
