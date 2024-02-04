package src.edu.hogwarts;

import java.time.LocalDate;

public class Teacher extends Person {
    private EmpType employment;
    private LocalDate employmentStart;
    private LocalDate employmentEnd;

    public Teacher(EmpType employment, LocalDate employmentStart, LocalDate employmentEnd, String fullName) {
        super(fullName);
        this.employment = employment;
        this.employmentStart = employmentStart;
        this.employmentEnd = employmentEnd;
    }

    public Teacher() {
        super();
        this.employment = EmpType.TEACHER;
        this.employmentStart = LocalDate.now();
        this.employmentEnd = LocalDate.now().plusYears(1);
    }

    public EmpType getEmployment() {
        return employment;
    }

    public void setEmployment(EmpType employment) {
        this.employment = employment;
    }

    public LocalDate getEmploymentStart() {
        return employmentStart;
    }

    public void setEmploymentStart(LocalDate employmentStart) {
        this.employmentStart = employmentStart;
    }

    public LocalDate getEmploymentEnd() {
        return employmentEnd;
    }

    public void setEmploymentEnd(LocalDate employmentEnd) {
        this.employmentEnd = employmentEnd;
    }

    @Override
    public String toString() {
        return "Teacher{\n" +
                "fullName: " + getFullName() + "\n" +
                "employment: " + employment + "\n" +
                "employmentStart: " + employmentStart + "\n" +
                "employmentEnd: " + employmentEnd + "\n" +
                "}";
    }

}
