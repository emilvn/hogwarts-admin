package src.edu.hogwarts;

public class HogwartsStudent extends Student implements HogwartsPerson {
    private House house;
    private boolean prefect;
    private String[] teams;

    @Override
    public String toString() {
        StringBuilder teamString = new StringBuilder();
        for(String team : teams){
            teamString.append(team).append(", ");
        }
        teamString.replace(teamString.lastIndexOf(", "), teamString.length(), ".");
        return super.toString() + "\nHouse: " + house + "\nPrefect: " + prefect + "\nTeams: " + teamString;
    }
}
