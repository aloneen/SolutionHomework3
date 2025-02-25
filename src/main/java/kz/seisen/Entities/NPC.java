package kz.seisen.Entities;

public class NPC implements IGameEntity{

    private String name;
    private String description;


    public NPC() {
    }

    public NPC(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void describe() {
        System.out.println("NPC: " + name + " - " + description);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
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
}
