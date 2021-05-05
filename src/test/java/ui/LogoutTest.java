package ui;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@RunWith(SerenityRunner.class)
public class LogoutTest extends BasicTestSetup {

    @Managed
    WebDriver webDriver;

    @Steps
    public LogoutSteps steps;

    @Test
    @Screenshots(beforeAndAfterEachStep = true)
    public void successfulLogout(){
        ThucydidesWebDriverSupport.useDriver(webDriver);
        steps.openSite();
        steps.loginSite();
        steps.openLoginMenu();
        steps.logout();
        steps.check(); 
    }    
}
