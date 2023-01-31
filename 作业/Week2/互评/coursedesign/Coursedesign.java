package coursedesign;
import java.io.*;
import java.io.InputStreamReader;
import java.util.List;
import java.math.*;


public class Coursedesign {
    public static void main(String args[]){
        int start = 0;
        int end = 0;
         
        System.out.println("Please input a start number: ");
        BufferedReader tx = new BufferedReader(new InputStreamReader(System.in));
        try {
            start = Integer.parseInt(tx.readLine());
        }catch (IOException e){}
 
        //System.out.println(start);
 
        System.out.println("Please input an end number:  ");
        tx = new BufferedReader(new InputStreamReader(System.in));
        try {
            end = Integer.parseInt(tx.readLine());
        }catch (IOException e){}
        /**
         * 上面一块是输入开始位置的数字和结束位置的数字  
          */
                
        int length = 0;
        
        length = end - start +1;
        int[] list = new int[length];
        for (int i = 0;i < length;i++){
            list[i] = start + i;
            System.out.print(list[i]+" ");
        }
        /**
         * 上面是创建从开始到结束数字的顺序表
         */
        int x = 0;
        double sums = 0;
        System.out.println("\n范围内结果有：");
        for (int j = 0;j < length;j++){
            sums = Math.pow(list[j],3) + sums;
        }
        System.out.println(sums+"\n");
        if (Math.cbrt(sums) == (int)(Math.cbrt(sums))){
            x = (int) (Math.cbrt(sums));
            System.out.println(x);
        }else {
            System.out.println("Null");
        }   
        /**
         * 计算列表里面所有数字的立方和，并判断是否可以开三次方根，若可以则返回这个数,反之返回NUll
         */
//        System.out.println(ans*ans*ans);
        if (sums == x*x*x){
            System.out.println("可以满足");
        }else {
            System.out.println("不可以满足");
        }
    }
}
 
