package SeleniumJUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class Q01 {
    public static void main(String[] args) {
        // 1-C01_TekrarTesti isimli bir class olusturun
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.google.com/ adresine gidin
        driver.get(" https://www.google.com/");

        //3- cookies uyarisini kabul ederek kapatin
        // COOKIES YOK

        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualGoogleTitle= driver.getTitle();
        String arananKelime="Google";
        if (actualGoogleTitle.contains(arananKelime)){
            System.out.println("Title Testi PASS");
        }else {
            System.out.println("Title Testi FAILD");
        }

        //5- Arama cubuguna “Nutella” yazip aratin
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@name='q']"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);


        //6-Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisi = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucSayisi.getText());


        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String sonucSayisiString = sonucSayisi.getText();
        String sonucKelimeleri[] = sonucSayisiString.split(" ");
        System.out.println(Arrays.toString(sonucKelimeleri));


        //8-Sayfayi kapatin
        driver.close();

}
}