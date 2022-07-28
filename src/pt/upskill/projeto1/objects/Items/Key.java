package pt.upskill.projeto1.objects.Items;
import pt.upskill.projeto1.rogue.utils.Position;

public class Key extends Items
{

    public Key(Position position)
    {
        super(position, false, true);
    }

    @Override
    public String getName() {
        return "Key";
    }

}
