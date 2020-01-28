import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class Window extends JFrame {
    public Window(){
        this.setTitle("Mon zob");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);

        JPanel pan = new JPanel();
        pan.setBackground(Color.gray);
        this.setContentPane(pan);
        this.setVisible(true);
    }
}