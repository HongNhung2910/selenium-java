package javaTest;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_03_Excercise {
   @Test
    public void BT_1(){
       int a=6;
       int b=2;
       System.out.println("Tong="+(a+b));
       System.out.println("Hieu="+(a-b));
       System.out.println("Tich="+(a*b));
       System.out.println("Thuong="+(a/b));
   }

   @Test
    public void BT2() {
       float Rong=7.5f;
       float Dai=3.8f;
       System.out.println("Dien tich hinh chu nhat la="+(Rong * Dai));
   }

   @Test
    public void BT3(){
       String text="Automation Testing";
       System.out.println("Hello "+ text);
   }
@Test
   public void BT4(){
       int a=5;
       int b=6;
       a= a+b;
       b=a-b;
       a=a-b;
    System.out.println("Sau bien doi: gia tri a="+a+ ", Gia tri b="+b);

   }

   @Test
    public void BT5 (){
       int Tuoi=15;
       Tuoi+=15;
       System.out.println("Sau 15 nam so tuoi la: "+Tuoi);

   }
   @Test
    public void BT6(){
       Scanner scanner= new Scanner(System.in);
       int a=scanner.nextInt();
       int b=scanner.nextInt();
       boolean soSanh;
       soSanh=(a> b)?true: false;
       System.out.println(soSanh);
   }
}
