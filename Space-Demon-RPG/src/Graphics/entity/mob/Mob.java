/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics.entity.mob;

import Graphics.entity.Entity;
import Graphics.graphics.Sprite;

/**
 *
 * @author Ben Allen
 */
public abstract class Mob extends Entity {

    protected Sprite sprite;
    protected int dir = 0;
    protected boolean moving = false;

    public void move(int xa, int ya) {
        if (xa > 0) {
            dir = 3; // RIGHT
        }
        if (xa < 0) {
            dir = 2; // LEFT
        }
        if (ya < 0) {
            dir = 0; // UP
        }
        if (ya > 0) {
            dir = 1; // DOWN
        }
        if (!collision()) {
            x += xa;
            y += ya;
        }

    }

    public void update() {
    }

    public void render() {
    }

    private boolean collision() {
        return false;
    }
}
