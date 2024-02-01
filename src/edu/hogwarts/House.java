package src.edu.hogwarts;

public class House {
    private String name;
    private String founder;
    private String[] colors;

    @Override
    public String toString() {
        StringBuilder colorString = new StringBuilder();
        for(String color : colors){
            colorString.append(color).append(", ");
        }
        colorString.replace(colorString.lastIndexOf(", "), colorString.length()-1, ".");
        return "Name: " + name + "\nFounder: " + founder + "\nColors: " + colorString;
    }
}
