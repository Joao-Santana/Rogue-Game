package pt.upskill.projeto1.objects.Items;
import pt.upskill.projeto1.rogue.utils.Position;

public class Sword extends Items
{
    private int damage;

    public Sword(Position position, int damage)
    {
        super(position, false, true);
        this.damage = damage;
    }

    @Override
    public String getName() {
        return "Sword";
    }

    public int getDamage() {
        return damage;
    }
}
