import java.util.ArrayList;

public class TaskManager{
    private ArrayList<Task> tasks;

    public TaskManager(){
        tasks = new ArrayList<>();
    }
    public void addTask(Task task){
        tasks.add(task);
    }
    public Task findTaskById(int id){
        for (Task task : tasks){
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
    public boolean updateTask(int id, String newDescription){
        Task task = findTaskById(id);
        if (task != null) {
            task.setDescription(newDescription);
            return true;
        }
        return false;
    }
    public boolean markInProgress(int id){
        Task task = findTaskById(id);

        if (task != null){
            task.setStatus("in-progress");
            return true;
        }
        return false;
    }
    public void listTasks(){
        if(tasks.isEmpty()){
            System.out.println("No tasks found.");
            return;
        }
        for (Task task : tasks){
            System.out.println(task);
        }
    }

    public boolean deleteTask(int id){
        Task task = findTaskById(id);

        if(task != null){
            tasks.remove(task);
            return true;
        }
        return false;
    }
    public boolean markDone(int id){

    Task task = findTaskById(id);

    if(task != null){
        task.setStatus("done");
        return true;
    }

    return false;
    }
    public void listTasksByStatus(String status){
        boolean found = false;

        for (Task task : tasks){
            if(task.getStatus().equals(status)){
                System.out.println(task);
                found = true;
            }
        }

        if (!found){
            System.out.println("No tasks with status: " + status);
        }
    }
    public ArrayList<Task> getTasks(){
        return tasks;
    }
}
