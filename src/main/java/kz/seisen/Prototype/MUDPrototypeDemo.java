package kz.seisen.Prototype;


import kz.seisen.Entities.Item;
import kz.seisen.Entities.Room;

public class MUDPrototypeDemo {
    public static void main(String[] args) {
        // Create a prototype room
        Room prototypeRoom = new Room("Main Hall", "The grand entrance to the dungeon.");
        prototypeRoom.addItem(new Item("Sword", "A sharp blade for combat."));

        // Clone the prototype room
        Room clonedRoom = (Room) prototypeRoom.clone();
        clonedRoom.addItem(new Item("Shield", "A sturdy shield for defense."));


        // Display the rooms
        System.out.println("Prototype Room: " + prototypeRoom);
        System.out.println("Cloned Room: " + clonedRoom);



        // Example of modifiying
        clonedRoom = new Room(prototypeRoom.getName(), "Just modified");
        System.out.println("Cloned and modified Room: " + clonedRoom);
    }
}
