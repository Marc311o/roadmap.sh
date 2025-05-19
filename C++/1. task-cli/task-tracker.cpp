#include "task-tracker.h"

task_t::task_t(int id, std::string desc){
    this->id = id;
    this->description = std::move(desc);

    this->createdAt = time(&createdAt);
    this->updatedAt = time(&updatedAt);

    this->status = TODO;
}

task_t::~task_t() = default;

void task_t::update(status_t new_status, const std::string& desc){
    if(!desc.empty()){
        this->description = desc;
    }
    this->status = new_status;
    this->updatedAt = time(&updatedAt);
}


