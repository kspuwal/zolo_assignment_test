package com.zolotest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kuldeep on 23-09-2017.
 */
public class FilterResultPage {

    WebDriver driver;

    @FindBy(xpath = "//div/label[text()='Budget']/..//select")
    WebElement selectBudgetWE;

    @FindBy(xpath = "//div/label[text()='Sharing Preference']/..//select")
    WebElement selectSharingPrefWE;

    @FindBy(id = "gender-drpdwn")
    WebElement selectPgTypeWE;

    @FindBy(xpath = "//a/i")
    WebElement applyFilterWE;

    public FilterResultPage(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver,this);
    }


    public void setSelectBudget(String budget){
        Select selectBudget = new Select(selectBudgetWE);
        selectBudget.selectByVisibleText(budget);
    }

    public void setSelectSharingPref(String sharingPref){
        Select selectSharingPref = new Select(selectSharingPrefWE);
        selectSharingPref.selectByVisibleText(sharingPref);
    }

    public void setSelectPgType(String pgType){
        Select selectPgType = new Select(selectPgTypeWE);
        selectPgType.selectByVisibleText(pgType);
    }

    public void clickOnApplyFilter(){
        applyFilterWE.click();
    }

    public void selectProperties(String propertyName) throws InterruptedException {

        List<WebElement> properties = driver.findElements(By.xpath("//h2"));

        for (WebElement wb : properties){
            if(propertyName.contains(wb.getText())){
                System.out.print("Properties found successfully with Name :"+wb.getText());
                wb.click();
                break;
            }

        }
        Thread.sleep(5000);

    }
}
