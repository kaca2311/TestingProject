package org.example;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.swing.*;


public class SeleniumDriverManager {
    static WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    static void typeIn(By locator, String text){
        getElement(locator).sendKeys();
    }
    static WebDriver driver;


    public static void useDriver() {

        SoftAssert softAssert = new SoftAssert();

        By usernameLocator = By.id("username");
        By passwordLocator = By.id("password");
        By buttonLocator = By.className("radius");

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        typeIn (usernameLocator, "tomsmith");
        typeIn (passwordLocator, "SuperSecretPassword!");
        getElement(buttonLocator).click();
        String expectedText = "You logged into a secure area!";
        WebElement loggedInUserText = driver.findElement(By.id("flash"));
        String actualText = loggedInUserText.getText();

        String actual =loggedInUserText.getText().substring(0, loggedInUserText.getText().length()-1);

        System.out.println(actualText);
        System.out.println(actual);


        String actualColor = loggedInUserText.getCssValue("background-color");
        System.out.println(actualColor);
        String expectedColor = "rgba(93, 164, 35, 1)";


//        Assert.assertEquals(actualColor, expectedColor, "Failed!");
//
//        Assert.assertEquals(actualText.trim(), expectedText, "Failed text");

        softAssert.assertEquals(actualColor, expectedColor, "Failed!");

        softAssert.assertEquals(actualText.trim(), expectedText, "Failed text");

        softAssert.assertAll();


        driver.quit();
    }

}
