package GameElements;

import java.awt.image.BufferedImage;
import javax.swing.text.Position;

/**
 * Author: Davin Holmberg
 * 
 * Environment entities are those that don't move and can't be interacted with.
 * This includes both collidable and non-collidable objects. 
 * 
 * Should this be regular or abstract?
 */
public class Environment extends Entity{

    private boolean solid;
    
    public Environment(BufferedImage sprite, Position pos, Boolean solid) {
        super(sprite, pos);
        this.solid = solid;
    }

    public boolean isSolid() {
        return solid;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }

    
}
