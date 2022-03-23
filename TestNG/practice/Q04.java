package practies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static java.awt.SystemColor.text;

public class Q04 {
    /*
    Go to url   https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
    Task 1      Find Dropdown on Multi Selection
    Task 2      Find Dropdown all Elements on page
    Task 3      Printout DropDown Elements' number
    Task 4      choose all dropdown elements and printout dropdown elements' name
    Task 5      check until choise 6'
     */

    WebDriver driver;
    @BeforeClass
    public void setUp(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.get(" https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
    }

    @Test
    public void test(){
        // Task 1      Find Dropdown on Multi Selection
        driver.findElement(By.id("justAnInputBox")).click();

        // Task 2      Find Dropdown Elements
        List<WebElement> dropList = driver.findElements(By.xpath("//span[@class ='comboTreeItemTitle']"));

        // Task 3      Printout DropDown Elements' number
        System.out.println("dropListteki element sayisi : " + dropList.size());

        //  Task 4      choose all dropdown elements and printout dropdown elements' name
        for (int i = 0; i <dropList.size(); i++){
            String text = dropList.get(i).getText();
            System.out.println("text = " + text);

        
        //  Task 5      check until choise 6'
        if (text.equals("choise 6")){
            dropList.get(i).click();
            break;
        }
        }
    }
}
