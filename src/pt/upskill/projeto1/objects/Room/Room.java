package pt.upskill.projeto1.objects.Room;
import pt.upskill.projeto1.gui.ImageTile;
import pt.upskill.projeto1.objects.Enemy.*;
import pt.upskill.projeto1.objects.Items.Meat;
import pt.upskill.projeto1.objects.Items.Hammer;
import pt.upskill.projeto1.objects.Items.Items;
import pt.upskill.projeto1.objects.Items.Key;
import pt.upskill.projeto1.rogue.utils.Position;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Room {
    private List<ImageTile> tiles = new ArrayList<>();

    private List<Enemy> enemies = new ArrayList<>();

    private List<Items> items = new ArrayList<>();

    private Hero hero;

    public Door door;


    public Room(Hero hero) {
        this.hero = hero;
    }
    public void createRoom(String pathname, HashMap<String, Room> levelsOfDoor)
    {
        List<Door> listOfDoors = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++) {
                tiles.add(new Floor(new Position(i, j)));
            }
        try {
            Scanner s = new Scanner(new File("C:/Upskill/Upskill projeto - Joao Santana/Version 2 - Rogue_UPskill2022_v1_Nome_Completo/rooms/" + pathname));
            int nr2 = 0;
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if ((line.charAt(0) == '#')) {
                    if (line.length() > 1) {
                        String[] token = line.split(" ");
                        String key = null;
                        switch (token.length) {
                            case 6:
                                key = token[5];
                            case 5:
                                if (!levelsOfDoor.containsKey(token[3])) {
                                    Room nextRoom = new Room(hero);
                                    levelsOfDoor.put(token[3], nextRoom);
                                    nextRoom.createRoom(token[3], levelsOfDoor);
                                }
                                Room nextRoom = levelsOfDoor.get(token[3]);
                                listOfDoors.add(new Door(new Position(-1, -1), nextRoom, token[2], token[4], key));
                                break;
                        }
                    }
                } else {
                    for (int i = 0; i < line.length(); i++) {
                        char lineChar = line.charAt(i);
                        switch (lineChar) {
                            case 'W':
                                tiles.add(new Wall(new Position(i, nr2)));
                                break;
                            case 'S':
                                Enemy skeleton = (new Skeleton(new Position(i, nr2)));
                                tiles.add(skeleton);
                                enemies.add(skeleton);
                                break;
                            case 'H':
                                 hero.setPosition(new Position(i, nr2));
                                break;
                            case 'k':
                                Items key = new Key(new Position(i, nr2));
                                tiles.add(key);
                                items.add(key);
                                break;
                            case 'B':
                                Enemy bat = new Bat(new Position(i, nr2));
                                tiles.add(bat);
                                enemies.add(bat);
                                break;
                            case 'G':
                                Enemy badguy = new BadGuy(new Position(i, nr2));
                                tiles.add(badguy);
                                enemies.add(badguy);
                                break;
                            case 'h':
                                Items hammer = new Hammer(new Position(i, nr2), 30);
                                tiles.add(hammer);
                                items.add(hammer);
                                break;
                            case 'm':
                                Items meat = new Meat(new Position(i, nr2), true, false);
                                tiles.add(meat);
                                items.add(meat);
                                break;
                            case 't':
                                Enemy thief = new Thief(new Position(i, nr2));
                                tiles.add(thief);
                                enemies.add(thief);
                                break;
                            case ' ':
                                break;
                            default:
                                if(java.lang.Character.isDigit(lineChar))
                            {
                                int doorNumb = lineChar - '0';
                                door = listOfDoors.get(doorNumb);
                                door.setPosition(new Position(i,nr2));
                                tiles.add(door);
                            }
                        }
                    }
                    nr2++;
                }
            }
            tiles.add(hero);
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public List<ImageTile> getTiles() {
        return tiles;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Items> getItems() {
        return items;
    }

    public Hero getHero() {
        return hero;
    }


}

