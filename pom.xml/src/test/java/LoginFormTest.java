/**
 * Author: Jagan Thammishetti
 * Project: SDET Practice Project
 * Description: Automated UI test for validating login functionality
 *              on a demo web application using Selenium WebDriver.
 */

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginFormTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    void testValidLogin() {
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button.radius")).click();

        WebElement flash = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        assertTrue(flash.getText().contains("You logged into a secure area"));
    }

    @Test
    void testInvalidLogin() {
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("wronguser");
        driver.findElement(By.id("password")).sendKeys("wrongpass");
        driver.findElement(By.cssSelector("button.radius")).click();

        WebElement flash = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        assertTrue(flash.getText().contains("Your username is invalid"));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }
}