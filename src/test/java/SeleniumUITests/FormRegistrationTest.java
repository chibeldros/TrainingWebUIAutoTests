package SeleniumUITests;

import SeleniumUITests.Pages.CheckSubmit;
import SeleniumUITests.Pages.StudentRegistrationForm;
import SeleniumUITests.Steps.Steps;

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
    public WebDriverWait wait;
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
    public void

    testConnect() {
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
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        new Steps(page, new CheckSubmit(driver))
                .checkCurrentName(firstName + ' ' + lastName)
                .checkGender("Male")
                .checkMobile(mobileNumber);

        page.clickCloseButton();


    }


    @AfterClass
    private void quitDriver() {
        driver.quit();
    }

}
