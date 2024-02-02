package src.edu.hogwarts;

public class Student extends Person{
    private int enrollmentYear;
    private int graduationYear;
    private boolean graduated;

    public Student(){
        super();
    }
    public Student(String fullName){
        this(-1, -1, false, fullName);
    }
    public Student(int enrollmentYear, int graduationYear){
        this(enrollmentYear, graduationYear, false, null);
    }
    public Student(int enrollmentYear, String fullName){
        this(enrollmentYear, -1, false, fullName);
    }
    public Student(int enrollmentYear, int graduationYear, String fullName){
        this(enrollmentYear, graduationYear, false, fullName);
    }
    public Student(int enrollmentYear, int graduationYear, boolean graduated){
        this(enrollmentYear, graduationYear, graduated, null);
    }
    public Student(int enrollmentYear, int graduationYear, boolean graduated, String fullName){
        super(fullName);
        this.enrollmentYear = enrollmentYear;
        this.graduationYear = graduationYear;
        this.graduated = graduated;
    }

    public int getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(int enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }

    @Override
    public String toString() {
        return super.toString() + "\nEnrollment year: " + enrollmentYear + "\nGraduation year: " + graduationYear + "\nGraduated: " + graduated;
    }
}
