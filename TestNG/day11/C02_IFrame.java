package day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class C02_IFrame {
    //● Tests package’inda yeni bir class olusturun: WindowHandle2

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void windowHandleTest(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement sayfadakiYaziElementi=driver.findElement(By.tagName("h3"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(sayfadakiYaziElementi.getText(),"Opening a new window","sayfadaki yazi fakli");

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        softAssert.assertEquals(driver.getTitle(),"The Internet","sayfa tittle'i farkli");

        //● Click Here butonuna basın.
        String windowHandleDegeri=driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();


        // Once tum handle degerlerini alip bir set'e koyalim

        Set<String> handleDegerleriSeti = driver.getWindowHandles();
        String windowHandleDegeri2="";

        for (String each:handleDegerleriSeti){
            if (!each.equals(windowHandleDegeri)){
                windowHandleDegeri2=each;
            }
        }

        // ARTIK YENI SAYFAYA GECIS YAPABILIRIM
        driver.switchTo().window(windowHandleDegeri2);

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        softAssert.assertEquals(driver.getTitle(),"New Window","Yeni sayfa tittle istenenden farkli");

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement ikinciSayfadakiYaziElementi=driver.findElement(By.tagName("h3"));
        softAssert.assertEquals(ikinciSayfadakiYaziElementi.getText(),"New Window","Ikinci sayfa");

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(windowHandleDegeri);
        softAssert.assertEquals(driver.getTitle(),"The Internet","Ikı sayfanin title'i beklenen..");

        softAssert.assertAll();
    }

    @AfterClass
    public void teardown(){

        driver.close();
    }
}
