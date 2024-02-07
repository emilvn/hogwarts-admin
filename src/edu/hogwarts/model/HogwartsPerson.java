package src.edu.hogwarts.model;

import src.edu.hogwarts.enums.EmpType;

public interface HogwartsPerson {
    House getHouse();

    void setHouse(House house);

    String getFullName();

    void setFullName(String fullName);

    int getAge();

    String getFirstName();

    void setFirstName(String firstName);

    String getMiddleName();

    void setMiddleName(String middleName);

    String getLastName();

    void setLastName(String lastName);

    EmpType getRole();

    boolean hasMiddleName();

    boolean hasLastName();
}
