
package se.sigma.selenium.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 *
 * @author josimar
 */
public class SearchResultPage_1 {
    private WebDriver driver;

    public SearchResultPage_1(WebDriver driver) {
        this.driver = driver;
        if (!driver.getTitle().contains("indeed.pt")) {
            throw new IllegalStateException("This is not indeed.pt: " + driver.getCurrentUrl());
        }
    }

    public LocationPage clickOnTopSearchResultLink() {
        String topLinkXPathExpression = "//div[@id='directories']/table/tbody/tr/td[2]/a";
        WebElement topResultLink = driver.findElement(By.xpath(topLinkXPathExpression));
        topResultLink.click();

        return new LocationPage(driver);
    }
}
