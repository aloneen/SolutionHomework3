package kz.seisen.Entities;

import java.util.HashMap;

public class Player implements IGameEntity {

    private String name;
    private String description;
    private Room currentRoom;
    private HashMap<Item, Integer> inventory;

    @Override
    public void describe() {
        System.out.println("Name: " + name + " - Description: " + description);
    }




    public Player(String name, String description) {
        this.name = name;
        this.description = description;
        inventory = new HashMap<>();
    }

    public Player(String name, Room currentRoom) {
        this.name = name;
        this.currentRoom = currentRoom;
        inventory = new HashMap<>();
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

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public HashMap<Item, Integer> getInventory() {
        return inventory;
    }
    public void setInventory(HashMap<Item, Integer> inventory) {
        this.inventory = inventory;
    }









    public void addItem(Item item) {
        inventory.put(item, inventory.getOrDefault(item, 0) + 1);
    }

    public void removeItem(Item item) {
        if (inventory.containsKey(item)) {
            if (inventory.get(item) > 0) {
                inventory.put(item, inventory.get(item) - 1);
            }else {
                inventory.remove(item);
            }
        }
    }

}
