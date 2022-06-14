package mykademy.tests;

import java.awt.*;
import java.util.Map;

import mykademy.pages.MykademyLogin;
import mykademy.pages.MykademySignUp;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MykademyTestSuite extends TestBase{

	MykademyLogin Mylogin;
	MykademySignUp MySignup;

	// this is my code for something

	@BeforeMethod(alwaysRun=true)
	public void  initApp() {
		driver().get("https://debug.mykademy.com/");
		Mylogin = new MykademyLogin(driver());
		MySignup = new MykademySignUp(driver());
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
		System.err.println();
	}

	@Test(groups = {"smoke"},dataProvider = "getData",priority = 3)
	public void verifyLearnerAdd(){

	}
}
