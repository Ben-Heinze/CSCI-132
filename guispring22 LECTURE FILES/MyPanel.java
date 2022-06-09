/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guispring22;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.event.MouseListener;
/**
 *
 * @author Hunter
 */
public class MyPanel extends JPanel implements MouseListener{
    private int x, y, endX, endY;
    private int shape;
    public static final int RECT = 1;
    public static final int OVAL = 2;
    private static MyPanel inst;
    
    public static MyPanel getInstance()
    {
        if(inst == null)
            inst = new MyPanel();
        return inst;
    }
    private MyPanel()
    {
        setBackground(Color.yellow);
        addMouseListener(this);
    }
    
    public void setShape(int x)
    {
        shape = x;
    }

    public void draw()
    {
        Graphics2D g = (Graphics2D)getGraphics();
        if(shape == RECT)
            g.drawRect(x, y, endX, endY);
        else if(shape == OVAL)
            g.drawOval(x, y, endX, endY);
    }
    public void mouseExited(MouseEvent e){
            System.out.println("exited");
    } 
    public void mouseEntered(MouseEvent e){
               System.out.println("entered");
    }
    public void mousePressed(MouseEvent e){
               System.out.println("Pressed " + e.getX());
               x = e.getX();
               y = e.getY();
    }
    public void mouseClicked(MouseEvent e){
         System.out.println("eClicked");
    }
    public void mouseReleased(MouseEvent e){
              System.out.println("released " + e.getX());
              endX = e.getX() - x;
              endY = e.getY() - y;
              draw();
    }
    
    
}
