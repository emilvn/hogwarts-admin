package src.edu.hogwarts.data;

public class Tool extends TeachingMaterial {
    private String name;
    private String description;

    public Tool(String name, String description, boolean onShoppingList, boolean required, boolean provided, String notes) {
        super(name, onShoppingList, required, provided, notes);
        this.name = name;
        this.description = description;
    }

    public Tool() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Tool{\n" +
                "name: " + name + "\n" +
                "description: " + description + "\n" +
                "onShoppingList: " + isOnShoppingList() + "\n" +
                "required: " + isRequired() + "\n" +
                "provided: " + isProvided() + "\n" +
                "notes: " + getNotes() + "\n" +
                "}";
    }
}
