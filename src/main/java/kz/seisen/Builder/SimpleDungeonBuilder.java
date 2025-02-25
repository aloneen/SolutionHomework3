package kz.seisen.Builder;


import kz.seisen.Entities.NPC;
import kz.seisen.Entities.Room;

public class SimpleDungeonBuilder implements IDungeonBuilder {
    private Dungeon dungeon;
    private Room roomPrototype;
    private int cloneCounter = 0; // Counter for cloned rooms

    public SimpleDungeonBuilder() {
        this.dungeon = new Dungeon("Default Dungeon");
    }

    public void setRoomPrototype(Room roomPrototype) {
        this.roomPrototype = roomPrototype;
    }

    @Override
    public IDungeonBuilder setDungeonName(String name) {
        this.dungeon = new Dungeon(name);
        return this;
    }

    @Override
    public IDungeonBuilder addRoom(Room room) {
        dungeon.addRoom(room);
        return this;
    }

    @Override
    public IDungeonBuilder makeCloneOfRoom() {
        if (roomPrototype != null) {
            // Clone the prototype and give numbers
            Room clonedRoom = (Room) roomPrototype.clone();
            clonedRoom.setName("Clone #" + (++cloneCounter) + " " + clonedRoom.getName());
            dungeon.addRoom(clonedRoom);
        }
        return this;
    }

    @Override
    public IDungeonBuilder addNPC(NPC npc) {
        dungeon.addNPC(npc);
        return this;
    }

    @Override
    public Dungeon build() {
        return dungeon;
    }
}