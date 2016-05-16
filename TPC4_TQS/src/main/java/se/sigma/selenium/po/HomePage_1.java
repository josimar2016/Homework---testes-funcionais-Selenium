package se.sigma.selenium.po;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author josimar
 */
public class HomePage_1 {

    private WebDriver driver;

    public HomePage_1(WebDriver driver) {
        this.driver = driver;
        String baseUrl = "http://www.indeed.pt";
        driver.get(baseUrl + "/");
    }

    public SearchResultPage searchFor(String location) {
        try {
            WebElement searchField = driver.findElement(By.id("sted"));
            searchField.clear();
            searchField.sendKeys(location);
            searchField.submit();
        } catch (RuntimeException e) {
            takeScreenShot(e, "searchError");
        }

        return new SearchResultPage(driver);
    }

    private void takeScreenShot(RuntimeException e, String fileName) {
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShot, new File(fileName + ".png"));
        } catch (IOException ioe) {
            throw new RuntimeException(ioe.getMessage(), ioe);
        }
        throw e;
    }
}
