public class TaskApp {

    static TaskList tasklist = new TaskList("tasks.json");

    public static void main(String[] args) {

        tasklist.loadTasks();
        //TODO: user interaction
        tasklist.listTasks();
        tasklist.saveTasks();
    }
}
