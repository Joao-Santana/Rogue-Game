package pt.upskill.projeto1.objects.Room;
import pt.upskill.projeto1.objects.GameObject;
import pt.upskill.projeto1.rogue.utils.Position;
public class LifeUnit extends GameObject
{
    private int lifeCounter;

    private Hero hero;

    public LifeUnit(Position position, Hero hero, int lifeCounter) {
        super(position);
        this.hero = hero;
        this.lifeCounter = lifeCounter;
    }

    @Override
    public String getName() {
        int currentHerolife = hero.getHealth();
        if(currentHerolife <= lifeCounter)
        {
            return "Red";
        }
        else if (currentHerolife > lifeCounter + 9)
        {
          return "Green";
        }
        else
        {
            return "RedGreen";
        }
    }

    public int getLifeCounter() {
        return lifeCounter;
    }

}
