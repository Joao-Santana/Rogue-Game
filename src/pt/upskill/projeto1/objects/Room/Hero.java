package pt.upskill.projeto1.objects.Room;
import pt.upskill.projeto1.gui.ImageTile;
import pt.upskill.projeto1.objects.Enemy.Enemy;
import pt.upskill.projeto1.objects.Items.Items;
import pt.upskill.projeto1.objects.Items.Key;
import pt.upskill.projeto1.rogue.utils.Position;
import java.util.ArrayList;
public class Hero extends Character
{

    private ArrayList<Key> keys = new ArrayList<>();

    private ArrayList<Items> heroInventory = new ArrayList<>();

    public Hero(Position position)
    {
        super(position, 10, 40);
    }

    @Override
    public String getName() {
        return "Hero";
    }

    public ArrayList<Items> getHeroInventory() {
        return heroInventory;
    }

    @Override
    public boolean isBlockingTheWay(ImageTile imageTile) {
        if (imageTile instanceof Wall || imageTile instanceof Enemy) {
            return true;
        }
        else if (imageTile instanceof Door) {
            return !(((Door) imageTile).getIsOpen());
        }
        else if(imageTile instanceof Items)
        {
            pickUp((Items) imageTile);
            return false;
        }
        return false;
    }
    public void attack(Enemy enemy)
    {
        enemy.setHealth(enemy.getHealth() - this.getDamage());
        enemy.amIDead();
    }
    public Door isNextDoor(Room room, Position position) {
        for (ImageTile imageTile : room.getTiles()) {
            if (imageTile.getPosition().equals(position)) {
                if (imageTile instanceof Door) {
                    return (Door) imageTile;
                }
            }
        }
        return null;
    }
    public void movement(Room room, Position nextPosition)
    {
        ImageTile obstacle = canMove(room,nextPosition);

        if(obstacle == null)
        {
            this.setPosition(nextPosition);
        }
        else if (obstacle instanceof Enemy)
        {
            attack((Enemy) obstacle);
        }
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
    public void pickUp(Items item) {
        if (heroInventory.size() < 3)
        {
            heroInventory.add((item));
            item.setPosition(new Position(-1000,-1000));
        }
    }
}