import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJFrame extends JFrame {

    public static void main(String args[]){
        new MyJFrame("MyFrame");
    }


    public MyJFrame(String x){

        super(x);//Sets string to title bar on frame
        setSize(500,500);//sets frame dimensions
        setLocation(800,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //create two JPanels
        JPanel buttonPanel = new JPanel();
        JPanel colorPanel = new JPanel();

        //=================================================================

        //Create and add two buttons and send in the text and instance of colorPanel to constructor.
        MyJButton red = new MyJButton("Red", colorPanel);//creates red button
        MyJButton blue = new MyJButton("Blue", colorPanel);//creates blue button
        buttonPanel.add(blue);
        buttonPanel.add(red);

        MyJButton otherRed = new MyJButton(colorPanel, red);
        MyJButton otherBlue = new MyJButton(colorPanel, blue);


        MyJPanel mp = new MyJPanel(buttonPanel);
        MyJPanel mp2 = new MyJPanel(colorPanel);

        buttonPanel.setBackground(Color.YELLOW);

        getContentPane().add(buttonPanel, BorderLayout.WEST);
        getContentPane().add(colorPanel, BorderLayout.CENTER);


        setVisible(true);

    }
}

/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJFrame extends JFrame {

    public static void main(String args[]){
        new MyJFrame("MyFrame");
    }


    public MyJFrame(String x){

        super(x);//Sets string to title bar on frame
        setSize(500,500);//sets frame dimensions
        setLocation(800,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //create two JPanels
        JPanel buttonPanel = new JPanel();
        JPanel colorPanel = new JPanel();

        //=================================================================

        //Create and add two buttons and send in the text and instance of colorPanel to constructor.
        MyJButton red = new MyJButton("Red", colorPanel);//creates red button
        MyJButton blue = new MyJButton("Blue", colorPanel);//creates blue button
        buttonPanel.add(blue);
        buttonPanel.add(red);

        MyJButton otherRed = new MyJButton(colorPanel, red);
        MyJButton otherBlue = new MyJButton(colorPanel, blue);




        //buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        //MyJPanel mp = new MyJPanel("Text", colorPanel);

        MyJPanel mp = new MyJPanel(buttonPanel);
        MyJPanel mp2 = new MyJPanel(colorPanel);

        buttonPanel.setBackground(Color.YELLOW);
        //colorPanel.setBackground(Color.BLACK);


        getContentPane().add(buttonPanel, BorderLayout.WEST);
        getContentPane().add(colorPanel, BorderLayout.CENTER);


        setVisible(true);

    }
}

 */// working code