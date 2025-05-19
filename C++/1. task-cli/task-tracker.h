#ifndef TASK_CLI_TASK_TRACKER_H
#define TASK_CLI_TASK_TRACKER_H

#include <iostream>
#include <ctime>
#include <utility>
#include <fstream>

enum status_t{
    TODO,
    IN_PROGRESS,
    DONE
};

class task_t{
public:
    unsigned int id;
    std::string description;

    time_t createdAt;
    time_t updatedAt;
    status_t status;

    task_t(int id, std::string desc);
    ~task_t();

    void update(status_t new_status, const std::string& desc);
};

#endif //TASK_CLI_TASK_TRACKER_H
