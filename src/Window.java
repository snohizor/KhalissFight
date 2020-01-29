import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class Window extends JFrame {

    private JButton bouton = new JButton("Mon bouton");
    JPanel pan = new JPanel();

    public Window(){
        this.setTitle("Khaliss Fight");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        boolean b = false;
        this.setResizable(b);

        pan.setBackground(Color.orange);
        pan.add(bouton);

        this.setContentPane(new Visual());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}