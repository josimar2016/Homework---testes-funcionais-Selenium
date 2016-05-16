
package test.se.sigma.selenium.po;
import se.sigma.selenium.po.LocationPage;
import se.sigma.selenium.po.SearchResultPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static junit.framework.Assert.assertTrue;
import se.sigma.selenium.po.HomePage;
/**
 *
 * @author josimar
 */
public class SearchTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void verifyThatStockholmCanBeFound() {
        HomePage home = new HomePage(driver);
        SearchResultPage searchResult = home.searchFor("Stockholm");

        LocationPage stockholm = searchResult.clickOnTopSearchResultLink();

        String expected = "Stockholm";
        String actual = stockholm.getHeadLine();
        assertTrue(actual.contains(expected));
    }
}
