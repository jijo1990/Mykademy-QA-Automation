package mykademy.tests;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import core.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestBase {

	private WebDriver driver;
	private DriverFactory df;
	private TestReporter report;

	@BeforeSuite
	public void initSuite() {
		report =  new TestReporter();
	}
	
	@BeforeClass(alwaysRun=true)
	public void initDriver() {
		df = new DriverFactory();
		driver = df.getDriver(System.getenv("browser"));
	}

	@BeforeMethod
	public void startReport(Method method) {
		report.startReporting(method.getName(), driver);
	}

	@AfterMethod
	public void endReport() {
		report.endReporting();
	}

	@AfterClass(alwaysRun=true)
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}

	@AfterSuite
	public void endSuite() {
		report.flushReport();
	}
	
	public WebDriver driver() {
		return driver;
	}

	public TestReporter log() {
		return report;
	}

	@DataProvider
	public Object[][] getData(Method method){
		String filePath= System.getProperty("user.dir")+"//src//test//data//mykademyData";
		String env =  System.getenv("env");		
		ITestData data = null;
		
		try {
			
			if(System.getenv("datasource").toLowerCase().equals("excel")) {
				data = new ExcelDataProvider(filePath+"//TestData.xlsx",env.toUpperCase());
			}else if(System.getenv("datasource").toLowerCase().equals("json")) {
				data = new JSONDataProvider(filePath+"//"+env.toLowerCase()+"_data.json");
			}
			
			List<Map<String,String>> finalData = data.getAllData(method.getName());
			
			Object[][] dp = new Object[finalData.size()][1];

			for(int i=0;i<finalData.size();i++) {
				dp[i][0] = finalData.get(i);
			}
			
			return dp;
		}catch(Exception e) {
			e.printStackTrace();			
		}
		return null;
	}

}
