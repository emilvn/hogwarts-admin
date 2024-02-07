package src.edu.hogwarts.application;

import src.edu.generic.Controller;
import src.edu.hogwarts.data.HogwartsStudent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

public class StudentController extends Controller<HogwartsStudent> {
    private final ArrayList<HogwartsStudent> students = new ArrayList<>();

    public StudentController() {
        super();
    }

    public StudentController(HogwartsStudent... students) {
        super();
        Collections.addAll(this.students, students);
    }

    public ArrayList<HogwartsStudent> getAll() {
        return students;
    }

    public HogwartsStudent get(UUID id) {
        return students.stream().filter(student -> student.getId().equals(id)).findFirst().orElse(null);
    }

    public void add(HogwartsStudent student) {
        students.add(student);
    }

    public void add(HogwartsStudent[] students) {
        Collections.addAll(this.students, students);
    }

    public void update(UUID id, HogwartsStudent student) {
        var oldStudent = get(id);
        if (oldStudent != null) {
            oldStudent.setFullName(student.getFullName());
            oldStudent.setBirthDate(student.getBirthDate());
            oldStudent.setHouse(student.getHouse());
            oldStudent.setPrefect(student.isPrefect());
            oldStudent.setTeams(student.getTeams());
            oldStudent.setEnrollmentYear(student.getEnrollmentYear());
            oldStudent.setGraduationYear(student.getGraduationYear());
            oldStudent.setGraduated(student.isGraduated());
        }
    }

    public void delete(UUID id) {
        students.removeIf(student -> student.getId().equals(id));
    }
}
