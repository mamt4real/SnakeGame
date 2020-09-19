/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author MIQDAD
 */
public class Crazy implements Levels{
    
    private Rectangle[] rects;
   
    public Crazy(){
        rects = new Rectangle[11];
        rects[0] = new Rectangle(0,0,120,8);
        rects[1] = new Rectangle(0,0,70,160);
        rects[2] = new Rectangle(0,240,400,8);
        rects[3] = new Rectangle(196,240,8,160);
        rects[4] = new Rectangle(0,182,200,8);
        rects[5] = new Rectangle(150,0,150,8);
        rects[6] = new Rectangle(350,0,50,8);
        rects[7] = new Rectangle(392,0,8,160);
        rects[8] = new Rectangle(250,182,150,8);
        rects[9] = new Rectangle(180,8,20,8);
        rects[10] = new Rectangle(192,16,8,174);
        
    }
        
    public void draw(Graphics g) {
        //background
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, 400, 400);
        //borders
        g.setColor(Color.cyan);
        for(Rectangle r: rects)
            g.fillRect(r.x,r.y,r.width,r.height);
    }

    @Override
    public boolean gameOver(Rectangle re) {
        boolean collide = false;
        for(Rectangle r: rects)
            if(r.intersects(re)){
                collide = true;
                break;
            }
        return collide;
    }

    @Override
    public Point snakeStart() {
        return new Point(200,200);
    }

    @Override
    public Color getSnakeColor() {
        return Color.YELLOW;
    }

    @Override
    public Color getTokenColor() {
        return Color.green;
    }

    @Override
    public Color getBonusColor() {
        return Color.blue;
    }

    @Override
    public Color getBonusBarColor() {
        return Color.blue;
    }
    public String toString(){
        return "Crazy";
    }
    
}
