
package se.sigma.selenium.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 *
 * @author josimar
 */
public class LocationPage_1 {
     private WebDriver driver;

    public LocationPage_1(WebDriver driver) {
        this.driver = driver;

        if (!driver.getTitle().contains("indeed.pt")) {
            throw new IllegalStateException("This is not indeed.pt: " + driver.getCurrentUrl());
        }
    }

    public String getHeadLine() {
        WebElement resultPageHeadLine = driver.findElement(By.cssSelector("h1"));
        return resultPageHeadLine.getText();
    }
}
