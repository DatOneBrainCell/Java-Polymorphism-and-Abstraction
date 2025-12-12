package Grades_Project;

import java.sql.*;
import java.util.Scanner;

public class StudentGradeJDBC {

    static final String URL = "jdbc:mysql://localhost:3306/atm_db";
    static final String USER = "root";
    static final String PASS = "";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Load MySQL Driver (optional but safe)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("MySQL Driver not found!");
        }

        while (true) {
            System.out.println("\n===== STUDENT MARK MANAGEMENT =====");
            System.out.println("1. New Register");
            System.out.println("2. Old Register (Edit)");
            System.out.println("3. Add / Edit Marks");
            System.out.println("4. Show Result");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> newRegister();
                case 2 -> editOldRegister();
                case 3 -> addMarks();
                case 4 -> showResult();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // ---------------- NEW REGISTER -----------------
    static void newRegister() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

            System.out.print("Enter Reg No: ");
            String regno = sc.next();

            PreparedStatement check = con.prepareStatement("SELECT * FROM students WHERE regno=?");
            check.setString(1, regno);
            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                System.out.println("RegNo already exists! Use OLD REGISTER option.");
                return;
            }

            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Mobile: ");
            String mobile = sc.next();

            System.out.print("Enter Email: ");
            String email = sc.next();

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO students(regno,name,mobile,email) VALUES(?,?,?,?)");

            ps.setString(1, regno);
            ps.setString(2, name);
            ps.setString(3, mobile);
            ps.setString(4, email);
            ps.executeUpdate();

            System.out.println("Registration Completed!");
        } catch (SQLException e) {
            printSQLError(e);
        }
    }

    // ---------------- EDIT OLD REGISTER -----------------
    static void editOldRegister() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

            System.out.print("Enter Reg No to Edit: ");
            String regno = sc.next();

            PreparedStatement ps = con.prepareStatement("SELECT * FROM students WHERE regno=?");
            ps.setString(1, regno);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("No record found!");
                return;
            }

            System.out.println("\n----- Old Details -----");
            System.out.println("Name   : " + rs.getString("name"));
            System.out.println("Mobile : " + rs.getString("mobile"));
            System.out.println("Email  : " + rs.getString("email"));

            sc.nextLine();
            System.out.print("\nEnter New Name: ");
            String name = sc.nextLine();

            System.out.print("Enter New Mobile: ");
            String mobile = sc.next();

            System.out.print("Enter New Email: ");
            String email = sc.next();

            PreparedStatement update = con.prepareStatement(
                    "UPDATE students SET name=?, mobile=?, email=? WHERE regno=?");

            update.setString(1, name);
            update.setString(2, mobile);
            update.setString(3, email);
            update.setString(4, regno);
            update.executeUpdate();

            System.out.println("Record Updated!");
        } catch (SQLException e) {
            printSQLError(e);
        }
    }

    // ---------------- ADD / EDIT MARKS -----------------
    static void addMarks() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

            System.out.print("Enter Reg No: ");
            String regno = sc.next();

            PreparedStatement ps = con.prepareStatement("SELECT * FROM students WHERE regno=?");
            ps.setString(1, regno);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("Register not found! Register first.");
                return;
            }

            int java = getMark("Java");
            int python = getMark("Python");
            int c = getMark("C");
            int cpp = getMark("C++");
            int go = getMark("Go");

            PreparedStatement update = con.prepareStatement(
                    "UPDATE students SET java_mark=?, python_mark=?, c_mark=?, cpp_mark=?, go_mark=? WHERE regno=?");

            update.setInt(1, java);
            update.setInt(2, python);
            update.setInt(3, c);
            update.setInt(4, cpp);
            update.setInt(5, go);
            update.setString(6, regno);
            update.executeUpdate();

            System.out.println("Marks Updated Successfully!");

        } catch (SQLException e) {
            printSQLError(e);
        }
    }

    static int getMark(String subject) {
        int mark;
        while (true) {
            System.out.print("Enter " + subject + " Mark (<100): ");
            mark = sc.nextInt();
            if (mark >= 0 && mark <= 100)
                break;
            System.out.println("Invalid mark! Must be between 0 and 100.");
        }
        return mark;
    }

    // ---------------- SHOW RESULT -----------------
    static void showResult() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

            System.out.print("Enter Reg No: ");
            String regno = sc.next();

            PreparedStatement ps = con.prepareStatement("SELECT * FROM students WHERE regno=?");
            ps.setString(1, regno);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("Record not found!");
                return;
            }

            int java = rs.getInt("java_mark");
            int python = rs.getInt("python_mark");
            int c = rs.getInt("c_mark");
            int cpp = rs.getInt("cpp_mark");
            int go = rs.getInt("go_mark");

            int total = java + python + c + cpp + go;
            double percentage = total / 5.0;

            System.out.println("\n===== RESULT =====");
            System.out.println("RegNo       : " + regno);
            System.out.println("Name        : " + rs.getString("name"));
            System.out.println("------------------------");
            System.out.println("Java        : " + java);
            System.out.println("Python      : " + python);
            System.out.println("C           : " + c);
            System.out.println("C++         : " + cpp);
            System.out.println("Go          : " + go);
            System.out.println("------------------------");
            System.out.println("Total       : " + total);
            System.out.println("Percentage  : " + percentage + "%");

        } catch (SQLException e) {
            printSQLError(e);
        }
    }

    // ---------------- PRINT SQL ERROR DETAILS -----------------
    static void printSQLError(SQLException e) {
        System.out.println("\n---- SQL ERROR ----");
        System.out.println("Message   : " + e.getMessage());
        System.out.println("SQLState  : " + e.getSQLState());
        System.out.println("ErrorCode : " + e.getErrorCode());
        e.printStackTrace();
        System.out.println("-------------------\n");
    }
}
