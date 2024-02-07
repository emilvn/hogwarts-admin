package src.edu.hogwarts.application;

import src.edu.generic.Controller;
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

    public HogwartsTeacher get(UUID id){
        return teachers.stream().filter(teacher -> teacher.getId().equals(id)).findFirst().orElse(null);
    }

    public void add(HogwartsTeacher teacher){
        teachers.add(teacher);
    }

    public void add(HogwartsTeacher[] teachers){
        Collections.addAll(this.teachers, teachers);
    }

    public void update(UUID id, HogwartsTeacher teacher){
        var oldTeacher = get(id);
        if(oldTeacher != null){
            oldTeacher.setFullName(teacher.getFullName());
            oldTeacher.setBirthDate(teacher.getBirthDate());
            oldTeacher.setHouse(teacher.getHouse());
            oldTeacher.setHeadOfHouse(teacher.isHeadOfHouse());
            oldTeacher.setEmploymentStart(teacher.getEmploymentStart());
            oldTeacher.setEmploymentEnd(teacher.getEmploymentEnd());
        }
    }
    public void delete(UUID id){
        teachers.removeIf(teacher -> teacher.getId().equals(id));
    }
}
