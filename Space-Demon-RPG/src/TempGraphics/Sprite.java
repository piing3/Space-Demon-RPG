/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TempGraphics;

/**
 *
 * @author Ben Allen
 */
public class Sprite {

    private final int SIZE;
    private int x, y;
    public int[] pixels;
    public static SpriteSheet sheet;

    public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.Sheet);

    public Sprite(int size, int x, int y, SpriteSheet sheet) {
        this.SIZE = size;
        pixels = new int[SIZE * SIZE];
        this.x = x * size;
        this.y = y * size;
        this.sheet = sheet;
        load();
    }

    private void load() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
            }
        }
    }

}
