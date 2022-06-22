package mykademy.pages;

import core.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class LearnerModule extends DriverFactory {

    @FindBy(xpath = ".//ol[@class='sidebar-menu']//following-sibling::li//span[contains(text(),'Users')]")
    private WebElement usersModule;

    @FindBy(xpath = ".//ol[@class='sidebar-menu']//following-sibling::li//div//ul//li//a[text()='Learners']")
    private  WebElement learnerModule;

    //User Add fields

    @FindBy(id = "add_new_users")
    private WebElement addUserbtn;

    @FindBy(id = "student_name")
    private WebElement studentName;

    @FindBy(id = "student_email")
    private WebElement studentEmail;

    @FindBy(id = "phone_number")
    private WebElement studentPhone;

    @FindBy(id = "student_password")
    private WebElement studentPassword;

    @FindBy(id = "student_institute")
    private WebElement studentInstitute;

    @FindBy(xpath = "(.//select[@id='student_institute']//following-sibling::option)[7]")
    private WebElement instituteSelect;

    @FindBy(xpath = ".//button[@id='create_box_ok']")
    private WebElement okBtn;

    @FindBy(id = "advanced_confirm_box_ok")
    private WebElement confirmBoxOkBtn;

    @FindBy(id = "user_keyword")
    private WebElement searchBarUsers;

    @FindBy(xpath = ".//input[@class='user-checkbox-parent']//ancestor::label[text()='select all']")
    private WebElement selectAllCheckbox;

    @FindBy(xpath = ".//div[@id='user_bulk']//span[contains(text(),'Bulk Action')]")
    private WebElement bulkAction;

    @FindBy(xpath = ".//div[@id='user_bulk']//following-sibling::a[contains(text(),'Delete')]")
    private WebElement delete;

    @FindBy(xpath = ".//button[@id='advanced_confirm_box_ok']")
    private WebElement btnOk;

    @FindBy(xpath = ".//a[@onclick='importUsers()']")
    private WebElement importUsers;

    @FindBy(id = "import_user")
    private WebElement browseFileForUpload;

    @FindBy(id = "student_institute_upload")
    private WebElement instituteSelection;

    @FindBy(xpath = "(.//select[@id='student_institute_upload']//option)[7]")
    private WebElement instituteUpload;

    @FindBy(xpath = ".//button[@class='btn btn-green' and contains(text(),'UPLOAD')]")
    private WebElement uploadLearners;

    @FindBy(xpath = "(.//div[@id='user_row_wrapper']//following-sibling::input[@class='user-checkbox'])")
    private List<WebElement> learnerCheckBoxSelection;

    @FindBy(xpath = ".//div[@id='user_bulk']//span[contains(text(),'Bulk Action')]")
    private WebElement learnerPageBulkActionBtn;

    @FindBy(xpath = ".//div[@id='user_bulk']//following-sibling::a[contains(text(),'Delete')]")
    private WebElement learnerDeleteOption;

    @FindBy(id = "user-export")
    private WebElement btnExportLearner;

    @FindBy(xpath = ".//input[@class='field-checkbox-parent']")
    private WebElement selectAllRequiredField;

    @FindBy(xpath = ".//button[@id='learnerExportMoadalBtn']")
    private WebElement btnExportLearners;

    @FindBy(xpath = ".//a[@class='logo']")
    private WebElement logoIcon;

    public LearnerModule(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @Test(priority = 1)
    public void MoveToLearnerModule() throws InterruptedException{

        usersModule.click();
        learnerModule.click();
    }

    @Parameters({"stdName","stdEmail","stdPhone","stdPassword"})
    @Test (priority = 2, dependsOnMethods = {"MoveToLearnerModule"})
    public void AddLearners(String stdName, String stdEmail, String stdPhone, String stdPassword) {

            addUserbtn.click();
            studentName.sendKeys(stdName);
            studentEmail.sendKeys(stdEmail);
            studentPhone.sendKeys(stdPhone);
            studentPassword.sendKeys(stdPassword);
            studentInstitute.click();
            instituteSelect.click();
            okBtn.click();
            confirmBoxOkBtn.click();

    }

    @SuppressWarnings("deprecation")
    @Parameters({"searchUsers"})
    @Test(priority = 3, dependsOnMethods = "AddLearners")
    public void DeleteAlreadyAddedLearners(String searchUsers) throws InterruptedException {

        searchBarUsers.sendKeys(searchUsers);
        Thread.sleep(2000);
        selectAllCheckbox.click();
        bulkAction.click();
        delete.click();
        btnOk.click();
        Thread.sleep(1000);
        confirmBoxOkBtn.click();
//        Thread.sleep(2000);


    }

    @Test(priority = 5, dependsOnMethods = "MoveToLearnerModule")
    public void UploadLearners() throws InterruptedException {

        importUsers.click();
        browseFileForUpload.sendKeys("C:\\Users\\Enfin\\IJ_Work_Space\\MykademyMavenProject\\Upload Files\\learnertemplate.csv");
        instituteSelection.click();
        instituteUpload.click();
        uploadLearners.click();
        Thread.sleep(8000);
        searchBarUsers.clear();


        for(int i=0;i<2;i++){
            learnerCheckBoxSelection.get(i).click();
        }

        learnerPageBulkActionBtn.click();
        learnerDeleteOption.click();
        btnOk.click();
        Thread.sleep(500);
        confirmBoxOkBtn.click();

    }
    @Test(priority = 6, dependsOnMethods = "MoveToLearnerModule")
    public void ExportLearner() {

        btnExportLearner.click();
        selectAllRequiredField.click();
        btnExportLearners.click();

    }

    @Test(priority = 7, dependsOnMethods = "MoveToLearnerModule")
    public void GoToHomePage() {

        logoIcon.click();
    }
}
