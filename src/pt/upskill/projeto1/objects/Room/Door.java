package pt.upskill.projeto1.objects.Room;
import pt.upskill.projeto1.objects.GameObject;
import pt.upskill.projeto1.rogue.utils.Position;
public class Door extends GameObject
{
    private boolean isOpen;

    private Room nextRoom;

    private String doorType;

    private String nextStartingPos;

    private String key;

    public Door(Position position, Room nextRoom, String doorType, String nextStartingPos, String key) {
        super(position);
        this.nextRoom = nextRoom;
        this.doorType = doorType;
        this.nextStartingPos = nextStartingPos;
        this.key = key;
        this.isOpen = false;
    }
    @Override
    public String getName()
    {
        if(isOpen)
        {
            return "DoorOpen";
        }
        return "DoorClosed";
    }
    public boolean getIsOpen()
    {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public Room getNextRoom() {
        return nextRoom;
    }

    public String getDoorType() {
        return doorType;
    }

    public String getNextStartingPos() {
        return nextStartingPos;
    }

    public String getKey() {
        return key;
    }

}
