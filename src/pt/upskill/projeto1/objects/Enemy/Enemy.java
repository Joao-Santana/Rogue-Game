package pt.upskill.projeto1.objects.Enemy;
import pt.upskill.projeto1.gui.ImageTile;
import pt.upskill.projeto1.objects.Room.*;
import pt.upskill.projeto1.objects.Room.Character;
import pt.upskill.projeto1.rogue.utils.Direction;
import pt.upskill.projeto1.rogue.utils.Position;
import java.util.Random;

public abstract class Enemy extends Character implements ImageTile {

    public Enemy(Position position, int damage, int health) {
        super(position, damage, health);
    }

    public void movement(Room room)
    {
        int diferenceOfY = getPosition().getY() - room.getHero().getPosition().getY();
        int diferenceOfX = getPosition().getX() - room.getHero().getPosition().getX();
        Direction direction;

        if ((Math.abs(diferenceOfX) <=2) && (Math.abs(diferenceOfY) <=2))
        {
            direction = moveToHero(room.getHero());
        }
        else {
            Random random = new Random();
            int rdm = random.nextInt(4) + 1;
            switch (rdm) {
                case 1:
                    direction = Direction.UP;
                    break;
                case 2:
                    direction = Direction.LEFT;
                    break;
                case 3:
                    direction = Direction.RIGHT;
                    break;
                case 4:
                    direction = Direction.DOWN;
                    break;
                default:
                    return;
            }
        }
            Position nextPosition = getPosition().plus(direction.asVector());
            ImageTile obstacle = canMove(room, nextPosition);
            if (obstacle == null) {
                this.setPosition(nextPosition);
            } else if (obstacle instanceof Hero) {
                attack((Hero) obstacle);
            }

    }
    @Override
    public boolean isBlockingTheWay(ImageTile imageTile) {
        if (imageTile instanceof Wall || imageTile instanceof Door || imageTile instanceof Hero) {
            return true;
        }
        return false;
    }

    public void attack(Hero hero)
    {
        hero.setHealth(hero.getHealth() - this.getDamage());
        hero.amIDead();
    }
    public Direction  moveToHero(Hero hero)
    {
        int diferenceOfY = getPosition().getY() - hero.getPosition().getY();
        int diferenceOfX = getPosition().getX() - hero.getPosition().getX();

        if (diferenceOfX > 0) {
            return Direction.LEFT;
        }
        if (diferenceOfX < 0) {
            return Direction.RIGHT;
        }
        if ((diferenceOfY > 0)) {
            return Direction.UP;
        }
        return Direction.DOWN;
    }

}
