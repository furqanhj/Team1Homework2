package amazonHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class TestAmazon extends Base {


    @Test(priority = 1)
    public void testPageTitle() {

        System.out.println("Page title is : " + chromeDriver.getTitle());
        String actualTitle = chromeDriver.getTitle().toLowerCase();
        String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more ".toLowerCase();

        Assert.assertEquals(actualTitle, expectedTitle, "TITLE DOES NOT MATCH");

    }

    @Test(priority = 2)
    public void testDoSearch1() {

        WebElement searchBox = chromeDriver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("KorgPa4x");

        WebElement searchButton = chromeDriver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();

        String actualTitle = chromeDriver.getTitle().toLowerCase();
        String expectedTitle = "Amazon.com : KorgPa4x".toLowerCase();

        Assert.assertEquals(actualTitle, expectedTitle, "Wrong Title");

    }

    @Test(priority = 3)
    public void testBestSellerLink() {


        WebElement BestSellerLink = chromeDriver.findElement(By.cssSelector("#nav-xshop > a:nth-child(2)"));
        BestSellerLink.click();

        WebElement anyDepartment = chromeDriver.findElement(By.id("zg_browseRoot"));

        System.out.println("Links in this Page :" + anyDepartment.findElements(By.tagName("a")).size());


    }


    @Test(priority = 4)
    public void testMusicalInstrumentsLink() {
        WebElement bestSellerLink = chromeDriver.findElement(By.cssSelector("#nav-xshop > a:nth-child(2)"));
        bestSellerLink.click();
        WebElement musicalInstrumentsLink = chromeDriver.findElement(By.xpath("//*[@id='zg_browseRoot']/ul/li[31]/a"));
        musicalInstrumentsLink.click();
        WebElement anyDepartment = chromeDriver.findElement(By.cssSelector("#a-page > div:nth-child(2) > div.a-row.zg-banner.zg-text-center-align"));
        System.out.print("banner-text : " + anyDepartment.getText());

        String actualText = anyDepartment.getText();
        String expectedText = "Amazon Best Sellers\n" +
                "Our most popular products based on sales. Updated hourly.";

        Assert.assertEquals(actualText, expectedText, "Wrong Text");

    }

    @Test(priority = 5)
    public void testOrderReturnLink() {




        boolean order = chromeDriver.findElement(By.id("nav-orders")).isEnabled();

        if (order) {
            System.out.println("Link is enabled");
        } else {
            System.out.println("Link is Not enabled");

        }
        WebElement order1=chromeDriver.findElement(By.id("nav-orders"));
        order1.click();

    }

}








