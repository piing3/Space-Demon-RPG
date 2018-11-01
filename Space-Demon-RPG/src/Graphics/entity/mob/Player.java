/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics.entity.mob;

import Graphics.graphics.Screen;
import Graphics.graphics.Sprite;
import Graphics.input.Keyboard;

/**
 *
 * @author Ben Allen
 */
public class Player extends Mob {

    private Keyboard input;
    private Sprite sprite;
    private int anim = 0;
    private boolean walking = false;

    public Player(int x, int y, Keyboard input) {
        this.x = x;
        this.y = y;
        this.input = input;

    }

    public Player(Keyboard input) {
        this.input = input;
        sprite = Sprite.player_front;
    }

    @Override
    public void update() {
        int xa = 0;
        int ya = 0;
        if (anim < 7500) {
            anim++;
        } else {
            anim = 0;
        }
        if (input.up) {
            ya--;
        }
        if (input.down) {
            ya++;
        }
        if (input.left) {
            xa--;
        }
        if (input.right) {
            xa++;
        }

        if (xa != 0 || ya != 0) {
            move(xa, ya);
            walking = true;
        } else {
            walking = false;
        }

    }

    public void render(Screen screen) {
        if (dir == 1) {
            sprite = Sprite.player_front;
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = Sprite.player_front_1;
                } else {
                    sprite = Sprite.player_front_2;
                }
            }
        }
        if (dir == 0) {
            sprite = Sprite.player_back;
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = Sprite.player_back_1;
                } else {
                    sprite = Sprite.player_back_2;
                }
            }
        }
        if (dir == 2) {
            sprite = Sprite.player_left;
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = Sprite.player_left_1;
                } else {
                    sprite = Sprite.player_left_2;
                }
            }
        }
        if (dir == 3) {
            sprite = Sprite.player_right;
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = Sprite.player_right_1;
                } else {
                    sprite = Sprite.player_right_2;
                }
            }
        }
        screen.renderPlayer(x - 16, y - 16, sprite);
    }
}
