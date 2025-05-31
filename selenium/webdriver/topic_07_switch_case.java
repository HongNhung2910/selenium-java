package webdriver;

import org.testng.annotations.Test;

import java.util.Scanner;

public class topic_07_switch_case {
    Scanner scanner= new Scanner(System.in);

    @Test
    public void BT1(){
        int so=scanner.nextInt();
        switch (so){
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            case 4:
                System.out.println("four");
                break;
            case 5:
                System.out.println("five");
                break;
            case 6:
                System.out.println("six");
                break;
            case 7:
                System.out.println("seven");
                break;
            case 8:
                System.out.println("eight");
                break;
            case 9:
                System.out.println("nine");
                break;
            case 10:
                System.out.println("ten");
                break;
            default:
                System.out.println("So khong chinh xac, vui long nhap lai");
                break;
        }
    }

    @Test
    public void BT2(){
        System.out.println("Phep tinh: ");
        String C=scanner.nextLine();
        System.out.println("So thu nhat la: ");
        int A=scanner.nextInt();
        System.out.println("So thu hai la: ");
        int B=scanner.nextInt();


        switch (C){
            case "+":
                System.out.println(A+B);
                break;
            case "-":
                System.out.println(A-B);
                break;
            case "*":
                System.out.println(A*B);
                break;
            case "/":
                System.out.println(A/B);
                break;
            case "%":
                System.out.println(A%B);
                break;
            default:
                System.out.println("Phep toan khong hop le");
                break;
        }
    }
}
