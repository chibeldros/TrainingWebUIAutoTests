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

public class FormRegistration {
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
        //wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test(description = "submit with minimal required fields")
    public void testConnect() {
        connect("https://demoqa.com/automation-practice-form");
        String firstName = "Timon";
        String lastName = "Birmann";
        String mobileNumber = "9876543210";
        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys(firstName);
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys(lastName);
        driver.findElement(By.xpath("//*[@id=\"userNumber\"]")).sendKeys(mobileNumber);
        driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).submit();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@id=\"closeLargeModal\"]")).click();
    }


    @AfterClass
    private void quitDriver() {
        driver.quit();
    }

}
