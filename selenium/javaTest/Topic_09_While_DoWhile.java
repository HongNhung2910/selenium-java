package javaTest;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_09_While_DoWhile {
     Scanner scanner = new Scanner(System.in);
/*Viết chương trình nhập vào số nguyên n và in ra số chẵn từ n đến 100
 */
        @Test
        public  void BT_01_while () {
            int number = scanner.nextInt();
            while (number < 100) {
                if (number % 2 == 0) {
                    System.out.println(number);
                }
                number++;
            }
        }

        @Test
        public  void BT_01_doWhile () {
            int numberB = scanner.nextInt();
            do {
                if (numberB % 2 == 0) {
                    System.out.println(numberB);
                                    }
                numberB++;
            }
            while (numberB < 100);

        }

        @Test
        public  void BT_01_for () {
            int numberC = scanner.nextInt();
            for (int i = numberC; i < 100; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
        }
/*Viết chương trình nhập vào số nguyên a và b. Hiển thị ra màn hình các số từ a đến b mà chia hết cho 3 và 5
*/
        @Test
        public  void BT_02_while () {
            int numberA = scanner.nextInt();
            int numberB = scanner.nextInt();
            while (numberA < numberB) {
                if (numberA % 3 == 0 && numberA % 5 == 0) {
                    System.out.println(numberA);
                    }
                numberA++;
            }
        }
    @Test
        public  void BT_02_doWhile () {
            int numberA = scanner.nextInt();
            int numberB = scanner.nextInt();
            do{
                if (numberA % 3 == 0 && numberA % 5 == 0) {
                    System.out.println(numberA);
                }
                numberA++;
            }
             while (numberA < numberB);

    }
/*
Viết chương trình nhập vào số n. Hiển thị ra tổng các số lẻ từ 0 đến n
 */
    @Test
    public void BT_03_while(){
        int n=scanner.nextInt();
        int sum=0;
        while (n>0){
            if (n%2!=0){
                sum+=n;
            }
            n--;
        }
        System.out.println(sum);
    }
/*Viết chương trình nhập vào số nguyên a và b. Hiển thị ra màn hình các số từ a đến b mà chia hết cho 3
 */
    @Test
    public void BT_04_doWhile(){
        int numberA = scanner.nextInt();
        int numberB = scanner.nextInt();
        do{
            if (numberA % 3 == 0) {
                System.out.println(numberA);
            }
            numberA++;
        }
        while (numberA < numberB);
    }
/*
Viết chương trình nhập vào số n và hiển thị ra màn hình n giai thừa
 */
    @Test
    public void BT_05_while(){
        int n=scanner.nextInt();
        long x=1;
        while (n>0){
            x=x*n;
            n--;
        }
        System.out.println(x);
    }
    /*
    HIển thị tổng số chẵn từ 1 đến 10
     */
    @Test
    public void BT_06_doWhile(){
        int sum=0;
        int i=1;
        do {
            if (i%2==0){
                sum+=i;
            }
            i++;
        }
        while (i<=10);
        System.out.println(sum);
    }
    }

