package src.edu.hogwarts.application;

import src.edu.hogwarts.data.HogwartsStudent;

public class StudentController extends HogwartsController<HogwartsStudent> {
    private HogwartsStudent[] students;

    public StudentController(HogwartsStudent... students){
        super();
        this.students = students;
    }
    public StudentController(){
        super();
        students = new HogwartsStudent[0];
    }

    public HogwartsStudent[] getAll(){
        return students;
    }
    public void add(HogwartsStudent student){
        //TODO: add( Student ) - der modtager et Student-objekt, gemmer det i en liste, og tildeler det et id.
    }
    public void add(HogwartsStudent[] students){
        this.students = students;
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
