package src.edu.hogwarts.application;

public class MenuHandler {

    private final String horizontalLine = "=======================================================================================================================";

    public void printMainMenu() {
        System.out.println("Welcome to Hogwarts School of Witchcraft and Wizardry");
        System.out.println(horizontalLine);
        System.out.println("Please select an option:");
        System.out.println("1. Students");
        System.out.println("2. Teachers");
        System.out.println("3. Print all");
        System.out.println("0. Exit");
        System.out.println(horizontalLine);
    }

    public void printFilterOrSortMenu() {
        System.out.println("Please select an option:");
        System.out.println("1. Filter");
        System.out.println("2. Sort");
        System.out.println("0. Back");
        System.out.println(horizontalLine);
    }

    public void printFilterMenu() {
        System.out.println("Filter by:");
        System.out.println("1. Role");
        System.out.println("2. House");
        System.out.println("0. Back");
    }

    public void printFilterHouseMenu() {
        System.out.println("Select house:");
        System.out.println("1. Gryffindor");
        System.out.println("2. Hufflepuff");
        System.out.println("3. Ravenclaw");
        System.out.println("4. Slytherin");
        System.out.println("5. Unknown");
        System.out.println("6. All");
        System.out.println("0. Back");
    }

    public void printFilterRoleMenu() {
        System.out.println("Select role:");
        System.out.println("1. Teacher");
        System.out.println("2. Student");
        System.out.println("3. All");
        System.out.println("0. Back");
    }

    public void printSortMenu() {
        System.out.println("Sort by:");
        System.out.println("1. First name");
        System.out.println("2. Middle name");
        System.out.println("3. Last name");
        System.out.println("4. Age");
        System.out.println("5. House");
        System.out.println("6. Role");
        System.out.println("0. Back");
    }

    public void printSortOrderMenu() {
        System.out.println("Select order:");
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
        System.out.println("0. Back");
    }

    public void printStudentsMenu() {
        System.out.println(horizontalLine);
        System.out.println("Please select an option:");
        System.out.println("1. Add student");
        System.out.println("2. Print students");
        System.out.println("0. Back");
        System.out.println(horizontalLine);
    }

    public void printTeachersMenu() {
        System.out.println(horizontalLine);
        System.out.println("Please select an option:");
        System.out.println("1. Add teacher");
        System.out.println("2. Print teachers");
        System.out.println("0. Back");
        System.out.println(horizontalLine);
    }

    public void printHouseMenu(){
        System.out.println("Select house:");
        System.out.println("1. Gryffindor");
        System.out.println("2. Hufflepuff");
        System.out.println("3. Ravenclaw");
        System.out.println("4. Slytherin");
        System.out.println("0. Unknown");
    }
}
