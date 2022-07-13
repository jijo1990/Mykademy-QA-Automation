package mykademy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MykademyLogin {

    @FindBy(xpath = ".//div[@class='form-group text-right']//a[text()='Sign In']")
    private WebElement SignIn_btn;

    @FindBy(xpath = ".//span[@id='email_message_holder']")
    private WebElement username_error;

    @FindBy(xpath = ".//span[@id='password_message_holder']")
    private WebElement password_error;

    @FindBy(xpath = ".//input[@id='login_email']")
    private WebElement usernameField;

    @FindBy(xpath = ".//input[@id='login_password']")
    private WebElement passwordField;

    @FindBy(xpath = ".//div[@class='admin-profile']")
    private WebElement AdminProfileBtn;

    @FindBy(xpath = ".//a[@id='mykademyLogoutButton' and contains(text(),'Logout')]")
    private WebElement LogOut;

    private WebDriver driver;

    public MykademyLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void launchApp(){
        driver.get("https://debug.mykademy.com/");
    }

    @Test(priority = 1) /* (groups = {"regression"}) */
    public boolean Login_Error_Check() {

//		getDriver().findElement(By.xpath(".//li[@class='d-flex align-items-center h-100']//a[text()='SIGN IN']")).click();
        SignIn_btn.click();
        String username_error_new = username_error.getText();
        System.out.println(username_error);
        String password_error_new = password_error.getText();
        String actual_Usernam_Error = "Enter your Email id or Phone number";
        String actual_Password_Error = "Password cannot be empty";

        if(actual_Usernam_Error.equals(username_error_new) && actual_Password_Error.equals(password_error_new)) {
            System.out.println("The Username and Password Error Check - PASSED");
        }else {
            System.out.println("The Username and Password Error Check - FAILED");
        }

        return (username_error.isDisplayed());
    }

    @Parameters({"username", "password"})
    @Test (priority = 2)
    public boolean Login_Check(String username, String password) throws InterruptedException {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        SignIn_btn.click();
        Thread.sleep(500);
        return (AdminProfileBtn.isDisplayed());
    }

}
