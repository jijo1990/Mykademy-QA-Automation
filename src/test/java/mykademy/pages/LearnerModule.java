package mykademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LearnerModule {

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






    @Test(priority = 1)
    public void MoveToLearnerModule() throws InterruptedException{

        usersModule.click();
        learnerModule.click();
    }

    @Parameters({})
    @Test (priority = 2, dependsOnMethods = {"MoveToLearnerModule"})
    public void AddLearners(String name, String email, String phone, String password) {
        addUserbtn.click();
        studentName.sendKeys(name);
        studentEmail.sendKeys(email);
        studentPhone.sendKeys(phone);
        studentPassword.sendKeys(password);
        studentInstitute.click();
        instituteSelect.click();
        okBtn.click();
        confirmBoxOkBtn.click();

    }

    @DataProvider(name = "Learner_Details")
    public Object[][] getData(){
        Object [][] data = new Object[2][4];

        data[0][0] = "Jijo Joseph 6902";
        data[1][0] = "Jijo Joseph 6901";

        data[0][1] = "jijo.joseph+6902@mykademy.com";
        data[1][1] = "jijo.joseph+6901@mykademy.com";

        data[0][2] = "08988885479";
        data[1][2] = "08988885477";

        data[0][3] = "Passowrd@123";
        data[1][3] = "Passowrd@123";

        return data;
    }

    @SuppressWarnings("deprecation")
    @Test(priority = 4, dependsOnMethods = "AddLearners")
    public void DeleteAlreadyAddedLearners() throws InterruptedException {

        WebElement search_users = getDriver().findElement(By.id("user_keyword"));
        search_users.sendKeys("Jijo Joseph 6902, Jijo Joseph 6901");

        Thread.sleep(2000);
        WebElement selectall = getDriver().findElement(By.xpath(".//input[@class='user-checkbox-parent']//ancestor::label[text()='select all']"));
        selectall.click();
        getDriver().findElement(By.xpath(".//div[@id='user_bulk']//span[contains(text(),'Bulk Action')]")).click();
        getDriver().findElement(By.xpath(".//div[@id='user_bulk']//following-sibling::a[contains(text(),'Delete')]")).click();
        getDriver().findElement(By.xpath(".//button[@id='advanced_confirm_box_ok']")).click();
        Thread.sleep(300);
//		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		WebDriverWait wait = new WebDriverWait(getDriver(),1000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("advanced_confirm_box_ok")));
        getDriver().findElement(By.id("advanced_confirm_box_ok")).click();

        WebDriverWait wait = new WebDriverWait(getDriver(),2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchclear"))).click();
        Thread.sleep(2000);
    }

    @Test(priority = 5, dependsOnMethods = "MoveToLearnerModule")
    public void UploadLearners() throws InterruptedException {

        getDriver().findElement(By.xpath(".//a[@onclick='importUsers()']")).click();
        WebElement browseFileForUpload = getDriver().findElement(By.id("import_user"));
        browseFileForUpload.sendKeys("C:\\eclipse for java\\File Upload\\learnertemplate.csv");
        getDriver().findElement(By.id("student_institute_upload")).click();
        getDriver().findElement(By.xpath("(.//select[@id='student_institute_upload']//option)[7]")).click();
        getDriver().findElement(By.xpath(".//button[@class='btn btn-green' and contains(text(),'UPLOAD')]")).click();

        Thread.sleep(5000);

//		WebDriverWait wait = new WebDriverWait(getDriver(),6000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(.//div[@id='user_row_wrapper']//following-sibling::input[@class='user-checkbox'])[1]"))).click();
        getDriver().findElement(By.xpath("(.//div[@id='user_row_wrapper']//following-sibling::input[@class='user-checkbox'])[1]")).click();
        getDriver().findElement(By.xpath("(.//div[@id='user_row_wrapper']//following-sibling::input[@class='user-checkbox'])[2]")).click();

        getDriver().findElement(By.xpath(".//div[@id='user_bulk']//span[contains(text(),'Bulk Action')]")).click();
        getDriver().findElement(By.xpath(".//div[@id='user_bulk']//following-sibling::a[contains(text(),'Delete')]")).click();
        getDriver().findElement(By.xpath(".//button[@id='advanced_confirm_box_ok']")).click();
        Thread.sleep(300);
        getDriver().findElement(By.id("advanced_confirm_box_ok")).click();

    }
    @Test(priority = 6, dependsOnMethods = "MoveToLearnerModule")
    public void ExportLearner() {

        getDriver().findElement(By.id("user-export")).click();
        getDriver().findElement(By.xpath(".//input[@class='field-checkbox-parent']")).click();
        getDriver().findElement(By.xpath(".//button[@id='learnerExportMoadalBtn']")).click();

    }

    @Test(priority = 7, dependsOnMethods = "MoveToLearnerModule")
    public void GoToHomePage() {
        getDriver().findElement(By.xpath(".//a[@class='logo']")).click();
    }

    @AfterTest
    public void teaDown() {
        if(getDriver()!=null) {
            getDriver().quit();
        }
    }
}
