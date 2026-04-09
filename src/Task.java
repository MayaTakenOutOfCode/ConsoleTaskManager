public class Task{
    protected int id;
    private String name;
    private String description;
    private Priority priority;
    private boolean done;

    public Task(int id, String name, String description, Priority priority){
        this.id = id;
        this.priority = priority;
        this.name = name;
        this.description = description;
        this.done = false;
    }

    public int getId() {
        return id;
    }

    public String getPriority() {
        return priority.toString();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getDone(){
        if(done) {
            return "Done";
        }
        return "To-Do";
    }

    public String getName() {
        return this.name;
    }
}