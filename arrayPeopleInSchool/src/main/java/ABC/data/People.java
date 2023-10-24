package ABC.data;

public class People {
   /*  static enum Gender {
        MALE, 
        FEMALE,
        UNKNOWN
    }*/

    String name;
    int age;
    String gender;
    

    public void displayInfor() {
        System.out.printf("------ Name: %s ------\n", this.name);
        System.out.printf("-- Age: %s\n", this.age);
        System.out.printf("-- Gender: %s\n", this.gender);
    }
}
