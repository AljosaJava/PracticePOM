package Base;

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


 @BeforeClass
 public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        sidebarPage = new SidebarPage(driver);
        practicePage = new PracticePage(driver);
 }

 @AfterClass
 public void tearDown()  {
     //driver.quit();
 }
}
