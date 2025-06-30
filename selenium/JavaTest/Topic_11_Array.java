package JavaTest;

import org.testng.annotations.Test;

public class Topic_11_Array {

    @Test
    public void BT_1_findMax(){
    int number[]={2,7,6,8,9,1};
    int x=0;

    System.out.println("So lon nhat la: "+x);
    }

    @Test
    public void BT_2(){
        int number[]={2,7,6,8,9};
        System.out.println(number[0]+ number[number.length-1]);
    }

    @Test
    public void BT_3(){
        int number[]={2,7,6,8,9,16,17,20};
        for(int i=0; i <number.length;i++){
            if (number[i] %2==0) {
                System.out.println(number[i]);
            }
        }
    }

    @Test
    public void BT_4(){
        int number[]={3,-7,2,5,9,-6,10,13};
        int x=0;
        for(int i=0; i <number.length;i++){
            if (number[i] %2 !=0 && number[i] >0 ) {
                x+=number[i];
            }
                  }
       ;
    }

    @Test
    public void BT_5(){
        int number[]={3,-7,2,5,9,-6,10,13};
        for(int i=0; i <number.length;i++){
            if (number[i] >=0 && number[i] <=10 ) {
                System.out.println(number[i]);
            }
        }
    }

    @Test
    public void BT_6(){
        int number[]={3,5,7,30,10,5,8,23,0,-5};
        int tong=0;
        float trungBinhCong=0;
        for(int i=0; i <number.length;i++){
            tong+=number[i];
            }
        trungBinhCong=tong/number.length;
        System.out.println("Tong các so trong day la: "+tong);
        System.out.println("TBC các so trong day la: "+trungBinhCong);
        }




}
