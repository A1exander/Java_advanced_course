package example.Math.SimpleCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by USER on 27.11.2017.
 */
public class CalculatorPanel extends JPanel {
    //Графические компоненты
    private JButton display;
    private JPanel buttonsPanel;

    //Логика калькулятора
    private double result;
    private String lastCommand;
    private boolean start;

    //Слушатели событий
    private IsertActionListener insert;
    private CommandActionListner command;

    CalculatorPanel(){
        initLogic();
        initGUI();
    }

    private void initLogic(){
        result = 0;
        lastCommand = "=";
        start = true;
        insert = new IsertActionListener();
        command = new CommandActionListner();
    }
    private void initGUI(){
        setLayout(new BorderLayout());
        display = new JButton("0");
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(4, 5));

        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton("/", command);
        addButton("pow", command);

        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton("*", command);
        addButton("sin", command);

        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("+", command);
        addButton("cos", command);

        addButton("0", insert);
        addButton(".", insert);
        addButton("-", command);
        addButton("=", command);
        addButton("tan", command);

        add(buttonsPanel, BorderLayout.CENTER);
        setPreferredSize(new Dimension(320, 320));
        setMinimumSize(new Dimension(320, 320));
    }

    private void addButton(String label, ActionListener listener){
        JButton b = new JButton(label);
        b.addActionListener(listener);
        buttonsPanel.add(b);
    }

    private void calculate(double x){
        if(lastCommand.equals("+"))result +=x;
        else if(lastCommand.equals("-"))result -=x;
        else if(lastCommand.equals("/"))result /=x;
        else if(lastCommand.equals("*"))result *=x;
        else if(lastCommand.equals("="))result = x;
        else if(lastCommand.equals("pow"))result = Math.pow(result, x);
        else if(lastCommand.equals("sin"))result = Math.sin(x);
        else if(lastCommand.equals("cos"))result = Math.cos(x);
        else if(lastCommand.equals("tan"))result = Math.cos(x);

        display.setText("" + result);
    }

    private class IsertActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String input = e.getActionCommand();
            if(start){
                display.setText("");
                start = false;
            }
            display.setText(display.getText() + input);
        }
    }

    private class CommandActionListner implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            System.out.println("нажата: " + command);
            if(start){
                if(command.equals("-")){
                    display.setText(command);
                    start = false;
                }else{
                    lastCommand = command;
                }
            }else{
                calculate(Double.parseDouble(display.getText()));
                lastCommand = command;
                start = true;
            }
        }
    }
}
