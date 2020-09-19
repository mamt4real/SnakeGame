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
public class Tunnel implements Levels{

    private Rectangle[] rects;
   
    public Tunnel(){
        rects = new Rectangle[10];
        rects[0] = new Rectangle(0,0,50,8);
        rects[1] = new Rectangle(0,0,8,50);
        rects[2] = new Rectangle(350,0,50,8);
        rects[3] = new Rectangle(350,392,50,8);
        rects[4] = new Rectangle(392,350,8,50);
        rects[5] = new Rectangle(392,0,8,50);
        rects[6] = new Rectangle(0,350,8,50);
        rects[7] = new Rectangle(0,392,50,8);
        rects[8] = new Rectangle(70,70,280,8);
        rects[9] = new Rectangle(70,330,280,8);
        
    }
        
    public void draw(Graphics g) {
        //background
        g.setColor(Color.cyan);
        g.fillRect(0, 0, 400, 400);
        //borders
        g.setColor(Color.red);
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
        return Color.black;
    }

    @Override
    public Color getTokenColor() {
        return Color.black;
    }

    @Override
    public Color getBonusColor() {
        return Color.pink;
    }

    @Override
    public Color getBonusBarColor() {
        return Color.pink;
    }
    public String toString(){
        return "Tunnel";
    }
    
}
