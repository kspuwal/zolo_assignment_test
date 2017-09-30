package com.zolo_tests;

import com.zolotest.Pages.*;
import com.zolotest.genericLib.CsvUtils;
import com.zolotest.genericLib.LaunchZolo;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sun.util.resources.cldr.ga.LocaleNames_ga;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kuldeep on 23-09-2017.
 */
public class Part1Test {

    LaunchZolo launchZolo;
    HomePage homePage;
    LoginPage loginPage;
    UserPage userPage;
    FilterResultPage filterResultPage;
    PropertyDetailsPage propertyDetailsPage;
    ScheduleVisitPage scheduleVisitPage;
    ConfirmationVisitPage confirmationVisitPage;

    WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {

       // String loginUrl = "http://52.201.90.154:9002/";
        //String loginUrl = "http://52.201.90.154:9002/pgs/search/undefined?latitude=12.8441489&longitude=77.67938129999993&text=Electronic%20City%20Phase%20II,%20Bengaluru,%20Karnataka,%20India&gender=";
        //String loginUrl = "http://52.201.90.154:9002/pgs//Electronic%20City/men/Zolo-Green-Garden-55a3b8ec7a6f6c4b8ca10000?lat=12.8441489&lng=77.67938129999993";
        String loginUrl = "http://52.201.90.154:9002/visits/new/0?centerId=55a3b8ec7a6f6c4b8ca10000";
        String browser = "chrome";
        //String browser = "firefox";
        String browserType = "webdriver." + browser + ".driver";
        if (browser == "firefox") {
            browserType = "webdriver.gecko.driver";
            browser = "gecko";
        }
        System.setProperty(browserType, "./src/main/resources/" + browser + "driver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        System.out.println("Launching " + browser + " Browser with url : " + loginUrl);
        driver.get(loginUrl);
       // HomePage homePage = new HomePage(driver);
       // homePage.clickOnLoginTab();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToZolo("7777777017","123456");
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        // Get test cases from csv
       Object[][] testCases = CsvUtils.getTestData(System.getProperty("user.dir")
                +"/src/test/java/com/zolo_tests/Part1Test.csv");
        return testCases;
    }

    @Test(dataProvider = "getData")
    public void part1Test(String testDesc,String searchText, String selectOption, String budget, String sharingPref, String pgType, String propertyName) throws InterruptedException {
        System.out.println("\t"+testDesc);
/*        String expectedPropertyName = selectOption;
        userPage = new UserPage(driver);
        userPage.selectOptionFromAutoSuggested(searchText,selectOption);
        filterResultPage = new FilterResultPage(driver);
        filterResultPage.setSelectBudget(budget);
        filterResultPage.setSelectSharingPref(sharingPref);
        filterResultPage.setSelectPgType(pgType);
        filterResultPage.clickOnApplyFilter();
        filterResultPage.selectProperties(propertyName);

        propertyDetailsPage = new PropertyDetailsPage(driver);
        propertyDetailsPage.verifyPropertiesDetails(propertyName);
        propertyDetailsPage.clickOnScheduleVisit();*/

        scheduleVisitPage = new ScheduleVisitPage(driver);
        scheduleVisitPage.verifyPropertiesDetailsOnScheduleVisit(propertyName);
        scheduleVisitPage.setVisitDate("27-09-2017");
        scheduleVisitPage.setVisitTime("5 pm - 6 pm");
        scheduleVisitPage.clickOnScheduleVisitButton();

        confirmationVisitPage = new ConfirmationVisitPage(driver);
        confirmationVisitPage.getAllConfirmationDetails();









    }
}
