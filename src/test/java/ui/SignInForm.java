package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInForm {
    private WebDriver driver;
    private WebDriverWait wait;

    public SignInForm(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(id="username")
    public WebElement emailField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//button[text()=\"Sign in\"]")
    public WebElement submitButton;

    @FindBy(id = "error-for-username")
    public WebDriver errorField;

    private void setValueToField(WebElement field , String value){
        field.sendKeys(value);
    }

    public void setValueToEmail(String value){
        setValueToField(emailField,value);
    }

    public void setValueToPassword(String value){
        setValueToField(passwordField,value);
    }


    public void confirmForm(){
        submitButton.submit();
    }

}
