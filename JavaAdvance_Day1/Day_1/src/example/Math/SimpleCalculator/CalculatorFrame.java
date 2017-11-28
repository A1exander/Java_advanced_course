package example.Math.SimpleCalculator;

import javax.swing.*;
import java.awt.*;

/**
 * Created by USER on 27.11.2017.
 */
public class CalculatorFrame extends JFrame{
    public  CalculatorFrame(){
        setTitle("JCalculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new CalculatorPanel());
        pack();
        setLocation((1920 / 2) - (getWidth() / 2),
                    (1080 / 2) - (getHeight() / 2));
        setVisible(true);
        setMinimumSize(new Dimension(320, 320));
    }
}
