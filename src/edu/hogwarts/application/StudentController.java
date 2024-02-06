package src.edu.hogwarts.application;

import src.edu.generic.Controller;
import src.edu.hogwarts.data.HogwartsStudent;
import src.edu.hogwarts.data.SortOption;

import java.util.ArrayList;
import java.util.Collections;

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
    public void add(HogwartsStudent student){
        //TODO: add( Student ) - der modtager et Student-objekt, gemmer det i en liste, og tildeler det et id.
    }
    public void add(HogwartsStudent[] students){
        Collections.addAll(this.students, students);
    }
    public HogwartsStudent get(String id){
        //TODO: get( id ) - der returnerer et enkelt Student objekt
        return null;
    }
    public void update(String id, HogwartsStudent student){
        //TODO: update(id, Student) - der opdaterer indholdet af et eksisterende Student-objekt med data fra et andet.
    }
    public void delete(String id){
        //TODO: delete(id) - der sletter et Student objekt fra listen. Id’et kan ikke genbruges!
    }
}
