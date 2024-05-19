import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskListApp {
    private static ArrayList<String> tasks = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        mainMenu();
        while(true) {   
            try {
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        addTask();
                        break;
                    case 2:
                        removeTask();
                        break;
                    case 3:
                        listTasks();
                        break;
                    case 4:
                        System.out.println("Exiting the TaskList application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try entering a valid choice.");
                }
            } 
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine();
            }
        }
    }

    private static void mainMenu() {
        System.out.println("\nTask List Application (MAIN MENU) : ");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. List Tasks");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addTask() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the task description to add : ");
        String task = input.nextLine();
        tasks.add(task);
        System.out.println(task + " Task added.");
        continueApp();
    }

    private static void removeTask() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the task number to remove: ");
        int taskNumber = input.nextInt();

        if (taskNumber < 1 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number. Please try again.");
        } else {
            String deleted = tasks.remove(taskNumber - 1);
            System.out.println(deleted + " Task removed.");
        }
        continueApp();
    }

    private static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("TaskList is Empty - No tasks to display.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
        continueApp();
    }

    private static void continueApp() {
        Scanner input = new Scanner(System.in);
        System.out.print("Do you want to continue using Application(Y/N): ");
        char ch = input.next().charAt(0);
        if(ch=='y'|| ch == 'Y') {
            mainMenu();
        }
        else {
            System.exit(0);
        }
    }
}
