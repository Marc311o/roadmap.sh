// https://roadmap.sh/projects/task-tracker

#include <iostream>
#include "task-tracker.h"
#include <string>
#include <vector>

using namespace std;

int readlist(string filename){
    return 0;
}

status_t parse_status(const std::string& str) {
    if (str == "TODO") return status_t::TODO;
    if (str == "IN_PROGRESS") return status_t::IN_PROGRESS;
    if (str == "DONE") return status_t::DONE;
    throw std::runtime_error("Unknown status: " + str);
}

std::string trim(const std::string& s) {
    size_t start = s.find_first_not_of(" \t\n\r\"");
    size_t end = s.find_last_not_of(" \t\n\r\"");
    return (start == std::string::npos) ? "" : s.substr(start, end - start + 1);
}

std::string get_value(const std::string& line) {
    size_t colon = line.find(':');
    if (colon == std::string::npos) return "";
    return trim(line.substr(colon + 1));
}

std::vector<task_t> load_tasks_from_json(const std::string& filename) {
    std::ifstream file(filename);
    if (!file) {
        throw std::runtime_error("Cannot open file: " + filename);
    }

    std::vector<task_t> tasks;
    std::string line;
    int id = 0;
    std::string description;
    time_t createdAt = 0, updatedAt = 0;
    status_t status;

    while (std::getline(file, line)) {
        line = trim(line);
        if (line.find("\"id\"") == 0) {
            id = std::stoi(get_value(line));
        } else if (line.find("\"description\"") == 0) {
            description = get_value(line);
        } else if (line.find("\"createdAt\"") == 0) {
            createdAt = std::stol(get_value(line));
        } else if (line.find("\"updatedAt\"") == 0) {
            updatedAt = std::stol(get_value(line));
        } else if (line.find("\"status\"") == 0) {
            status = parse_status(get_value(line));
        } else if (line.find("}") != std::string::npos) {
            task_t task(id, description);
            task.createdAt = createdAt;
            task.updatedAt = updatedAt;
            task.status = status;
            tasks.push_back(task);
        }
    }

    return tasks;
}

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