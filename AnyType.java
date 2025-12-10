class AnyType {
    public static void main(String[] args) {
        Portal portal = new Portal();
        
        Student stu = new Student();
        Staff staff = new Staff();
        Admin admin = new Admin();
        
        portal.SignIn(stu);
        portal.SignIn(staff);
        portal.SignIn(admin);
    }
}
class Portal {
    public void SignIn(Student stu) {
        System.out.println("Hello Student!");
    }
    public void SignIn(Staff staff) {
        System.out.println("Hello Staff!");
    }
    public void SignIn(Admin admin) {
        System.out.println("Hello Admin!");
    }
}
class Student {
    public static int id;
}
class Staff {
    public static int id;
}
class Admin {
    public static int id;
}
