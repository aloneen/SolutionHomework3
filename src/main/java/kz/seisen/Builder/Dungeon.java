package kz.seisen.Builder;

import kz.seisen.Entities.*;

import java.util.ArrayList;
import java.util.List;

public class Dungeon {
    private String name;
    private List<Room> rooms;
    private List<NPC> npcs;

    public Dungeon(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
        this.npcs = new ArrayList<>();
    }


    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addNPC(NPC npc) {
        npcs.add(npc);
    }




    //getters

    public String getName() {
        return name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<NPC> getNPCs() {
        return npcs;
    }




    // builder can set them.
    void setName(String name) {
        this.name = name;
    }

    void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    void setNpcs(List<NPC> npcs) {
        this.npcs = npcs;
    }



    @Override
    public String toString() {
        return "Dungeon: " + name + "\nRooms: " + rooms + "\nNPCs: " + npcs;
    }
}