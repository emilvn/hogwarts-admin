package src.edu.hogwarts.model.course;

import src.edu.generic.Student;
import src.edu.generic.Teacher;
import src.edu.hogwarts.model.HogwartsStudent;

import java.util.ArrayList;
import java.util.UUID;

public class Course {
    private Subject subject;
    private Teacher teacher;
    private ArrayList<HogwartsStudent> students;
    private TeachingMaterial[] materials;
    private final UUID id;

    public Course(Subject subject, Teacher teacher, ArrayList<HogwartsStudent> students, TeachingMaterial[] materials) {
        this.subject = subject;
        this.teacher = teacher;
        this.students = students;
        this.materials = materials;
        this.id = UUID.randomUUID();
    }

    public Course() {
        this(new Subject(), new Teacher(), new ArrayList<>(), new TeachingMaterial[0]);
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ArrayList<HogwartsStudent> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<HogwartsStudent> students) {
        this.students = students;
    }

    public TeachingMaterial[] getMaterials() {
        return materials;
    }

    public void setMaterials(TeachingMaterial... materials) {
        this.materials = materials;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder studentString = new StringBuilder();
        StringBuilder materialString = new StringBuilder();
        if (!students.isEmpty()) {
            for (Student student : students) {
                studentString.append(student.getFirstName()).append(", ");
            }
            studentString.replace(studentString.lastIndexOf(", "), studentString.length() - 1, ".");
        }
        if (materials.length > 0) {
            for (TeachingMaterial material : materials) {
                materialString.append(material.getName()).append(", ");
            }
            materialString.replace(materialString.lastIndexOf(", "), materialString.length() - 1, ".");
        }

        return "Course{\n" +
                " id: " + id + "\n" +
                " subject: " + subject.getName() + "\n" +
                " teacher: " + teacher.getFullName() + "\n" +
                " students: " + studentString + "\n" +
                " materials: " + materialString + "\n" +
                "}";
    }


}
