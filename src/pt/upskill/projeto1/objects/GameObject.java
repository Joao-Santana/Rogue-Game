package pt.upskill.projeto1.objects;

import pt.upskill.projeto1.gui.ImageTile;
import pt.upskill.projeto1.rogue.utils.Position;

public abstract class GameObject implements ImageTile {

    private Position position;

    public GameObject(Position position)
    {
        this.position = position;
    }
    @Override
    public abstract String getName();

    @Override
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
}
