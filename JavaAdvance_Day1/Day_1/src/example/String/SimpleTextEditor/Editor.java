package example.String.SimpleTextEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by USER on 27.11.2017.
 */
public class Editor {
    //Объявление графических компонентов
    private JFrame mainFrame;
    private JTextArea editor;

    //Сохранение\загрузка файла
    private JButton saveButton;
    private JButton loadButton;
    private JFileChooser chooser;

    //Элементы поиска
    private JButton searchButton;
    private JTextField searchField;
    private JCheckBox searchCaseSensitiveBox;
    private JCheckBox reverseSearchBox;

    //Элементы замещения
    private JButton replaceSelectionButton;
    private JButton replaceAllButton;
    private JTextField replaceField;

    //Слушатели
    private EditorListener editorListener;

    //Константы
    private final int NUM_CHARS = 15;

    Editor(){
        chooser = new JFileChooser();
        editorListener = new EditorListener();
        initGUI();
    }

    private void initGUI(){
        mainFrame = new JFrame("Simple text editor");
        editor = new JTextArea(20, 40);
        JScrollPane editorScroller = new JScrollPane(editor);
        editorScroller.setBorder(BorderFactory.createTitledBorder("Editing area"));
        Container contentPane = mainFrame.getContentPane();
        contentPane.add(editorScroller, BorderLayout.CENTER);

        //Инициализация панели управления редактором
        //Элементы поиска
        searchButton = new JButton("search");
        searchButton.addActionListener(editorListener);
        searchField = new JTextField(NUM_CHARS);
        searchCaseSensitiveBox = new JCheckBox("case sensitive", true);
        reverseSearchBox = new JCheckBox("reverse search", false);
        JPanel searchPanel = new JPanel();
        searchPanel.add(searchButton);
        searchPanel.add(searchField);
        searchPanel.add(searchCaseSensitiveBox);
        searchPanel.add(reverseSearchBox);

        //Замена символов
        replaceSelectionButton = new JButton("replace selection");
        replaceSelectionButton.addActionListener(editorListener);
        replaceAllButton = new JButton("replace all");
        replaceAllButton.addActionListener(editorListener);
        replaceField = new JTextField(NUM_CHARS);
        JPanel replacePanel = new JPanel();
        replacePanel.add(replaceSelectionButton);
        replacePanel.add(replaceAllButton);
        replacePanel.add(replaceField);

        //Элементы загрузки\сохранения
        loadButton = new JButton("load");
        loadButton.addActionListener(editorListener);
        saveButton = new JButton("save");
        saveButton.addActionListener(editorListener);
        JPanel filePanel = new JPanel();
        filePanel.add(loadButton);
        filePanel.add(saveButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 1));
        mainPanel.add(searchPanel);
        mainPanel.add(replacePanel);
        mainPanel.add(filePanel);
        contentPane.add(mainPanel, BorderLayout.SOUTH);
        //Установка фрейма
        mainFrame.pack();
        mainFrame.setLocation((1920 / 2) - (mainFrame.getWidth() / 2),
                            (1080 / 2) - (mainFrame.getHeight() / 2));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    private void search(){
        String editorText = editor.getText();
        String searchValue = searchField.getText();

        if(searchCaseSensitiveBox.getSelectedObjects() == null){
            editorText = editorText.toLowerCase();
            searchValue = searchValue.toLowerCase();
        }

        int start;
        if(reverseSearchBox.getSelectedObjects() == null){
            start = editorText.indexOf(searchValue, editor.getSelectionEnd());
        }else{
            start = editorText.lastIndexOf(searchValue, editor.getSelectionStart() - 1);
        }

        if(start != -1){
            editor.setCaretPosition(start);
            editor.moveCaretPosition(start + searchValue.length());
            editor.getCaret().setSelectionVisible(true);
        }
    }

    private void replaceAll(String oldString, String newString){
        if(!oldString.equals("")){
            String editorText = editor.getText();
            editorText = editorText.replaceAll(oldString, newString);
            editor.setText(editorText);
        }
    }
    private void replaceSelection(){
        String editorText = editor.getText();
        String start = editorText.substring(0, editor.getSelectionStart());
        String end = editorText.substring(editor.getSelectionEnd());
        editorText = start + replaceField.getText() + end;
        editor.setText(editorText);
    }
    private void save(){
        if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            File saveFile = chooser.getSelectedFile();
            try{
                PrintWriter out = new PrintWriter(new FileWriter(saveFile));
                out.print(editor.getText());
                out.close();
            }catch (IOException e){
                JOptionPane.showMessageDialog(null, "Could not save the file");
            }
        }
    }
    private void load(){
        if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            File loadFile = chooser.getSelectedFile();
            try {
                BufferedReader in = new BufferedReader(new FileReader(loadFile));
                editor.setText("");
                String nextLine = in.readLine();
                while(nextLine != null){
                    editor.append(nextLine + "\n");
                    nextLine = in.readLine();
                }
                in.close();
            } catch (IOException e) {
               JOptionPane.showMessageDialog(null, "Could not load the file");
            }
        }
    }

    private class EditorListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            if(clickedButton == searchButton){
                search();
            }else if(clickedButton == replaceAllButton){
                replaceAll(searchField.getText(), replaceField.getText());
            }else if(clickedButton == replaceSelectionButton){
                replaceSelection();
            }else if(clickedButton == saveButton){
                save();
            }else if(clickedButton == loadButton){
                load();
            }
        }
    }
}
