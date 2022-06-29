package mykademy.pages;


import core.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RoleManagement extends DriverFactory {

    @FindBy(xpath = ".//ol[@class='sidebar-menu']//following-sibling::li//span[contains(text(),'Users')]")
    private WebElement usersModule;

    @FindBy(xpath = ".//ol[@class='sidebar-menu']//following-sibling::li//div//ul//li//a[text()='Role Management']")
    private  WebElement roleManagementModule;

    @FindBy(xpath = ".//a[@data-target='#create_role' and contains(text(),'CREATE NEW ROLE')]")
    private WebElement createRolebtn;

    @FindBy(id = "role_name")
    private WebElement roleNameFld;

    @FindBy(xpath = ".//button[@id='create_box_ok' and contains(text(),'CREATE')]")
    private WebElement createRolebtnInPopUp;

    @FindBy(xpath = ".//input[@id='view']")
    private WebElement viewCheckbox;

    @FindBy(xpath = ".//input[@id='add']")
    private WebElement addCheckbox;

    @FindBy(xpath = ".//input[@id='edit']")
    private WebElement editCheckbox;

    @FindBy(xpath = ".//input[@id='delete']")
    private WebElement deleteCheckbox;

    @FindBy(xpath = ".//input[@class='access5 module37 all-access-other']")
    private WebElement customCheckbox1;

    @FindBy(xpath = ".//input[@class='access5 module44 all-access-other']")
    private WebElement customCheckbox2;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement submitBtn;

    @FindBy(id = "advanced_confirm_box_ok")
    private WebElement confirmationOkBtn;


    @FindBy(xpath = ".//button[@type='button' and contains(text(),'Back')]")
    private WebElement backBtn;

    @FindBy(xpath = ".//a[@class='text-capitalize' and contains(text(),'New Test Role14')]//ancestor::div[@class='rTableRow']//following-sibling::span[@class='dropdown-tigger']")
    private WebElement roleDropdownArrow;

    @FindBy(xpath = ".//a[@class='text-capitalize' and contains(text(),'New Test Role14')]//ancestor::div[@class='rTableRow']//following-sibling::ul[@class='dropdown-menu pull-right']//a[contains(text(),'Delete')]")
    private WebElement deleteRoleOption;

    @FindBy(xpath = ".//a[@class='text-capitalize' and contains(text(),'New Test Role14')]//ancestor::div[@class='rTableRow']//following-sibling::a[contains(text(),'Restore')]")
    private WebElement restoreRoleOption;

    @FindBy(xpath = ".//a[@class='logo']")
    private WebElement logoIcon;

    public RoleManagement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @Test(priority = 1)
    public void MoveToRoleManagement() {

       usersModule.click();
       roleManagementModule.click();
    }

    @Parameters({"roleName"})
    @Test(priority = 2,dependsOnMethods = "MoveToRoleManagement")
    public String CreateNewRole(String roleName) throws InterruptedException {

        String role = roleName;
        createRolebtn.click();
        roleNameFld.sendKeys(roleName);
        createRolebtnInPopUp.click();
        viewCheckbox.click();
        addCheckbox.click();
        editCheckbox.click();
        deleteCheckbox.click();
        customCheckbox1.click();
        customCheckbox2.click();
        submitBtn.click();
        Thread.sleep(2000);
        confirmationOkBtn.click();
        backBtn.click();
        return role;

    }


    @Test(priority = 4 , dependsOnMethods = "CreateNewRole")
    public void DeleteRole() throws InterruptedException {

        roleDropdownArrow.click();
        deleteRoleOption.click();
        confirmationOkBtn.click();
        Thread.sleep(2000);
        confirmationOkBtn.click();

    }

    @Test(priority = 5, dependsOnMethods = "DeleteRole")
    public void RestoreRole() throws InterruptedException {

        roleDropdownArrow.click();
        restoreRoleOption.click();
        confirmationOkBtn.click();
        Thread.sleep(1000);
        confirmationOkBtn.click();

    }

    @Test(priority = 6, dependsOnMethods = "MoveToRoleManagement")
    public void GoToHomePage() {

        logoIcon.click();
    }
}
