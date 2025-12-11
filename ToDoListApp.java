package Grades_Project;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String description;
    boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }
}

public class ToDoListApp {
    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    static String filename = "tasks.txt";

    public static void main(String[] args) {
        loadTasks();
        while (true) {
            System.out.println("\n--- To-Do List Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Done");
            System.out.println("3. Delete Task");
            System.out.println("4. View All Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int ch = scan.nextInt();
            scan.nextLine(); // Consume newline
            switch (ch) {
                case 1 -> addTask();
                case 2 -> markTaskAsDone();
                case 3 -> deleteTask();
                case 4 -> viewAllTasks();
                case 5 -> {
                    saveTasks();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addTask() {
        System.out.print("Enter task description: ");
        String description = scan.nextLine();
        Task task = new Task(description);
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    static void markTaskAsDone() {
        System.out.print("Enter task number to mark as done: ");
        int index = scan.nextInt() - 1;
        scan.nextLine(); // Consume newline
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).isDone = true;
            System.out.println("Task marked as done!");
        } else {
            System.out.println("Invalid task number!");
        }
    }

    static void deleteTask() {
        System.out.print("Enter task number to delete: ");
        int index = scan.nextInt() - 1;
        scan.nextLine(); // Consume newline
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Invalid task number!");
        }
    }

    static void viewAllTasks() {
        System.out.println("All Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            String status = task.isDone ? "Done" : "Pending";
            System.out.println((i + 1) + ". " + task.description + " - " + status);
        }
    }

    static void loadTasks() {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                Task task = new Task(parts[0]);
                task.isDone = parts[1].equals("true");
                tasks.add(task);
            }
        } catch (IOException e) {
            // File not found or error reading file
        }
    }

    static void saveTasks() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Task task : tasks) {
                bw.write(task.description + "," + task.isDone);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks!");
        }
    }
}
