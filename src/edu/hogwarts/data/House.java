package src.edu.hogwarts.data;

public class House {
    private final String name;
    private final String founder;
    private final String[] colors;
    private static final House gryffindor = new House("Gryffindor", "Godric Gryffindor", "scarlet", "gold");
    private static final House hufflepuff = new House("Hufflepuff", "Helga Hufflepuff", "yellow", "black");
    private static final House ravenclaw = new House("Ravenclaw", "Rowena Ravenclaw", "blue", "silver");
    private static final House slytherin = new House("Slytherin", "Salazar Slytherin", "green", "silver");
    private static final House unknown = new House();

    public House(String name, String founder, String... colors) {
        this.name = name;
        this.founder = founder;
        this.colors = colors;
    }

    public House() {
        this.name = "Unknown";
        this.founder = "Unknown";
        this.colors = new String[0];
    }

    public String getName() {
        return name;
    }

    public static House getGryffindor() {
        return gryffindor;
    }

    public static House getHufflepuff() {
        return hufflepuff;
    }

    public static House getRavenclaw() {
        return ravenclaw;
    }

    public static House getSlytherin() {
        return slytherin;
    }
    public static House getUnknown() {
        return unknown;
    }

    public String getFounder() {
        return founder;
    }

    public String[] getColors() {
        return colors;
    }


    @Override
    public String toString() {
        StringBuilder colorString = new StringBuilder();
        if (colors.length > 0) {
            for (String color : colors) {
                colorString.append(color).append(", ");
            }
            colorString.replace(colorString.lastIndexOf(", "), colorString.length() - 1, ".");
        }
        return "House{\n" +
                " name: " + name + "\n" +
                " founder: " + founder + "\n" +
                " colors: " + colorString + "\n" +
                "}";
    }
}
