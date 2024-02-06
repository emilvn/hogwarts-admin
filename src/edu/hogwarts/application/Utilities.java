package src.edu.hogwarts.application;

import src.edu.hogwarts.data.*;

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

    public static List<HogwartsPerson> filterBy(List<HogwartsPerson> list, FilterByOption option){
        if(option instanceof EmpType)
            return filterByRole(list, (EmpType) option);
        else if(option instanceof HouseNames)
            return filterByHouse(list, (HouseNames) option);
        return null;
    }

    private static List<HogwartsPerson> filterByRole(List<HogwartsPerson> list, EmpType role){
        List<HogwartsPerson> people = new ArrayList<>();
        for (HogwartsPerson person : list) {
            if(person.getRole().equals(role)){
                people.add(person);
            }
        }
        return people;
    }

    private static List<HogwartsPerson> filterByHouse(List<HogwartsPerson> list, HouseNames house){
        List<HogwartsPerson> filtered = new ArrayList<>();
        for (HogwartsPerson person : list) {
            if(person.getHouse().getName().equals(house)){
                filtered.add(person);
            }
        }
        return filtered;
    }

}
