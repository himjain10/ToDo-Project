package com.todo.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;


import java.util.concurrent.TimeUnit;

public class BaseTest {

public static WebDriver driver;
    @BeforeClass
    public void setUp()
    {
        System.setProperty("webdriver.http.factory", "jdk-http-client");

      //  System.setProperty("webdriver.chrome.driver","/Users/himanshijain/IdeaProjects/Selenium/chromedriver");

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();

        driver.get("https://todomvc.com/examples/react/dist/#/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        String heading=driver.findElement(By.xpath("//h1[contains(text(),'todos')]")).getText();
        Assert.assertEquals(heading, "todos", "Heading is not matching");
        System.out.println("Title is matching");
    }


    @AfterClass
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }

}
