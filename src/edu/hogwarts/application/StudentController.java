package src.edu.hogwarts.application;

import src.edu.generic.Controller;
import src.edu.hogwarts.data.HogwartsStudent;
import src.edu.hogwarts.data.SortOption;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

public class StudentController extends Controller<HogwartsStudent> {
    private final ArrayList<HogwartsStudent> students = new ArrayList<>();

    public StudentController(){
        super();
    }
    public StudentController(HogwartsStudent... students){
        super();
        Collections.addAll(this.students, students);
    }

    public ArrayList<HogwartsStudent> getAll(){
        return students;
    }
    public HogwartsStudent get(UUID id){
        return students.stream().filter(student -> student.getId().equals(id)).findFirst().orElse(null);
    }
    public void add(HogwartsStudent student){
        students.add(student);
    }
    public void add(HogwartsStudent[] students){
        Collections.addAll(this.students, students);
    }
    public HogwartsStudent get(String id){
        //TODO: get( id ) - der returnerer et enkelt Student objekt
        return null;
    }
    public void update(UUID id, HogwartsStudent student){
        //TODO: update(id, Student) - der opdaterer indholdet af et eksisterende Student-objekt med data fra et andet.
    }
    public void delete(UUID id){
        //TODO: delete(id) - der sletter et Student objekt fra listen. Id’et kan ikke genbruges!
    }
}
