package mykademy.tests;


import com.relevantcodes.extentreports.LogStatus;
import mykademy.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class MykademyTestSuite extends TestBase{

	MykademyLogin Mylogin;
	MykademySignUp MySignup;
	LearnerModule MyLearnerModule;
	RoleManagement MyRoleManagement;

	CourseCreationModule MyCourseCreation;


	// this is my code for something

	@BeforeMethod(alwaysRun=true)
	public void  initApp() {
//		driver().get("https://debug.mykademy.com/");
		Mylogin = new MykademyLogin(driver());
		MySignup = new MykademySignUp(driver());
		MyLearnerModule = new LearnerModule(driver());
		MyRoleManagement = new RoleManagement(driver());
		MyCourseCreation = new CourseCreationModule(driver());
	}
	@Test(groups= {"smoke"},dataProvider="getData",priority = 1)
	public void verifySignUpPage(Map<String,String> data) throws Exception {
		MySignup.launchApp();
		try{
			if(MySignup.signUpTest(data.get("signUpUsername"), data.get("signUpEmail"), data.get("signUpPhoneNumber"), data.get("signUpPassword"))){
				log().report(LogStatus.PASS, "SignUpTest", "SignUp page Launched Successful", true);
			}else {
				log().report(LogStatus.FAIL, "SignUp Test", "SignUp page Launch Failed", true);
			}

		} catch (Exception e) {
			log().report(LogStatus.FAIL, "Error", e.getLocalizedMessage());
		}
	}
	@Test(groups= {"smoke"},dataProvider="getData",priority = 2)
	public void verifyLoginCheck(Map<String,String> data) throws InterruptedException {
		Mylogin.launchApp();
		Mylogin.Login_Error_Check();
		try{
			if(Mylogin.Login_Check(data.get("username"), data.get("password"))){
				log().report(LogStatus.PASS, "LoginCheck", "Login page Launched Successful", true);
			}else {
				log().report(LogStatus.FAIL, "LoginCheck", "Login page Launch Failed", true);
			}
		} catch (Exception e) {
			log().report(LogStatus.FAIL, "Error", e.getLocalizedMessage());
		}
//		Mylogin.Login_Error_Check();
//		Mylogin.Login_Check(data.get("username"), data.get("password"));
//		Mylogin.LogOut();
	}
//
//	@Test(groups = {"smoke"},priority = 3)
//	public void moveToLearnerModule() throws InterruptedException {
//		
//		MyLearnerModule.MoveToLearnerModule();
//				
//	}
//	
//	@Test(groups = {"smoke"},priority = 4,dataProvider = "getData")
//	public void verifyLearnerAdd(Map<String,String> data) throws InterruptedException {
//		
//		try{
//			if(MyLearnerModule.AddLearners(data.get("stdName"), data.get("stdEmail"),data.get("stdPhone"),data.get("stdPassword"))){
//				log().report(LogStatus.PASS, "verifyLearnerAdd", "verifyLearnerAdd Successful", true);
//			}else {
//				log().report(LogStatus.FAIL, "verifyLearnerAdd", "verifyLearnerAdd Failed", true);
//			}
//		} catch (Exception e) {
//			log().report(LogStatus.FAIL, "Error", e.getLocalizedMessage());
//		}
//		
//	}
//	@Test(groups = {"smoke"},priority = 5,dataProvider = "getData")
//	public void OtherLearnerModuleOperations(Map<String,String> data) throws InterruptedException {
//		try{
//			if(MyLearnerModule.DeleteAlreadyAddedLearners(data.get("searchUsers"))){
//				log().report(LogStatus.PASS, "OtherLearnerModuleOperations", "OtherLearnerModuleOperations Successful", true);
//			}
//			else {
//				log().report(LogStatus.FAIL, "OtherLearnerModuleOperations", "OtherLearnerModuleOperations Failed", true);
//			}
//		} catch (Exception e) {
//			log().report(LogStatus.FAIL, "Error", e.getLocalizedMessage());
//		}
//		
//		try{
//			if(MyLearnerModule.UploadLearners()){
//				log().report(LogStatus.PASS, "LoginCheck", "Login page Launched Successful", true);
//			}
//			else {
//				log().report(LogStatus.FAIL, "LoginCheck", "Login page Launch Failed", true);
//			}
//		} catch (Exception e) {
//			log().report(LogStatus.FAIL, "Error", e.getLocalizedMessage());
//		}
//
//		try{
//			if(MyLearnerModule.ExportLearner()){
//				log().report(LogStatus.PASS, "LoginCheck", "Login page Launched Successful", true);
//			}
//			else {
//				log().report(LogStatus.FAIL, "LoginCheck", "Login page Launch Failed", true);
//			}
//		} catch (Exception e) {
//			log().report(LogStatus.FAIL, "Error", e.getLocalizedMessage());
//		}
//
//		MyLearnerModule.GoToHomePage();
//
//	}
//	@Test(groups = {"smoke"},priority =6,dataProvider = "getData")
//	public void roleManagementModule(Map<String,String> data) throws InterruptedException {
//		
//		MyRoleManagement.MoveToRoleManagement();
//		
//		try{
//			if(MyRoleManagement.CreateNewRole(data.get("roleName"))){
//				log().report(LogStatus.PASS, "LoginCheck", "Login page Launched Successful", true);
//			}
//			else {
//				log().report(LogStatus.FAIL, "LoginCheck", "Login page Launch Failed", true);
//			}
//		} catch (Exception e) {
//			log().report(LogStatus.FAIL, "Error", e.getLocalizedMessage());
//		}
//
//		try{
//			if(MyRoleManagement.DeleteRole()){
//				log().report(LogStatus.PASS, "LoginCheck", "Login page Launched Successful", true);
//			}
//			else {
//				log().report(LogStatus.FAIL, "LoginCheck", "Login page Launch Failed", true);
//			}
//		} catch (Exception e) {
//			log().report(LogStatus.FAIL, "Error", e.getLocalizedMessage());
//		}
//		
//		try{
//			if(MyRoleManagement.RestoreRole()){
//				log().report(LogStatus.PASS, "LoginCheck", "Login page Launched Successful", true);
//			}
//			else {
//				log().report(LogStatus.FAIL, "LoginCheck", "Login page Launch Failed", true);
//			}
//		} catch (Exception e) {
//			log().report(LogStatus.FAIL, "Error", e.getLocalizedMessage());
//		}
//		
//		MyRoleManagement.GoToHomePage();
//	}
	@Test(groups = {"smoke"}, priority = 7,dataProvider = "getData")
	public void courseCreationModuleFirstSteps(Map<String,String >data) throws InterruptedException {
		
		MyCourseCreation.MoveToProductsModule();
		
		try{
			if(MyCourseCreation.AddCourse(data.get("courseName"),data.get("sectionName"))){
				log().report(LogStatus.PASS, "AddCourse", "AddCourse Successful", true);
			}
			else {
				log().report(LogStatus.FAIL, "AddCourse", "AddCourse Failed", true);
			}
		} catch (Exception e) {
			log().report(LogStatus.FAIL, "Error", e.getLocalizedMessage());
		}
	
	}
//	@Test(groups = {"smoke"},priority = 8,dataProvider = "getData")
//	public void courseCreationModuleOperations(Map<String,String> data) throws InterruptedException {
//		
//		try{
//			if(MyCourseCreation.importFile(data.get("fileName"), data.get("lectureTitle"), data.get("lectureDescription"))){
//				log().report(LogStatus.PASS, "importFile", "importFile Successful", true);
//			}
//			else {
//				log().report(LogStatus.FAIL, "importFile", "importFile Failed", true);
//			}
//		} catch (Exception e) {
//			log().report(LogStatus.FAIL, "Error", e.getLocalizedMessage());
//		}
//		
//	}

//	@Test(groups = {"smoke"},priority = 9,dataProvider = "getData")
//	public void LiveClassCreationOperations(Map<String,String> data) throws InterruptedException {
//		
//		try{
//			if(MyCourseCreation.LiveClassCreation(data.get("liveLectureName"), data.get("liveSessionTag"), data.get("liveSessionAgenda"), data.get("liveSessionDescription"))){
//				log().report(LogStatus.PASS, "LiveClassCreation", "LiveClassCreation Successful", true);
//			}
//			else {
//				log().report(LogStatus.FAIL, "LiveClassCreation", "LiveClassCreation Failed", true);
//			}
//		} catch (Exception e) {
//			log().report(LogStatus.FAIL, "Error", e.getLocalizedMessage());
//		}
//		
//	}
//
//	@Test(groups = {"smoke"},priority = 10,dataProvider = "getData")
//	public void AssessmentCreationOperations(Map<String,String>data) throws InterruptedException {
//		
//		try{
//			if(MyCourseCreation.AssessmentCreation(data.get("assessmentName"),data.get("assessmentDescription"),data.get("totalMarkForAssessment"),data.get("submissionTestMessage"),data.get("passMarkPercentage"),data.get("passMessage"),data.get("failMessage"),data.get("attemptLimitCount"))){
//				log().report(LogStatus.PASS, "LoginCheck", "Login page Launched Successful", true);
//			}
//			else {
//				log().report(LogStatus.FAIL, "LoginCheck", "Login page Launch Failed", true);
//			}
//		} catch (Exception e) {
//			log().report(LogStatus.FAIL, "Error", e.getLocalizedMessage());
//		}
//		
//	}

//	@Test(groups = {"smoke"},priority = 11, dataProvider = "getData")
//	public void AssignmentCreationOperations(Map<String,String>data) throws InterruptedException {
//		
//		try{
//			if(MyCourseCreation.AssignmentCreation(data.get("assignmentName"),data.get("assignmentDescription"),data.get("assignmentTotalMark"),data.get("assignmentWorldLimit"),data.get("resubmissionDateCount"))){
//				log().report(LogStatus.PASS, "LoginCheck", "Login page Launched Successful", true);
//			}
//			else {
//				log().report(LogStatus.FAIL, "LoginCheck", "Login page Launch Failed", true);
//			}
//		} catch (Exception e) {
//			log().report(LogStatus.FAIL, "Error", e.getLocalizedMessage());
//		}
//		
//	}

	@Test(groups = {"smoke"},priority = 12, dataProvider = "getData")
	public void HTMLCreationOperations(Map<String,String>data) throws InterruptedException {
		
		try{
			if(MyCourseCreation.HTMLLecture(data.get("htmlContentTitle"),data.get("htmlContentDescription"))){
				log().report(LogStatus.PASS, "HTMLLecture", "HTMLLecture Successful", true);
			}
			else {
				log().report(LogStatus.FAIL, "HTMLLecture", "HTMLLecture Failed", true);
			}
		} catch (Exception e) {
			log().report(LogStatus.FAIL, "Error", e.getLocalizedMessage());
		}
		
	}
//
//	@Test(groups = {"smoke"},priority = 13, dataProvider = "getData")
//	public void ScormCreationOperations(Map<String,String>data) throws InterruptedException {
//		
//
//		try{
//			if(MyCourseCreation.ScormCreation(data.get("lectureNameFld"),data.get("lectureDescriptionFld"))){
//				log().report(LogStatus.PASS, "LoginCheck", "Login page Launched Successful", true);
//			}
//			else {
//				log().report(LogStatus.FAIL, "LoginCheck", "Login page Launch Failed", true);
//			}
//		} catch (Exception e) {
//			log().report(LogStatus.FAIL, "Error", e.getLocalizedMessage());
//		}
//		
//	}
//
//	@Test(groups = {"smoke"},priority = 14, dataProvider = "getData")
//	public void YouTubeCreationOperations(Map<String,String>data) throws InterruptedException {
//		
//		try{
//			if(MyCourseCreation.YoutubeLecture(data.get("youTubeContentTitle"),data.get("youTubeContentDescription"),data.get("enterYouTubeUrl"))){
//				log().report(LogStatus.PASS, "YoutubeLecture", "YoutubeLecture", true);
//			}
//			else {
//				log().report(LogStatus.FAIL, "YoutubeLecture", "YoutubeLecture", true);
//			}
//		} catch (Exception e) {
//			log().report(LogStatus.FAIL, "Error", e.getLocalizedMessage());
//		}
//		
//	}
//
//	@Test(groups = {"smoke"},priority = 15, dataProvider = "getData")
//	public void SurveyCreationOperations(Map<String,String>data) throws InterruptedException {
//		
//		try{
//			if(MyCourseCreation.SurveyLecture(data.get("surveyContentTitle"),data.get("surveyContentDescription"),data.get("surveyQuestionAdd"))){
//				log().report(LogStatus.PASS, "SurveyLecture", "SurveyLecture Successful", true);
//			}
//			else {
//				log().report(LogStatus.FAIL, "SurveyLecture", "SurveyLecture Failed", true);
//			}
//		} catch (Exception e) {
//			log().report(LogStatus.FAIL, "Error", e.getLocalizedMessage());
//		}
//		
//	}

	@Test(groups = {"smoke"},priority = 16, dataProvider = "getData")
	public void CourseSettingsOperations(Map<String,String>data) throws InterruptedException {
		
		try{
			if(MyCourseCreation.CourseSettings(data.get("courseShortDescription"),data.get("courseDescription"),data.get("courseActualPrice"))){
				log().report(LogStatus.PASS, "CourseSettings", "CourseSettings Successful", true);
			}
			else {
				log().report(LogStatus.FAIL, "CourseSettings", "CourseSettings Failed", true);
			}
		} catch (Exception e) {
			log().report(LogStatus.FAIL, "Error", e.getLocalizedMessage());
		}
		
	}

	@Test(groups = {"smoke"},priority = 17, dataProvider = "getData")
	public void ActivateCourseOperations(Map<String,String>data) throws InterruptedException {
		
		try{
			if(MyCourseCreation.ActivateNewCourse()){
				log().report(LogStatus.PASS, "ActivateCourse", "ActivateCourse Successful", true);
			}
			else {
				log().report(LogStatus.FAIL, "ActivateCourse", "ActivateCourse Failed", true);
			}
		} catch (Exception e) {
			log().report(LogStatus.FAIL, "Error", e.getLocalizedMessage());
		}
		
	}
	
	@Test(groups = {"smoke"},priority = 18, dataProvider = "getData")
	public void DeleteCourseOperations(Map<String,String>data) throws InterruptedException {
		try{
			if(MyCourseCreation.DeleteCourse(data.get("searchCourseName"))){
				log().report(LogStatus.PASS, "DeleteCourse", "DeleteCourse Successful", true);
			}
			else {
				log().report(LogStatus.FAIL, "DeleteCourse", "DeleteCourse Failed", true);
			}
		} catch (Exception e) {
			log().report(LogStatus.FAIL, "Error", e.getLocalizedMessage());
		}
		
	}

}
