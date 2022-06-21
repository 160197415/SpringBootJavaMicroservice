package com.tsi.abbas.gure.program;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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

}
