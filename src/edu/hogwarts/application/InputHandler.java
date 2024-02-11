package src.edu.hogwarts.application;

import src.edu.generic.Person;
import src.edu.hogwarts.model.House;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class InputHandler {
    private final Scanner s;

    public InputHandler(Scanner s) {
        this.s = s;
    }

    public int getYearInput() {
        System.out.println("Enter year (yyyy):");
        var year = s.nextInt();
        while (year < 0 || year > 3000) {
            System.out.println("Invalid year. Enter year (yyyy) before 1992:");
            year = s.nextInt();
        }
        return year;
    }

    public String[] getNameInput() {
        System.out.println("Enter first name:");
        var firstName = s.next();
        System.out.println("Enter middle name:");
        var middleName = s.next();
        System.out.println("Enter last name:");
        var lastName = s.next();
        return new String[]{firstName, middleName, lastName};
    }

    public LocalDate getBirthDateInput() {
        System.out.println("Birth year must be before 1992.");
        var birthYear = getYearInput();
        while (birthYear > 1992) {
            System.out.println("Invalid year. Must be before 1992.");
            birthYear = getYearInput();
        }
        var birthMonth = getMonthInput();
        var birthDay = getDayInput();
        try {
            return LocalDate.of(birthYear, birthMonth, birthDay);
        } catch (DateTimeException err) {
            System.out.println("Invalid date. Try again");
            return getBirthDateInput();
        }
    }

    public LocalDate getDateInput() {
        var birthYear = getYearInput();
        var birthMonth = getMonthInput();
        var birthDay = getDayInput();
        try {
            return LocalDate.of(birthYear, birthMonth, birthDay);
        } catch (DateTimeException err) {
            System.out.println("Invalid date. Try again");
            return getDateInput();
        }
    }

    public int getMonthInput() {
        System.out.println("Enter month (1-12):");
        return s.nextInt();
    }

    public int getDayInput() {
        System.out.println("Enter day:");
        return s.nextInt();
    }

    public String[] getTeamsInput() {
        System.out.println("Enter amount of teams the student is a part of:");
        var teamCount = s.nextInt();
        while (teamCount < 0 || teamCount > 5) {
            System.out.println("Invalid amount. Enter amount of teams the student is a part of:");
            teamCount = s.nextInt();
        }
        var teams = new String[teamCount];
        for (int i = 0; i < teamCount; i++) {
            System.out.println("Enter team " + (i + 1) + " name:");
            teams[i] = s.next();
        }
        return teams;
    }

    public House getHouseInput() {
        return switch (s.nextInt()) {
            case 1 -> House.getGryffindor();
            case 2 -> House.getHufflepuff();
            case 3 -> House.getRavenclaw();
            case 4 -> House.getSlytherin();
            default -> House.getUnknown();
        };
    }

    public boolean getYorNInput() {
        return s.next().equalsIgnoreCase("y");
    }

    public Person getPersonalDetails() {
        System.out.println("===== Name =====");
        var nameParts = getNameInput();
        var firstName = nameParts[0];
        var middleName = nameParts[1];
        var lastName = nameParts[2];
        System.out.println("===== Birthdate =====");
        var birthDate = getBirthDateInput();
        return new Person(firstName, middleName, lastName, birthDate);
    }
}
