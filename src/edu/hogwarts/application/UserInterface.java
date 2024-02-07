package src.edu.hogwarts.application;

import src.edu.hogwarts.data.*;

import java.time.LocalDate;
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
                printStudentMenu();
                break;
            case 2:
                printTeacherMenu();
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
        }
    }

    private void welcome() {
        System.out.println("Welcome to Hogwarts School of Witchcraft and Wizardry");
    }

    private void printMenu() {
        System.out.println(horizontalLine);
        System.out.println("Please select an option:");
        System.out.println("1. Students");
        System.out.println("2. Teachers");
        System.out.println("3. Print all");
        System.out.println("0. Exit");
        System.out.println(horizontalLine);
    }

    private void printTable(List<HogwartsPerson> people) {
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

    private void printAll(){
        List<HogwartsPerson> people = new ArrayList<>(studentController.getAll());
        people.addAll(teacherController.getAll());
        printTable(people);
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
                printAll();
                selectFilterOrSort();
                break;
            case 0:
                start();
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    // ============== FILTER =================
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
                printFilterOptions();
                break;
            default:
                System.out.println("Invalid option");
        }
        selectFilterOrSort();

    }


    // ============== SORT =================
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
                printAll();
                selectFilterOrSort();
                break;
            case 2:
                sortOption = SortOption.MIDDLE_NAME;
                selectOrder();
                printAll();
                selectFilterOrSort();
                break;
            case 3:
                sortOption = SortOption.LAST_NAME;
                selectOrder();
                printAll();
                selectFilterOrSort();
                break;
            case 4:
                sortOption = SortOption.AGE;
                selectOrder();
                printAll();
                selectFilterOrSort();
                break;
            case 5:
                sortOption = SortOption.HOUSE;
                selectOrder();
                printAll();
                selectFilterOrSort();
                break;
            case 6:
                sortOption = SortOption.ROLE;
                selectOrder();
                printAll();
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

    // ============== STUDENT CRUD =================
    private void printStudentMenu() {
        System.out.println(horizontalLine);
        System.out.println("Please select an option:");
        System.out.println("1. Add student");
        System.out.println("2. Print students");
        System.out.println("0. Back");
        System.out.println(horizontalLine);
        switch (s.nextInt()) {
            case 1:
                addStudent();
                printStudentMenu();
                break;
            case 2:
                printStudents();
                printStudentMenu();
                break;
            case 0:
                start();
                break;
            default:
                System.out.println("Invalid option");
        }
    }
    private void printStudents(){
        List<HogwartsPerson> students = new ArrayList<>(studentController.getAll());
        printTable(students);
    }
    private void addStudent() {
        System.out.println("Enter enrollment year (yyyy):");
        var enrollmentYear = s.nextInt();
        var graduationYear = enrollmentYear + 7;
        var isGraduated = 1992 > graduationYear;

        var nameParts = getNameParts();
        var firstName = nameParts[0];
        var middleName = nameParts[1];
        var lastName = nameParts[2];

        var house = selectHouse();

        var birthDate = getBirthDate();

        System.out.println("Is the student a prefect? (y/n)");
        var isPrefect = s.next().equalsIgnoreCase("y");
        var teams = getTeams();

        var student = new HogwartsStudent();
        student.setFirstName(firstName);
        student.setMiddleName(middleName);
        student.setLastName(lastName);
        student.setBirthDate(birthDate);
        student.setHouse(house);
        student.setPrefect(isPrefect);
        student.setTeams(teams);
        student.setEnrollmentYear(enrollmentYear);
        student.setGraduationYear(graduationYear);
        student.setGraduated(isGraduated);

        studentController.add(student);
        System.out.println("Student added");
    }

    private House selectHouse(){
        System.out.println("Enter house:");
        System.out.println("1. Gryffindor");
        System.out.println("2. Hufflepuff");
        System.out.println("3. Ravenclaw");
        System.out.println("4. Slytherin");
        System.out.println("0. Unknown");
        return switch (s.nextInt()) {
            case 1 -> House.getGryffindor();
            case 2 -> House.getHufflepuff();
            case 3 -> House.getRavenclaw();
            case 4 -> House.getSlytherin();
            default -> House.getUnknown();
        };
    }

    private String[] getTeams(){
        System.out.println("Enter amount of teams the student is a part of:");
        var teamCount = s.nextInt();
        var teams = new String[teamCount];
        for (int i = 0; i < teamCount; i++) {
            System.out.println("Enter team " + (i + 1) + " name:");
            teams[i] = s.next();
        }
        return teams;
    }

    private String[] getNameParts(){
        System.out.println("Enter first name:");
        var firstName = s.next();
        System.out.println("Enter middle name:");
        var middleName = s.next();
        System.out.println("Enter last name:");
        var lastName = s.next();
        return new String[]{firstName, middleName, lastName};
    }

    private LocalDate getBirthDate(){
        System.out.println("Enter birth year (yyyy):");
        var birthYear = s.nextInt();
        System.out.println("Enter birth month (1-12):");
        var birthMonth = s.nextInt();
        System.out.println("Enter birth day:");
        var birthDay = s.nextInt();
        return LocalDate.of(birthYear, birthMonth, birthDay);
    }

    // ============== TEACHER CRUD =================

    private void printTeacherMenu(){
        System.out.println(horizontalLine);
        System.out.println("Please select an option:");
        System.out.println("1. Add teacher");
        System.out.println("2. Print teachers");
        System.out.println("0. Back");
        System.out.println(horizontalLine);
        switch (s.nextInt()) {
            case 1:
                addTeacher();
                printTeacherMenu();
                break;
            case 2:
                printTeachers();
                printTeacherMenu();
                break;
            case 0:
                start();
                break;
            default:
                System.out.println("Invalid option");
        }
    }
    private void printTeachers(){
        List<HogwartsPerson> teachers = new ArrayList<>(teacherController.getAll());
        printTable(teachers);
    }
    private void addTeacher() {
        System.out.println("Enter year of employment start (yyyy):");
        var employmentStartYear = s.nextInt();
        System.out.println("Enter month of employment start (1-12):");
        var employmentStartMonth = s.nextInt();
        System.out.println("Enter day of employment start:");
        var employmentStartDay = s.nextInt();
        var employmentStart = LocalDate.of(employmentStartYear, employmentStartMonth, employmentStartDay);

        System.out.println("Enter year of (expected) employment end (yyyy):");
        var employmentEndYear = s.nextInt();
        var employmentEnd = LocalDate.of(employmentEndYear, 1, 1);

        var nameParts = getNameParts();
        var firstName = nameParts[0];
        var middleName = nameParts[1];
        var lastName = nameParts[2];

        var house = selectHouse();
        var birthDate = getBirthDate();

        System.out.println("Is the teacher the head of his/her house? (y/n)");
        var isHeadOfHouse = s.next().equalsIgnoreCase("y");

        var teacher = new HogwartsTeacher();
        teacher.setFirstName(firstName);
        teacher.setMiddleName(middleName);
        teacher.setLastName(lastName);
        teacher.setBirthDate(birthDate);
        teacher.setHouse(house);
        teacher.setHeadOfHouse(isHeadOfHouse);
        teacher.setEmploymentStart(employmentStart);
        teacher.setEmploymentEnd(employmentEnd);

        teacherController.add(teacher);
        System.out.println("Teacher added");
    }



}
