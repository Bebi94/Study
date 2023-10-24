package ABC.data;


public class Student extends People {
    String studentID;
    int grade;

    static void study(){
        System.out.println("Studying");
    }

    public Student(String name, int age, String gender, String studentID, int grade){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.studentID = studentID;
        this.grade = grade;
    }

    public void displayInfor(){
        super.displayInfor();
        System.out.printf("-- Student ID: %s\n", this.studentID);
        System.out.printf("-- Grade: %s\n", this.grade);
    }
}
