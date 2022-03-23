package day09;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C03_SoftAssertion {

    @Test
    public void test(){

        int a=10;
        int b=20;
        int c=30;

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(a,b ,"1. test basarisiz"); //failed
        softAssert.assertTrue(a<b, "2. test basarisiz"); // failed
        softAssert.assertTrue(c>b , "3. test basarisiz"); //passed
        softAssert.assertTrue(a<c , "4. test basarisiz"); //passed
        softAssert.assertTrue(c>a , "5. test basarisiz"); //failed


        // Assertall demezsek class calisir ve passed yazar, cunku aslinda raporlama yapmaz sadece koclar calismis olur
        softAssert.assertAll();
        System.out.println("eger softassertlerden fail olan varsa bu satir calizmaz");
    }
}
