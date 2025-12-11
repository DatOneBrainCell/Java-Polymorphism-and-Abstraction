import java.sql.*;
import java.util.Scanner;

public class StudentManagementJDBC {
    static final String URL = "jdbc:mysql:                             
    static final String USER = "//localhost:3306/student_db";
    static final String USER = "root";
    static final String PASS = "";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Class.forName("main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("MySQL Driver not found!");
        }

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.print("Enter choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> searchStudent();
                case 4 -> deleteStudent();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addStudent() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.print("addStudent() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.print("Enter Roll No: ");
            int rollNo = sc.nextInt();
            sc.nextLine();                   
            System.out.print("// Consume newline
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Age: ");
            int age = sc.nextInt();

            PreparedStatement ps = con.prepareStatement("INSERT INTO students(rollno, name, age) VALUES(?,?,?)");
            ps.setInt(1, rollNo);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            printSQLError(e);
        }
    }

    static void viewStudents() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("viewStudents() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                System.out.println("Roll No: " + rs.getInt("rollno") + ", Name: " + rs.getString("name") + ", Age: " + rs.getInt("age"));
            }
        } catch (SQLException e) {
            printSQLError(e);
        }
    }

    static void searchStudent() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.print("searchStudent() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.print("Enter Roll No: ");
            int rollNo = sc.nextInt();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM students WHERE rollno=?");
            ps.setInt(1, rollNo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Roll No: " + rs.getInt("rollno") + ", Name: " + rs.getString("name") + ", Age: " + rs.getInt("age"));
            } else {
                System.out.println("Student not found!");
            }
        } catch (SQLException e) {
            printSQLError(e);
        }
    }

    static void deleteStudent() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.print("deleteStudent() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.print("Enter Roll No: ");
            int rollNo = sc.nextInt();
            PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE rollno=?");
            ps.setInt(1, rollNo);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found!");
            }
        } catch (SQLException e) {
            printSQLError(e);
        }
    }

    static void printSQLError(SQLException e) {
        System.out.println("printSQLError(SQLException e) {
        System.out.println("\n---- SQL ERROR ----");
        System.out.println("Message : " + e.getMessage());
        System.out.println("SQLState : " + e.getSQLState());
        System.out.println("ErrorCode : " + e.getErrorCode());
        e.printStackTrace();
        System.out.println("-------------------\n");
    }
}
