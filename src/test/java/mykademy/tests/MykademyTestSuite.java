package mykademy.tests;

import java.util.Map;

import mykademy.pages.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MykademyTestSuite extends TestBase{

	MykademyLogin Mylogin;
	MykademySignUp MySignup;
	LearnerModule MyLearnerModule;
	RoleManagement MyRoleManagement;

	CourseCreationModule MyCourseCreation;


	// this is my code for something

	@BeforeTest(alwaysRun=true)
	public void  initApp() {
//		driver().get("https://debug.mykademy.com/");
		Mylogin = new MykademyLogin(driver());
		MySignup = new MykademySignUp(driver());
		MyLearnerModule = new LearnerModule(driver());
		MyRoleManagement = new RoleManagement(driver());
		MyCourseCreation = new CourseCreationModule(driver());
	}


	@Test(groups= {"smoke"},dataProvider="getData",priority = 1)
	public void verifySignUpPage(Map<String,String>  data) {
		MySignup.launchApp();
		MySignup.signUpTest(data.get("signUpUsername"), data.get("signUpEmail"), data.get("signUpPhoneNumber"), data.get("signUpPassword"));
		System.err.println();
	}

	@Test(groups= {"smoke"},dataProvider="getData",priority = 2)
	public void verifyLoginCheck(Map<String,String> data) throws InterruptedException {
		Mylogin.launchApp();
		Mylogin.Login_Error_Check();
		Mylogin.Login_Check(data.get("username"), data.get("password"));
//		Mylogin.LogOut();
	}

//	@Test(groups = {"smoke"},priority = 3)
//	public void moveToLearnerModule() throws InterruptedException {
//		MyLearnerModule.MoveToLearnerModule();
//	}
//
//	@Test(groups = {"smoke"},priority = 4,dataProvider = "getData")
//	public void verifyLearnerAdd(Map<String,String> data) throws InterruptedException {
//		MyLearnerModule.AddLearners(data.get("stdName"), data.get("stdEmail"),data.get("stdPhone"),data.get("stdPassword"));
//
//	}
//
//	@Test(groups = {"smoke"},priority = 5,dataProvider = "getData")
//	public void OtherLearnerModuleOperations(Map<String,String> data) throws InterruptedException {
//		MyLearnerModule.DeleteAlreadyAddedLearners(data.get("searchUsers"));
//		MyLearnerModule.UploadLearners();
//		MyLearnerModule.ExportLearner();
//		MyLearnerModule.GoToHomePage();
//	}
//
//	@Test(groups = {"smoke"},priority =6,dataProvider = "getData")
//	public void roleManagementModule(Map<String,String> data) throws InterruptedException {
//		MyRoleManagement.MoveToRoleManagement();
//		MyRoleManagement.CreateNewRole(data.get("roleName"));
//		MyRoleManagement.DeleteRole();
//		MyRoleManagement.RestoreRole();
//		MyRoleManagement.GoToHomePage();
//	}

	@Test(groups = {"smoke"}, priority = 7,dataProvider = "getData")
	public void courseCreationModuleFirstSteps(Map<String,String >data) throws InterruptedException {
		MyCourseCreation.MoveToProductsModule();
		MyCourseCreation.AddCourse(data.get("courseName"),data.get("sectionName"));
	}
	@Test(groups = {"smoke"},priority = 8,dataProvider = "getData")
	public void courseCreationModuleOperations(Map<String,String> data) throws InterruptedException {
		MyCourseCreation.importFile(data.get("fileName"), data.get("lectureTitle"), data.get("lectureDescription"));
	}

	@Test(groups = {"smoke"},priority = 9,dataProvider = "getData")
	public void LiveClassCreationOperations(Map<String,String> data) throws InterruptedException {
		MyCourseCreation.LiveClassCreation(data.get("liveLectureName"), data.get("liveSessionTag"), data.get("liveSessionAgenda"), data.get("liveSessionDescription"));
	}

	@Test(groups = {"smoke"},priority = 10,dataProvider = "getData")
	public void AssessmentCreationOperations(Map<String,String>data) throws InterruptedException {
		MyCourseCreation.AssessmentCreation(data.get("assessmentName"),data.get("assessmentDescription"),data.get("totalMarkForAssessment"),data.get("submissionTestMessage"),data.get("passMarkPercentage"),data.get("passMessage"),data.get("failMessage"),data.get("attemptLimitCount"));
	}

	@Test(groups = {"smoke"},priority = 11, dataProvider = "getData")
	public void AssignmentCreationOperations(Map<String,String>data) throws InterruptedException {
		MyCourseCreation.AssignmentCreation(data.get("assignmentName"),data.get("assignmentDescription"),data.get("assignmentTotalMark"),data.get("assignmentWorldLimit"),data.get("resubmissionDateCount"));
	}

	@Test(groups = {"smoke"},priority = 12, dataProvider = "getData")
	public void HTMLCreationOperations(Map<String,String>data) throws InterruptedException {
		MyCourseCreation.HTMLLecture(data.get("htmlContentTitle"),data.get("htmlContentDescription"));
	}

	@Test(groups = {"smoke"},priority = 13, dataProvider = "getData")
	public void ScormCreationOperations(Map<String,String>data) throws InterruptedException {
		MyCourseCreation.ScormCreation(data.get("lectureNameFld"),data.get("lectureDescriptionFld"));
	}

	@Test(groups = {"smoke"},priority = 14, dataProvider = "getData")
	public void YouTubeCreationOperations(Map<String,String>data) throws InterruptedException {
		MyCourseCreation.YoutubeLecture(data.get("youTubeContentTitle"),data.get("youTubeContentDescription"),data.get("enterYouTubeUrl"));
	}

	@Test(groups = {"smoke"},priority = 15, dataProvider = "getData")
	public void SurveyCreationOperations(Map<String,String>data) throws InterruptedException {
		MyCourseCreation.SurveyLecture(data.get("surveyContentTitle"),data.get("surveyContentDescription"),data.get("surveyQuestionAdd"));
	}

	@Test(groups = {"smoke"},priority = 16, dataProvider = "getData")
	public void CourseSettingsOperations(Map<String,String>data) throws InterruptedException {
		MyCourseCreation.CourseSettings(data.get("courseShortDescription"),data.get("courseDescription"),data.get("courseActualPrice"));
	}

	@Test(groups = {"smoke"},priority = 17, dataProvider = "getData")
	public void ActivateCourseOperations(Map<String,String>data) throws InterruptedException {
		MyCourseCreation.ActivateCourse();
	}
	@Test(groups = {"smoke"},priority = 18, dataProvider = "getData")
	public void DeleteCourseOperations(Map<String,String>data) throws InterruptedException {
		MyCourseCreation.DeleteCourse(data.get("searchCourseName"));
	}


}
