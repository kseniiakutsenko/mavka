#include "MainMath.h"
#include "LambertW.h"
#include "com_example_mavka_angle_NativeCallsClass.h"
#define _USE_MATH_DEFINES
#include <jni.h>
#include <iostream>
#include <math.h>
#include <cmath>
#include <complex>


//extern "C" JNIEXPORT jdouble JNICALL
JNIEXPORT double JNICALL Java_com_example_mavka_angle_NativeCallsClass_getA(JNIEnv *env, jobject thiz, double cr_1, double cr_2, double cr_3, double cr_4, double temp_m, int num){

using namespace std;

    cout.precision(3);
    double w1, l1, w2, l2, D, a, L_max, A, m, b, d_new, diff_O, diff_fi;
    double v0 = 980;
    double LO, g = 9.80665, p = 101325, T = 293.15, h = 0, L = 0.0065, M = 0.0289644, R = 287.058, Cd = 0.3, d = 0.15471, t;
    w1 = cr_1;
    l1 = cr_2;
    w2 = cr_3;
    l2 = cr_4;
    m = temp_m;
    double V_x_0, V_y_0;
    double ro = (p/(R*T))*pow((1-((L*h)/T)), (g*M)/(R*L)-1);
    b = ((PI*ro*pow(d, 2))/8)*Cd;

    w1 = (w1 * PI) / 180;
    l1 = (l1 * PI) / 180;
    w2 = (w2 * PI) / 180;
    l2 = (l2 * PI) / 180;
    double trLam;
    trLam = abs(l1 - l2);
    D = Radius * acos(sin(w1) * sin(w2) + cos(w1) * cos(w2) * cos(trLam));
    A = 0.5 * asin((g * D) / pow(v0, 2));
    A = A * 180 / PI;
    L_max = pow(v0, 2) / g;
    double angle_grad = 0, angle, t_under = 0, angle_grad_under = 0;
    int check = 0;
    while(check != 2)
    {
        angle = angle_grad * PI / 180;
        V_x_0 = v0 * cos(angle);
        V_y_0 = v0 * sin(angle);

        t = 2 * sqrt(m / (g * b)) * ((PI / 2) - atan(sqrt((m * g) / b) * (1 / V_y_0)));

        LO = (m / b) * log(1 + 2 * V_x_0 * sqrt(b / (m * g)) *
                               ((PI / 2) - atan(sqrt((m * g) / b) * (1 / V_y_0))));

        if (LO >= (D-3) && LO <= (D+3)) {
            check += 1;

        }
        if (check == 1 && t_under == 0 && angle_grad_under == 0)
        {
            t_under = t;
            angle_grad_under = angle_grad;
        }
        angle_grad += 0.01;
    }
    End:
    if(num == 0)
        return A;
    if(num == 1)
        return L_max;
    if(num == 2)
        return t;
    if(num == 3)
        return angle_grad;
    if(num == 4)
        return D;
    if(num == 5)
        return LO;
    if(num == 6)
        return t_under;
    if(num = 7)
        return angle_grad_under;
}