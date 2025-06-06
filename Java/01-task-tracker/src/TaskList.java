import java.io.*;
import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;
    final private String filename;

    public TaskList(String filename) {
        tasks = new ArrayList<>();
        this.filename = filename;
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public void addTask(String description){
        SimpleDate d = new SimpleDate();
        Task newTask = new Task(getHighestUnusedID(), description, Status.TODO, d);
        tasks.add(newTask);
    }

    public void updateTask(int id, String description){
        Task task = findTask(id);
        if(task != null){
            SimpleDate d = new SimpleDate();
            task.setDescription(description);
            task.setUpdatedAt(d);
        }else{
            System.out.println("Task not found");
        }
    }

    public void listTasks(){
        for(Task task : tasks){
            System.out.println(task.toString());
        }
    }
    public void listTasks(Status status){
        for(Task task : tasks){
            if(task.getStatus() == status) System.out.println(task.toString());
        }
    }


    public void updateTaskStatus(int id, Status status){
        Task task = findTask(id);
        if(task != null){
            task.setStatus(status);
            SimpleDate d = new SimpleDate();
            task.setUpdatedAt(d);
        }else{
            System.out.println("Task not found");
        }
    }

    private int getHighestUnusedID(){
        int maxID = 0;
        for(Task task : tasks){
            int temp = task.getId();
            if(temp > maxID){
                maxID = temp;
            }
        }
        return maxID + 1;
    }

    private Task findTask(int id){
        for(Task task : tasks){
            if(task.getId() == id){
                return task;
            }
        }
        return null;
    }


    public void saveTasks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("[\n");
            for (int i = 0; i < tasks.size(); i++) {
                writer.write(tasks.get(i).toJson());
                if (i != tasks.size() - 1) {
                    writer.write(",\n");
                } else {
                    writer.write("\n");
                }
            }
            writer.write("]");
        } catch (IOException e) {
            System.out.println("Error while saving file: " + e.getMessage());
        }
    }

    public void loadTasks() {
        StringBuilder jsonContent = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line.trim());
            }
        } catch (IOException e) {
            System.out.println("Error while reading file: " + e.getMessage());
            return;
        }

        String json = jsonContent.toString();
        json = json.substring(1, json.length() - 1);
        String[] items = json.split("\\},\\{");

        for (String item : items) {
            if (!item.startsWith("{")) item = "{" + item;
            if (!item.endsWith("}")) item = item + "}";

            Task t = parseTaskFromString(item);
            tasks.add(t);
        }
    }
    private Task parseTaskFromString(String json) {
        int id = Integer.parseInt(getField(json, "id"));
        String description = getField(json, "description");
        Status status = Status.valueOf(getField(json, "status"));
        String createdAtStr = getField(json, "createdAt");
        String updatedAtStr = getField(json, "updatedAt");

        SimpleDate createdAt = new SimpleDate(createdAtStr);
        SimpleDate updatedAt = new SimpleDate(updatedAtStr);

        Task task = new Task(id, description, status, createdAt);
        task.setUpdatedAt(updatedAt);
        return task;
    }

    private String getField(String json, String fieldName) {
        String search = "\"" + fieldName + "\":\"";
        int start = json.indexOf(search) + search.length();
        int end = json.indexOf("\"", start);
        return json.substring(start, end);
    }

}
