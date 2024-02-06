package src.edu.hogwarts.application;

import src.edu.hogwarts.data.HogwartsPerson;
import src.edu.hogwarts.data.HogwartsTeacher;
import src.edu.hogwarts.data.House;
import src.edu.hogwarts.data.SortOption;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final StudentController studentController;
    private final TeacherController teacherController;
    private final CourseController courseController;
    private final Scanner s = new Scanner(System.in);
    private final String horizontalLine = "=======================================================================================================================";

    public UserInterface(StudentController studentController, TeacherController teacherController, CourseController courseController) {
        this.studentController = studentController;
        this.teacherController = teacherController;
        this.courseController = courseController;
    }

    public void start() {
        welcome();
        printMenu();
        var choice = s.nextInt();
        while (choice != 0) {
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    //addTeacher();
                    break;
                case 3:
                    printTable(SortOption.FIRST_NAME);
                    printSortOptions();
                    break;
                default:
                    System.out.println("Invalid option");
            }
            printMenu();
            choice = s.nextInt();
        }
    }

    private void printTable(SortOption option) {
        ArrayList<HogwartsPerson> people = new ArrayList<>(teacherController.getAll());
        people.addAll(studentController.getAll());

        Utilities.sortBy(people, option);

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

        for (HogwartsPerson person : people) {
            String role = person instanceof HogwartsTeacher ? "Teacher" : "Student";
            System.out.print("| "+forceLength(person.getFirstName()) + " |");
            System.out.print("\t");
            System.out.print("| " + forceLength(person.getMiddleName()) + " |");
            System.out.print("\t");
            System.out.print("| " + forceLength(person.getLastName())+ " |");
            System.out.print("\t");
            System.out.print("| " + forceLength(Integer.toString(person.getAge())) + " |");
            System.out.print("\t");
            System.out.print("| " + forceLength(person.getHouse().getName()) + " |");
            System.out.print("\t");
            System.out.print("| " + forceLength(role) + " |");
            System.out.print("\n");
        }
        System.out.println(horizontalLine);
    }

    private void addStudent() {
        //TODO: Implement this method
    }

    private House selectHouse() {
        System.out.println("Select house:");
        System.out.println("1. Gryffindor");
        System.out.println("2. Hufflepuff");
        System.out.println("3. Ravenclaw");
        System.out.println("4. Slytherin");
        var choice = s.nextInt();
        return switch (choice) {
            case 1 -> House.getGryffindor();
            case 2 -> House.getHufflepuff();
            case 3 -> House.getRavenclaw();
            case 4 -> House.getSlytherin();
            default -> {
                System.out.println("Invalid option, setting house to unknown");
                yield House.getUnknown();
            }
        };
    }

    public void welcome() {
        System.out.println("Welcome to Hogwarts School of Witchcraft and Wizardry");
    }
    public void printMenu() {
        System.out.println(horizontalLine);
        System.out.println("Please select an option:");
        System.out.println("1. Add student");
        System.out.println("2. Add teacher");
        System.out.println("3. Print table");
        System.out.println("0. Exit");
        System.out.println(horizontalLine);
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
        while(choice != 0){
            switch (choice) {
                case 1:
                    printTable(SortOption.FIRST_NAME);
                    break;
                case 2:
                    printTable(SortOption.MIDDLE_NAME);
                    break;
                case 3:
                    printTable(SortOption.LAST_NAME);
                    break;
                case 4:
                    printTable(SortOption.AGE);
                    break;
                case 5:
                    printTable(SortOption.HOUSE);
                    break;
                case 6:
                    printTable(SortOption.ROLE);
                    break;
                default:
                    System.out.println("Invalid option");
            }
            printSortOptions();
            choice = s.nextInt();
        }
        start();
    }

    private String forceLength(String s) {
        if (s == null){
            s = "-";
        }
        int COLUMN_WIDTH = 15;
        if (s.length() > COLUMN_WIDTH) {
            return s.substring(0, COLUMN_WIDTH -3) + "...";
        }
        else{
            while(s.length() < COLUMN_WIDTH){
                s = s.concat(" ");
            }
        }
        return s;
    }
}
