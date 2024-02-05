package src.edu.hogwarts.application;

import src.edu.generic.Controller;
import src.edu.hogwarts.data.Course;

import java.util.ArrayList;
import java.util.Collections;

public class CourseController extends Controller<Course> {
    private final ArrayList<Course> courses = new ArrayList<>();

    public CourseController() {
        super();
    }
    public CourseController(Course... courses) {
        super();
        Collections.addAll(this.courses, courses);
    }

    public ArrayList<Course> getAll() {
        return this.courses;
    }

    public void add(Course course) {
        //TODO: createOne( Student ) - der modtager et Student-objekt, gemmer det i en liste, og tildeler det et id.
    }

    public void add(Course... courses) {
        Collections.addAll(this.courses, courses);
    }

    public Course get(String id) {
        //TODO: get( id ) - der returnerer et enkelt Student objekt
        return null;
    }

    public void update(String id, Course entity) {
        //TODO: update(id, Student) - der opdaterer indholdet af et eksisterende Student-objekt med data fra et andet.
    }

    public void delete(String id) {
        //TODO: delete(id) - der sletter et Student objekt fra listen. Id’et kan ikke genbruges!
    }

}
