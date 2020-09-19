/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Token {
    
    private int x;
    private int y;
    private int score, bonus;
    private final Snake snake;
    private final Levels lvl;
    private BonusToken bigToken;
    private boolean drawBonus;
    public Token(Snake s,Levels lv){
        score = bonus = 0;
        lvl = lv;
        bigToken = new BonusToken();
        drawBonus = false;
        changePos();
        snake = s;
    }
    public void changePos(){
        x = (int)(Math.random()* 392);
        y = (int)(Math.random() * 392);
        Rectangle token = new Rectangle(x,y,8,8);
        if(lvl.gameOver(token))
            changePos();
    }
    public void draw(Graphics g){
        g.setColor(lvl.getTokenColor());
        g.fillRect(x, y, 8, 8);
        if(drawBonus){
            bigToken.draw(g);
            bigToken.intersect();
        }
        
    }
    
    public boolean intersect(){
        Rectangle token = new Rectangle(x,y,8,8);
        if(token.intersects(snake.getHead())){
            changePos();
            score++;
            if(score % 5 == 0){
                drawBonus = true;
                bigToken.changePos();
            }
            snake.elongate(true);
            return true;
        }
        return false;
    }
    public int getTotalScore(){
        return score + bonus;
    }
    public int getScore(){
        return score;
    }
    
    class BonusToken{
       private int bar;
       private int xpos;
       private int ypos;
       private Rectangle ball;
       
       public BonusToken(){
           bar = 95;
           changePos();
       }
       private void changePos(){
           bar = 95;
           xpos = (int)(Math.random() * 388);
           ypos = (int)(Math.random() * 388);
           ball = new Rectangle(xpos,ypos,12,12);
           if(lvl.gameOver(ball))
               changePos();
       }
       
       private void draw(Graphics g){
           if(bar > 0){
            g.setColor(lvl.getBonusColor());
            g.fillOval(ball.x, ball.y, 12, 12);
           
           //progress bar
            g.setColor(lvl.getBonusBarColor());
            g.fillRect(10, 375, bar*4, 10);
            bar--;
           }else
               drawBonus = false;
       }
       
       public void intersect(){
           if(ball.intersects(snake.getHead())){
               bonus += bar*2;
               bar = 0;
               drawBonus = false;
           }
       }
       
    }
}
