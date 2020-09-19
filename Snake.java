/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MIQDAD
 */
public class Snake {
    
    private List<Point> snakePoints;
    final int StartSize = 12,StartX,StartY;
    private int sDirX,sDirY;
    private boolean isMoving,elongate;
    private Color snakeColor;
    public Snake(Levels lvl){
        snakePoints = new ArrayList<Point>();
        StartX = lvl.snakeStart().getX();
        StartY = lvl.snakeStart().getY();
        snakeColor = lvl.getSnakeColor();
        snakePoints.add(0,new Point(StartX,StartY));
        sDirX = 1;
        sDirY = 0;
        isMoving = elongate = false;
        for(int i = 1;i<StartSize;i++)
            snakePoints.add(new Point(StartX - i*6,StartY));
    }
    
    public void draw(Graphics g){
        g.setColor(snakeColor);
        for(int i=0;i<snakePoints.size();i++)
            g.fillRect(snakePoints.get(i).getX(),snakePoints.get(i).getY(),6,6);
            
    }
    public void move(){
        if(isMoving){
            Point temp = snakePoints.get(0);
            Point last = snakePoints.get(snakePoints.size()-1);
            Point newStart = new Point(temp.getX() + sDirX * 6,temp.getY() + sDirY * 6);
            for(int i=snakePoints.size()-1;i>=1;i--){
                snakePoints.set(i,snakePoints.get(i-1));
            }
            if(newStart.getX() > 396){
                newStart.setX(0);
            }
            else if(newStart.getX() < 0){
                newStart.setX(396);
            }
            if(newStart.getY() > 396){
                newStart.setY(0);
            }
            else if(newStart.getY() < 0){
                newStart.setY(396);
            }
            snakePoints.set(0,newStart);
            if(elongate){
                snakePoints.add(last);
                elongate = false;
            }
        }
        
    }
    public boolean snakeCollides(){
        int x = getX();
        int y = getY();
        for(int i=1;i< snakePoints.size();i++)
            if(snakePoints.get(i).getX() == x && snakePoints.get(i).getY() == y)
                return true;
        return false;
    }
    public int getXDir(){
        return sDirX;
    }
    public int getYDir(){
        return sDirY;
    }
    public void setYDir(int v){
        sDirY = v;
    }
    public void setXDir(int v){
        sDirX = v;
    }
    
    public int getX(){
        return snakePoints.get(0).getX();
    }
    public int getY(){
        return snakePoints.get(0).getY();
    }
    public void setX(int x){
        snakePoints.get(0).setX(x);
    }
    public void setY(int y){
        snakePoints.get(0).setY(y);
    }
    public boolean isMoving(){
        return isMoving;
    }
    public void setMoving(boolean b){
        isMoving = b;
    }
    public void elongate(boolean b){
        elongate = b;
    }
    public Rectangle getHead(){
        return new Rectangle(getX(),getY(),6,6);
    }
}
