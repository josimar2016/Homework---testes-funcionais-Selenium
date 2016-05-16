package test.se.sigma.selenium.cu;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.sigma.selenium.po.HomePage;

import static junit.framework.Assert.assertTrue;
import se.sigma.selenium.po.LocationPage;
import se.sigma.selenium.po.SearchResultPage;

/**
 *
 * @author josimar
 */
public class SearchStepDefinitions_1 {

    private WebDriver driver;
    private HomePage home;
    private SearchResultPage searchResult;

    @Before
    public void prepare() {
        driver = new FirefoxDriver();
    }

    @After
    public void cleanUp() {
        driver.close();
    }

    @Given("^Eu quero saber a oferta de emprego de emprego na área de Electrónica Automação e Comando$")
    public void prepareHomePage() {
        home = new HomePage(driver);
    }

    @When("^Eu procurar por (.*)$")
    public void search(String location) {
        searchResult = home.searchFor(location);
    }

    @Then("^Eu deveria ser capaz de obter uma resposta referente (.*)$")
    public void assertTheSearchResult(String locationName) {
        LocationPage location = searchResult.clickOnTopSearchResultLink();
        String actualHeadLine = location.getHeadLine();

        assertTrue(actualHeadLine.contains(locationName));
    }
}
