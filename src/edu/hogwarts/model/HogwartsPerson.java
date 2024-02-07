package src.edu.hogwarts.model;

public interface HogwartsPerson {
    House getHouse();

    void setHouse(House house);

    int getAge();

    String getFirstName();

    String getMiddleName();

    String getLastName();

    EmpType getRole();

    boolean hasMiddleName();

    boolean hasLastName();
}
