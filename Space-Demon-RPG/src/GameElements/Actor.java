package GameElements;

import java.awt.image.BufferedImage;
import javax.swing.text.Position;

/**
 * Author: Davin Holmberg
 * 
 * Actors are entities that can do stuff
 */
public abstract class Actor extends Entity{

    private int actorType;
    private String name;
    private String[] dialogue;
    //private ??? movement; no clue how to do this
    
    public Actor(BufferedImage sprite, Position pos, int actorType, String name) {
        super(sprite, pos);
        this.actorType = actorType;
        this.name = name;
    }

    public int getActorType() {
        return actorType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
}
