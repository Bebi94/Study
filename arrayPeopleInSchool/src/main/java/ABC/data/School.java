package ABC.data;
import java.util.ArrayList;

public class School {
    ArrayList<Teacher> teachers = new ArrayList<Teacher>(10);
    ArrayList<Student> students = new ArrayList<Student>(10);

    public void listTeacher(){
        for(int i = 0; i < teachers.size(); i++){
       System.out.printf("Giao vien thu \n: \n", i, teachers.get(i));
        }
    }

    
}
