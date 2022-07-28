package pt.upskill.projeto1.objects.Room;
import pt.upskill.projeto1.gui.ImageTile;
import pt.upskill.projeto1.objects.GameObject;
import pt.upskill.projeto1.rogue.utils.Position;
public abstract class Character extends GameObject
{
    private int damage;
    private int health;

    public Character(Position position, int damage, int health) {
        super(position);
        this.damage = damage;
        this.health = health;
    }
    @Override
    public abstract String getName();

    public ImageTile canMove(Room room, Position nextPosition) {

        for (ImageTile imageTile : room.getTiles()) {
            if(imageTile.getPosition().equals(nextPosition))
            {
                if(isBlockingTheWay(imageTile))
                {
                   return imageTile;
                }
            }
        }
        return null;
    }

    public abstract boolean isBlockingTheWay(ImageTile imageTile);

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean amIDead()
    {
        if(this.getHealth() <= 0)
        {
            setPosition(new Position(-1000,-1000));
            return true;
        }
        return false;
    }


}
