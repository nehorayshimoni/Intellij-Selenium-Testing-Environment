import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass {

    WebDriver driver;

    @BeforeTest
    public void startSession() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
    }

    @Test
    public void getTitle() {
        System.out.println("Title: " + driver.getTitle());
    }
    @Test
    public void performSearch() {
        WebElement searchGoogle = driver.findElement(By.name("_nkw"));
        searchGoogle.sendKeys("test search bar");

        searchGoogle.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, 5);

        System.out.println("New Title: " + driver.getTitle());
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
