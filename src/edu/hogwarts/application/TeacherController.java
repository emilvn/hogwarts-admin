package src.edu.hogwarts.application;

import src.edu.generic.Controller;
import src.edu.hogwarts.data.HogwartsTeacher;

import java.util.ArrayList;
import java.util.Collections;

public class TeacherController extends Controller<HogwartsTeacher> {
    private final ArrayList<HogwartsTeacher> teachers = new ArrayList<>();

    public TeacherController(){
        super();
    }
    public TeacherController(HogwartsTeacher... teachers){
        super();
        Collections.addAll(this.teachers, teachers);
    }

    public ArrayList<HogwartsTeacher> getAll(){
        return teachers;
    }
    public void add(HogwartsTeacher teacher){
        teachers.add(teacher);
    }

    public void add(HogwartsTeacher[] teachers){
        Collections.addAll(this.teachers, teachers);
    }
    public HogwartsTeacher get(String id){
        //TODO: get( id ) - der returnerer et enkelt Student objekt
        return null;
    }
    public void update(String id, HogwartsTeacher teacher){
        //TODO: update(id, Student) - der opdaterer indholdet af et eksisterende Student-objekt med data fra et andet.
    }
    public void delete(String id){
        //TODO: delete(id) - der sletter et Student objekt fra listen. Id’et kan ikke genbruges!
    }
}
