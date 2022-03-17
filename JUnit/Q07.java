package SeleniumJUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q07 {

    // http://the-internet.herokuapp.com/add_remove_elements/
    // click on the "App Element" button 100 times
    // write a function that takes a number, and clicks the "Delete" button
    // given number of times, and then validates that given number of
    // buttons was delete


    // 1. Methods : createButtons(100)
    // 2. deleteButtonsAndValidate()

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        createButtons(driver,100);
        deleteButtonsAndValidate(driver,60);


    }

    private static void createButtons(WebDriver driver, int eklenecekSayi) {
        WebElement addButton = driver.findElement(By.xpath("//*[@onclick='addElement()']"));
        for (int i = 0; i<eklenecekSayi; i++){
            addButton.click();
        }
    }

    private static void deleteButtonsAndValidate(WebDriver driver, int number) {
        List<WebElement>elements = driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        int sizeBeforeDelete = elements.size();

        List<WebElement>buttonDelete  =driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        int sayac = 0;

        for (WebElement w :buttonDelete){
            sayac ++;
            if (sayac>number){
                break;
            }
            w.click();
        }
        List<WebElement> elementAfter = driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        int sizeAfterDelete = elementAfter.size();

        if ((sizeBeforeDelete-number)==sizeAfterDelete){
            System.out.println("sizeAfterDelete = " + sizeAfterDelete);
            System.out.println("SUCCESS");
        }else
            System.out.println("FAIL");
    }

}
