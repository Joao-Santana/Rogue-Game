package pt.upskill.projeto1.objects.Items;

import pt.upskill.projeto1.rogue.utils.Position;

public class Meat extends Items
{
    private int recoversHealth;
    public Meat(Position position, boolean isConsumable, boolean isEquipable) {
        super(position, isConsumable, isEquipable);
        recoversHealth = 10;
    }

    @Override
    public String getName() {
        return "GoodMeat";
    }

    public void setRecoversHealth(int recoversHealth) {
        this.recoversHealth = recoversHealth;
    }

    public int getRecoversHealth() {
        return recoversHealth;
    }
}
