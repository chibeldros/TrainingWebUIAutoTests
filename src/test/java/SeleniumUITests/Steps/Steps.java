package SeleniumUITests.Steps;

import SeleniumUITests.Pages.CheckSubmit;
import SeleniumUITests.Pages.StudentRegistrationForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Steps {



    private final CheckSubmit submit;

    public Steps(StudentRegistrationForm page, CheckSubmit submit){
        this.submit = submit;
    }

    public Steps checkCurrentName(String name) {
        Assert.assertEquals(submit.getCurrentName(), name);
        return this;
    }

    public Steps checkGender (String gender){
        Assert.assertEquals(submit.getCurrentGender(), gender);
        return this;
    }

    public Steps checkMobile (String mobileNumber) {
        Assert.assertEquals(submit.getCurrentMobile(), mobileNumber);
        return this;
    }
}
