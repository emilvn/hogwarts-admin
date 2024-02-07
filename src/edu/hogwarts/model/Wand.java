package src.edu.hogwarts.model;

import src.edu.hogwarts.model.TeachingMaterial;

public class Wand extends TeachingMaterial {
    private double lengthInInches;
    private String wood;
    private String core;

    public Wand(double lengthInInches, String wood, String core, String name, boolean onShoppingList, boolean required, boolean provided, String notes) {
        super(name, onShoppingList, required, provided, notes);
        this.lengthInInches = lengthInInches;
        this.wood = wood;
        this.core = core;
    }

    public Wand() {
        super();
    }

    public double getLengthInInches() {
        return lengthInInches;
    }

    public void setLengthInInches(double lengthInInches) {
        this.lengthInInches = lengthInInches;
    }

    public String getWood() {
        return wood;
    }

    public void setWood(String wood) {
        this.wood = wood;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    @Override
    public String toString() {
        return "Wand{\n" +
                "lengthInInches: " + lengthInInches + "\n" +
                "wood: " + wood + "\n" +
                "core: " + core + "\n" +
                "name: " + getName() + "\n" +
                "onShoppingList: " + isOnShoppingList() + "\n" +
                "required: " + isRequired() + "\n" +
                "provided: " + isProvided() + "\n" +
                "notes: " + getNotes() + "\n" +
                "}";
    }
}
