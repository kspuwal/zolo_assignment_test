package com.zolotest.genericLib;

import com.zolotest.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Kuldeep on 23-09-2017.
 */
public class LaunchZolo {

    WebDriver driver;

    LoginPage loginPage;

    public WebDriver launchZolo() {
        String loginUrl = "http://52.201.90.154:9002/";
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
        return driver;
    }

}
