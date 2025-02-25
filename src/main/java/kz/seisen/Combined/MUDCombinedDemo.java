package kz.seisen.Combined;

import kz.seisen.Builder.Dungeon;
import kz.seisen.Builder.IDungeonBuilder;
import kz.seisen.Builder.SimpleDungeonBuilder;
import kz.seisen.Entities.Item;
import kz.seisen.Entities.NPC;
import kz.seisen.Entities.Room;


public class MUDCombinedDemo {
    public static void main(String[] args) {
        // Create a prototype room
        Room prototypeRoom = new Room("Main Hall", "The grand entrance to the dungeon.");
        prototypeRoom.addItem(new Item("Sword", "A sharp blade for combat."));

        // Create a dungeon using the builder and prototype
        SimpleDungeonBuilder builder = new SimpleDungeonBuilder();
        builder.setRoomPrototype(prototypeRoom);

        Dungeon dungeon = builder.setDungeonName("Dark Forest")
                .addRoom(new Room("Something important", "asdfa")) // Just usual unique Room adding
                .makeCloneOfRoom() // using prototype and making bunch of copies just with one method.
                .makeCloneOfRoom()
                .addNPC(new NPC("Guard", "A sturdy guard protecting the entrance."))
                .addNPC(new NPC("Wizard", "Magic casting is important"))
                .build();

        // Display the dungeon
        System.out.println(dungeon);



        //In the console you should see that addRoom doesn't create any Clone. it's just creates an object. B
        //but make clone uses roomPrototype to create clone.
    }
}