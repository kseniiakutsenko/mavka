#include "MainMath.h"
#include "LambertW.h"
#include <math.h>
MainMath::MainMath(double v0, double w1, double l1, double w2, double l2, double m, double b, double d, double A)
{
    V0 = v0;
    W1 = w1;
    L1 = l1;
    W2 = w2;
    L2 = l2;
    M = m;
    B = b;
    D = d;
    a = A;
}
double MainMath::distance()
{
    double trLam;
    trLam = abs(L1 - L2);
    D = R * acos(sin(W1) * sin(W2) + cos(W1) * cos(W2) * cos(trLam));
    return D;
}

double MainMath::V_0_x(double v0, double angle)
{
    double V;
    V = v0 * cos(angle);
    return V;
}

double MainMath::V_0_y(double v0, double angle)
{
    double V;
    V = v0 * sin(angle);
    return V;
}

double MainMath::angle()
{
    a = 0.5 * asin((g * D) / pow(V0, 2));
    a = a * 180 / PI;
    return a;
}

double MainMath::check()
{
    double L;
    a = a * PI / 180;
    L = (pow(V0, 2) * sin(2 * a)) / g;
    return L;
}


double MainMath::range()
{
    double L_max;
    L_max = pow(V0, 2) / g;
    return L_max;
}

void MainMath::In_grad()
{
    W1 = (W1 * PI) / 180;
    L1 = (L1 * PI) / 180;
    W2 = (W2 * PI) / 180;
    L2 = (L2 * PI) / 180;
}

/*void MainMath::D_new()
{
    double diff_O = abs(L1 - L2);
    double diff_fi = abs(W1 - W2);

    complex<double> d_new = (V0 * cos(diff_O) * M) / B * (1.0 - exp(-(B / M) * ((M * g + B * V0 * sin(diff_O) + M * g * LambertW(-(exp(-(M * g + B * V0 * sin(diff_O)) / (M * g)) * (M * g + B * V0 * sin(diff_O))) / (M * g))) / (B * g))));
    cout << d_new << endl;
}*/
