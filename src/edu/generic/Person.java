package src.edu.generic;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthDate;
    private final UUID id;

    public Person() {
        this("Unknown", "Unknown", "Unknown", LocalDate.now());
    }

    public Person(Person person) {
        this(person.getFirstName(), person.getMiddleName(), person.getLastName(), person.getBirthDate());
    }

    public Person(String fullName, LocalDate birthDate) {
        setFullName(fullName);
        this.birthDate = birthDate;
        this.id = UUID.randomUUID();
    }

    public Person(String firstName, String middleName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.id = UUID.randomUUID();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        if (hasMiddleName()) {
            return getFirstName() + " " + getMiddleName() + " " + getLastName();
        }
        return getFirstName() + " " + getLastName();
    }

    public void setFullName(String fullName) {
        int firstSpaceIndex = fullName.indexOf(" ");
        int lastSpaceIndex = fullName.lastIndexOf(" ");
        if (firstSpaceIndex == -1) {
            setFirstName(fullName);
            return;
        }
        setFirstName(fullName.substring(0, firstSpaceIndex));
        if (firstSpaceIndex != lastSpaceIndex) {
            setMiddleName(fullName.substring(firstSpaceIndex + 1, lastSpaceIndex));
        } else {
            this.middleName = null;
        }
        setLastName(fullName.substring(lastSpaceIndex + 1));
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        var hogwartsNow = LocalDate.now().withYear(1992);
        return Period.between(birthDate, hogwartsNow).getYears();
    }

    public boolean hasMiddleName() {
        return middleName != null;
    }

    public boolean hasLastName() {
        return lastName != null;
    }

    @Override
    public String toString() {
        return "Person{\n" +
                "firstName: " + firstName + "\n" +
                "middleName: " + middleName + "\n" +
                "lastName: " + lastName + "\n" +
                "}";
    }


}