package SeleniumJUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q09 {
    // https://www.teknosa.com adresine gitmek
    // arama cubuguna oppo yazip aratin
    // sonuc sayisini yazdirin
    // cikan ilk urune tiklayin
    // sepete ekleyin
    // sepetime git'e tiklayin
    // consol da "Siparis Ozeti" webelemntinin tex'ini yazdirmak
    // Alisverisi tamamlayiniz
    // son olarak da "Teknosa'ya hos geldiniz" webelementinin text'ini yazdirin
    // driver'i kapatın

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.teknosa.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("oppo" + Keys.ENTER);

        System.out.println("Sonuc Sayisi : " + driver.findElement(By.xpath("//div[@class='plp-info']")).getText());

        driver.findElement(By.xpath("(//a[@class='prd-link'])[1]")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,200)");

        driver.findElement(By.xpath("(//*[@id='addToCartButton'])[1]")).click();
        driver.findElement(By.xpath("//a[@class='btn btn-secondary']")).click();

        System.out.println("Siparis Ozeti : " + driver.findElement(By.xpath("//div[@class='cart-sum-title']")).getText());

        driver.findElement(By.xpath("//a[@class='btn btn-primary js-checkout-controls']")).click();

        System.out.println("Teknosa : " + driver.findElement(By.xpath("(//div[@class='lrl-title'])[1]")).getText());

        driver.close();

    }
}
