package pt.upskill.projeto1.objects.Room;
import pt.upskill.projeto1.objects.GameObject;
import pt.upskill.projeto1.rogue.utils.Position;

public class Wall extends GameObject
{
    public Wall(Position position)
    {
        super(position);
    }

    @Override
    public String getName() {
        return "Wall";
    }

}
