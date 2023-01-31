

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 本代码为资金管理系统 主要实现查询 与 转帐功能
 */
public class FundManagement {

    public static void main(String[] args) throws IOException {
            //欢迎登陆界面
            show_message_();
            //定义资金
            while (true)
                show_mange_();
    }

    public  static void  show_message_() {

        System.out.println("***********************************************");
        System.out.println("**************欢迎登陆资金管理系统****************");
        System.out.println("******************亲爱的朋友*********************");
        System.out.println("***********************************************");
    }

    public  static  void   show_mange_() throws IOException {

        Scanner  scanner  = new Scanner(System.in);
        System.out.println("请输入你的名字:");
        String username  =   scanner.nextLine();
        System.out.println("请输入你的密码:");
        String password = scanner.nextLine();
        login(username,password);
    }

    public static   void  login(String username, String  password) throws IOException {

        String  pathname = System.getProperty("user.dir")+"/db/user_password_table";
        BufferedReader  in = new BufferedReader(new FileReader(pathname));
        String str;
        while ((str = in.readLine()) != null) {
             String [] strings =  str.split("-");
             if (strings[0].equals( username) &&  strings[1].equals(password)) {
                  System.out.println("登陆成功！");
                  show_monny(strings[0]);
                  break;
             }
        }
        in.close();
        System.out.println("你输入的用户密码不对，请重新输入:");
    }

    public  static  void   show_monny(String  user) throws IOException {
          String  pathname = System.getProperty("user.dir")+"/db/many_table";
         // 读入内存
          BufferedReader  in = new BufferedReader(new FileReader(pathname));
          List list =  new ArrayList();
            //List  list = new ArrayList();
          String line = null;
          while (true){
                String strings = in.readLine();
                if (strings == null) {
                    break;
                }
                String [] strings1 =  strings.split("-");
                list.add(Arrays.asList(strings1));
            }
          in.close();


          while (true) {
               System.out.println("点1查看个人资金--点2进行转帐---点0退出");
               Scanner scanner = new Scanner(System.in);
               String number = scanner.nextLine();
               //查询资金
               Pattern pattern = Pattern.compile("[0-9]*");
               boolean is_number = pattern.matcher(number).matches();
               // 查看个人资金
               if (is_number == false){
                    break;
               }
               if(is_number &&  Integer.parseInt(number)==1) {
                     // 读取当前的资金
                   for (int i = 0; i <list.size() ; i++) {
                        List strings = (List) list.get(i);
                        // 如果当前姓名一样
                        if (user.equals(strings.get(1))) {
                            System.out.println(list.get(0));
                            System.out.println(strings);
                            System.out.println("你当前的金额:"+strings.get(3));
                            break;
                        }
                   }
                   continue;
               }

               if(is_number  &&  Integer.parseInt(number)==2) {
                     // 转帐操作
                     Scanner scanner1 = new Scanner(System.in);
                     System.out.println("输入本人姓名：");
                     String  b_name = scanner1.nextLine();
                     System.out.println("输入你要转帐人姓名：");
                     String  move_name = scanner1.nextLine();
                     System.out.println("输入你要转帐的金额：");
                     String  move_many = scanner1.nextLine();
                     if (b_name.equals(user)) {
                         for (int i = 0; i < list.size(); i++) {
                             List list1= (List) list.get(i);
                             String name = (String) list1.get(1);
                             if (b_name.equals(name)){
                                 // 更新金额
                                 Integer integer = Integer.parseInt((String) list1.get(3));
                                 Integer number_= integer - Integer.parseInt(move_many);
                                 list1.set(3,number_.toString());
                             }
                         }

                         //被转账人更新
                         for (int i = 0; i < list.size(); i++) {
                             List list1= (List) list.get(i);
                             if (move_name.equals(list1.get(1))) {
                                 // 更新金额
                                 Integer integer = Integer.parseInt((String)list1.get(3));
                                 Integer number_= integer + Integer.parseInt(move_many);
                                 list1.set(3,number_.toString());
                             }
                         }

                         BufferedWriter  on = new BufferedWriter(new FileWriter(pathname));
                         String str1 = "";
                         for (int i = 0; i < list.size(); i++) {
                             List list1 = (List) list.get(i);
                             str1 += String.join("-" , list1)+"\n";
                          }
                         on.write(str1);
                         on.close();
                         System.out.println("转帐成功！");
                         break;
                     }
               }

              if(is_number ||  Integer.parseInt(number)==0) {
                  break;
              }
        }
    }

}
