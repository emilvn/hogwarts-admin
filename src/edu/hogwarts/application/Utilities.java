package src.edu.hogwarts.application;

import src.edu.hogwarts.data.HogwartsPerson;
import src.edu.hogwarts.data.HogwartsTeacher;
import src.edu.hogwarts.data.SortOption;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Utilities {
    public static void sortBy(List<HogwartsPerson> list, SortOption option){
        switch (option){
            case FIRST_NAME:
                list.sort(Comparator.comparing(HogwartsPerson::getFirstName));
                break;
            case MIDDLE_NAME:
                list.sort(Comparator.comparing(s -> s.hasMiddleName() ? s.getMiddleName() : "z"));
                break;
            case LAST_NAME:
                list.sort(Comparator.comparing(s -> s.hasLastName() ? s.getLastName() : "z"));
                break;
            case AGE:
                list.sort(Comparator.comparing(HogwartsPerson::getAge));
                break;
            case HOUSE:
                list.sort(Comparator.comparing(s -> s.getHouse().getName()));
                break;
            case ROLE:
                list.sort(Comparator.comparing(s -> s instanceof HogwartsTeacher ? "Teacher" : "Student"));
                break;
        }
    }
}
