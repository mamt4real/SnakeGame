/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MIQDAD
 */
public class SnakeGame extends Applet implements KeyListener,Runnable{

    Graphics gfx;
    Image img;
    Snake snake;
    Token token;
    int speed;
    Thread thread;
    boolean gameOver;
    Levels lvl;
    private boolean levelComplete;
    private int lvlSelector = 4;
    private Levels[] levels = {
      new Classic(),
      new Box(),
      new Tunnel(),
      new Maze(),
      new Crazy()
    };
    
    public void init(){
        this.resize(400,400);
        img = createImage(400,400);
        gfx = img.getGraphics();
        speed = 65;
        lvl = getLevel(lvlSelector);
        addKeyListener(this);
        snake = new Snake(lvl);
        token = new Token(snake,lvl);
        gameOver = false;
        levelComplete = false;
        thread = new Thread(this);
        thread.start();

    }
    public void paint(Graphics g){
        lvl.draw(gfx);
        if(!gameOver && !levelComplete){
            snake.draw(gfx);
            token.draw(gfx);
        }else if(gameOver){
            gfx.setColor(Color.red);
            gfx.drawString("Gmae Over!!",170,170);
            gfx.drawString("Final Score: " + token.getTotalScore(),170,185);
            gfx.drawString("\npress enter to restart..",170, 200);
        }else if(levelComplete){
            gfx.setColor(Color.green);
            gfx.setFont(new Font("times new roman",Font.BOLD,15));
            gfx.drawString("Level Complete",170,170);
            gfx.drawString("Level Score: " + token.getTotalScore(),170,190);
            gfx.drawString("\npress enter to continue..",170, 220);
        }
        
        g.drawImage(img,0,0,null);
        
    }
    public void update(Graphics g){
        paint(g);
    }
    public void repaint(Graphics g){
        paint(g);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }
    public Levels getLevel(int x){
        if(x >= levels.length)
            x = 0;
        return levels[x];
    }
    public void checkGameover(){
        gameOver = lvl.gameOver(snake.getHead()) || snake.snakeCollides();
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(!snake.isMoving()){
            if(e.getKeyCode()==KeyEvent.VK_UP || e.getKeyCode()==KeyEvent.VK_DOWN || e.getKeyCode()==KeyEvent.VK_RIGHT 
                    || e.getKeyCode()==KeyEvent.VK_LEFT)
                snake.setMoving(true);
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            if(snake.getYDir() != 1){
                snake.setYDir(-1);
                snake.setXDir(0);
            }
            
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if(snake.getYDir() != -1){
                snake.setYDir(1);
                snake.setXDir(0);
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(snake.getXDir() != 1){
                snake.setXDir(-1);
                snake.setYDir(0);           
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(snake.getXDir() != -1){
                snake.setXDir(1);
                snake.setYDir(0);
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            if(gameOver){
                lvlSelector = 0;
                init();
            }
            else if(levelComplete){
                init();
            }
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }
    public int updateSpeed(int score){
        //double val = ((105 - score*5)/105.0)*80;
        return 70-score;
    }
    @Override
    public void run() {
        for(;;){
            
            if(!gameOver){
                snake.move();
                checkGameover();
                speed = updateSpeed(token.getScore());
                token.intersect();
                if(token.getScore() == 21){
                    lvlSelector++;
                    levelComplete = true;
                }
            } 
            this.repaint();
            try {
                thread.sleep(speed);
            } catch (InterruptedException ex) {
                Logger.getLogger(SnakeGame.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(gameOver || levelComplete)
                break;
        }
      
    }
     
}
