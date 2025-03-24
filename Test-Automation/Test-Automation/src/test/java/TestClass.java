import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
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
        driver.get("https://www.google.com");
    }

    @Test
    public void openGoogle() {
        System.out.println("Title: " + driver.getTitle());
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
