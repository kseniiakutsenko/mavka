package com.example.mavka.angle;

public class NativeCallsClass {
    static {
        System.loadLibrary("mavka");
    }

    native public static double getA(double cr_1, double cr_2, double cr_3, double cr_4, double temp_m, int num);
}
