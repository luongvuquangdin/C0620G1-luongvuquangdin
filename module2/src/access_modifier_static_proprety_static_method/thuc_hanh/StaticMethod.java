package access_modifier_static_proprety_static_method.thuc_hanh;
class Student {
    private int rollno;
    private String name;
    private static String college = "BBDIT";

    //constructor to initialize the variable
    Student(int r, String n) {
        ab++;
        rollno = r;
        name = n;
    }

    //static method to change the value of static variable
    static void change() {
        college = "CODEGYM";
    }
    public static int ab;

    //method to display values
    void display() {
        System.out.println(rollno + " " + name + " " + college);
    }
}


public class StaticMethod {
        public static void main(String args[]) {
            Student.change(); //calling change method

            //creating objects
            Student s1 = new Student(111, "Hoang");
            Student s2 = new Student(222, "Khanh");
            Student s3 = new Student(333, "Nam");

            //calling display method
            s1.display();
            s2.display();
            s3.display();
            System.out.println(Student.ab);
        }
    }
