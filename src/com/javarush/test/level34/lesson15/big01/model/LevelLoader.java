package com.javarush.test.level34.lesson15.big01.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {
    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = null;
        int currentLevel;
        int height;
        int x;
        int y;
        if (level > 60) level = 1;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(levels.toFile()));
            String string;
            while ((string = reader.readLine()) != null) {
                currentLevel = 0;
                if (string.trim().contains("Maze: ")) {
                    string = string.replace("Maze: ", "");
                    currentLevel = Integer.parseInt(string);
                }
                if (currentLevel == level) {
                    reader.readLine();
                    reader.readLine();

                    string = reader.readLine().trim().replace("Size Y: ", "");
                    height = Integer.parseInt(string);

                    reader.readLine();
                    reader.readLine();
                    reader.readLine();

                    y = 0;

                    while (height > 0) {
                        x = 0;
                        y += Model.FIELD_SELL_SIZE;
                        char[] elements = reader.readLine().toCharArray();
                        for (int i = 0; i < elements.length; i++) {
                            x += Model.FIELD_SELL_SIZE;
                            switch (elements[i]) {
                                case ('X'):
                                    walls.add(new Wall(x - Model.FIELD_SELL_SIZE / 2, y - Model.FIELD_SELL_SIZE / 2));
                                    break;
                                case ('*'):
                                    boxes.add(new Box(x - Model.FIELD_SELL_SIZE / 2, y - Model.FIELD_SELL_SIZE / 2));
                                    break;
                                case ('.'):
                                    homes.add(new Home(x - Model.FIELD_SELL_SIZE / 2, y - Model.FIELD_SELL_SIZE / 2));
                                    break;
                                case ('@'):
                                    player = new Player(x - Model.FIELD_SELL_SIZE / 2, y - Model.FIELD_SELL_SIZE / 2);
                                    break;
                                case ('&'):
                                    boxes.add(new Box(x - Model.FIELD_SELL_SIZE / 2, y - Model.FIELD_SELL_SIZE / 2));
                                    homes.add(new Home(x - Model.FIELD_SELL_SIZE / 2, y - Model.FIELD_SELL_SIZE / 2));
                            }
                        }
                        height--;
                    }
                }
            }
        } catch (IOException e) {
        }

        return new GameObjects(walls, boxes, homes, player);
    }
}
