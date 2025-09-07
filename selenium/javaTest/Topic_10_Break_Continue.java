package javaTest;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_10_Break_Continue {
Scanner scanner=new Scanner(System.in);

@Test
    public void BT_01_continue (){
    String[] trinhDuyet={"chrome","firefox","edge","safari"};
    String y=scanner.nextLine();
    for(int i=0;i< trinhDuyet.length;i++){
        if(y.equals("edge")){
            continue;
       }
        System.out.println(trinhDuyet[i]);
    }
}
/*
@Test
    public void BT_02_break(){
    String [] month={"Mot","Hai","Ba","Bon","Nam","Sau","Bay","Tam","Chin","Muoi","Muoi Mot","Muoi Hai"};
    int x=scanner.nextLine();
    for (int i=0; i<= month.length;i++){
        if (x= month[i]){

        }
    }

}

 */
}
