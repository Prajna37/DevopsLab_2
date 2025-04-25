package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

public class WebPageTest {
    private static WebDriver driver;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.get("https://prajna37.github.io/DevopsLab_2/");
    }

    @Test
    public void titleValidationTest() {
        String actualTitle = driver.getTitle();
        System.out.println("Page Title: " + actualTitle);
        String expectedTitle = "DEVOPS - Login";
        Assert.assertEquals(actualTitle, expectedTitle, "Page title doesn't match!");

        // Removed this line:
        // Assert.assertTrue(actualTitle.contains("Design"), "Title should contain 'Design'");
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
