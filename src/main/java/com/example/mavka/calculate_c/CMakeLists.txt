cmake_minimum_required(VERSION 3.26.4)
project("mavka")

find_package(JNI REQUIRED)
include_directories(${JNI_INCLUDE_DIRS})

set(JAVA_HOME "C:\\Program Files\\Java\\jdk-20" CACHE PATH "C:\\Program Files\\Java\\jdk-20")
include_directories(${JAVA_HOME}/include)
include_directories(${JAVA_HOME}/include/win32)

add_library(
             mavka
             SHARED
             mavka.cpp
        )
add_library(
            MainMath
            SHARED
            MainMath.cpp
)
add_library(
            LambertW
            SHARED
            LambertW.cpp
)
