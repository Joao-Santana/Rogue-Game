package pt.upskill.projeto1.objects.Enemy;

import pt.upskill.projeto1.rogue.utils.Position;

public class BadGuy extends Enemy{

    public BadGuy(Position position) {
        super(position,5,20);
    }


    @Override
    public String getName() {
        return "BadGuy";
    }
}
