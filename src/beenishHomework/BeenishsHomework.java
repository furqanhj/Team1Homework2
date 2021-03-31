package beenishHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BeenishsHomework extends Base {

    //Testing the title page after clicking Best Sellers link
    @Test
    public static void testBestSellersLink() throws InterruptedException {

        WebElement bestSellersLink = chromeDriver.findElement(By.xpath("//div[@id='nav-xshop']//a[contains(@class,'')][normalize-space()='Best Sellers']"));
        bestSellersLink.click();

        Thread.sleep(3000);

        String expectedPageTitle = chromeDriver.getTitle().toLowerCase();
        String actualPageTitle = "Amazon.com Best Sellers: The most popular items on Amazon".toLowerCase();

        Assert.assertEquals(actualPageTitle, expectedPageTitle, "TITLE ON THE PAGE DOES NOT MATCH");
    }

    //Testing the number of quick links on best sellers page
    @Test
    public static void testNumOfQuickLinksOnBestSellersPage() throws InterruptedException {

        WebElement bestSellersLink = chromeDriver.findElement(By.xpath("//div[@id='nav-xshop']//a[contains(@class,'')][normalize-space()='Best Sellers']"));
        bestSellersLink.click();

        Thread.sleep(3000);

        List<WebElement> quickBestSellersLinks = chromeDriver.findElements(By.cssSelector("********"));

        int actualNumOfLinks = quickBestSellersLinks.size();
        int expectedNumOfLinks = 5;

        Assert.assertEquals(actualNumOfLinks, expectedNumOfLinks, "NUMBER OF LINKS DO NOT MATCH");

    }

    //Testing if the best sellers baby link works
    @Test
    public static void testBestSellersBabyLink() throws InterruptedException {

        WebElement bestSellersLink = chromeDriver.findElement(By.xpath("//div[@id='nav-xshop']//a[contains(@class,'')][normalize-space()='Best Sellers']"));
        bestSellersLink.click(); //baby link element

        Thread.sleep(3000);

        String clickBabyLink = "//ul[@id='zg_browseRoot']//ul//a[contains(text(),'Baby')]";
        chromeDriver.findElement(By.xpath(clickBabyLink)).click();


        Assert.assertEquals();
    }

    //Testing if the toys and games link in best sellers works
    @Test
    public static void testToysAndGamesLink() throws InterruptedException {

        WebElement bestSellersLink = chromeDriver.findElement(By.xpath("//div[@id='nav-xshop']//a[contains(@class,'')][normalize-space()='Best Sellers']"));
        bestSellersLink.click(); //baby link element

        Thread.sleep(3000);

        String toysAndGamesLink = "//a[contains(text(),'See more Best Sellers in Toys & Games')]";
        chromeDriver.findElement(By.xpath(toysAndGamesLink)).click();

        Thread.sleep(3000);

        String expectedPageTitle = chromeDriver.getTitle().toLowerCase();
        String actualPageTitle = "Amazon Best Sellers: Best Toys & Games".toLowerCase();

        Assert.assertEquals(actualPageTitle, expectedPageTitle, "TITLE ON THE PAGE DOES NOT MATCH");
    }

    @Test(priority = 29)
    public void testSearchChessAndSelectMagneticChessThanAddToCart() throws InterruptedException {
        checkChess();
        String expectedText = "Amazon.com Shopping Cart";
        chromeDriver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();

        Thread.sleep(2000);

        chromeDriver.findElement(By.cssSelector("div.sg-col-4-of-12:nth-child(3) > div:nth-child(1) > span:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > h2:nth-child(2) > a:nth-child(1) > span:nth-child(1)")).click();
        Thread.sleep(2000);

        chromeDriver.findElement(By.cssSelector("#add-to-cart-button")).click();
        Thread.sleep(2000);

        String actualText = chromeDriver.getTitle();
        Assert.assertEquals(actualText, expectedText, "Product does not match");
    }
}