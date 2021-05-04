package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.useDriver;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@RunWith(SerenityRunner.class)
public class LogoutSteps {
    private HomePage homePage;

    private UserProfilePage userProfilePage;

    @Step
    public void openSite() {
        homePage = PageFactory.initElements(ThucydidesWebDriverSupport.getDriver(), HomePage.class);
    }

    @Step
    public void loginSite() {
        Util.login(homePage, ThucydidesWebDriverSupport.getDriver(), "stamin4ik4@gmail.com", "Stamin4ik161291");
        homePage.profileIcon.click();
    }

    @Step
    public void openLoginMenu() {
        userProfilePage = PageFactory.initElements(ThucydidesWebDriverSupport.getDriver(), UserProfilePage.class);
    }

    @Step
    public void logout() {
        userProfilePage.submitLogout();
    }

    @Step
    public void check() {
        assertNotEquals(homePage.getAuthStatus(), null);
    }


}
