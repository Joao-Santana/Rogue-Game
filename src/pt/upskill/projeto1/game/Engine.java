package pt.upskill.projeto1.game;
import pt.upskill.projeto1.gui.ImageMatrixGUI;
import pt.upskill.projeto1.gui.ImageTile;
import pt.upskill.projeto1.objects.Enemy.Enemy;
import pt.upskill.projeto1.objects.Items.*;
import pt.upskill.projeto1.objects.Room.*;
import pt.upskill.projeto1.rogue.utils.Direction;
import pt.upskill.projeto1.rogue.utils.Position;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
public class Engine {
    private Room room;
    private Hero hero = new Hero(new Position(1,1));

    private ArrayList<ImageTile> statusImage = new ArrayList<>();

    private HashMap<String, Room> levelsOfRoom = new HashMap<>();

    private ImageMatrixGUI gui = ImageMatrixGUI.getInstance();


    public void init() {
        room = new Room(hero);
        gui.setEngine(this);
        levelsOfRoom.put("room0.txt", room);
        room.createRoom("room0.txt", levelsOfRoom);
        gui.newImages(room.getTiles());

        for (int i = 0; i <= 9; ++i) {
                statusImage.add(new Black(new Position(i, 0)));
        }
        int xOffset = 3;
        for (int i = 0; i < 4; ++i)
        {
            statusImage.add(new LifeUnit(new Position(i + xOffset, 0), hero, i*10));
        }
        gui.go();
        gui.newStatusImages(statusImage);
        gui.setStatus("The Game Has Started!");
        while (!hero.amIDead()) {
            gui.update();
        }
        gui.showMessage("GAMEOVER", "YOU LOST");
    }
    public void notify(int keyPressed) {
        Direction d = null;
        switch (keyPressed) {
            case KeyEvent.VK_DOWN:
                d = Direction.DOWN;
                break;
            case KeyEvent.VK_S:
                d = Direction.DOWN;
                break;
            case KeyEvent.VK_UP:
                d = Direction.UP;
                break;
            case KeyEvent.VK_W:
                d = Direction.UP;
                break;
            case KeyEvent.VK_LEFT:
                d = Direction.LEFT;
                break;
            case KeyEvent.VK_A:
                d = Direction.LEFT;
                break;
            case KeyEvent.VK_RIGHT:
                d = Direction.RIGHT;
                break;
            case KeyEvent.VK_D:
                d = Direction.RIGHT;
                break;
            default:
                return;
        }
        for(Items heroitems: hero.getHeroInventory())
        {
            if(heroitems.getName().equals("Hammer"))
            {
                statusImage.add(new Hammer(new Position(hero.getHeroInventory().indexOf(heroitems)+7,0),30));
            }
            else if(heroitems.getName().equals("GoodMeat"))
            {
                    statusImage.add(new Meat(new Position(hero.getHeroInventory().indexOf(heroitems)+7,0),true,false));
            }
            else if(heroitems.getName().equals("Key"))
            {
                statusImage.add(new Key(new Position(hero.getHeroInventory().indexOf(heroitems)+7,0)));
            }
        }
        gui.newStatusImages(statusImage);
        gui.go();
        Position nextPosition = hero.getPosition().plus(d.asVector());
        hero.movement(room, nextPosition);
        Door nextDoor = hero.isNextDoor(room,nextPosition);
        if (nextDoor != null) {
            room = nextDoor.getNextRoom();
            gui.clearImages();
            gui.newImages(room.getTiles());
            hero.setPosition(room.door.getPosition());
            return;
        }
        for (Enemy enemy : room.getEnemies()) {
            enemy.movement(room);
        }
    }
    public static void main(String[] args) {
        Engine engine = new Engine();
        engine.init();
        System.exit(0);
    }
}
