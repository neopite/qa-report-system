package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForumPostPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ForumPostPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public static String page = "https://dou.ua/calendar/31729/";

    @FindBy(id = "people")
    private WebElement allPeoples;

    @FindBy(className = "big-button_events")
    private WebElement buttonGoToEvent;

    @FindBy(id ="btnLike")
    private WebElement likeButton;

    public void changeAllPeopleStatus(){
        buttonGoToEvent.click();
    }

    public void changeLikeStatus(){
        likeButton.click();
    }
    public WebElement getCurrentStateOfLikes(){
     return driver.findElement(By.id("btnLike")).findElement(By.className("likely__counter"));
    }
    public WebElement getCurrentStatusOfIWillGoButton(){
        return driver.findElement(By.cssSelector("button[class*='big-button big-button_events checked']"));
    }
}
