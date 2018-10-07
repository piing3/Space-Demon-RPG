/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

/**
 *
 * @author Ben Allen
 */
public class Graphics extends Canvas implements Runnable {

    private static final int WIDTH = 300;
    private static final int HEIGHT = WIDTH / 16 * 9;
    private static final int SCALE = 3;
    private static final int TILESIZE = 16;
    public int x = 0, y = 0;
    public static final int MOVE_SPEED = 5;

    private Thread thread;
    private boolean running = false;
    private Screen screen;
    private JFrame frame;
    private Keyboard key;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    public Graphics() {
        Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
        setPreferredSize(size);
        screen = new Screen(WIDTH, HEIGHT);
        frame = new JFrame();
        key = new Keyboard();
        
        addKeyListener(key);
    }

    public synchronized void start() {
        running = true;
        thread = new Thread(this, "Display");
        thread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void run() {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns =  1000000000.0 / 60.0;
        double delta = 0;
        int frames = 0;
        int updates = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                update();
                updates++;
                delta--;
            }
            
            render();
            frames++;
            
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("Fps:" + frames + "  Ups:" + updates);
                frame.setTitle("Meme:  " + "Fps:" + frames + "  Ups:" + updates);
                frames = 0;
                updates = 0;
            }
        }
        stop();
    }

    public static void main(String[] args) {
        Graphics game = new Graphics();

        game.getFrame().setResizable(false);
        game.getFrame().setTitle("Meme: " + " Fps:" + 0 + "  Ups:" + 0);
        game.getFrame().add(game);
        game.getFrame().pack();
        game.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.getFrame().setLocationRelativeTo(null);
        game.requestFocusInWindow();
        game.getFrame().setVisible(true);

        game.start();

    }

    public JFrame getFrame() {
        return frame;
    }

    private void update() {
        key.update();
        if (key.up) {
            y -= MOVE_SPEED;
            System.out.println("up:" + key.up);
        }
        if (key.down) {
            y += MOVE_SPEED;
            System.out.println("Down:" + key.down);
        }
        if (key.left) {
            x -= MOVE_SPEED;
            System.out.println("left:" + key.left);
        }
        if (key.right) {
            x += MOVE_SPEED;
            System.out.println("right:" + key.right);
        }
    }

    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        //clears Screen
        screen.clear();
        //Filled Pixels in Screen Class
        screen.render(x,y);
        //Copies Pixels from Screen Class
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = screen.pixels[i];
        }
        java.awt.Graphics g = bs.getDrawGraphics();
        //Draws the Pixel Array
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        
        g.dispose();
        bs.show();
    }
    public static int getTileSize(){
        return TILESIZE;
    }
}
