package SeleniumUITests.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckSubmit implements Page {

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[1]/td[2]")
    WebElement currentName;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[3]/td[2]")
    WebElement currentGender;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[4]/td[2]")
    WebElement currentMobile;

    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public CheckSubmit(WebDriver driver) {
        init(driver);
    }

    public String getCurrentName() { return currentName.getText();}

    public String getCurrentGender() { return currentGender.getText();}

    public String getCurrentMobile() { return currentMobile.getText();}

}
