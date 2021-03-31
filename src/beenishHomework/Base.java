package beenishHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Base {
    public static final String checkChess = "checkersGames";


    static String chromeRelativePath = "/resources/webdrivers/Windows/chromedriver.exe";
    static String chromeDriverPath = System.getProperty("user.dir") + chromeRelativePath;
    static WebDriver chromeDriver;
    private final String URL = "https://www.amazon.com";

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("@BeforeSuite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("@AfterSuite");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("@BeforeClass");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("@AfterClass");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("@BeforeMethod");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        chromeDriver = new ChromeDriver();

        chromeDriver.get(URL);
        chromeDriver.manage().deleteAllCookies();
        chromeDriver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        System.out.println("@AfterMethod");

        Thread.sleep(5000);

        chromeDriver.close();
        chromeDriver.quit();
    }


}


