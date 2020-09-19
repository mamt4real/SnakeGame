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
public class Maze implements Levels{
    private Rectangle[] rects;
   
    public Maze(){
        rects = new Rectangle[4];
        rects[0] = new Rectangle(120,0,8,332);
        rects[1] = new Rectangle(0,362,128,8);
        rects[2] = new Rectangle(280,30,120,8);
        rects[3] = new Rectangle(280,68,8,332);
    }
        
    public void draw(Graphics g) {
        //background
        g.setColor(Color.blue);
        g.fillRect(0, 0, 400, 400);
        //borders
        g.setColor(Color.black);
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
        return new Point(250,120);
    }

    @Override
    public Color getSnakeColor() {
        return Color.red;
    }

    @Override
    public Color getTokenColor() {
        return Color.green;
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
        return "Maze";
    }
}
