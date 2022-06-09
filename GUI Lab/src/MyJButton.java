import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class MyJButton extends JButton implements ActionListener {

    public JPanel x;

    public MyJButton(String text, JPanel colorPanel){
        super(text);
        x = colorPanel;
    }

    public MyJButton(JPanel colorPanel, JButton button){
        x= colorPanel;
        button.addActionListener(this);
    }



    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Red"))
            x.setBackground(new Color(255,0,0));
        else if(e.getActionCommand().equals("Blue"))
            x.setBackground(new Color(0,0,255));
    }
}
