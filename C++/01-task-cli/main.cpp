// https://roadmap.sh/projects/task-tracker

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
// JSON: {
// "task1":{"id":"1","description":"task_desc","createdat" : "date","updatedat":"date"},
// }

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