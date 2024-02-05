package src.edu.hogwarts.application;

import src.edu.generic.Controller;
import src.edu.hogwarts.data.HogwartsTeacher;

public class TeacherController implements Controller<HogwartsTeacher> {
    private HogwartsTeacher[] teachers;

    public TeacherController(HogwartsTeacher... teachers){
        this.teachers = teachers;
    }
    public TeacherController(){
        teachers = new HogwartsTeacher[0];
    }

    public HogwartsTeacher[] getTeachers(){
        return teachers;
    }
    public void add(HogwartsTeacher teacher){
        //TODO: createOne( Student ) - der modtager et Student-objekt, gemmer det i en liste, og tildeler det et id.
    }

    public void add(HogwartsTeacher[] teachers){
        this.teachers = teachers;
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
