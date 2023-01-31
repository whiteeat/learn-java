package com.hauweicloud;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class Calculate {

    public static void main(String[] args) throws Exception {
        System.out.println(multi(9, 3));
        System.out.println(devision(9, 3));
        System.out.println(add(9, 3));
        System.out.println(sub(9, 3));
    }

    public interface CLibrary extends Library {
        CLibrary INSTTANCE = 
			(CLibrary) Native.loadLibrary("test", CLibrary.class);

        int Add(int a, int b);

        int Sub(int a, int b);
    }

    public static int add(int a, int b) {
        return CLibrary.INSTTANCE.Add(a, b);
    }

    public static int sub(int a, int b) {
        return CLibrary.INSTTANCE.Sub(a, b);
    }

    public static double multi(double a, double b) {
        return a * b;
    }

    public static double devision(double a, double b) throws Exception {
        if (0.0 == b) {
            throw new Exception("除数不能为0");
        }
        return a / b;
    }
}
