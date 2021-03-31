package anaamHomework;

import amazonHomework.AmazonTeam1Base;
import amazonHomework.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AmazonHomework extends AnaamBase{


    @Test
    public static void testPrimeNavigationLink() {

        WebElement primeLinkLocator = chromeDriver.findElement(By.cssSelector("a#nav-link-prime > span:nth-of-type(1)"));
        primeLinkLocator.click();


        String actualPageTitle = chromeDriver.getTitle().toLowerCase();
        String expectedPageTitle = "Amazon.com: Amazon Prime".toLowerCase();


        Assert.assertEquals(actualPageTitle, expectedPageTitle, "THE TITLES DO NOT MATCH");

    }
    @Test
    public static void testNumOfQuickLinksOnPrimePage(){

        WebElement primeLinkLocator = chromeDriver.findElement(By.cssSelector("a#nav-link-prime > span:nth-of-type(1)"));
        primeLinkLocator.click();


        List<WebElement> quickPrimeLinks = chromeDriver.findElements(By.cssSelector("#prime-top-nav > span"));

        int actualNumOfLinks = quickPrimeLinks.size();
        int expectedNumOfLinks = 5;

        Assert.assertEquals(actualNumOfLinks,expectedNumOfLinks,"NUMBER OF LINKS DO NOT MATCH");


    }

    @Test
    public static void testNamesOfQuickLinksOnPrimePage(){

        WebElement primeLinkLocator = chromeDriver.findElement(By.cssSelector("a#nav-link-prime > span:nth-of-type(1)"));
        primeLinkLocator.click();

        List<WebElement> quickPrimeLinks = chromeDriver.findElements(By.cssSelector());
        String[] actualNamesOfQuickPrimeLinks = new String[quickPrimeLinks.size()];

        String[] expectedNamesOfQuickPrimeLinks ={"Prime", "Delivery","Exclusive Deals", "Prime Insider","Get Help"};

        Assert.assertEquals(actualNamesOfQuickPrimeLinks, expectedNamesOfQuickPrimeLinks, "NAMES OF LINKS DO NOT MATCH");


    }



}
