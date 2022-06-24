package com.tsi.abbas.gure.program;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SeleniumTests {

    public static WebDriver webDriver;

    @BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

    }

    @AfterAll
    public static void tearDown(){
        webDriver.quit();

    }

    @Test
    void webConnectionALiveCheck(){
        Assertions.assertDoesNotThrow(()->{
            webDriver.get("http://localhost:3000/");
        });

    }

    @Test
    void actorFormCheck(){
        webDriver.get("http://localhost:3000/Actor");
//        WebElement addId = webDriver.findElement(By.className("$FAAIField"));
//        addId.sendKeys("3");
//        WebElement submitButton = webDriver.findElement(By.className("$FAA"))

    }

    @Test
    void countryFormCheck(){
        webDriver.get("http://localhost:3000/Country");

    }

    @Test
    void customerFormCheck(){
        webDriver.get("http://localhost:3000/Customer");

    }

    @Test
    void filmFormCheck(){
        webDriver.get("http://localhost:3000/Film");

    }
    @Test
    void filmActorFormCheck(){
        webDriver.get("http://localhost:3000/Film_Actor");

    }
    @Test
    void storeFormCheck(){
        webDriver.get("http://localhost:3000/Store");

    }

    @Test
    public void testAllActor() {
        //Get this url
        webDriver.get("http://localhost:3000/All_Actors");

        String expected = webDriver.findElement(By.id("actorNameList")).getText();
        //Find the element in the screen and click on it
        webDriver.findElement(By.id("displayButton")).click();
        webDriver.findElement(By.id("actorNameList")).isDisplayed();

        // waite until keyword display is not equal to expected or 30 secs has passed
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("actorNameList"), expected));

        String actual = webDriver.findElement(By.id("actorNameList")).getText();
        Assertions.assertNotEquals(expected, actual);

    }




//    @Test
//    public void testAllCountries() {
//        //Get this url
//        webDriver.get("http://localhost:3000/All_Countries");
//
//        String expected = webDriver.findElement(By.id("countryNameList")).getText();
//        //Find the element in the screen and click on it
//        webDriver.findElement(By.id("displayButton")).click();
//        webDriver.findElement(By.id("countryNameList")).isDisplayed();
//
//        // waite until keyword display is not equal to expected or 30 secs has pass
//        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("countryNameList"), expected));
//
//        String actual = webDriver.findElement(By.id("countryNameList")).getText();
//        Assertions.assertNotEquals(expected, actual);
//
//    } @Test
//    public void testAllCustomers() {
//        //Get this url
//        webDriver.get("http://localhost:3000/All_Customers");
//
//        String expected = webDriver.findElement(By.id("customerNameList")).getText();
//        //Find the element in the screen and click on it
//        webDriver.findElement(By.id("displayButton")).click();
//        webDriver.findElement(By.id("customerNameList")).isDisplayed();
//
//        // waite until keyword display is not equal to expected or 30 secs has pass
//        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("customerNameList"), expected));
//
//        String actual = webDriver.findElement(By.id("customerNameList")).getText();
//        Assertions.assertNotEquals(expected, actual);
//
//    }

//
//    @Test
//    public void testAllFilmActors() {
//        //Get this url
//        webDriver.get("http://localhost:3000/All_Actors");
//
//        String expected = webDriver.findElement(By.id("filmActorList")).getText();
//        //Find the element in the screen and click on it
//        webDriver.findElement(By.id("displayButton")).click();
//        webDriver.findElement(By.id("filmActorList")).isDisplayed();
//
//        // waite until keyword display is not equal to expected or 30 secs has pass
//        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("filmActorList"), expected));
//
//        String actual = webDriver.findElement(By.id("filmActorList")).getText();
//        Assertions.assertNotEquals(expected, actual);
//
//    }
//
//
//    @Test
//    public void testAllStores() {
//        //Get this url
//        webDriver.get("http://localhost:3000/All_Stores");
//
//        String expected = webDriver.findElement(By.id("storeList")).getText();
//        //Find the element in the screen and click on it
//        webDriver.findElement(By.id("displayButton")).click();
//        webDriver.findElement(By.id("storeList")).isDisplayed();
//
//        // waite until keyword display is not equal to expected or 30 secs has pass
//        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("storeList"), expected));
//
//        String actual = webDriver.findElement(By.id("storeList")).getText();
//        Assertions.assertNotEquals(expected, actual);
//
//    }
}
