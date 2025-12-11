package Grades_Project;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
}

public class LibraryManagementSystem {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add New Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. View All Books");
            System.out.println("5. View Issued Books");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int ch = scan.nextInt();
            scan.nextLine(); // Consume newline
            switch (ch) {
                case 1 -> addBook();
                case 2 -> issueBook();
                case 3 -> returnBook();
                case 4 -> viewAllBooks();
                case 5 -> viewIssuedBooks();
                case 6 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = scan.nextInt();
        scan.nextLine(); // Consume newline
        System.out.print("Enter Book Title: ");
        String title = scan.nextLine();
        System.out.print("Enter Book Author: ");
        String author = scan.nextLine();

        Book book = new Book(id, title, author);
        books.add(book);
        System.out.println("Book added successfully!");
    }

    static void issueBook() {
        System.out.print("Enter Book ID: ");
        int id = scan.nextInt();
        scan.nextLine(); // Consume newline
        for (Book book : books) {
            if (book.id == id && !book.isIssued) {
                book.isIssued = true;
                System.out.println("Book issued successfully!");
                return;
            } else if (book.id == id && book.isIssued) {
                System.out.println("Book is already issued!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    static void returnBook() {
        System.out.print("Enter Book ID: ");
        int id = scan.nextInt();
        scan.nextLine(); // Consume newline
        for (Book book : books) {
            if (book.id == id && book.isIssued) {
                book.isIssued = false;
                System.out.println("Book returned successfully!");
                return;
            } else if (book.id == id && !book.isIssued) {
                System.out.println("Book is not issued!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    static void viewAllBooks() {
        System.out.println("All Books:");
        for (Book book : books) {
            System.out.println("ID: " + book.id + ", Title: " + book.title + ", Author: " + book.author + ", Issued: " + book.isIssued);
        }
    }

    static void viewIssuedBooks() {
        System.out.println("Issued Books:");
        for (Book book : books) {
            if (book.isIssued) {
                System.out.println("ID: " + book.id + ", Title: " + book.title + ", Author: " + book.author);
            }
        }
    }
}
