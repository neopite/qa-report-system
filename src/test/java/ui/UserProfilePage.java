package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserProfilePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public UserProfilePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(xpath = "//a[text()=\"Logout\"]")
    WebElement logoutButton;

    @FindBy(xpath = "//a[text()=\"Edit profile\"]")
    WebElement editProfileButton;

    @FindBy(className = "head")
    public WebElement profileHeader;

    public void submitLogout() {
        logoutButton.click();
    }

    public void submitButton() {
        editProfileButton.click();
    }

    public WebElement getProfileUsername() {
        return profileHeader.findElement(By.cssSelector("h1"));
    }
}
