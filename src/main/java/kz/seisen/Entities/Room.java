package kz.seisen.Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Room implements IGameEntity, CloneableGameEntity {
    private String name;
    private String description;
    private List<Item> items;
    private List<NPC> npcs;
    private HashMap<String, Room> connectedRooms;




    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>();
        this.npcs = new ArrayList<>();
        this.connectedRooms = new HashMap<>();
    }


    public Room(String name, String description, List<Item> items, List<NPC> npcs, HashMap<String, Room> connectedRooms) {
        this.name = name;
        this.description = description;
        this.items = items;
        this.npcs = npcs;
        this.connectedRooms = connectedRooms;
    }



    @Override
    public void describe() {
        System.out.println("Room: " + name + " - " + description);
    }







    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<NPC> getNPCs() {
        return npcs;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void addNPC(NPC npc) {
        npcs.add(npc);
    }

    public void removeNPC(NPC npc) {
        npcs.remove(npc);
    }

    public Room getConnectedRoom(String direction) {
        return connectedRooms.get(direction);
    }

    public void connectRoom(String direction, Room room) {
        connectedRooms.put(direction, room);
    }

    public void setName(String s) {
        this.name = s;
    }


    public HashMap<String, Room> getConnectedRooms() {
        return connectedRooms;
    }






    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", items=" + items +
                ", npcs=" + npcs +
                ", connectedRooms=" + connectedRooms +
                '}';
    }






    public Item getItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    public NPC getNPC(String npcName) {
        for (NPC npc : npcs) {
            if (npc.getName().equals(npcName)) {
                return npc;
            }
        }
        return null;
    }




    //Clone method. Prototype
    @Override
    public CloneableGameEntity clone() {

        //Making deep copy for items
        List<Item> newItems = new ArrayList<>();
        for (Item item : this.items) {
            newItems.add(new Item(item.getName(), item.getDescription())); // Deep Copy of each element of the List
        }


        //Making deep copy of NPC List
        List<NPC> newNpcs = new ArrayList<>();
        for (NPC npc : this.npcs) {
            newNpcs.add(new NPC(npc.getName(), npc.getDescription()));
        }

//        HashMap<String, Room> newConnectedRooms = new HashMap<>();
//        for (String direction : this.connectedRooms.keySet()) {
//        //  newConnectedRooms.put(direction, new Room(this.connectedRooms.get(direction).getName(),
//        //                                     this.connectedRooms.get(direction).getDescription()));
//            newConnectedRooms.put(direction, this.connectedRooms.get(direction));
//        }



        HashMap<String, Room> newConnectedRooms = new HashMap<>();
        for (String direction : this.connectedRooms.keySet()) {
            Room originalRoom = this.connectedRooms.get(direction);
            if (originalRoom != null) {
                newConnectedRooms.put(direction, (Room) originalRoom.clone()); // deep copy
            }
        }


        //We did all of this stuff only because there can be objects with same links.
        return new Room(this.name, this.description, newItems, newNpcs, newConnectedRooms);
    }

}