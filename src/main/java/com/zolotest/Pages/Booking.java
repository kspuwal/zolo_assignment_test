package com.zolotest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Kuldeep on 04-10-2017.
 */
public class Booking {

    @FindBy(xpath = "//li[2]/a[@href='/manage-booking']")
    WebElement bookingMenuWE;

    public void clickOnBookingOption() throws InterruptedException {
        bookingMenuWE.click();
        //wait for 5 sec
        Thread.sleep(5000);
    }
}
