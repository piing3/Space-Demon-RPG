/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TempGraphics;

import static java.lang.Math.random;
import java.util.Random;

/**
 *
 * @author Ben Allen
 */
public class Screen {

    private int width, height;
    public int MAP_SIZE = 12;
    public int MAP_SIZE_MASK = MAP_SIZE - 1;
    public int[] pixels;

    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

    private Random random = new Random();

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];

        for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
            tiles[i] = random.nextInt(0xffffff);
        }
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    public void render(int xOffset, int yOffSet) {

        for (int y = 0; y < height; y++) {
            int yMove = y + yOffSet;
            //if (yMove < 0 || yMove >= height) break;
            for (int x = 0; x < width; x++) {
                int xMove = x + xOffset;
                //if (xMove < 0 || xMove >= width) break;
                int tileIndex = ((xMove / Graphics.getTileSize()) & MAP_SIZE_MASK) + ((yMove / Graphics.getTileSize()) & MAP_SIZE_MASK) * MAP_SIZE;
                pixels[x + y * width] = Sprite.grass.pixels[(x&15) + (y&15) * 16];
            }
        }
    }

}
