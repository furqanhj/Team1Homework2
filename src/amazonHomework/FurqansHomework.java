package amazonHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FurqansHomework extends Base{

    @Test (priority = 1, enabled = false)
    public static void testCustomerServiceNavigationLink(){

        WebElement customerServiceLink = chromeDriver.findElement(By.cssSelector("div#nav-xshop > a:nth-of-type(4)"));
        customerServiceLink.click();

        String expectedPageTitle = chromeDriver.getTitle().toLowerCase();
        String actualPageTitle = "Amazon.com Help: Help & Customer Service".toLowerCase();

        Assert.assertEquals(actualPageTitle, expectedPageTitle, "TITLE ON THE PAGE DOES NOT MATCH");
    }

    @Test (priority = 2, enabled = false, dependsOnMethods = "testCustomerServiceNavigationLink")
    public static void testNumOfMainCustomerServiceOptions(){

        WebElement customerServiceLink = chromeDriver.findElement(By.cssSelector("div#nav-xshop > a:nth-of-type(4)"));
        customerServiceLink.click();

        List<WebElement> numOfCustServiceOptions = chromeDriver.findElements(By.xpath("//div[@class='a-box self-service-rich-card']"));

        int actualNumOfOptions = numOfCustServiceOptions.size();
        int expectedNumOfOptions = 9;

        Assert.assertEquals(actualNumOfOptions, expectedNumOfOptions, "NUMBER OF LINKS DO NOT MATCH");
    }

    @Test (priority = 3)
    public static void testSearchHelpLibrary(){

        WebElement customerServiceLink = chromeDriver.findElement(By.cssSelector("div#nav-xshop > a:nth-of-type(4)"));
        customerServiceLink.click();

        try {
            WebElement searchBarLocator = chromeDriver.findElement(By.cssSelector("input#helpsearch"));
            searchBarLocator.sendKeys("Return an Item", Keys.ENTER);
        } catch (Exception e){
            e.printStackTrace();
        }

        String actualTitleOnNavigatedPage = chromeDriver.getTitle().toLowerCase();
        String expectedTextOnNavigatedPage = "Amazon.com Help: Help & Customer Service".toLowerCase();

        Assert.assertEquals(actualTitleOnNavigatedPage, expectedTextOnNavigatedPage, "TITLES DO NOT MATCH");
    }

}
