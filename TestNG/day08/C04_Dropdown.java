package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C04_Dropdown {

        WebDriver driver;
        Select select;
        int expectedSize, actualSize, result;
        String text;
        String[] arr;
        List<WebElement> optionList;
        boolean isDisplayedJava;

        @BeforeClass
        public void setup() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.get("https://www.amazon.com/");
            select = new Select(driver.findElement(By.xpath("//select[@id='searchDropdownBox']")));
        }

        @Test
        public void test01() {

//● Bir class oluşturun: C3_DropDownAmazon
//● https://www.amazon.com/ adresine gidin.
//- Test 1
//Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
            optionList = select.getOptions();
            expectedSize = 45;
            actualSize = optionList.size();
            Assert.assertEquals(actualSize, expectedSize);
        }

        @Test
        public void test02() {
            //-Test 2
//    1. Kategori menusunden Books secenegini  secin
//    2. Arama kutusuna Java yazin ve aratin
//    3. Bulunan sonuc sayisini yazdirin
//    4. Sonucun Java kelimesini icerdigini test edin
            select.selectByVisibleText("Books");
            driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java" + Keys.ENTER);
            text = driver.findElement(By.xpath("(//span[@dir='auto'])[1]")).getText();
            arr = text.split(" ");
            result = Integer.parseInt(arr[3].replaceAll("\\D", ""));
            System.out.println("result = " + result);
            isDisplayedJava = text.contains("Java");
            Assert.assertTrue(isDisplayedJava);


        }
    }

