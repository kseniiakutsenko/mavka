//
// Created by miste on 17.04.2023.
//

#ifndef MAVKA_LAMBERTW_H
#define MAVKA_LAMBERTW_H

#pragma once

#ifndef LambertW_H
#define LambertW_H

#define _USE_MATH_DEFINES
#include <iostream>
#include <math.h>
#include <cmath>
#include <complex>

/////////////////////////////////////////

using namespace std;

//z * exp(z)
complex<double> zexpz(complex<double> z);


//The derivative of z * exp(z) = exp(z) + z * exp(z)
complex<double> zexpz_d(complex<double> z);

//The second derivative of z * exp(z) = 2. * exp(z) + z * exp(z)
complex<double> zexpz_dd(complex<double> z);

//Determine the initial point for the root finding
complex<double> InitPoint(complex<double> z, int k);

complex<double> LambertW(complex<double> z, int k );



#endif
#endif
