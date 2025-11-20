package SetUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SuperClass
{
    // Create the WebDriver as a Global variable
    WebDriver driver;

    // Step 2: create a global variable for soft assert
    public SoftAssert soft;

@BeforeMethod
public void OpenDriver()
{
    // Step 1: Create Object from
    driver = new ChromeDriver();

    // Step 2: Manage Conditional Synchronisation "implicit wait"
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    // Step 3: Manage Conditional Synchronisation "explicit wait"
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    // Step 4: Manage Window Maximize
    driver.manage().window().maximize();

    // Step 5: Create Object From Class SoftAssert
    soft = new SoftAssert();

    // Step 6: Launch The WebSide
    driver.get("https://automationexercise.com/");
};

@AfterMethod
public void CloseDriver() throws InterruptedException {
    // Step 1: Call `assertAll()` to check all assertions
    soft.assertAll();

    // Step 2: Manage unconditional synchronization
    Thread.sleep(3000);

    //Step 3: Close Driver
    driver.quit();
};
}
