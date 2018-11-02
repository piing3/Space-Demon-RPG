package GameElements;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import javax.swing.text.Position;

/**
 * Author: Davin Holmberg
 * 
 * Hey, it's you!
 */
public class Player extends Actor{

    private final Inventory inventory = new Inventory();
    
    public Player(BufferedImage sprite, Position pos) {
        super(sprite, pos, 0, "Garry from IT, thirteenth of his name");
    }
    
}