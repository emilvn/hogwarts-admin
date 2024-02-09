package src.edu.hogwarts.util;

import src.edu.hogwarts.model.EmpType;
import src.edu.hogwarts.model.HogwartsPerson;
import src.edu.hogwarts.model.HogwartsTeacher;
import src.edu.hogwarts.model.HouseNames;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Utilities {
    public static void sortBy(List<HogwartsPerson> list, SortOption option, boolean descending) {
        Comparator<HogwartsPerson> comparator = switch (option) {
            case FIRST_NAME -> Comparator.comparing(HogwartsPerson::getFirstName);
            case MIDDLE_NAME -> Comparator.comparing(s -> s.hasMiddleName() ? s.getMiddleName() : "z");
            case LAST_NAME -> Comparator.comparing(s -> s.hasLastName() ? s.getLastName() : "z");
            case AGE -> Comparator.comparing(HogwartsPerson::getAge);
            case HOUSE -> Comparator.comparing(s -> s.getHouse().getName());
            case ROLE -> Comparator.comparing(s -> s instanceof HogwartsTeacher ? "Teacher" : "Student");
        };
        if(descending){
            comparator = comparator.reversed();
        }
        list.sort(comparator);
    }

    public static List<HogwartsPerson> filterBy(List<HogwartsPerson> list, FilterByOption option) {
        if (option instanceof EmpType)
            return filterByRole(list, (EmpType) option);
        else if (option instanceof HouseNames)
            return filterByHouse(list, (HouseNames) option);
        return null;
    }

    private static List<HogwartsPerson> filterByRole(List<HogwartsPerson> list, EmpType role) {
        List<HogwartsPerson> people = new ArrayList<>();
        for (HogwartsPerson person : list) {
            if (person.getRole().equals(role)) {
                people.add(person);
            }
        }
        return people;
    }

    private static List<HogwartsPerson> filterByHouse(List<HogwartsPerson> list, HouseNames house) {
        List<HogwartsPerson> filtered = new ArrayList<>();
        for (HogwartsPerson person : list) {
            if (person.getHouse().getName().equals(house)) {
                filtered.add(person);
            }
        }
        return filtered;
    }

    public static String forceLength(String s) {
        if (s == null) {
            s = "-";
        }
        int COLUMN_WIDTH = 15;
        if (s.length() > COLUMN_WIDTH) {
            return s.substring(0, COLUMN_WIDTH - 3) + "...";
        } else {
            while (s.length() < COLUMN_WIDTH) {
                s = s.concat(" ");
            }
        }
        return s;
    }

}
