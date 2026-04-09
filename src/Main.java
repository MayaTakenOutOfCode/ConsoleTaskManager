import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean isRunning = true;
        TaskService service = new TaskService();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to ViviDo (CLI version)!");
        while (isRunning) {



            System.out.println(
                    "What would you like to do?\n" +
                            "-----------------------------------------\n" +
                            "0 - Add task\n" +
                            "1 - Remove task\n" +
                            "2 - Show tasks\n" +
                            "3 - Mark task as done\n" +
                            "4 - Exit\n" +
                            "-----------------------------------------"
            );

            System.out.print("Your choice: ");
            int userInput = sc.nextInt();
            sc.nextLine(); // 🔥 FIX: consume newline

            switch (userInput) {

                case 0 -> {
                    System.out.print("Task name: ");
                    String name = sc.nextLine();

                    System.out.print("Task description: ");
                    String desc = sc.nextLine();

                    System.out.print("Priority (LOW/MEDIUM/HIGH): ");
                    String priority = sc.nextLine();

                    service.addTask(name, desc, priority);

                    System.out.println("Task added!");
                }

                case 1 -> {
                    System.out.print("Task ID to remove: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    service.removeTask(id);

                    System.out.println("Task removed (if existed).");
                }

                case 2 -> service.getAllTasks();

                case 3 -> {
                    System.out.print("Task ID to mark as done: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    service.markAsDone(id);
                }

                case 4 -> {
                    System.out.println("Exiting app...");
                    isRunning = false;
                }

                default -> System.out.println("Invalid option.");
            }
        }

        sc.close();
    }
}