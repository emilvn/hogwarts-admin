package src.edu.hogwarts.application;

import src.edu.hogwarts.data.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static src.edu.hogwarts.application.Utilities.forceLength;
public class UserInterface {
    private final StudentController studentController;
    private final TeacherController teacherController;
    private final Scanner s = new Scanner(System.in);
    private final String horizontalLine = "=======================================================================================================================";

    private SortOption sortOption = SortOption.FIRST_NAME;
    private boolean descending = false;
    private FilterByOption filterByOption;

    public UserInterface(StudentController studentController, TeacherController teacherController) {
        this.studentController = studentController;
        this.teacherController = teacherController;
    }

    public void start() {
        welcome();
        printMenu();
        var choice = s.nextInt();
        switch (choice) {
            case 1:
                addStudent();
                break;
            case 2:
                //addTeacher();
                break;
            case 3:
                printTable();
                selectFilterOrSort();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    private void welcome() {
        System.out.println("Welcome to Hogwarts School of Witchcraft and Wizardry");
    }

    private void printMenu() {
        System.out.println(horizontalLine);
        System.out.println("Please select an option:");
        System.out.println("1. Add student");
        System.out.println("2. Add teacher");
        System.out.println("3. Print table");
        System.out.println("0. Exit");
        System.out.println(horizontalLine);
    }

    private void printTable() {
        List<HogwartsPerson> people = new ArrayList<>(teacherController.getAll());
        people.addAll(studentController.getAll());

        Utilities.sortBy(people, sortOption);
        if(descending){
            people = people.reversed();
        }
        if(filterByOption != null){
            people = Utilities.filterBy(people, filterByOption);
        }

        String[] columnNames = {"FIRST NAME", "MIDDLE NAME", "LAST NAME", "AGE", "HOUSE", "ROLE"};
        System.out.println(horizontalLine);

        for(int i = 0; i<columnNames.length; i++){
            if(i == columnNames.length-1){
                System.out.print("| " + forceLength(columnNames[i]) + " |");
            }
            else{
                System.out.print("| " + forceLength(columnNames[i]) + " |" + "\t");
            }
        }

        System.out.print("\n");
        System.out.println(horizontalLine);

        assert people != null;
        for (HogwartsPerson person : people) {
            String role = person instanceof HogwartsTeacher ? "Teacher" : "Student";
            System.out.print("| "+ forceLength(person.getFirstName()) + " |");
            System.out.print("\t");
            System.out.print("| " + forceLength(person.getMiddleName()) + " |");
            System.out.print("\t");
            System.out.print("| " + forceLength(person.getLastName())+ " |");
            System.out.print("\t");
            System.out.print("| " + forceLength(Integer.toString(person.getAge())) + " |");
            System.out.print("\t");
            System.out.print("| " + forceLength(person.getHouse().getName().toString()) + " |");
            System.out.print("\t");
            System.out.print("| " + forceLength(role) + " |");
            System.out.print("\n");
        }
        System.out.println(horizontalLine);
    }

    private void selectFilterOrSort(){
        System.out.println("1. Sort");
        System.out.println("2. Filter");
        System.out.println("3. Reset");
        System.out.println("0. Back");
        switch (s.nextInt()){
            case 1:
                printSortOptions();
                break;
            case 2:
                printFilterOptions();
                break;
            case 3:
                sortOption = SortOption.FIRST_NAME;
                descending = false;
                filterByOption = null;
                printTable();
                selectFilterOrSort();
                break;
            case 0:
                start();
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    private void printFilterOptions(){
        System.out.println("Filter by:");
        System.out.println("1. Role");
        System.out.println("2. House");
        System.out.println("0. Back");
        var choice = s.nextInt();
        switch (choice) {
            case 1:
                printFilterByRole();
                printFilterOptions();
                break;
            case 2:
                printFilterByHouse();
                printFilterOptions();
                break;
            case 0:
                selectFilterOrSort();
                break;
            default:
                System.out.println("Invalid option");
                printFilterOptions();
        }

    }

    private void printFilterByHouse() {
        System.out.println("Select house:");
        System.out.println("1. Gryffindor");
        System.out.println("2. Hufflepuff");
        System.out.println("3. Ravenclaw");
        System.out.println("4. Slytherin");
        System.out.println("5. Unknown");
        System.out.println("6. All");
        System.out.println("0. Back");
        var choice = s.nextInt();
        switch (choice) {
            case 1:
                filterByOption = HouseNames.GRYFFINDOR;
                printTable();
                selectFilterOrSort();
                break;
            case 2:
                filterByOption = HouseNames.HUFFLEPUFF;
                printTable();
                selectFilterOrSort();
                break;
            case 3:
                filterByOption = HouseNames.RAVENCLAW;
                printTable();
                selectFilterOrSort();
                break;
            case 4:
                filterByOption = HouseNames.SLYTHERIN;
                printTable();
                selectFilterOrSort();
                break;
            case 5:
                filterByOption = HouseNames.UNKNOWN;
                printTable();
                selectFilterOrSort();
                break;
            case 0:
                filterByOption = null;
                printFilterOptions();
                break;
            default:
                System.out.println("Invalid option");
        selectFilterOrSort();
        }

    }

    private void printFilterByRole() {
        System.out.println("Select role:");
        System.out.println("1. Teacher");
        System.out.println("2. Student");
        System.out.println("3. All");
        System.out.println("0. Back");
        var choice = s.nextInt();
        switch (choice) {
            case 1:
                filterByOption = EmpType.TEACHER;
                printTable();
                break;
            case 2:
                filterByOption = EmpType.STUDENT;
                printTable();
                break;
            case 3:
                filterByOption = null;
                printTable();
                break;
            case 0:
                filterByOption = null;
                printFilterOptions();
                break;
            default:
                System.out.println("Invalid option");
        }
        selectFilterOrSort();

    }

    public void printSortOptions(){
        System.out.println("Sort by:");
        System.out.println("1. First name");
        System.out.println("2. Middle name");
        System.out.println("3. Last name");
        System.out.println("4. Age");
        System.out.println("5. House");
        System.out.println("6. Role");
        System.out.println("0. Back");
        var choice = s.nextInt();
        switch (choice) {
            case 1:
                sortOption = SortOption.FIRST_NAME;
                selectOrder();
                printTable();
                selectFilterOrSort();
                break;
            case 2:
                sortOption = SortOption.MIDDLE_NAME;
                selectOrder();
                printTable();
                selectFilterOrSort();
                break;
            case 3:
                sortOption = SortOption.LAST_NAME;
                selectOrder();
                printTable();
                selectFilterOrSort();
                break;
            case 4:
                sortOption = SortOption.AGE;
                selectOrder();
                printTable();
                selectFilterOrSort();
                break;
            case 5:
                sortOption = SortOption.HOUSE;
                selectOrder();
                printTable();
                selectFilterOrSort();
                break;
            case 6:
                sortOption = SortOption.ROLE;
                selectOrder();
                printTable();
                selectFilterOrSort();
                break;
            case 0:
                sortOption = SortOption.FIRST_NAME;
                selectFilterOrSort();
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    private void selectOrder(){
        System.out.println("Select order:");
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
        descending = s.nextInt() == 2;
    }

    private void addStudent() {
        //TODO: Implement this method
    }


}
