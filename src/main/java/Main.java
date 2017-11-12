import project.entities.StudentsEntity;
import project.services.StudentsService;

import java.util.stream.Collectors;

public class Main {

    public static void main(final String[] args) throws Exception {
        StudentsEntity student = new StudentsEntity();
        StudentsService studentsService = new StudentsService();
        /*student.setId("adasdasdasdasdasdasd");
        student.setName("Alex");
        student.setSurname("Sokolov");
        //studentsService.addStudent(student);*/
        System.out.println(studentsService.getAllStudents().stream()
                .map(s -> s.getId())
                .collect(Collectors.toList()));
    }
}