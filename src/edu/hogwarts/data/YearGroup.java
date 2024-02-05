package src.edu.hogwarts.data;

import src.edu.generic.Student;

import java.time.LocalDate;

public class YearGroup {
    private int schoolYear;
    private LocalDate beginningOfSchoolYear;
    private Student[] students;

    public YearGroup(int schoolYear, LocalDate beginningOfSchoolYear, Student[] students) {
        this.schoolYear = schoolYear;
        this.beginningOfSchoolYear = beginningOfSchoolYear;
        this.students = students;
    }

    public YearGroup() {
        this.schoolYear = 1;
        this.beginningOfSchoolYear = LocalDate.now();
        this.students = new Student[0];
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

    public LocalDate getBeginningOfSchoolYear() {
        return beginningOfSchoolYear;
    }

    public void setBeginningOfSchoolYear(LocalDate beginningOfSchoolYear) {
        this.beginningOfSchoolYear = beginningOfSchoolYear;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student... students) {
        this.students = students;
    }

    @Override
    public String toString() {
        StringBuilder studentString = new StringBuilder();
        for (Student student : students) {
            studentString.append(student).append(", ");
        }
        studentString.replace(studentString.lastIndexOf(", "), studentString.length() - 1, ".");

        return "YearGroup{\n" +
                "schoolYear: " + schoolYear + "\n" +
                "beginningOfSchoolYear: " + beginningOfSchoolYear + "\n" +
                "students: " + studentString + "\n" +
                "}";
    }
}
