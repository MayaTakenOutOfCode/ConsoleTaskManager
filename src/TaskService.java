import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public void addTask(String name, String description, String priority){
        try{
            Priority priorityEnum = Priority.LOW;
            priority = priority.toUpperCase();
            priorityEnum = Enum.valueOf(priorityEnum.getDeclaringClass(), priority);
            Task userTask = new Task(nextId,name, description, priorityEnum);
            tasks.add(userTask);
            nextId++;
        }catch(Exception e){
            System.out.println("Fallback, wrong selection, in result: priority = LOW");
        }
    }

    public void removeTask(int taskId){
        try{
            tasks.removeIf(task -> task.getId() == taskId);
        }catch(Exception e){
            System.out.println("Something went wrong...");
        }
    }
    public void markAsDone(int taskId){
        boolean isFound = false;
        for(Task task : tasks){
            if(taskId == task.getId()){
                isFound = true;
                task.setDone(true);
                break;
            }
        }
        if (isFound) {
            System.out.println("The task is done! Specified id: " + taskId);
        } else {
            System.out.println("Task not found, ID doesn't exist! ID specified: " + String.valueOf(taskId));
        }
    }
    public void getAllTasks(){
        StringBuilder allTasks = new StringBuilder();
        if(tasks.isEmpty()){
            System.out.println("No tasks avalible!");
        }else{
            for(Task task : tasks) {
                StringBuilder taskString = new StringBuilder();
                taskString.append(task.getId())
                        .append(".").append(task.getName())
                        .append(", ").append(task.getDescription())
                        .append(", State: ")
                        .append(task.getDone())
                        .append(", Priority: ")
                        .append(task.getPriority())
                        .append("\n--------------------------------\n");
                allTasks.append(taskString);
            }
            System.out.println(allTasks);
        }
    }
}