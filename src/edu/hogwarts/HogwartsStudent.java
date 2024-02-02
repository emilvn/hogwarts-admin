package src.edu.hogwarts;

public class HogwartsStudent extends Student implements HogwartsPerson {
    private House house;
    private boolean prefect;
    private String[] teams;

    public HogwartsStudent(House house, boolean prefect, String[] teams, int enrollmentYear, int graduationYear, boolean graduated, String fullName){
        super(enrollmentYear, graduationYear, graduated, fullName);
        this.house = house;
        this.prefect = prefect;
        this.teams = teams;
    }
    public HogwartsStudent(){
        super();
    }

    @Override
    public String toString() {
        StringBuilder teamString = new StringBuilder();
        for(String team : teams){
            teamString.append(team).append(", ");
        }
        teamString.replace(teamString.lastIndexOf(", "), teamString.length()-1, ".");
        return  "HogwartsStudent{\n" +
                "fullName" + getFullName() + "\n" +
                "enrollmentYear: " + getEnrollmentYear() + "\n" +
                "graduationYear: " + getGraduationYear() + "\n" +
                "graduated: " + isGraduated() + "\n" +
                "house: " + house + "\n" +
                "prefect: " + prefect + "\n" +
                "teams: " + teamString + "\n" +
                "}";
    }
}
