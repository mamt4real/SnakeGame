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
public class Classic implements Levels{

    public void draw(Graphics g) {
       g.setColor(Color.black);
       g.fillRect(0, 0,400,400);
    }

    @Override
    public boolean gameOver(Rectangle r) {
        return false;
    }

    @Override
    public Point snakeStart() {
        return new Point(150,150);
    }

    @Override
    public Color getSnakeColor() {
        return Color.white;
    }

    @Override
    public Color getTokenColor() {
        return Color.green;
    }

    @Override
    public Color getBonusColor() {
        return Color.orange;
    }

    @Override
    public Color getBonusBarColor() {
        return Color.orange;
    }
    
    public String toString(){
        return "Classic";
    }
}
