package test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author josimar
 */
public class SearchExportedFromIDETest {

    private WebDriver driver;
    private String baseUrl = "";
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSearchExportedFromIDE() throws Exception {
        driver.get("/");
        driver.findElement(By.id("sted")).clear();
        driver.findElement(By.id("sted")).sendKeys("Stockholm");
        driver.findElement(By.id("queryknapp")).click();
        driver.findElement(By.xpath("//div[@id='directories']/table/tbody/tr/td[2]/a")).click();
        driver.findElement(By.cssSelector("li")).click();
        assertEquals("Weather forecast forStockholm (Sweden)", driver.findElement(By.cssSelector("h1")).getText());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
