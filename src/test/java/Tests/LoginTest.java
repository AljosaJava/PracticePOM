package Tests;

import Base.BaseTest;
import Pages.LoggedOutPage;
import Pages.LoginPage;
import Pages.PracticePage;
import Pages.SidebarPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest { //znaci driver je vidljiv

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        sidebarPage = new SidebarPage(driver);
        practicePage = new PracticePage(driver);
        loginPage = new LoginPage(driver);
        loggedOutPage = new LoggedOutPage(driver);
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");
    }

    @Test(priority = 10)
    public void userCanLogin() {
        sidebarPage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPage();
        loginPage.inputUsername("student");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmitButton();

        Assert.assertTrue(loggedOutPage.getMessage().isDisplayed()); //da li prikazuje poruku
        Assert.assertTrue(loggedOutPage.getLogOutButton().isDisplayed()); //button se pojavljuje
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/logged-in-successfully/"); //url je dobar
    }

    @Test(priority = 20)
    public void userCanLogout() {
        sidebarPage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPage();
        loginPage.inputUsername("student");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmitButton();
        loggedOutPage.clickOnLogOutButton();
        Assert.assertTrue(loginPage.getSubmitButton().isDisplayed()); //da li ima submit button
    }

    @Test(priority = 30)
    public void userCannotLoginWithInvalidUsername() {
        sidebarPage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPage();
        loginPage.inputUsername("non-student");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmitButton();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getError()));
        Assert.assertTrue(loginPage.getError().getText().contains("Your username is invalid!"));
    }

    @Test(priority = 40)
    public void userCannotLoginWithInvalidPassword() {
        sidebarPage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPage();
        loginPage.inputUsername("student");
        loginPage.inputPassword("nePassword123");
        loginPage.clickOnSubmitButton();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getError()));
        Assert.assertTrue(loginPage.getError().getText().contains("Your password is invalid!"));
    }


}
