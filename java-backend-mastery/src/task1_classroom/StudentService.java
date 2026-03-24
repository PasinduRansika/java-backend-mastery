package task1_classroom;

import java.util.LinkedList;
import java.util.List;

public class StudentService{
    private List<Student> studentsList = new LinkedList<>();

    public List getStudentsList()<Student() {
        return studentsList;
    }

    public void addStudentToList(Student student){
        studentsList.add(student);
    }

    public void addStudentToFront(Student student){
        studentsList.addFirst(student);
    }

    public List<Student> getTopPerformance() {
        return studentsList.stream().filter(s -> s.getGpa() > 3.5)
                .toList();
    }

}

