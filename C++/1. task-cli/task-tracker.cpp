#include "task-tracker.h"

class task_t{

public:
    unsigned int id;
    std::string description;

    time_t createdAt;
    time_t updatedAt;
    status_t status;

    task_t(int id, std::string desc){
        this->id = id;
        this->description = std::move(desc);

        this->createdAt = time(&createdAt);
        this->updatedAt = time(&updatedAt);

        this->status = TODO;
    }

};