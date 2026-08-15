/**
 * Author: Jagan Thammishetti
 * Description: Automated UI test verifying dropdown selection behavior
 *              using Selenium WebDriver.
 */

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropdownTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    void testDropdownSelection() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropdownElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("dropdown"))
        );
        Select dropdown = new Select(dropdownElement);

        dropdown.selectByVisibleText("Option 2");

        String selected = dropdown.getFirstSelectedOption().getText();
        assertEquals("Option 2", selected);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }
}