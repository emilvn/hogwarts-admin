package src.edu.hogwarts.controller;

import src.edu.hogwarts.model.HogwartsTeacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class TeacherController extends Controller<HogwartsTeacher> {
    private final HashMap<UUID, HogwartsTeacher> teachers = new HashMap<>();

    public TeacherController() {
        super();
    }

    public TeacherController(HogwartsTeacher... teachers) {
        super();
        for (var teacher : teachers) {
            this.teachers.put(teacher.getId(), teacher);
        }
    }

    public ArrayList<HogwartsTeacher> getAll() {
        return new ArrayList<>(this.teachers.values());
    }

    public HogwartsTeacher get(UUID id) {
        return teachers.get(id);
    }

    public void add(HogwartsTeacher teacher) {
        teachers.put(teacher.getId(), teacher);
    }

    public void add(HogwartsTeacher... teachers) {
        for (var teacher : teachers) {
            add(teacher);
        }
    }

    public void update(UUID id, HogwartsTeacher teacher) {
        var oldTeacher = get(id);
        if (oldTeacher != null) {
            oldTeacher.setFullName(teacher.getFullName());
            oldTeacher.setBirthDate(teacher.getBirthDate());
            oldTeacher.setHouse(teacher.getHouse());
            oldTeacher.setHeadOfHouse(teacher.isHeadOfHouse());
            oldTeacher.setEmploymentStart(teacher.getEmploymentStart());
            oldTeacher.setEmploymentEnd(teacher.getEmploymentEnd());
        }
    }

    public void delete(UUID id) {
        teachers.remove(id);
    }
}
