package javaTest;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_08_For_ForEach {
    Scanner scanner= new Scanner(System.in);
    @Test
    public void BT_1(){

        int x= scanner.nextInt();
        for (int i=1; i<=x;i++){
            System.out.print(i+" ");
        }
    }

    @Test
    public void BT_2(){
        int a= scanner.nextInt();
        int b= scanner.nextInt();
        for (int i=a; i<=b; i++){
            System.out.print(i+" ");
        }

    }
    @Test
    public void BT_3(){
        int sum=0;
        for(int i=1; i<=10; i++){
            if(i % 2==0){
                sum+=i;
            }
        }
        System.out.print(sum);
    }

    @Test
    public void BT_4(){
        int a= scanner.nextInt();
        int b= scanner.nextInt();
        int sum=0;
        for (int i=a; i<=b; i++){
            sum+=i;
        }
        System.out.println(sum);
    }

    @Test
    public void BT_5(){
        int sum=0;
        int a= scanner.nextInt();
        for(int i=0; i<=a; i++){
            if(i % 2!=0){
                sum+=i;
            }
        }
        System.out.print(sum);
    }

    @Test
    public void BT_6(){
        int a= scanner.nextInt();
        int b= scanner.nextInt();
        for (int i=a; i<=b; i++){
            if (i%3==0){
                System.out.print(i+" ");
            }
        }
    }

    @Test
    public void BT_7(){
        int x=1;
        int n= scanner.nextInt();
        for (int i=1; i<=n;i++){
            x*=i;
        }
        System.out.print(x);
    }
}
