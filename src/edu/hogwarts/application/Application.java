package src.edu.hogwarts.application;

import src.edu.generic.Student;
import src.edu.hogwarts.data.*;

import java.time.LocalDate;

public class Application {
    private Subject[] subjects;
    private TeachingMaterial[] materials;

    private StudentController studentController;
    private TeacherController teacherController;
    private CourseController courseController;

    public static void main(String[] args) {
        Application app = new Application();
        app.initApp();
    }

    public void initApp() {
        studentController = new StudentController();
        teacherController = new TeacherController();
        courseController = new CourseController();
        initStudents();
        initTeachers();
        initSubjects();
        initTeachingMaterials();
        initCourses();

        printHouses();
        printStudents();
        printTeachers();
        printSubjects();
        printTeachingMaterials();
        printCourses();
    }

    public void initStudents() {
        var harry = new HogwartsStudent();
        var ron = new HogwartsStudent();
        var hermione = new HogwartsStudent();
        var neville = new HogwartsStudent();
        var luna = new HogwartsStudent();
        var draco = new HogwartsStudent();

        harry.setFullName("Harry James Potter");
        harry.setEnrollmentYear(1991);
        harry.setGraduationYear(1998);
        harry.setGraduated(true);
        harry.setHouse(House.getGryffindor());
        harry.setTeams("Quidditch");

        ron.setFullName("Ronald Bilius Weasley");
        ron.setEnrollmentYear(1991);
        ron.setGraduationYear(1998);
        ron.setGraduated(true);
        ron.setHouse(House.getGryffindor());
        ron.setTeams("Quidditch", "Wizard Chess");

        hermione.setFullName("Hermione Jean Granger");
        hermione.setEnrollmentYear(1991);
        hermione.setGraduationYear(1998);
        hermione.setGraduated(true);
        hermione.setHouse(House.getGryffindor());
        String[] teams = {"Wizard Chess", "SPEW"};
        hermione.setTeams(teams);

        neville.setFullName("Neville Longbottom");
        neville.setEnrollmentYear(1991);
        neville.setGraduationYear(1998);
        neville.setGraduated(true);
        neville.setHouse(House.getGryffindor());
        neville.setTeams("Herbology");

        luna.setFullName("Luna Lovegood");
        luna.setEnrollmentYear(1992);
        luna.setGraduationYear(1999);
        luna.setGraduated(true);
        luna.setHouse(House.getRavenclaw());
        luna.setTeams("Quidditch", "Wizard Chess", "SPEW");

        draco.setFullName("Draco Malfoy");
        draco.setEnrollmentYear(1991);
        draco.setGraduationYear(1998);
        draco.setGraduated(true);
        draco.setHouse(House.getSlytherin());
        draco.setTeams("Quidditch", "Wizard Chess", "Duelling Club");

        var students = new HogwartsStudent[]{harry, ron, hermione, neville, luna, draco};
        studentController.add(students);
    }

    public void initTeachers() {
        var snape = new HogwartsTeacher();
        var slughorn = new HogwartsTeacher();

        snape.setFullName("Severus Snape");
        snape.setHouse(House.getSlytherin());
        snape.setHeadOfHouse(true);
        snape.setEmployment(EmpType.TEACHER);
        snape.setEmploymentStart(LocalDate.of(1981, 9, 1));
        snape.setEmploymentEnd(LocalDate.of(1998, 6, 30));

        slughorn.setFullName("Horace Slughorn");
        slughorn.setHouse(House.getSlytherin());
        slughorn.setHeadOfHouse(false);
        slughorn.setEmployment(EmpType.TEACHER);
        slughorn.setEmploymentStart(LocalDate.of(1931, 9, 1));
        slughorn.setEmploymentEnd(LocalDate.of(1981, 6, 30));

        var teachers = new HogwartsTeacher[]{snape, slughorn};
        teacherController.add(teachers);
    }

    public void initSubjects() {
        var potions = new Subject();

        potions.setName("Potions");
        potions.setSchoolYear(1);
        potions.setElective(false);

        subjects = new Subject[]{potions};
    }

    public void initTeachingMaterials() {
        var textBook = new TextBook();
        var wand = new Wand();
        var tool = new Tool();
        var ingredient = new Ingredient();

        textBook.setName("Advanced Potion Making");
        textBook.setAuthor("Libatius Borage");
        textBook.setPublisher("Horace Slughorn");
        textBook.setTitle("Advanced Potion Making");
        textBook.setPublishedYear(1946);
        textBook.setOnShoppingList(true);
        textBook.setNotes("This book is the property of the Half-Blood Prince.");
        textBook.setProvided(true);
        textBook.setRequired(true);

        wand.setName("Wand");
        wand.setCore("Phoenix feather");
        wand.setWood("Holly");
        wand.setNotes("The wand chooses the wizard.");
        wand.setProvided(false);
        wand.setRequired(true);
        wand.setOnShoppingList(true);
        wand.setLengthInInches(11);

        tool.setName("Cauldron");
        tool.setDescription("Pewter, standard size 2");
        tool.setNotes("Pewter cauldrons are standard size 2.");
        tool.setProvided(false);
        tool.setRequired(true);
        tool.setOnShoppingList(true);

        ingredient.setName("Bubotuber pus");
        ingredient.setAmount(2);
        ingredient.setUnit("ounces");
        ingredient.setNotes("Bubotuber pus is a magical substance.");
        ingredient.setProvided(false);
        ingredient.setRequired(true);
        ingredient.setOnShoppingList(true);

        materials = new TeachingMaterial[]{textBook, wand, tool, ingredient};
    }

    public void initCourses() {
        var potions = new Course();
        potions.setSubject(subjects[0]);
        potions.setTeacher(teacherController.getAll()[1]);
        potions.setStudents(studentController.getAll());
        potions.setMaterials(materials);

        var courses = new Course[]{potions};
        courseController.add(courses);
    }


    public void printHouses() {
        System.out.println(House.getGryffindor());
        System.out.println(House.getHufflepuff());
        System.out.println(House.getRavenclaw());
        System.out.println(House.getSlytherin());
    }

    public void printStudents() {
        for (Student student : studentController.getAll()) {
            System.out.println(student);
        }
    }

    public void printTeachers() {
        for (HogwartsTeacher teacher : teacherController.getAll()) {
            System.out.println(teacher);
        }
    }

    public void printSubjects() {
        for (Subject subject : subjects) {
            System.out.println(subject);
        }
    }

    public void printTeachingMaterials() {
        for (TeachingMaterial material : materials) {
            System.out.println(material);
        }
    }

    public void printCourses() {
        for (Course course : courseController.getAll()) {
            System.out.println(course);
        }
    }
}
