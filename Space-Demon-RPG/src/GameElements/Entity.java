package GameElements;

import java.awt.image.BufferedImage;
import javax.swing.text.Position;

/**
 * Author: Davin Holmberg
 * 
 * Entities appear on the map, and so have a position and a sprite.
 * maybe size, if needed
 */
public abstract class Entity {
    //private int size;
    private BufferedImage sprite; 
    private Position pos;

    public Entity(BufferedImage sprite, Position pos) {
        this.sprite = sprite;
        this.pos = pos;
    }
    
    public BufferedImage getSprite(){
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }
    
    
}
