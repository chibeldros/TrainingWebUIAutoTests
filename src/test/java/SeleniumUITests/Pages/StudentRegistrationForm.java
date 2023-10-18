package SeleniumUITests.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentRegistrationForm implements Page{


    public StudentRegistrationForm(WebDriver driver) {
        init(driver);
    }

    @FindBy(xpath = "//*[@id=\"firstName\"]")
    WebElement firstName;

    @FindBy(xpath = "//*[@id=\"lastName\"]")
    WebElement lastName;

    @FindBy(xpath = "//*[@id=\"userNumber\"]")
    WebElement mobileNumber;

    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")
    WebElement genderButton;

    @FindBy(xpath = "//*[@id=\"submit\"]")
    WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"closeLargeModal\"]")
    WebElement closeButton;

    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public StudentRegistrationForm setFirstName(String name){
        firstName.sendKeys(name);
        return this;
    }

    public StudentRegistrationForm setLastName(String surName){
        lastName.sendKeys(surName);
        return this;
    }

    public StudentRegistrationForm setMobilenumber(String number){
        mobileNumber.sendKeys(number);
        return this;
    }

    public StudentRegistrationForm setGender(){
        genderButton.click();
        return this;
    }

    public StudentRegistrationForm clickSubmit(){
        submitButton.submit();
        return this;
    }

    public StudentRegistrationForm clickCloseButton(){
        closeButton.click();
        return this;
    }
}
