import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.DataUtils;

public class LoginTest {

//    DataUtils dataUtils = new DataUtils();

    static WebDriver driver;

    static WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    static void typeIn(By locator, String text){
        getElement(locator).sendKeys(text);
    }

    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By buttonLocator = By.className("radius");
    WebElement button = driver.findElement(buttonLocator);

//    @Test
//    @BeforeTest
//    public void setUp() {
//    }

    @BeforeClass
    public void setUpClass() {
    }

    @BeforeMethod
    public void setUpMethod() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void cleanup() {
        driver.close();
    }


    @Test(priority = 1)
    public void test1() {
        typeIn(usernameLocator, DataUtils.validUsername);
        typeIn(passwordLocator, DataUtils.wrongPassword);
        getElement(buttonLocator).click();

        Assert.assertTrue(button.isDisplayed(), "Button is not displayed on the page.");
    }


    @Test(priority = 1)
    public void test2() {
        typeIn(usernameLocator, DataUtils.wrongUsername);
        typeIn(passwordLocator, DataUtils.validPassword);
        getElement(buttonLocator).click();

        Assert.assertTrue(button.isDisplayed(), "Button is not displayed on the page.");
    }


    @Test (priority = 1)
    public void test3() {
        typeIn(usernameLocator, DataUtils.wrongUsername);
        typeIn(passwordLocator, DataUtils.wrongPassword);
        getElement(buttonLocator).click();

        Assert.assertTrue(button.isDisplayed(), "Button is not displayed on the page.");
    }


    @Test (priority = 1)
    public void test4() {
        typeIn(usernameLocator, "");
        typeIn(passwordLocator, "");
        getElement(buttonLocator).click();

        Assert.assertTrue(button.isDisplayed(), "Button is not displayed on the page.");
    }





}
