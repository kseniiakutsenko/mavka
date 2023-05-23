//
// Created by miste on 17.04.2023.
//

#ifndef MAVKA_MAINMATH_H
#define MAVKA_MAINMATH_H

#pragma once

#ifndef MainMath_H
#define MainMath_H

#define _USE_MATH_DEFINES
#include <iostream>
#include <math.h>
#include <cmath>
#include <complex>


const double Radius = 6371000.79;
const double R = 287.058;
const double g = 9.807;

const double PI = 3.141592653589793238463;

class MainMath
{
    double V0;
    double W1;
    double L1;
    double W2;
    double L2;
    double M;
    double B;

    double D = 0;
    double a = 0;

public:
    MainMath(double v0, double w1, double l1, double w2, double l2, double m, double b, double d, double A);
    double distance();
    double V_0_x(double v0, double angle);
    double V_0_y(double v0, double angle);
    double angle();
    double check();
    double range();
    void In_grad();
    void D_new();

};


#endif

#endif //MAVKA_MAINMATH_H
