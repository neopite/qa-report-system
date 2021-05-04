package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public static String correctEmail = System.getProperty("login");
    public static String correctPassword = System.getProperty("password");

    @FindBy(id = "login-link")
    private WebElement signInLink;

    @FindBy(id = "btnLinkedIn")
    private WebElement linkedInButton;

    @FindBy(className = "min-profile")
    public WebElement profileIcon;

    public String siteLink = "https://dou.ua/";

    public String parentWindow;
    public String signInWindow;

    public void open() {
        driver.get(siteLink);
    }

    public void getStarted() {
        open();
        signInLink.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        linkedInButton.click();
        parentWindow = driver.getWindowHandle();
        signInWindow = Util.getPopupWindow(driver);
        Util.switchToWindow(driver, signInWindow);
    }

    public WebElement getAuthStatus() {
        return driver.findElement(By.id("login-link"));
    }

    public WebElement getErrorField() {
        return driver.findElement(By.id("error-for-username"));
    }
}
