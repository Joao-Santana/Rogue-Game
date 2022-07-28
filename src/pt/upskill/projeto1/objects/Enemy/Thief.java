package pt.upskill.projeto1.objects.Enemy;
import pt.upskill.projeto1.gui.ImageMatrixGUI;
import pt.upskill.projeto1.gui.ImageTile;
import pt.upskill.projeto1.objects.Room.Hero;
import pt.upskill.projeto1.objects.Room.Room;
import pt.upskill.projeto1.rogue.utils.Direction;
import pt.upskill.projeto1.rogue.utils.Position;
import java.util.Random;

public class Thief extends Enemy{

    public Thief(Position position) {
        super(position, 5, 50);
    }

    @Override
    public String getName() {
        return "Thief";
    }
    @Override
    public void movement(Room room) {
        ImageMatrixGUI gui = ImageMatrixGUI.getInstance();
        Direction direction = null;
        Random random = new Random();
        int rdm = random.nextInt(4) + 1;
        switch (rdm) {
            case 1:
                direction = Direction.LEFTUP;
                break;
            case 2:
                direction = Direction.LEFTDOWN;
                break;
            case 3:
                direction = Direction.RIGHTDOWN;
                break;
            case 4:
                direction = Direction.RIGHTUP;
                break;
            default:
                return;
        }
        Position nextPosition = getPosition().plus(direction.asVector());
        ImageTile obstacle = canMove(room, nextPosition);
        if (obstacle == null) {
            this.setPosition(nextPosition);
        } else if (obstacle instanceof Hero) {
            attack((Hero) obstacle);
        }
    }
}
