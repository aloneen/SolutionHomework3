package kz.seisen.Builder;

import kz.seisen.Entities.NPC;
import kz.seisen.Entities.Room;

public interface IDungeonBuilder {
    IDungeonBuilder setDungeonName(String name);
    IDungeonBuilder addRoom(Room room);
    IDungeonBuilder addNPC(NPC npc);
    IDungeonBuilder makeCloneOfRoom();
    Dungeon build();
}