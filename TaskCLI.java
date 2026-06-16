public class TaskCLI {
    public static void main(String[] args){
        TaskManager manager = new TaskManager();

        if(args.length == 0) {
            System.out.println("Tell me what to do,");
            return;
        }
        String command = args[0];
        switch(command){
            case "add":
                System.out.println("Add command selected.");
                break;

            case "update":
                System.out.println("Update command selected.");
                break;
            case "delete":
                System.out.println("Delete command selected.");
                break;
            case "mark-done":
                System.out.println("Mark done command selected");
                break;
            case "mark-in-progress":
                System.out.println("Mark in progress command selected.");
                break;
            case "list":
                System.out.println("List command selected.");
                break;
            default:
                System.out.println("Unkown command.");
        }
    }
}
