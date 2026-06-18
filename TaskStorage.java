import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.io.FileWriter;

public class TaskStorage{

    public TaskStorage(){
        createFileIfNeeded();
    }

    private void createFileIfNeeded(){
        File file = new File("tasks.json");
        try {
            if(!file.exists()){
                file.createNewFile();
                System.out.println("tasks.json created.");
            }
        }catch (IOException e){
            System.out.println("Error creating file.");
        }
    }

    public void saveTasks(ArrayList<Task> tasks){
        try {
            FileWriter writer = new FileWriter("tasks.json");
            writer.write("[\n");
            for (int i = 0; i < tasks.size(); i++){
                Task task = tasks.get(i);

                writer.write(
                    " {\n" + "  \"id\": " + task.getId() + ",\n" + "  \"description\": \"" + task.getDescription() + "\",\n" + "  \"status\": \" "+ task.getStatus() + "\",\n" + "  \"createdAt\": \" " + task.getCreatedAt() + "\",\n" + "  \"updatedAt\": \"" + task.getUpdatedAt() + "\"\n" + " }");
                
                if (i < tasks.size() - 1){
                    writer.write(",");
                }

                writer.write("\n");
            }
            writer.write("]");
            writer.close();
        } catch(IOException e){
            System.out.println("Error saving tasks.");
        }

    }

public ArrayList<Task> loadTasks() {

    ArrayList<Task> tasks = new ArrayList<>();

    try {

        File file = new File("tasks.json");

        if (!file.exists() || file.length() == 0) {
            return tasks;
        }

        String content = Files.readString(file.toPath());

        content = content.trim();

        if (content.equals("[]")) {
            return tasks;
        }

        String[] objects = content.split("\\},\\s*\\{");

        for (String object : objects) {

            object = object.replace("[", "")
                           .replace("]", "")
                           .replace("{", "")
                           .replace("}", "");

            String[] fields = object.split(",");

            int id = 0;
            String description = "";
            String status = "";
            String createdAt = "";
            String updatedAt = "";

            for (String field : fields) {

                String[] keyValue = field.split(":", 2);

                String key = keyValue[0]
                        .replace("\"", "")
                        .trim();

                String value = keyValue[1]
                        .replace("\"", "")
                        .trim();

                switch (key) {

                    case "id":
                        id = Integer.parseInt(value);
                        break;

                    case "description":
                        description = value;
                        break;

                    case "status":
                        status = value;
                        break;

                    case "createdAt":
                        createdAt = value;
                        break;

                    case "updatedAt":
                        updatedAt = value;
                        break;
                }
            }

            Task task = new Task(
                    id,
                    description,
                    status,
                    createdAt,
                    updatedAt
            );

            tasks.add(task);
        }

    } catch (IOException e) {

        System.out.println("Error loading tasks.");
    }

    return tasks;
}
}
