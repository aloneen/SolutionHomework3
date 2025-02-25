package kz.seisen.Builder;


import kz.seisen.Entities.NPC;
import kz.seisen.Entities.Room;

public class MUDBuilderDemo {
    public static void main(String[] args) {
        // Create a dungeon using the builder
        IDungeonBuilder builder = new SimpleDungeonBuilder();
        Dungeon dungeon = builder.setDungeonName("Dark Forest")
                .addRoom(new Room("Entrance", "A dark and eerie entrance."))
                .addRoom(new Room("Treasure Room", "A room filled with gold and jewels."))
                .addNPC(new NPC("Guard", "A sturdy guard protecting the entrance."))
                .build();

        // Display the dungeon
        System.out.println(dungeon);
    }
}