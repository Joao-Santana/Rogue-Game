package pt.upskill.projeto1.objects.Items;

import pt.upskill.projeto1.rogue.utils.Position;

public class Hammer extends Items
{
    private int damage;

    public Hammer(Position position, int damage)
    {
        super(position, false, true);
        this.damage = damage;
    }
    @Override
    public String getName() {
        return "Hammer";
    }

    public int getDamage() {
        return damage;
    }
}
