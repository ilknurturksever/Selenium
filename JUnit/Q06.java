package SeleniumJUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Q06 {

    // https://www.bestbuy.com 'a gidin,
    // Sayfa basliginin "Best" icerdigini (contains) dogrulayın
    // Ayrica Relative Locator kullanarak;
    //    logoTest -> BestBuy logosunun goruntulendigini dogrulayin
    //    mexicoLinkTest -> Linkin goruntulenip goruntulenmedigini dogrulayin

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Before
    public void before(){

        driver.get("https://www.bestbuy.com");
    }

    @Test
    public void titleTest(){

        String title = driver.getTitle();
        boolean iceriyorMu = title.contains("Best");
        Assert.assertTrue( "Tittle Best icermiyor",iceriyorMu);
    }

    @Test
    public void logoTest(){

        WebElement helloHeading = driver.findElement(By.xpath("(//div[@class='heading'])[1]"));
        WebElement logo = driver.findElement(By.xpath(String.valueOf(RelativeLocator.with(By.tagName("img")).above(helloHeading))));
        // boolean logoGorunuyorMu = logo.isDisplayed();
        //  Assert.assertTrue(logoGorunuyorMu);
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void linkTest(){

        WebElement usLink = driver.findElement(By.xpath("(//img[@alt='United States'])[1]"));
        WebElement mexicoLink = driver.findElement(By.xpath("(//img[@alt='Mexico'])[1]"));
             // WebElement mexicoLink = driver.findElement(RelativeLocator.with(By.tagName("a")).toRightOf(usLink));
        Assert.assertTrue(mexicoLink.isDisplayed());
    }

    @AfterClass
    public static void tearDown(){
        driver.close();


    }
}