package mykademy.pages;

import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.security.SecureRandom;
import java.util.List;

public class CourseCreationModule extends DriverFactory {

    public CourseCreationModule(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    String checkInDate = "10-Aug-2022";

    String live_class_day = checkInDate.split("-")[0];
    String live_class_month = checkInDate.split("-")[1];
    String live_class_year = checkInDate.split("-")[2];

    @FindBy(xpath = ".//ol[@class='sidebar-menu']//following-sibling::li//span[contains(text(),'Products')]")
    private WebElement products;

    @FindBy(xpath = ".//ol[@class='sidebar-menu']//following-sibling::li//div//ul//li//a[@href='https://debug.mykademy.com/admin/course/']")
    private WebElement courses;

    @FindBy(xpath = ".//a[@id='course_create']")
    private WebElement createCourseBtn;

    @FindBy(xpath = ".//input[@id='course_name']")
    private WebElement courseNameFld;

    @FindBy(xpath = ".//button[@type='button' and text()='CREATE']")
    private WebElement createBtn;

    @FindBy(xpath = ".//ol[@class='nav offa-tab custom-sidemenu']//li//a[contains(text(),'BATCHES')]")
    private WebElement moveToBatchPage;

    @FindBy(xpath = ".//a[@class='btn btn-violet' and contains(text(),'ENROLL BATCH')]")
    private WebElement enrollBatchBtn;

    @FindBy(xpath = ".//span[contains(text(),'Automation')]")
    private WebElement selectBatchFromList;

    @FindBy(xpath = ".//a[@id='enroll_user_confirmed' and text()='Enroll Batches']")
    private WebElement enrollBatchToCourseBtn;

    @FindBy(xpath = ".//button[@class='custom-rounded-btn selected' and text()='ADD']")
    private WebElement addBatchConfirmationBtn;

    @FindBy(id = "advanced_confirm_box_ok")
    private WebElement confirmationPopUpOkBtn;

    @FindBy(xpath = ".//ol[@class='nav offa-tab custom-sidemenu']//li//a[contains(text(),'ASSIGN FACILITATOR')]")
    private WebElement moveToFacilitatorPage;

    @FindBy(xpath = ".//a[@id='add-tutor-advanced']")
    private WebElement assignNewFacilitatorBtn;
    @FindBy(xpath = ".//span[text()='Tutor Jijo']/..//input")
    private WebElement selectFacilitatorFromList;

    @FindBy(xpath = ".//button[@class='btn btn-green' and contains(text(),'ASSIGN')]")
    private WebElement assignFacilitatorToCourseBtn;

    @FindBy(xpath = ".//ol[@class='nav offa-tab custom-sidemenu']//li//a[contains(text(),'COURSE CONTENT')]")
    private WebElement moveToCourseContentPage;

    @FindBy(xpath = ".//a[@class='btn btn-blue' and text()='ADD SECTION']")
    private WebElement addSectionBtn;

    @FindBy(id = "section_name_create")
    private WebElement sectionNameFld;

    @FindBy(xpath = ".//button[@id='add_section_save_ok' and text()='CREATE']")
    private WebElement createSectionBtn;

    @FindBy(xpath = ".//input[@id='lecture_file_upload_manual']")
    private WebElement chooseAFileBtn;

    @FindBy(id = "lecture_name")
    private WebElement lectureNameFld;

    @FindBy(xpath = "(.//select[@id='section_id']//option)[2]")
    private WebElement selectSectionFromDropdown;

    @FindBy(xpath = ".//textarea[@id='lecture_description']")
    private WebElement lectureDescriptionFld;

    @FindBy(xpath = ".//button[@id='save_lecture']")
    private WebElement uploadLectureBtn;

    @FindBy(xpath = ".//a[text()='ACTIVATE']")
    private WebElement activateLectureBtn;

    @FindBy(xpath = ".//button[text()='ACTIVATE']")
    private WebElement lectureActivateConfirmBtn;

    @FindBy(xpath = ".//button[@id='back_button']")
    private WebElement backBtnToCourseContentPage;

    @FindBy(xpath = ".//span[@class='lecture-type-holder' and contains(text(),'LIVE')]")
    private WebElement liveClassCreationBtn;

    @FindBy(id = "samba_live_lecture_name")
    private WebElement liveLectureName;

    @FindBy(xpath = "(.//select[@id='section_id_samba_live']//option)[2]")
    private WebElement selectLiveSectionFromDropdown;

    @FindBy(xpath = ".//select[@id='samba_live_course_batches']//option[contains(text(),'Automation')]")
    private WebElement selectBatchForLive;

    @FindBy(xpath = ".//span[@id='liveclass-date_label']")
    private WebElement liveDateSelection;

    @FindBy(xpath = ".//div[@id='ui-datepicker-div']")
    private WebElement liveDatePicker;

    @FindBy(xpath = ".//select[@class='ui-datepicker-month']//option[@selected='selected']")
    private WebElement liveMonth;

    @FindBy(xpath = ".//span[@class='ui-icon ui-icon-circle-triangle-e' and text()='Next']")
    private WebElement nextArrow;

    @FindBy(xpath = ".//a[@class='ui-state-default' and text()='10']")
    private WebElement liveDay;

//    WebElement liveDay = driver.findElement(By.xpath(".//a[@class='ui-state-default' and text()='"+live_class_day+"']"));

    @FindBy(xpath = ".//select[@id='samba_live_hour']//option[@value='10']")
    private WebElement liveHour;

    @FindBy(xpath = ".//select[@id='samba_live_minitutes']//option[@value='30']")
    private WebElement liveMinutes;

    @FindBy(xpath = ".//select[@id='samba_live_period']//option[contains(text(),'AM')]")
    private WebElement liveTimePeriod;

    @FindBy(xpath = ".//button[@id='schedule-btn']")
    private WebElement scheduleLiveBtn;

    @FindBy(xpath = ".//input[@class='custom-input form-control' and @placeholder='Sample tag']")
    private WebElement liveSessionTag;

    @FindBy(xpath = ".//textarea[@name='agenda']")
    private WebElement liveSessionAgenda;

    @FindBy(xpath = ".//textarea[@name='description']")
    private WebElement liveSessionDescription;

    @FindBy(xpath = ".//select[@id='ll_integration']//option[contains(text(),'Mykademy Live')]")
    private WebElement liveClassIntegration;

    @FindBy(xpath = ".//select[@id='ll_room_id']//option[contains(text(),'Room 12')]")
    private WebElement liveClassRoom;

    @FindBy(xpath = ".//button[@id='showAddLearnersPage']")
    private WebElement nextBtnInLiveClassCreation;

    @FindBy(xpath = ".//input[@id='add-speaker']")
    private WebElement addSpeakers;

    @FindBy(xpath = ".//ul[@id='add-speakerautocomplete-list']//following-sibling::li//span[contains(text(),'jijo.joseph+1@mykademy.com')]//following-sibling::span[contains(text(),'Add')]")
    private WebElement selectSpeakerFromList;

    @FindBy(xpath = ".//button[@id='create-live-submit-button']")
    private WebElement scheduleLiveClassBtn;

    @FindBy(xpath = ".//div[@id='closesuccesspopup']")
    private WebElement liveSuccessPopUpClose;

    //Assessment Creation

    @FindBy(xpath = ".//span[@class='lecture-type-holder' and contains(text(),'Test')]")
    private WebElement selectAssessmentCreationBtn;

    @FindBy(id = "assesment_name")
    private WebElement assessmentName;

    @FindBy(xpath = "(.//select[@id='section_id_assesment']//option)[2]")
    private WebElement selectAssessmentSectionFromDropdown;

    @FindBy(xpath = ".//textarea[@id='assesment_description']")
    private WebElement assessmentDescription;

    @FindBy(xpath = ".//a[@id='createAssesmentConfirmed']")
    private WebElement assessmentCreateBtn;

//    STEP1

    @FindBy(id = "test_mark")
    private WebElement totalMarkForAssessment;

    @FindBy(xpath = ".//input[@id='lecture_logo_btn']")
    private WebElement assessmentImageUpload;

    @FindBy(xpath = ".//div[@data-id='upload_lecture_image']")
    private WebElement cropImage;

    @FindBy(xpath = ".//button[@id='saveNext_button']")
    private WebElement saveAndNextBtn;

//    STEP2

    @FindBy(xpath = ".//a[@class='btn full-width-btn import-quespool-btn']")
    private WebElement importFromQuestionPoolBtn;

    @FindBy(xpath = ".//div[@id='generate_test_wrapper']//following-sibling::div//input")
    private List<WebElement> selectQuestionsFromPoolCheckbox;

    @FindBy(xpath = ".//a[@id='import_question_confirmed']")
    private WebElement importQuestionToAssessmentBtn;

//    STEP3

    @FindBy(xpath = ".//input[@id='test_question_grouping']")
    private WebElement groupQuestionsubjectWiseCheckbox;

    @FindBy(xpath = ".//input[@id='test_question_shuffling']")
    private WebElement shuffleQuestionsCheckbox;

    @FindBy(xpath = ".//input[@id='test_question_navigate']")
    private WebElement restrictUserNavigationCheckbox;

    @FindBy(xpath = ".//input[@id='test_attend_all']")
    private WebElement mandatoryToAttendAllQuestionsCheckbox;

    @FindBy(xpath = ".//input[@id='test_submit_response']")
    private WebElement showMsgAfterTestSubmissionCheckbox;

    @FindBy(xpath = ".//textarea[@id='test_submit_message']")
    private WebElement submissionTestMessage;

    @FindBy(xpath = ".//input[@id='test_show_mark']")
    private WebElement showMarkForEachQuestions;

    @FindBy(xpath = ".//input[@id='test_has_passfail']")
    private WebElement setTestPassMarkCheckbox;

    @FindBy(xpath = ".//input[@id='test_pass_percentage']")
    private WebElement passMarkPercentage;

    @FindBy(xpath = ".//input[@id='test_passfail_response']")
    private WebElement passFailResponseCheckbox;

    @FindBy(xpath = ".//textarea[@id='test_pass_message']")
    private WebElement passMessage;

    @FindBy(xpath = ".//textarea[@id='test_fail_message']")
    private WebElement failMessage;

    @FindBy(xpath = ".//input[@id='test_que_report']")
    private WebElement showAnsAndExplanationsCheckbox;

    @FindBy(xpath = ".//input[@id='test_right_report']")
    private WebElement hideRightAnsAndExplOfWrongAnsCheckbox;

//    STEP4

    @FindBy(xpath = ".//input[@name='cl_limited' and @value='1']")
    private WebElement numberOfAttemptsLimit;

    @FindBy(xpath = ".//input[@name='cl_limited_access']")
    private WebElement attemptLimitCount;

    @FindBy(xpath = ".//button[@id='save_button' and @value='SAVE']")
    private WebElement saveAssessmentBtn;

//    AssignmentCreation

    @FindBy(xpath = ".//span[@class='lecture-type-holder' and contains(text(),'Assignment')]")
    private WebElement assignmentCreationBtn;

    @FindBy(xpath = ".//input[@id='descriptive_test_name']")
    private WebElement assignmentName;

    @FindBy(xpath = "(.//select[@id='section_id_descriptive']//option)[2]")
    private WebElement assignmentSectionSelection;

    @FindBy(xpath = ".//textarea[@id='descriptive_description']")
    private WebElement assignmentDescription;

    @FindBy(xpath = ".//input[@id='total_mark']")
    private WebElement assignmentTotalMark;

    @FindBy(xpath = ".//input[@id='descriptive_words_limit']")
    private WebElement assignmentWorldLimit;

    @FindBy(xpath = ".//span[@id='descriptive_submission_date_label']")
    private WebElement assignmentSubmissionDateLabel;

    @FindBy(xpath = ".//div[@id='ui-datepicker-div']")
    private WebElement assignmentDatePicker;

    @FindBy(xpath = ".//a[@id='createDescriptiveTest']")
    private WebElement createAssessmentBtn;

    @FindBy(xpath = ".//input[@id='resubmission_check']")
    private WebElement submissionDueDateCheckbox;

    @FindBy(xpath = ".//input[@id='resubmission_no']")
    private WebElement resubmissionDateCount;

    @FindBy(xpath = "(.//button[@class='btn btn-green' and contains(text(),'SAVE')])[1]")
    private WebElement saveBasicSettingsBtn;

    @FindBy(xpath = ".//a[@class='btn btn-green' and contains(text(),'ACTIVATE')]")
    private WebElement activateCurriculumBtn;

    @FindBy(xpath = ".//button[@class='custom-rounded-btn selected lc-launch']")
    private WebElement confirmActiveBtn;

//    HTML Content Creation

    @FindBy(xpath = ".//span[@class='lecture-type-holder' and contains(text(),'HTML')]")
    private WebElement htmlCreationBtn;

    @FindBy(xpath = ".//input[@id='html_name']")
    private WebElement htmlContentTitle;

    @FindBy(xpath = "(.//select[@id='section_id_html']//option)[2]")
    private WebElement selectHtmlSectionFromDropdown;

    @FindBy(xpath = ".//textarea[@id='html_description']")
    private WebElement htmlContentDescription;

    @FindBy(xpath = ".//button[@id='createHtmlConfirmed']")
    private WebElement createHtmlBtn;

    @FindBy(xpath = ".//i[@class='re-icon-image']")
    private WebElement imageSelectionIcon;

    @FindBy(xpath = ".//input[@type='file' and @multiple='multiple']")
    private WebElement imageUploadArea;

    @FindBy(xpath = ".//button[@class='btn btn-green float-r1']")
    private WebElement saveUploadedImageInHtml;

//    ScormContentCreation

    @FindBy(xpath = ".//input[@id='lecture_file_upload_scrom']")
    private WebElement scormContentCreationBtn;

    @FindBy(xpath = ".//span[text()='Automation Scorm Lecture']")
    private WebElement selectScormFromCourseContentList;

//    YouTube Lecture

    @FindBy(xpath = ".//span[@class='lecture-type-holder' and contains(text(),'Youtube / Vimeo')]")
    private WebElement youTubeContentCreationBtn;

    @FindBy(xpath = ".//input[@id='youtube_name']")
    private WebElement youTubeContentTitle;

    @FindBy(xpath = "(.//select[@id='section_id_youtube'])//option[2]")
    private WebElement selectYouTubeSectionFormDropdown;

    @FindBy(xpath = ".//textarea[@id='youtube_description']")
    private WebElement youTubeContentDescription;

    @FindBy(xpath = ".//input[@id='youtube_url']")
    private WebElement enterYouTubeUrl;

    @FindBy(xpath = ".//button[@id='create_btn']")
    private WebElement createYouTubeLectureBtn;

//    Survey Lecture Creation

    @FindBy(xpath = ".//span[@class='lecture-type-holder' and contains(text(),'Survey')]")
    private WebElement surveyContentCreationBtn;

    @FindBy(xpath = ".//input[@id='survey_name']")
    private WebElement surveyContentTitle;

    @FindBy(xpath = "(.//select[@id='section_id_survey']//option)[2]")
    private WebElement selectSurveyOptionsFromDropdown;

    @FindBy(xpath = ".//textarea[@id='survey_description']")
    private WebElement surveyContentDescription;

    @FindBy(xpath = ".//a[@id='createSurveyConfirmed']")
    private WebElement surveyCreateBtn;

    @FindBy(xpath = ".//button[@id='add_question']")
    private WebElement addSurveyQuestionBtn;

    @FindBy(xpath = ".//textarea[@id='question_0']")
    private WebElement surveyQuestionAdd;

    @FindBy(xpath = ".//button[@id='add_option_btn_0']")
    private WebElement addOptionsForTheSurvey;

    @FindBy(xpath = ".//input[@name='lecture_name' and @placeholder='eg: Option 1' or @placeholder='eg:Option 1' ]")
    private List<WebElement> surveyOptions;

    @FindBy(xpath = ".//button[@class='btn btn-success']")
    private WebElement saveSurveyBtn;

    @FindBy(xpath = ".//input[@id='survey_tutor']")
    private WebElement tutorSurveyOptionSelection;

    @FindBy(xpath = ".//select[@id='survey_tutor_list']//option[contains(text(),'Tutor Jijo')]")
    private WebElement selectTutorFromTheList;

//    CourseSettingsPage

    @FindBy(xpath = ".//a[@class='btn btn-red lecture-back-btn']//i[@class='icon icon-left']")
    private WebElement backButtonFromCourseContentPage;

    @FindBy(xpath = ".//a[text()='Settings']")
    private WebElement selectCourseSettingsPage;

    @FindBy(xpath = ".//input[@id='site_logo_btn']")
    private WebElement courseLogoImageUploadBtn;

    @FindBy(xpath = ".//div[@id='crop_image_save']")
    private WebElement cropImageForCourse;

    @FindBy(xpath = "(.//button[@title='None selected'])[1]")
    private WebElement selectCourseCategoryDropdown;

    @FindBy(xpath = "((.//button[@title='None selected'])[1]//following-sibling::ul//label//input)[2]")
    private WebElement courseCategorySelectionFromDropDown;

    @FindBy(xpath = ".//button[@title='Care Services']")
    private WebElement selectedCourseCategoryClick;

    @FindBy(xpath = ".//button[@title='US English']")
    private WebElement selectedCourseLanguage;

    @FindBy(xpath = ".//textarea[@id='cb_short_description']")
    private WebElement courseShortDescription;

    @FindBy(xpath = ".//a[text()='Course Description * :']")
    private WebElement courseDescriptionOptionSelect;

    @FindBy(xpath = ".//div[@role='presentation']")
    private WebElement courseDescription;

    @FindBy(xpath = ".//a[text()='Course Short Description * :']")
    private WebElement shortDescriptionSelectFromCD;

    @FindBy(xpath = ".//input[@id='b2benabled']")
    private WebElement enableB2BSale;

    @FindBy(xpath = ".//button[@class='btn btn-green' and contains(text(),'OK')]")
    private WebElement confirmationOKBtn;

    @FindBy(xpath = ".//input[@id='cb_price']")
    private WebElement courseActualPrice;

    @FindBy(xpath = ".//a[@id='course_savenext_button']")
    private WebElement saveAndNextBtnInCourseSettings;

    @FindBy(xpath = ".//select[@id='cb_app_price']//option[contains(text(),'Free')]")
    private WebElement appStorePrice;

//    ActivateCourse

    @FindBy(xpath = "(.//span[@class='dropdown-tigger'])[2]")
    private WebElement selectDropdownOfSection;

    @FindBy(xpath = "(.//span[@class='dropdown-tigger'])[2]//following-sibling::ul//a[contains(text(),'Activate all')]")
    private WebElement selectActivateAllOption;

    @FindBy(xpath = "(.//span[@class='dropdown-tigger']//i[@class='icon icon-down-arrow'])[1]")
    private WebElement courseActivateOptionOfCourseContent;

    @FindBy(xpath = ".//button[@class='btn custom-rounded-btn selected lc-launch' and contains(text(),'Activate')]")
    private WebElement confirmationActivateBtnInPopup;

    @FindBy(xpath = "(.//a[@href='https://debug.mykademy.com/admin/course/'])[2]")
    private WebElement selectCourseFromBreadcrumbs;

//    DeleteCourse

    @FindBy(xpath = ".//input[@id='course_keyword']")
    private WebElement searchCourseName;

    @FindBy(xpath = ".//i[@class='icon icon-down-arrow']")
    private WebElement selectCourseDropdownForAction;

    @FindBy(xpath = ".//a[text()='Delete']")
    private WebElement selectDeleteOptionFromDropdown;


    @Test()
    public void MoveToProductsModule() {

        products.click();
        courses.click();
    }
    @Parameters({"courseName","sectionName"})
    @Test()
    public void AddCourse(String courseName, String sectionName) throws InterruptedException {

        createCourseBtn.click();
        courseNameFld.sendKeys(courseName);
        createBtn.click();
        //Add Batches

        moveToBatchPage.click();
        enrollBatchBtn.click();
        selectBatchFromList.click();
        enrollBatchToCourseBtn.click();
        addBatchConfirmationBtn.click();
        Thread.sleep(1000);
        confirmationPopUpOkBtn.click();

        //Assign Facilitator
        moveToFacilitatorPage.click();
        assignNewFacilitatorBtn.click();
        selectFacilitatorFromList.click();
        assignFacilitatorToCourseBtn.click();

        // Create Course
        moveToCourseContentPage.click();
        addSectionBtn.click();
        sectionNameFld.sendKeys(sectionName);
        createSectionBtn.click();

    }

    @Parameters({"fileName","lectureTitle","lectureDescription"})
    @Test()
    public void importFile(String fileName, String lectureTitle, String lectureDescription) throws InterruptedException {

        chooseAFileBtn.sendKeys("C:\\Users\\Enfin\\IJ_Work_Space\\MykademyMavenProject\\SupportingDocumentFiles" + fileName + "");
        lectureNameFld.sendKeys(lectureTitle);
        selectSectionFromDropdown.click();
        lectureDescriptionFld.sendKeys(lectureDescription);
        uploadLectureBtn.click();
        activateLectureBtn.click();
        lectureActivateConfirmBtn.click();
        confirmationPopUpOkBtn.click();
        backBtnToCourseContentPage.click();
        Thread.sleep(3000);

    }
    @Parameters({"liveLectureName","liveSessionTag","liveSessionAgenda","liveSessionDescription"})
    @Test()
    public void LiveClassCreation(String liveLectureNameFLd, String liveSessionTagFld, String liveSessionAgendaFld, String liveSessionDescriptionFld) throws InterruptedException {

        liveClassCreationBtn.click();
        liveLectureName.sendKeys(liveLectureNameFLd);
        Thread.sleep(500);
        selectLiveSectionFromDropdown.click();
        selectBatchForLive.click();
        liveDateSelection.click();

        if (liveDatePicker.isDisplayed()) {

            String liveMonthName = liveMonth.getText().trim();
            while (!liveMonthName.equals(live_class_month)){
                nextArrow.click();
                liveMonthName = liveMonth.getText().trim();
            }

            liveDay.click();
        }

        liveHour.click();
        liveMinutes.click();
        liveTimePeriod.click();
        scheduleLiveBtn.click();

        // Live Class Next Page

        liveSessionTag.sendKeys(liveSessionTagFld);
        liveSessionAgenda.sendKeys(liveSessionAgendaFld);
        liveSessionDescription.sendKeys(liveSessionDescriptionFld);
        liveClassIntegration.click();
        liveClassRoom.click();
        nextBtnInLiveClassCreation.click();
        addSpeakers.click();
        selectSpeakerFromList.click();
        scheduleLiveClassBtn.click();
        liveSuccessPopUpClose.click();
        driver.navigate().back();
        Thread.sleep(500);
        driver.navigate().back();

    }

    @Parameters({"assessmentName","assessmentDescription","totalMarkForAssessment","submissionTestMessage","passMarkPercentage","passMessage","failMessage","attemptLimitCount"})
    @Test()
    public void AssessmentCreation(String assessmentNameFld, String assessmentDescriptionFld, String totalMarkForAssessmentFld, String submissionTestMessageFld, String passMarkPercentageFld, String passMessageFld, String failMessageFld, String attemptLimitCountFld) throws InterruptedException {

        selectAssessmentCreationBtn.click();
        assessmentName.sendKeys(assessmentNameFld);
        selectAssessmentSectionFromDropdown.click();
        assessmentDescription.sendKeys(assessmentDescriptionFld);
        assessmentCreateBtn.click();

        // STEP1

        totalMarkForAssessment.sendKeys(totalMarkForAssessmentFld);
//        assessmentImageUpload.sendKeys("C:\\Users\\Enfin\\IJ_Work_Space\\MykademyMavenProject\\SupportingDocumentFilesJPG.jpg");
//        cropImage.click();
        saveAndNextBtn.click();
        confirmationPopUpOkBtn.click();

        // STEP2

        importFromQuestionPoolBtn.click();
        for(int i=0;i<5;i++){
            selectQuestionsFromPoolCheckbox.get(i).click();
        }
        importQuestionToAssessmentBtn.click();
        Thread.sleep(1000);
        confirmationPopUpOkBtn.click();
        saveAndNextBtn.click();
        Thread.sleep(6000);

        // STEP3

        groupQuestionsubjectWiseCheckbox.click();
        shuffleQuestionsCheckbox.click();
        restrictUserNavigationCheckbox.click();
        mandatoryToAttendAllQuestionsCheckbox.click();
        showMsgAfterTestSubmissionCheckbox.click();
        submissionTestMessage.sendKeys(submissionTestMessageFld);
        showMarkForEachQuestions.click();
        setTestPassMarkCheckbox.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        passMarkPercentage.clear();
        passMarkPercentage.sendKeys(passMarkPercentageFld);
        passFailResponseCheckbox.click();
        js.executeScript("window.scrollBy(0,250)", "");
        passMessage.sendKeys(passMessageFld);
        failMessage.sendKeys(failMessageFld);
        showAnsAndExplanationsCheckbox.click();
        hideRightAnsAndExplOfWrongAnsCheckbox.click();
        saveAndNextBtn.click();
        Thread.sleep(6000);

        // STEP4

        numberOfAttemptsLimit.click();
        attemptLimitCount.sendKeys(attemptLimitCountFld);
        saveAssessmentBtn.click();
        backBtnToCourseContentPage.click();

    }

    @Parameters({"assignmentName", "assignmentDescription", "assignmentTotalMark", "assignmentWorldLimit", "resubmissionDateCount"})
    @Test()
    public void AssignmentCreation(String assignmentNameFld, String assignmentDescriptionFld, String assignmentTotalMarkFld, String assignmentWorldLimitFld, String resubmissionDateCountFld) throws InterruptedException {

        assignmentCreationBtn.click();
        assignmentName.sendKeys(assignmentNameFld);
        assignmentSectionSelection.click();
        assignmentDescription.sendKeys(assignmentDescriptionFld);
        assignmentTotalMark.sendKeys(assignmentTotalMarkFld);
        assignmentWorldLimit.sendKeys(assignmentWorldLimitFld);
        assignmentSubmissionDateLabel.click();

        if(assignmentDatePicker.isDisplayed()){

            String liveMonthName = liveMonth.getText().trim();
            while (!liveMonthName.equals(live_class_month)) {
                nextArrow.click();
                liveMonthName = liveMonth.getText().trim();
            }
            liveDay.click();
        }

        Thread.sleep(1000);
        createAssessmentBtn.click();
        submissionDueDateCheckbox.click();
        resubmissionDateCount.clear();
        resubmissionDateCount.sendKeys(resubmissionDateCountFld);
        saveBasicSettingsBtn.click();
        confirmationPopUpOkBtn.click();

        activateCurriculumBtn.click();
        confirmActiveBtn.click();
        confirmationPopUpOkBtn.click();
        backBtnToCourseContentPage.click();
        Thread.sleep(2000);

    }

    @Parameters({"htmlContentTitle","htmlContentDescription"})
    @Test()
    public void HTMLLecture(String htmlContentTitleFld, String htmlContentDescriptionFld) throws InterruptedException {

        htmlCreationBtn.click();
        htmlContentTitle.sendKeys(htmlContentTitleFld);
        selectHtmlSectionFromDropdown.click();
        htmlContentDescription.sendKeys(htmlContentDescriptionFld);
        createHtmlBtn.click();
        imageSelectionIcon.click();
        imageUploadArea.sendKeys("C:\\Users\\Enfin\\IJ_Work_Space\\MykademyMavenProject\\SupportingDocumentFiles\\JPG.jpg");
        saveUploadedImageInHtml.click();
        confirmationPopUpOkBtn.click();
        activateCurriculumBtn.click();
        confirmActiveBtn.click();
        confirmationPopUpOkBtn.click();
        backBtnToCourseContentPage.click();

    }

    @Parameters({"lectureNameFld","lectureDescriptionFld"})
    @Test()
    public void ScormCreation(String lectureName, String lectureDescription) throws InterruptedException {

        scormContentCreationBtn.sendKeys("C:\\Users\\Enfin\\IJ_Work_Space\\MykademyMavenProject\\SupportingDocumentFiles\\SL360_LMS_SCORM_2004.zip");
        lectureNameFld.sendKeys(lectureName);
        selectSectionFromDropdown.click();
        lectureDescriptionFld.sendKeys(lectureDescription);
        uploadLectureBtn.click();
        Thread.sleep(20000);
        backBtnToCourseContentPage.click();
        selectScormFromCourseContentList.click();
        activateCurriculumBtn.click();
        confirmActiveBtn.click();
        confirmationPopUpOkBtn.click();
        backBtnToCourseContentPage.click();

    }

    @Parameters({"youTubeContentTitle","youTubeContentDescription", "enterYouTubeUrl"})
    @Test()
    public void YoutubeLecture(String youTubeContentTitleFld, String youTubeContentDescriptionFld, String enterYouTubeUrlFld) throws InterruptedException {

        youTubeContentCreationBtn.click();
        youTubeContentTitle.sendKeys(youTubeContentTitleFld);
        selectYouTubeSectionFormDropdown.click();
        youTubeContentDescription.sendKeys(youTubeContentDescriptionFld);
        enterYouTubeUrl.sendKeys(enterYouTubeUrlFld);
        createYouTubeLectureBtn.click();
        activateCurriculumBtn.click();
        confirmActiveBtn.click();
        confirmationPopUpOkBtn.click();
        backBtnToCourseContentPage.click();

    }

    @Parameters({"surveyContentTitle", "surveyContentDescription", "surveyQuestionAdd"})
    @Test()
    public void SurveyLecture(String surveyContentTitleFld, String surveyContentDescriptionFld, String surveyQuestionAddFld) throws InterruptedException {

        surveyContentCreationBtn.click();
        surveyContentTitle.sendKeys(surveyContentTitleFld);
        selectSurveyOptionsFromDropdown.click();
        surveyContentDescription.sendKeys(surveyContentDescriptionFld);
        surveyCreateBtn.click();

        // Add Questions to Survey

        addSurveyQuestionBtn.click();
        surveyQuestionAdd.sendKeys(surveyQuestionAddFld);

        for(int i=0;i<2;i++){
            addOptionsForTheSurvey.click();
        }

      int number=1;
        for(WebElement option : surveyOptions){

            String num = Integer.toString(number);
            option.sendKeys(num);
            number++;
        }
        saveSurveyBtn.click();
        activateCurriculumBtn.click();
        confirmActiveBtn.click();
        confirmationPopUpOkBtn.click();
        backBtnToCourseContentPage.click();

        surveyContentCreationBtn.click();
        surveyContentTitle.sendKeys(surveyContentTitleFld);
        selectSurveyOptionsFromDropdown.click();
        tutorSurveyOptionSelection.click();
        selectTutorFromTheList.click();
        surveyContentDescription.sendKeys(surveyContentDescriptionFld);
        surveyCreateBtn.click();
        addSurveyQuestionBtn.click();
        surveyQuestionAdd.sendKeys(surveyQuestionAddFld);

        for (int i=0;i<=2;i++){
            addOptionsForTheSurvey.click();
        }

        int fac_number = 1;
        for (WebElement option : surveyOptions) {

            String num = Integer.toString(fac_number);

            option.sendKeys(num);
            fac_number++;
        }
        saveSurveyBtn.click();
        activateCurriculumBtn.click();
        confirmActiveBtn.click();
        confirmationPopUpOkBtn.click();
        backBtnToCourseContentPage.click();

    }

    @Parameters({"courseShortDescription","courseDescription","courseActualPrice"})
    @Test()
    public void CourseSettings(String courseShortDescriptionFld, String courseDescriptionFld, String courseActualPriceFld) throws InterruptedException {

        backButtonFromCourseContentPage.click();
        selectCourseSettingsPage.click();
        Actions action = new Actions(driver);
        action.moveToElement(courseLogoImageUploadBtn).perform();
        courseLogoImageUploadBtn.sendKeys("C:\\Users\\Enfin\\IJ_Work_Space\\MykademyMavenProject\\SupportingDocumentFiles\\JPG.jpg");
        Thread.sleep(500);
        cropImageForCourse.click();
        selectCourseCategoryDropdown.click();
        courseCategorySelectionFromDropDown.click();
        selectedCourseCategoryClick.click();
        Thread.sleep(500);

        selectCourseCategoryDropdown.click();
        courseCategorySelectionFromDropDown.click();
        selectedCourseLanguage.click();
        Thread.sleep(500);

        // scroll window down

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        courseShortDescription.sendKeys(courseShortDescriptionFld);
        courseDescriptionOptionSelect.click();
        courseDescription.sendKeys(courseDescriptionFld);
        shortDescriptionSelectFromCD.click();
        enableB2BSale.click();
        confirmationOKBtn.click();
        courseActualPrice.clear();
        courseActualPrice.sendKeys(courseActualPriceFld);
        appStorePrice.click();
        saveAndNextBtnInCourseSettings.click();
        confirmationPopUpOkBtn.click();

    }

    @Test()
    public void ActivateCourse() throws InterruptedException {

        moveToCourseContentPage.click();
        selectDropdownOfSection.click();
        confirmationPopUpOkBtn.click();
        confirmationPopUpOkBtn.click();
        courseActivateOptionOfCourseContent.click();
        activateLectureBtn.click();
        confirmationActivateBtnInPopup.click();
        confirmationPopUpOkBtn.click();
        backButtonFromCourseContentPage.click();
        selectCourseFromBreadcrumbs.click();

    }

    @Parameters({"searchCourseName"})
    @Test()
    public void DeleteCourse(String searchCourseNameFld) throws InterruptedException {

        searchCourseName.sendKeys(searchCourseNameFld);
        Thread.sleep(1000);

        selectCourseDropdownForAction.click();
        selectDeleteOptionFromDropdown.click();
        confirmationPopUpOkBtn.click();
        confirmationPopUpOkBtn.click();

    }

}
