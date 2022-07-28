package pt.upskill.projeto1.objects.Items;
import pt.upskill.projeto1.gui.ImageTile;
import pt.upskill.projeto1.objects.GameObject;
import pt.upskill.projeto1.rogue.utils.Position;

public class Items extends GameObject
{
    private boolean isConsumable;
    private boolean isEquipable;
    public Items(Position position, boolean isConsumable, boolean isEquipable)
    {
        super(position);
        this.isConsumable = isConsumable;
        this.isEquipable = isEquipable;
    }

    public void setConsumable(boolean consumable) {
        isConsumable = consumable;
    }

    public void setEquipable(boolean equipable) {
        isEquipable = equipable;
    }

    @Override
    public String getName() {
        return "null";
    }

}
