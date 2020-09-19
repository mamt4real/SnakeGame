/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public interface Levels {
    void draw(Graphics g);
    boolean gameOver(Rectangle r);
    Point snakeStart();
    Color getSnakeColor();
    Color getTokenColor();
    Color getBonusColor();
    Color getBonusBarColor();
}
