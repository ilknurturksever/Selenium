package SeleniumJUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q04 {
    // Before class ile driver 1 olusturun ve class icinde static yapin
    // Maximize edin, 15 sn bekleyin
    // http://www.google.com adresine gidin
    // arama kutusuna "Greean Mile" yazip, cikan sonuc sayisini yazdirin
    // arama kutusuna "Premonition" yazip, cikan sonuc sayfasini yazdirin
    // arama kutusuna "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
    // AfterClass ile kapatın

    WebDriver driver;
    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test1(){

        driver.get("http://www.google.com");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Greean Mile" + Keys.ENTER);

    }

    @Test
    public void test2(){

        driver.get("http://www.google.com");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Premonition" + Keys.ENTER);

    }

    @Test
    public void test3(){

        driver.get("http://www.google.com");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("The Curious Case of Benjamin Button" + Keys.ENTER);

    }

    @After
    public void tearDown(){
        driver.close();
    }


}


