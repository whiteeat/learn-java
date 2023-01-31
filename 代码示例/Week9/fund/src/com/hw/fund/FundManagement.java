package com.hw.fund;

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
        // 欢迎界面
        showMessage();
        // 登录并处理资金
        doBusiness();
    }

    public static void showMessage() {
        System.out.println("***********************************************");
        System.out.println("**************欢迎登陆资金管理系统****************");
        System.out.println("******************亲爱的朋友*********************");
        System.out.println("***********************************************");
    }

    public static void doBusiness() throws IOException {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入你的名字(名字为空则退出系统):");
            String username = scanner.nextLine();
            if ("".equals(username))
                break;
            System.out.println("请输入你的密码(不会显示出来):");
            String password = new String(System.console().readPassword());

            if (!checkUser(username, password)) {
                System.out.println("你输入的用户密码不对，请重新输入:");
                continue;
            }
            System.out.println(username + "，你好，你已成功登录");
            doMoneyLoop(username);
        }
    }

    public static void doMoneyLoop(String user) throws IOException {
        // 读入内存
        List<List<String>> moneyList = loadMoneyData();

        while (true) {
            System.out.println("点1查看个人资金--点2进行转帐---点0退出当前用户");
            Scanner scanner = new Scanner(System.in);
            String operationType = scanner.nextLine();
            if ("0".equals(operationType)) {
                break;
            } else if ("1".equals(operationType)) {
                // 读取当前的资金
                for (List<String> record : moneyList) {
                    // 如果当前姓名一样
                    if (user.equals(record.get(1))) {
                        System.out.println(moneyList.get(0));
                        //System.out.println(record);
                        System.out.println("你当前的金额:" + record.get(3));
                        break;
                    }
                }
            } else if ("2".equals(operationType)) {
                // 转帐操作
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("输入本人姓名：");
                String b_name = scanner1.nextLine();
                System.out.println("输入你要转帐人姓名：");
                String move_name = scanner1.nextLine();
                System.out.println("输入你要转帐的金额：");
                String move_many = scanner1.nextLine();
                if (b_name.equals(user)) {
                    for (int i = 0; i < moneyList.size(); i++) {
                        List<String> record = moneyList.get(i);
                        String name = (String) record.get(1);
                        if (b_name.equals(name)) {
                            // 更新金额
                            Integer oldNum = Integer.parseInt(record.get(3));
                            Integer newNum = oldNum - Integer.parseInt(move_many);
                            record.set(3, newNum.toString());
                        }
                    }

                    // 被转账人更新
                    for (int i = 0; i < moneyList.size(); i++) {
                        List<String> record = moneyList.get(i);
                        if (move_name.equals(record.get(1))) {
                            // 更新金额
                            Integer oldNum = Integer.parseInt(record.get(3));
                            Integer newNum = oldNum + Integer.parseInt(move_many);
                            record.set(3, newNum.toString());
                        }
                    }
                    // 保存数据
                    saveData(moneyList);
                    System.out.println("转帐成功！");
                }
            }
        }
    }

    private static boolean checkUser(String username, String password) throws FileNotFoundException, IOException {
        String pathname = "./data/user_table";
        try (BufferedReader in = new BufferedReader(new FileReader(pathname))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] fields = line.split("-");
                if (fields[0].equals(username) && fields[1].equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static String dataFilePath = "./data/money_table";

    private static List<List<String>> loadMoneyData() throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader(dataFilePath));
        List<List<String>> records = new ArrayList<>();
        while (true) {
            String line = in.readLine();
            if (line == null) {
                break;
            }
            String[] fields = line.split("-");
            records.add(Arrays.asList(fields));
        }
        in.close();
        return records;
    }

    private static void saveData(List<List<String>> records) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < records.size(); i++) {
            List<String> record = records.get(i);
            sb.append(String.join("-", record) + "\n");
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(dataFilePath));
        writer.write(sb.toString());
        writer.close();
    }

}
