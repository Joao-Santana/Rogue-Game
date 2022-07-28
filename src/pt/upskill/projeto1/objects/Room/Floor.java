package pt.upskill.projeto1.objects.Room;
import pt.upskill.projeto1.objects.GameObject;
import pt.upskill.projeto1.rogue.utils.Position;

public class Floor extends GameObject
{
    public Floor(Position position)
    {
        super(position);
    }
    @Override
    public String getName() {
        return "Floor";
    }

}
