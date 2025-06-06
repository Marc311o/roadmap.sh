public class Task {

    private int id;
    private String description;
    private Status status;
    private SimpleDate createdAt;
    private SimpleDate updatedAt;

    public Task(int id, String description, Status status, SimpleDate createdAt) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = createdAt;

    }

    public void update(SimpleDate updatedAt, Status status) {
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public String toJson(){
        return String.format("{\"id\":\"%d\",\"description\":\"%s\",\"status\":\"%s\",\"createdAt\":\"%s\",\"updatedAt\":\"%s\"}", id, description, status, createdAt.toString(), updatedAt.toString());
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Description: %s | Status: %s | Created at: %s | Updated at: %s", id, description, status, createdAt.toString(), updatedAt.toString());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setUpdatedAt(SimpleDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
