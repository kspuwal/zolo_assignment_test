package com.zolotest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Kuldeep on 23-09-2017.
 */
public class UserPage {

    WebDriver driver;

    @FindBy(id = "searchBar")
    WebElement searchBoxWE;

    @FindBy(xpath = "//button/span[2][contains(text(),'Search')]")
    WebElement searchButtonWE;

    public UserPage(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver,this);
    }


    public void enterSearchText(String searchText){
        searchBoxWE.sendKeys(searchText);
    }

    public void clickOnSearchButton(){
        searchButtonWE.click();
    }

    public void selectOptionFromAutoSuggested(String searchText, String selectOption){
        try {
            enterSearchText(searchText);
            //driver.findElement(By.xpath("//li/div[text()='Electronic City Phase II, Bengaluru, Karnataka, India']")).click();
            System.out.println("Selecting option from auto search result:"+selectOption);
            driver.findElement(By.xpath("//li/div[text()='"+selectOption+"']")).click();
            clickOnSearchButton();
        }
        catch (Exception e){
            System.out.print(e);
            System.out.println("Please check your selectOption "+selectOption+" available or not");
        }

    }

}
