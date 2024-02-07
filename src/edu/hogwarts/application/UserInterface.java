package src.edu.hogwarts.application;

import src.edu.hogwarts.controller.StudentController;
import src.edu.hogwarts.controller.TeacherController;
import src.edu.hogwarts.model.*;
import src.edu.hogwarts.util.FilterByOption;
import src.edu.hogwarts.util.SortOption;
import src.edu.hogwarts.util.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static src.edu.hogwarts.util.Utilities.forceLength;

public class UserInterface {
    private final StudentController studentController;
    private final TeacherController teacherController;
    private final Scanner s = new Scanner(System.in);

    private SortOption sortOption = SortOption.FIRST_NAME;
    private boolean descending = false;
    private FilterByOption filterByOption;
    private final MenuHandler menuHandler = new MenuHandler();
    private final InputHandler inputHandler;

    public UserInterface(StudentController studentController, TeacherController teacherController) {
        this.studentController = studentController;
        this.teacherController = teacherController;
        this.inputHandler = new InputHandler(this.s);
    }

    public void start() {
        menuHandler.printMainMenu();
        var choice = s.nextInt();
        switch (choice) {
            case 1:
                selectStudentOptions();
                break;
            case 2:
                selectTeacherOptions();
                break;
            case 3:
                printAll();
                selectFilterOrSort();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option");
                start();
        }
    }

    private void printTable(List<HogwartsPerson> people) {
        var horizontalLine = "=======================================================================================================================";
        Utilities.sortBy(people, sortOption);
        if (descending) {
            people = people.reversed();
        }
        if (filterByOption != null) {
            people = Utilities.filterBy(people, filterByOption);
        }

        String[] columnNames = {"FIRST NAME", "MIDDLE NAME", "LAST NAME", "AGE", "HOUSE", "ROLE"};
        System.out.println(horizontalLine);

        for (int i = 0; i < columnNames.length; i++) {
            if (i == columnNames.length - 1) {
                System.out.print("| " + forceLength(columnNames[i]) + " |");
            } else {
                System.out.print("| " + forceLength(columnNames[i]) + " |" + "\t");
            }
        }

        System.out.print("\n");
        System.out.println(horizontalLine);

        assert people != null;
        for (HogwartsPerson person : people) {
            String role = person instanceof HogwartsTeacher ? "Teacher" : "Student";
            System.out.print("| " + forceLength(person.getFirstName()) + " |");
            System.out.print("\t");
            System.out.print("| " + forceLength(person.getMiddleName()) + " |");
            System.out.print("\t");
            System.out.print("| " + forceLength(person.getLastName()) + " |");
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

    private void printAll() {
        List<HogwartsPerson> people = new ArrayList<>(studentController.getAll());
        people.addAll(teacherController.getAll());
        printTable(people);
    }

    private void selectFilterOrSort() {
        menuHandler.printFilterOrSortMenu();
        switch (s.nextInt()) {
            case 1:
                selectSortOptions();
                break;
            case 2:
                selectFilterOptions();
                break;
            case 3:
                sortOption = SortOption.FIRST_NAME;
                descending = false;
                filterByOption = null;
                printAll();
                selectFilterOrSort();
                break;
            case 0:
                start();
                break;
            default:
                System.out.println("Invalid option");
                selectFilterOrSort();
        }
    }

    // ============== FILTER =================
    private void selectFilterOptions() {
        menuHandler.printFilterMenu();
        var choice = s.nextInt();
        switch (choice) {
            case 1:
                selectFilterRole();
                selectFilterOptions();
                break;
            case 2:
                selectFilterHouse();
                selectFilterOptions();
                break;
            case 0:
                selectFilterOrSort();
                break;
            default:
                System.out.println("Invalid option");
                selectFilterOptions();
        }

    }

    private void selectFilterHouse() {
        menuHandler.printFilterHouseMenu();
        var choice = s.nextInt();
        switch (choice) {
            case 1:
                filterByOption = HouseNames.GRYFFINDOR;
                printAll();
                selectFilterOrSort();
                break;
            case 2:
                filterByOption = HouseNames.HUFFLEPUFF;
                printAll();
                selectFilterOrSort();
                break;
            case 3:
                filterByOption = HouseNames.RAVENCLAW;
                printAll();
                selectFilterOrSort();
                break;
            case 4:
                filterByOption = HouseNames.SLYTHERIN;
                printAll();
                selectFilterOrSort();
                break;
            case 5:
                filterByOption = HouseNames.UNKNOWN;
                printAll();
                selectFilterOrSort();
                break;
            case 0:
                filterByOption = null;
                selectFilterOptions();
                break;
            default:
                System.out.println("Invalid option");
                selectFilterHouse();
        }

    }

    private void selectFilterRole() {
        menuHandler.printFilterRoleMenu();
        var choice = s.nextInt();
        switch (choice) {
            case 1:
                filterByOption = EmpType.TEACHER;
                printAll();
                break;
            case 2:
                filterByOption = EmpType.STUDENT;
                printAll();
                break;
            case 3:
                filterByOption = null;
                printAll();
                break;
            case 0:
                filterByOption = null;
                selectFilterOptions();
                break;
            default:
                System.out.println("Invalid option");
                selectFilterRole();
        }
        selectFilterOrSort();

    }


    // ============== SORT =================
    public void selectSortOptions() {
        menuHandler.printSortMenu();
        var choice = s.nextInt();
        switch (choice) {
            case 1:
                sortOption = SortOption.FIRST_NAME;
                selectSortOrder();
                printAll();
                selectFilterOrSort();
                break;
            case 2:
                sortOption = SortOption.MIDDLE_NAME;
                selectSortOrder();
                printAll();
                selectFilterOrSort();
                break;
            case 3:
                sortOption = SortOption.LAST_NAME;
                selectSortOrder();
                printAll();
                selectFilterOrSort();
                break;
            case 4:
                sortOption = SortOption.AGE;
                selectSortOrder();
                printAll();
                selectFilterOrSort();
                break;
            case 5:
                sortOption = SortOption.HOUSE;
                selectSortOrder();
                printAll();
                selectFilterOrSort();
                break;
            case 6:
                sortOption = SortOption.ROLE;
                selectSortOrder();
                printAll();
                selectFilterOrSort();
                break;
            case 0:
                sortOption = SortOption.FIRST_NAME;
                selectFilterOrSort();
                break;
            default:
                System.out.println("Invalid option");
                selectSortOptions();
        }
    }

    private void selectSortOrder() {
        menuHandler.printSortOrderMenu();
        descending = s.nextInt() == 2;
    }

    // ============== STUDENT =================
    private void selectStudentOptions() {
        menuHandler.printStudentsMenu();
        switch (s.nextInt()) {
            case 1:
                addStudent();
                selectStudentOptions();
                break;
            case 2:
                printStudents();
                selectStudentOptions();
                break;
            case 0:
                start();
                break;
            default:
                System.out.println("Invalid option");
                selectStudentOptions();
        }
    }

    private void printStudents() {
        List<HogwartsPerson> students = new ArrayList<>(studentController.getAll());
        printTable(students);
    }

    private void addStudent() {
        var person = inputHandler.getPersonalDetails();

        System.out.println("===== Enrollment year =====");
        var enrollmentYear = inputHandler.getYearInput();
        var graduationYear = enrollmentYear + 7;
        var isGraduated = 1992 > graduationYear;

        System.out.println("===== House =====");
        menuHandler.printHouseMenu();
        var house = inputHandler.getHouseInput();

        System.out.println("===== Prefect status =====");
        System.out.println("Is the student a prefect? (y/n)");
        var isPrefect = inputHandler.getYorNInput();

        System.out.println("===== Teams =====");
        var teams = inputHandler.getTeamsInput();

        var student = new HogwartsStudent(person);
        student.setHouse(house);
        student.setPrefect(isPrefect);
        student.setTeams(teams);
        student.setEnrollmentYear(enrollmentYear);
        student.setGraduationYear(graduationYear);
        student.setGraduated(isGraduated);
        studentController.add(student);
        System.out.println("Student added");
    }

    // ============== TEACHER =================
    private void selectTeacherOptions() {
        menuHandler.printTeachersMenu();
        switch (s.nextInt()) {
            case 1:
                addTeacher();
                selectTeacherOptions();
                break;
            case 2:
                printTeachers();
                selectTeacherOptions();
                break;
            case 0:
                start();
                break;
            default:
                System.out.println("Invalid option");
                selectTeacherOptions();
        }
    }

    private void printTeachers() {
        List<HogwartsPerson> teachers = new ArrayList<>(teacherController.getAll());
        printTable(teachers);
    }

    private void addTeacher() {
        var person = inputHandler.getPersonalDetails();

        System.out.println("===== Employment start =====");
        var employmentStart = inputHandler.getDateInput();

        System.out.println("===== Employment end (expected) =====");
        var employmentEnd = inputHandler.getDateInput();
        while (employmentEnd.getYear() < employmentStart.getYear()) {
            System.out.println("Invalid year. Enter year of (expected) employment end (yyyy):");
            employmentEnd = inputHandler.getDateInput();
        }

        System.out.println("===== House =====");
        menuHandler.printHouseMenu();
        var house = inputHandler.getHouseInput();

        System.out.println("===== Head of house status =====");
        System.out.println("Is the teacher the head of his/her house? (y/n)");
        var isHeadOfHouse = inputHandler.getYorNInput();

        var teacher = new HogwartsTeacher(person);
        teacher.setHouse(house);
        teacher.setHeadOfHouse(isHeadOfHouse);
        teacher.setEmploymentStart(employmentStart);
        teacher.setEmploymentEnd(employmentEnd);

        teacherController.add(teacher);
        System.out.println("Teacher added");
    }
}
