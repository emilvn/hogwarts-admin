package src.edu.hogwarts;

public class Course {
    private Subject subject;
    private Teacher teacher;
    private Student[] students;
    private TeachingMaterial[] materials;

    public Course(Subject subject, Teacher teacher, Student[] students, TeachingMaterial[] materials) {
        this.subject = subject;
        this.teacher = teacher;
        this.students = students;
        this.materials = materials;
    }
    public Course(){
        this.subject = new Subject();
        this.teacher = new Teacher();
        this.students = new Student[0];
        this.materials = new TeachingMaterial[0];
    }
    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public Student[] getStudents() {
        return students;
    }
    public void setStudents(Student[] students) {
        this.students = students;
    }
    public TeachingMaterial[] getMaterials() {
        return materials;
    }
    public void setMaterials(TeachingMaterial[] materials) {
        this.materials = materials;
    }

    @Override
    public String toString() {
        StringBuilder studentString = new StringBuilder();
        for(Student student : students){
            studentString.append(student).append(", ");
        }
        studentString.replace(studentString.lastIndexOf(", "), studentString.length()-1, ".");
        StringBuilder materialString = new StringBuilder();
        for(TeachingMaterial material : materials){
            materialString.append(material).append(", ");
        }
        materialString.replace(materialString.lastIndexOf(", "), materialString.length()-1, ".");

        return "Course{\n" +
                "subject: " + subject + "\n" +
                "teacher: " + teacher + "\n" +
                "students: " + studentString + "\n" +
                "materials: " + materialString + "\n" +
                "}";
    }
}
