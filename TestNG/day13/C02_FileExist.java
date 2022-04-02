package day13;

import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C02_FileExist {

    @Test
    public void test01(){

        System.out.println(System.getProperty("user.home")); // C:\Users\ilknu\OneDrive\Masaüstü

        // masaustundeki Deneme klasorunun Path'ini istersem
        // C:\Users\ilknu\OneDrive\Masaüstü

        // Yani dinamik olarak masausundeki Deneme klasorunun path'ini yazmak istersem

        String path=System.getProperty("user.home")+"\\ilknu\\OneDrive\\Masaüstü";

        System.out.println(path);

        System.out.println("user.dir :" + System.getProperty("user.dir"));

        // Masaustunde Deneme klasoru icerisinde selenium.xlsx isminde bir dosya oldugunu test edin

        // 1- once bu dosyaya ulasmak icin gerekli dinamik path olusturalim

        String dosyaYolu =System.getProperty("user.home")+"\\ilknu\\OneDrive\\Masaüstü\\";

        System.out.println(Files.exists(Paths.get(dosyaYolu)));



    }
}
