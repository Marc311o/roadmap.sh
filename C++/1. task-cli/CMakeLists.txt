cmake_minimum_required(VERSION 3.31)
project(1__task_cli)

set(CMAKE_CXX_STANDARD 17)

add_executable(1__task_cli main.cpp
        task-tracker.cpp
        task-tracker.h)
