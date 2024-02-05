package src.edu.hogwarts.application;

import src.edu.hogwarts.data.Course;

public class CourseController extends HogwartsController<Course>{
    private Course[] courses;

    public CourseController() {
        super();
        this.courses = new Course[0];
    }
    public CourseController(Course... courses) {
        super();
        this.courses = courses;
    }

    public Course[] getAll() {
        return this.courses;
    }

    public void add(Course course) {
        //TODO: createOne( Student ) - der modtager et Student-objekt, gemmer det i en liste, og tildeler det et id.
    }

    public void add(Course... courses) {
        this.courses = courses;
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
