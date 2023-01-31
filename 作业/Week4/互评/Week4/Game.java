import animals.*;
import prop.Plate;
import prop.Record;
import prop.Watermelon;

import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

public class Game {

    public static void main(String[] args) {
        System.out.println("观众朋友们，大家好，一年一度的吃西瓜大赛又开始了。");
        System.out.println("让我们欢迎我们今年的选手：");
        System.out.println("");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) { }
        Vector<Animals> players = new Vector<Animals>();
        players.add(new Rabbit(10));
        players.add(new Pig(30));
        players.add(new Elephant(28));
        players.add(new Monkey(18));
        players.add(new Lion(24));
        for (Animals each : players) {
            System.out.println(each.getName() + ": " + each.say());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
        }
        Plate<Watermelon> p;
        Record[] record = new Record[5];
        int index = 0;
        System.out.println("");
        for (Animals each : players) {
            System.out.println("好的，接下来有请" + each.getName() + "开始吃西瓜，计时开始");
            p = new Plate<>(10);
            Random seed = new Random(1);
            for (int i = 0; i < 10; i++) {
                p.add(new Watermelon(seed.nextInt(20)));
            }
            for (int i = 0; i < 10; i++) {
                System.out.print(".");
                System.out.flush();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) { }
            }
            record[index] = new Record(each.getName(), each.eatWatermelon(p));
            System.out.println("");
            System.out.printf("总共花费了%.2fs的时间。非常不错的成绩\n", record[index].getTime());
            System.out.println("");
            index++;
        }
        Arrays.sort(record);
        System.out.println("接下来公布成绩：");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) { }
        for (int i = 0; i < 5; i++) {
            System.out.print("第" + (i + 1) + "名是");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
            System.out.println(record[i].getName());
        }
    }

}

