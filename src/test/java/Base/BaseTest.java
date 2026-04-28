package Base;

import Pages.LoggedOutPage;
import Pages.LoginPage;
import Pages.PracticePage;
import Pages.SidebarPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public SidebarPage sidebarPage;
    public PracticePage practicePage;
    public LoginPage loginPage;
    public LoggedOutPage loggedOutPage;
    public ExcelReader excelReader;

 @BeforeClass
 public void setUp() throws IOException {
     driver = new ChromeDriver();
     wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     sidebarPage = new SidebarPage(driver);
     practicePage = new PracticePage(driver);
     loginPage = new LoginPage(driver);
     loggedOutPage = new LoggedOutPage(driver);
     //excelReader = new ExcelReader("C:\\Users\\mudri\\OneDrive\\Desktop\\TestData.xlsx");
     excelReader = new ExcelReader("TestData.xlsx");
 }

//da pokaze da element nije prisutan
public boolean elementIsPresent (WebElement element){
     boolean present = false;
    try {
    present = element.isDisplayed();
    } catch (Exception e) {
        System.out.println(e);
    }
    return present;
 }



 @AfterClass
 public void tearDown()  {
   // driver.quit();
 }
}
