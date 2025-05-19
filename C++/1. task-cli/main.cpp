#include <iostream>
#include "task-tracker.h"
#include <string>
#include <vector>

using namespace std;

int readlist(string filename){
    return 0;
}

int readtask(task_t& task){
    return 0;
}
// JSON: { "1" :    }

int main(int argc, char** argv) {

    if(argc < 1 || argc > 3){
        cout << "Invalid number of arguments!" << endl;
        return -1;
    }

    vector<string> all_args;
    all_args.assign(argv + 1, argv + argc);

    vector<task_t> tasks;





    return 0;

}