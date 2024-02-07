package src.edu.generic;

import src.edu.hogwarts.enums.EmpType;

import java.time.LocalDate;

public class Teacher extends Person {
    private final EmpType role = EmpType.TEACHER;
    private LocalDate employmentStart;
    private LocalDate employmentEnd;

    public Teacher(LocalDate employmentStart, LocalDate employmentEnd, String fullName, LocalDate birthDate) {
        super(fullName, birthDate);
        this.employmentStart = employmentStart;
        this.employmentEnd = employmentEnd;
    }

    public Teacher() {
        super();
        this.employmentStart = LocalDate.now();
        this.employmentEnd = LocalDate.now().plusYears(1);
    }

    public EmpType getRole() {
        return role;
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
                "employment: " + role + "\n" +
                "employmentStart: " + employmentStart + "\n" +
                "employmentEnd: " + employmentEnd + "\n" +
                "}";
    }

}
