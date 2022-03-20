package day08;

import org.testng.annotations.Test;

public class C01_Notaions {


    @Test // Priority atamazsa priority 0 olarak kabul eder
    public void youtubeTest01(){
        System.out.println("youtube testi calisti");

    }

    @Test(priority = -8) // sıfırdan kucuk oldugu icin buradan baslar
    public void amazonTest02(){
        System.out.println("amazon testi calisti");

    }

    @Test(priority = 5)
    public void bestbuyTest03(){
        System.out.println("bestbuy testi calisti");

    }
}
