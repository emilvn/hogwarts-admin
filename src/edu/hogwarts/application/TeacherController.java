package src.edu.hogwarts.application;

import src.edu.generic.Controller;
import src.edu.generic.Person;
import src.edu.hogwarts.data.HogwartsTeacher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

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
    public HogwartsTeacher get(UUID id){
        return teachers.stream().filter(teacher -> teacher.getId().equals(id)).findFirst().orElse(null);
    }
    public void update(UUID id, HogwartsTeacher teacher){
        //TODO: update(id, Student) - der opdaterer indholdet af et eksisterende Student-objekt med data fra et andet.
    }
    public void delete(UUID id){
        //TODO: delete(id) - der sletter et Student objekt fra listen. Id’et kan ikke genbruges!
    }
}
