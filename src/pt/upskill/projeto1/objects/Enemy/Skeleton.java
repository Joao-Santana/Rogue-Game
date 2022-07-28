package pt.upskill.projeto1.objects.Enemy;

import pt.upskill.projeto1.rogue.utils.Position;

public class Skeleton extends Enemy {


    public Skeleton(Position position)
    {
        super(position,5,50);
    }

    @Override
    public String getName() {
        return "Skeleton";
    }

}

