package Base;

import Pages.LoggedOutPage;
import Pages.LoginPage;
import Pages.PracticePage;
import Pages.SidebarPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public SidebarPage sidebarPage;
    public PracticePage practicePage;
    public LoginPage loginPage;
    public LoggedOutPage loggedOutPage;

 @BeforeClass
 public void setUp() {

 }

 @AfterClass
 public void tearDown()  {
    driver.quit();
 }
}
