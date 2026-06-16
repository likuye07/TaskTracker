import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class TaskManager{
    private ArrayList<Task> tasks;

    public TaskManager(){
        tasks = new ArrayList<>();
        createdFileIfNeeded();
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
            task.setStatus("In-progress");
            return true;
        }
        return false;
    }
    public void listTasks(){
        if(task.isEmpty()){
            System.out.println("No tasks found.");
            return;
        }
        for (Task task : tasks){
            System.out.println("No tasks found");
            return;
        }
        for (Task task : tasks){
            System.out.println(task);
        }
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
    private void createdFileIfNeeded(){
        File file = new File("tasks.json");
        try {
            if(!file.exists()){
                file.createdNewFile();
                System.out.println("tasks.json created.");
            }
        }catch (IOException e){
            System.out.println("Error creating file.");
        }
    }
    public void saveTasks(){
        try {
            FileWriter writer = new FileWriter("tasks.json");
            writer.write("[\n");
            for (int i = 0; i < tasks.size(); i++){
                Task task = task.get(i);

                writer.write(
                    " {\n" + "  \"id\": " + task.getid() + ",\n" + "  \"description\": \"" + task.getDescription() + "\",\n" + "  \"status\": \" "+ task.getStatus() + "\",\n" + "  \"createdAt\": \" " + task.getCreatedAt() + "\",\n" + "  \"updatedAt\": \"" + task.getUpdatedAt() + "\"\n" + " }");
                
                if (i < tasks.size() - 1){
                    writer.write(",");
                }

                writer.write("\n");
            }
            writer.write("]");
            write.close();
        } catch(IOException e){
            System.out.println("Error saving tasks.");
        }

    }
}
