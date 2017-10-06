package com.zolo_tests;

import com.zolotest.Pages.*;
import com.zolotest.genericLib.CsvUtils;
import com.zolotest.genericLib.LaunchZolo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Part2Test {

    HomePage homePage;
    LoginPage loginPage;
    UserPage userPage;
    FilterResultPage filterResultPage;
    PropertyDetailsPage propertyDetailsPage;
    RequestABedPage requestABedPage;
    MakePaymentPage makePaymentPage;
    ModeOfPaymentPage modeOfPaymentPage;
    ConfirmationVisitPage confirmationVisitPage;

    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {

        String loginUrl = "http://52.201.90.154:9002/";
        //String loginUrl = "http://52.201.90.154:9002/pgs/search/undefined?latitude=12.8441489&longitude=77.67938129999993&text=Electronic%20City%20Phase%20II,%20Bengaluru,%20Karnataka,%20India&gender=";
        //String loginUrl = "http://52.201.90.154:9002/pgs//Electronic%20City/men/Zolo-Green-Garden-55a3b8ec7a6f6c4b8ca10000?lat=12.8441489&lng=77.67938129999993";
       // String loginUrl = "http://52.201.90.154:9002/visits/new/0?centerId=55a3b8ec7a6f6c4b8ca10000";
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
        //Navigate to Home Page
        HomePage homePage = new HomePage(driver);
        homePage.clickOnLoginTab();

        //Login to zolostays.com
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToZolo("7777777017","123456");
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        // Get test cases from csv file
        Object[][] testCases = CsvUtils.getTestData(System.getProperty("user.dir")
                +"/src/test/java/com/zolo_tests/Part2Test.csv");
        return testCases;
    }

    @Test(dataProvider = "getData")
    public void part2Test(String testDesc,String searchText, String selectOption, String budget, String sharingPref, String pgType, String propertyName, String sharingType, String promoCode, String paymentMode) throws InterruptedException {

        System.out.println("\n ******************************************************************************************");
        System.out.println("\t"+testDesc);
        System.out.println("******************************************************************************************** \n");
        String expectedPropertyName = selectOption;

        userPage = new UserPage(driver);
        userPage.selectOptionFromAutoSuggested(searchText,selectOption);

        filterResultPage = new FilterResultPage(driver);
        filterResultPage.setSelectBudget(budget);
        filterResultPage.setSelectSharingPref(sharingPref);
        filterResultPage.setSelectPgType(pgType);
        filterResultPage.clickOnApplyFilter();
        filterResultPage.selectProperties(propertyName);

        //Request a Bed
        propertyDetailsPage = new PropertyDetailsPage(driver);
        propertyDetailsPage.verifyPropertiesDetails(propertyName);
        propertyDetailsPage.clickOnRequestABed();

        requestABedPage = new RequestABedPage(driver);
        //requestABedPage.setVisitDate("12-12-2017");
        requestABedPage.selectSharingType(sharingType);
        requestABedPage.clickOnProceedToPayButton();

        //Make payment page
        makePaymentPage = new MakePaymentPage(driver);
        makePaymentPage.gettingDetails();
        Assert.assertTrue(makePaymentPage.getPropertyName().equalsIgnoreCase(propertyName),"Your are on wrong Property," +
                " please check your property details before payment");
        //Assert.assertTrue(promoCode != "", "Promo Code should not be empty ");
        if(promoCode != "") {
            makePaymentPage.applyPromoCode(promoCode); // If Promo code is give this will execute.
        }
        makePaymentPage.clickOnMakePayment();

        modeOfPaymentPage = new ModeOfPaymentPage(driver);
        //You can give any payment mode in Part2Test.csv file it will work for Pay Via Link,Paytm, Phonepe, Debit Card, Credit Card and Internet Banking
        modeOfPaymentPage.clickOnPaymentMode(paymentMode);

        /*TODO : To implement 3rd and 4th steps we have to make payment but in assignment I can't make payment to get Home Page.
        Payment is pending So,right now i can't check 3rd and 4th Steps

         3. Verify that on success page Return home' link is available
         4. Go to Menu options >>
            a. Select Booking >>
            b. Verify the booking details*/
    }

    @AfterMethod
    public void closeOpenBrowser(){
        driver.quit();

    }
}
