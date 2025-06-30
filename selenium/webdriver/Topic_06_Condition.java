package webdriver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import java.util.Scanner;

public class Topic_06_Condition {
    WebDriver drive;
    Scanner scanner= new Scanner(System.in);
   @Test
   public void  BT_1(){
       int number= scanner.nextInt();
       if (number %2 == 0) {
           System.out.println("Đây là số chẵn");
       }
       else {
           System.out.println("Đây là số lẻ");
       }
       }
   @Test
   public void BT_2(){
       int numberA= scanner.nextInt();
       int numberB= scanner.nextInt();
       if (numberA>= numberB){
           System.out.println(numberA+" lớn hơn hoặc bằng "+ numberB);
       }
       else {
           System.out.println(numberA+" nhỏ hơn "+ numberB);
       }
   }
   @Test
    public void BT_3(){
       String TenA= scanner.nextLine();
       String TenB= scanner.nextLine();
       boolean Sosanh= TenA.equalsIgnoreCase(TenB);
       if (Sosanh=true) {
           System.out.println("Hai nguoi co cung ten");
       }
       else {
           System.out.println("Hai nguoi khac ten");
       }
   }
   @Test
    public void BT_4(){
       System.out.println("Nhập số thứ nhất: "); int a= scanner.nextInt();
       System.out.println("Nhập số thứ hai: ");int b= scanner.nextInt();
       System.out.println("Nhập số thứ ba: ");int c= scanner.nextInt();
  if (a>b && a> c){
      System.out.println("Số lớn nhất là: "+a);
  }
  else if (b>a && b>c){
      System.out.println("Số lớn nhất là: "+b);
  }
  else {
      System.out.println("Số lớn nhất là "+c);
  }
   }

   @Test
    public void BT_5(){
       int a= scanner.nextInt();
       if (a>=0 && a <=100){
           System.out.println(a+ " nằm trong [10,100]");
       }
       else {
           System.out.println(a+ " không nằm trong [10,100]");
       }
   }

   @Test
    public void BT_6(){
       System.out.println("Điểm thi của bạn là: ");
       int diemThi= scanner.nextInt();
       if (diemThi< 5){
           System.out.println("Bạn xếp loại D");
       }
       else if ( diemThi >=5 && diemThi<7.5 ){
           System.out.println("Bạn xếp loại C");
       }
       else if ( diemThi >= 7.5 && diemThi <8.5 ){
           System.out.println("Bạn xếp loại B");
       }
       else if ( diemThi >= 8.5 && diemThi <=10 ){
           System.out.println("Chúc mừng bạn đã xếp loại A");
       }
   }
    }




