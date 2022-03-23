package practies;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q03 {

    /* Birbirine bagli tesler olusturun..
         BeforeClass olusturup setUp ayarlarini yapin..
         birbirine bagli testler olusturarak;
            ilk once facebook'a gidin
            sonra facebook'a bagli olarak google'a gidin
            daha sonra google'a bagimli olarak amazon'a gidin
         driver'i kapatin
     */

    WebDriver driver;
    @BeforeClass
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test (dependsOnMethods ="googleTest")
    public void amazonTest(){

        driver.get("http://www.amazon.com");
    }

    @Test (dependsOnMethods ="facebookTest")
    public void googleTest(){

        driver.get("http://www.google.com");
    }

    @Test
    public void facebookTest(){

        driver.get("http://www.facebook.com");
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
