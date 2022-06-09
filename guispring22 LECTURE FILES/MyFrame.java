/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guispring22;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Hunter
 */
public class MyFrame extends JFrame implements ActionListener {
    
    public MyFrame(String x)        
    {
        super(x);
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200, 200);
        setSize(800, 600);
        
        
        MyButton button = new MyButton("Rectangle");
        MyButton secondButton = new MyButton("Oval");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(button);
        buttonPanel.add(secondButton);
        button.addActionListener(this);
        secondButton.addActionListener(this);
        buttonPanel.setBackground(Color.GREEN);
        
        MyPanel mp = MyPanel.getInstance();
        
        getContentPane().add(buttonPanel, BorderLayout.WEST);
        getContentPane().add(mp);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
         if(e.getActionCommand() == "Rectangle")
             //call panel with 1
             MyPanel.getInstance().setShape(MyPanel.RECT);
         else if(e.getActionCommand() == "Oval")
             MyPanel.getInstance().setShape(MyPanel.OVAL);
    }
}
