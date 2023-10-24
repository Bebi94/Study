package ABC.data;

public class Teacher extends People {
    String employeeID;
    String subject;


    public Teacher(String name, int age, String gender, String employeeID, String subject){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.employeeID = employeeID;
        this.subject = subject;
    }

    static void teach(){
        System.out.println("Teach");
    }

    public void displayInfor(){
        super.displayInfor();
        System.out.printf("-- Student ID: %s\n", this.employeeID);
        System.out.printf("-- Grade: %s\n", this.subject);
    }
    
}
