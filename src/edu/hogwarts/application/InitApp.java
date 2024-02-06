package src.edu.hogwarts.application;

import src.edu.hogwarts.data.*;

import java.time.LocalDate;

public class InitApp {
    private final StudentController studentController = new StudentController();
    private final TeacherController teacherController = new TeacherController();

    public void initApp() {
        initStudents();
        initStaff();

        var ui = new UserInterface(studentController, teacherController);
        ui.start();

    }

    public void initStudents() {
        // gryffindor
        var harry = new HogwartsStudent(House.getGryffindor(), false, new String[]{"Quidditch"}, 1991, 1998, true, "Harry James Potter", LocalDate.of(1980, 7, 31));
        var ron = new HogwartsStudent(House.getGryffindor(), false, new String[]{"Quidditch", "Wizard Chess"}, 1991, 1998, true, "Ronald Bilius Weasley", LocalDate.of(1980, 3, 1));
        var hermione = new HogwartsStudent(House.getGryffindor(), false, new String[]{"Wizard Chess", "SPEW"}, 1991, 1998, true, "Hermione Jean Granger", LocalDate.of(1979, 9, 19));
        var neville = new HogwartsStudent(House.getGryffindor(), false, new String[]{"Herbology"}, 1991, 1998, true, "Neville Longbottom", LocalDate.of(1980, 7, 30));
        var seamus = new HogwartsStudent(House.getGryffindor(), false, new String[]{"Quidditch"}, 1991, 1998, true, "Seamus Finnigan", LocalDate.of(1980, 3, 1));
        var parvati = new HogwartsStudent(House.getGryffindor(), false, new String[]{"Quidditch"}, 1991, 1998, true, "Parvati Patil", LocalDate.of(1980, 3, 1));

        // hufflepuff
        var hannah = new HogwartsStudent(House.getHufflepuff(), false, new String[]{"Herbology"}, 1991, 1998, true, "Hannah Abbott", LocalDate.of(1980, 3, 1));
        var susan = new HogwartsStudent(House.getHufflepuff(), false, new String[]{"Herbology"}, 1991, 1998, true, "Susan Bones", LocalDate.of(1980, 3, 1));
        var justin = new HogwartsStudent(House.getHufflepuff(), false, new String[]{"Herbology"}, 1991, 1998, true, "Justin Finch-Fletchley", LocalDate.of(1980, 3, 1));
        var wayne = new HogwartsStudent(House.getHufflepuff(), false, new String[]{"Herbology"}, 1991, 1998, true, "Wayne Hopkins", LocalDate.of(1980, 3, 1));
        var megan = new HogwartsStudent(House.getHufflepuff(), false, new String[]{"Herbology"}, 1991, 1998, true, "Megan Jones", LocalDate.of(1980, 3, 1));
        var ernest = new HogwartsStudent(House.getHufflepuff(), false, new String[]{"Herbology"}, 1991, 1998, true, "Ernest Macmillan", LocalDate.of(1980, 3, 1));

        // ravenclaw
        var amanda = new HogwartsStudent(House.getRavenclaw(), false, new String[]{"Quidditch"}, 1991, 1998, true, "Amanda", LocalDate.of(1980, 3, 1));
        var terry = new HogwartsStudent(House.getRavenclaw(), false, new String[]{"Quidditch"}, 1991, 1998, true, "Terry Boot", LocalDate.of(1980, 3, 1));
        var mandy = new HogwartsStudent(House.getRavenclaw(), false, new String[]{"Quidditch"}, 1991, 1998, true, "Mandy Brocklehurst", LocalDate.of(1980, 3, 1));
        var michael = new HogwartsStudent(House.getRavenclaw(), false, new String[]{"Quidditch"}, 1991, 1998, true, "Michael Corner", LocalDate.of(1980, 3, 1));
        var anthony = new HogwartsStudent(House.getRavenclaw(), false, new String[]{"Quidditch"}, 1991, 1998, true, "Anthony Goldstein", LocalDate.of(1980, 3, 1));
        var sue = new HogwartsStudent(House.getRavenclaw(), false, new String[]{"Quidditch"}, 1991, 1998, true, "Sue Li", LocalDate.of(1980, 3, 1));


        // slytherin
        var draco = new HogwartsStudent(House.getSlytherin(), false, new String[]{"Quidditch", "Wizard Chess", "Duelling Club"}, 1991, 1998, true, "Draco Malfoy", LocalDate.of(1980, 3, 1));
        var vincent = new HogwartsStudent(House.getSlytherin(), false, new String[]{"Quidditch", "Wizard Chess", "Duelling Club"}, 1991, 1998, true, "Vincent Crabbe", LocalDate.of(1980, 3, 1));
        var gregory = new HogwartsStudent(House.getSlytherin(), false, new String[]{"Quidditch", "Wizard Chess", "Duelling Club"}, 1991, 1998, true, "Gregory Goyle", LocalDate.of(1980, 3, 1));
        var pansy = new HogwartsStudent(House.getSlytherin(), false, new String[]{"Quidditch", "Wizard Chess", "Duelling Club"}, 1991, 1998, true, "Pansy Parkinson", LocalDate.of(1980, 3, 1));
        var blaise = new HogwartsStudent(House.getSlytherin(), false, new String[]{"Quidditch", "Wizard Chess", "Duelling Club"}, 1991, 1998, true, "Blaise Zabini", LocalDate.of(1980, 3, 1));
        var theodore = new HogwartsStudent(House.getSlytherin(), false, new String[]{"Quidditch", "Wizard Chess", "Duelling Club"}, 1991, 1998, true, "Theodore Nott", LocalDate.of(1980, 3, 1));

        var students = new HogwartsStudent[]{harry, ron, hermione, neville, seamus, parvati, hannah, susan, justin, wayne, megan, ernest, amanda, terry, mandy, michael, anthony, sue, draco, vincent, gregory, pansy, blaise, theodore};
        studentController.add(students);
    }

    public void initStaff() {
        // headmaster and heads of houses
        var dumbledore = new HogwartsTeacher(House.getGryffindor(), false, LocalDate.of(1910, 1, 1), LocalDate.of(1997, 6, 30), "Albus Percival Wulfric Brian Dumbledore", LocalDate.of(1881, 7, 1));
        var mcGonagall = new HogwartsTeacher(House.getGryffindor(), true, LocalDate.of(1935, 1, 1), LocalDate.now(), "Minerva McGonagall", LocalDate.of(1925, 10, 4));
        var sprout = new HogwartsTeacher(House.getHufflepuff(), true, LocalDate.of(1935, 1, 1), LocalDate.now(), "Pomona Sprout", LocalDate.of(1925, 5, 15));
        var flitwick = new HogwartsTeacher(House.getRavenclaw(), true, LocalDate.of(1935, 1, 1), LocalDate.now(), "Filius Flitwick", LocalDate.of(1925, 10, 17));
        var snape = new HogwartsTeacher(House.getSlytherin(), true, LocalDate.of(1970, 1, 1), LocalDate.of(1998, 5, 2), "Severus Snape", LocalDate.of(1960, 1, 9));

        var staff = new HogwartsTeacher[]{dumbledore, mcGonagall, sprout, flitwick, snape};
        teacherController.add(staff);

    }

    //TODO: add courses

}
