package SeleniumUITests;

import SeleniumUITests.Pages.StudentRegistrationForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FormRegistrationTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private void connect(String url){
        driver.get(url);
    }

    @BeforeClass
    private void startDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test(description = "submit with minimal required fields")
    public void testConnect() {
        connect("https://demoqa.com/automation-practice-form");
        String firstName = "Timon";
        String lastName = "Birmann";
        String mobileNumber = "9876543210";
        StudentRegistrationForm page = new StudentRegistrationForm(driver);
        page = page.setFirstName(firstName)
                .setLastName(lastName)
                .setMobilenumber(mobileNumber)
                .setGender()
                .clickSubmit();


    //    driver.findElement(By.xpath("//*[@id=\"submit\"]")).submit();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@id=\"closeLargeModal\"]")).click();
    }


    @AfterClass
    private void quitDriver() {
        driver.quit();
    }

}
