package src.edu.hogwarts;

public class Student extends Person{
    private int enrollmentYear;
    private int graduationYear;
    private boolean graduated;

    @Override
    public String toString() {
        return super.toString() + "\nEnrollment year: " + enrollmentYear + "\nGraduation year: " + graduationYear + "\nGraduated: " + graduated;
    }
}
