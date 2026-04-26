package Tests;

import Base.BaseTest;
import Pages.SidebarPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest { //znaci driver je vidljiv

    @BeforeMethod
public void pageSetUp() {
    driver.manage().window().maximize();
    driver.get("https://practicetestautomation.com/");
}

@Test
public void userCanLogin(){
        sidebarPage.clickOnPracticeButton();
        practicePage.clickonTestLoginPage();
}



}
