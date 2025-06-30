package webdriver;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_12_String {
    Scanner scanner=new Scanner(System.in);

    @Test
    public void BT_1_Cach1(){
        String chuoiKyTu=scanner.nextLine();
        char mangKyTu[]=chuoiKyTu.toCharArray();
        int count=0;
        for(char kyTu: mangKyTu){
            if (kyTu >='A' && kyTu <='Z'){
                count++;
            }
        }
        System.out.println("So ky tu viet hoa la: "+count);
    }

    @Test
    public void BT_1_Cach2(){
        String chuoiKyTu=scanner.nextLine();
        int count=0;
        for(char i=0; i<chuoiKyTu.length();i++){
            if (chuoiKyTu.charAt(i) >='A' && chuoiKyTu.charAt(i) <='Z'){
                count++;
            }
        }
        System.out.println("So ky tu viet hoa la: "+count);
    }

    @Test
    public void BT_2(){
        String chuoiKyTu="Automation Testing 345 Tutorials Online 789";
        int sokytu=0;
        for(char i=0; i<chuoiKyTu.length();i++){
            if (chuoiKyTu.charAt(i) >='a' ){
                sokytu++;
            }
        }
        System.out.println("So luong ky tu a la: "+sokytu);

        boolean soSanh=chuoiKyTu.contains("Testing");
        System.out.println("Chuỗi có chứa Testing không: "+soSanh);

        boolean c=chuoiKyTu.startsWith("Automation");
        System.out.println("Chuỗi có bắt đầu bằng Automation không: "+c);

        boolean d=chuoiKyTu.endsWith("Online");
        System.out.println("Chuỗi có kết thúc bằng Online không: "+d);

        int index=chuoiKyTu.indexOf("Tutorials");
        System.out.println("Vị trí của chuỗi Tutorials là: "+index);

        String thayThe=chuoiKyTu.replace("Online","Offline");
        System.out.println(thayThe);

        int so=0;
        for(char y=0; y<chuoiKyTu.length();y++){
            if (chuoiKyTu.charAt(y)>='0' && chuoiKyTu.charAt(y) <='9'){
                so++;
            }
        }
        System.out.println("Số ký tự số là: "+so);
    }

    @Test
    public void BT_3(){
        System.out.println("Mời bạn nhập chuỗi ký tự: ");
        String chuoi1=scanner.nextLine();
        String chuoi2= new StringBuilder(chuoi1).reverse().toString();

        System.out.println("Chuỗi ký tự đảo ngược là: "+chuoi2);

    }
}
