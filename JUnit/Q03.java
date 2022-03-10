package SeleniumJUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q03 {

    WebDriver driver;

    @Test

    public void test01(){

        // Amazona gidelim ve title'in "amazon" icerdigini test edelim

        driver.get("https://www.amazon.com");
        String actualTitle = driver.getTitle();
        String arananKelime = "amazon";

        if (actualTitle.contains(arananKelime)){
            System.out.println("Amazon testi PASS");
        }else {
            System.out.println("Amazon tesi FAILED");
        }
    }


    @Test

    public void test02(){
       // google'a gidelim ve basligin "google" icerdigini test edelim

        driver.get("https://www.google.com");
        String actualTitle = driver.getTitle();
        String arananKelime = "google";

        if (actualTitle.contains(arananKelime)){
            System.out.println("Google testi PASS");
        }else {
            System.out.println("Google tesi FAILED");
        }


    }

    @Before
    public void ayarlariDuzenle(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void ortaligiTopla(){

        driver.close();

    }
}
