/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;

/**
 *
 * @author MIQDAD
 */
public class SelectLevel extends JDialog implements ActionListener{
    private JButton[] btns;
    String lvls[] = {"Classic","Box","Tunnel","Maze"};
    Levels lvl;
    public SelectLevel(){
        this.setTitle("Select Level");
        this.setBounds(100,100,250,250);
        this.setLayout(new FlowLayout());
        this.getContentPane().setBackground(Color.gray);
        btns = new JButton[4];
        for(int i=0;i<btns.length;i++){
            btns[i] = new JButton(lvls[i]);
            btns[i].setBackground(Color.green);
            btns[i].setForeground(Color.white);
            btns[i].addActionListener(this);
            this.add(btns[i]);
        }
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Classic"))
            lvl = new Classic();
        else if(e.getActionCommand().equals("Box"))
            lvl = new Box();
        else if(e.getActionCommand().equals("Tunnel"))
            lvl = new Tunnel();
        else
            lvl = new Maze();
        this.dispose();
    }
    
    public Levels getLevel(){
        return lvl;
    }
    
}
