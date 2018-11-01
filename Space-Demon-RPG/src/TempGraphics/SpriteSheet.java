/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TempGraphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Ben Allen
 */
public class SpriteSheet {

    private String path;
    public final int SIZE;
    public int[] pixels;

    public static SpriteSheet Sheet = new SpriteSheet("src/Textures/spriteSheet.png", 256);

    public SpriteSheet(String path, int SIZE) {
        this.path = path;
        this.SIZE = SIZE;
        pixels = new int[SIZE * SIZE];
        load();
    }

    private void load() {
        try {
            BufferedImage image = ImageIO.read(SpriteSheet.class.getResource("/Textures/spriteSheet.png"));
            int w = image.getWidth();
            int h = image.getHeight();
            image.getRGB(0, 0, w, h, pixels, 0, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
