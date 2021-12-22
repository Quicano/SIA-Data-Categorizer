package util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class GUI extends Component {

    public void chooseFile() throws IOException {
        String result;
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Select A Directory with unsorted Papers");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            result = chooser.getSelectedFile().getAbsolutePath();
        }
        else {
            result = null;
        }
        PropertiesHandler.addValue("filepath", result);
    }

    public ArrayList<String> addKeywordList(){
        ArrayList<String> keywords = new ArrayList<>();
        JFrame jFrame = new JFrame("Extra Keywords");
        JTextField textField = new JTextField();
        DefaultListModel<String> dlm = new DefaultListModel<String>();
        JList<String> list = new JList<>(dlm);
        textField.setBounds(0,0,300,30);
        list.setBounds(0,200, 200, 400);
        jFrame.setBounds(0,0,1000,1000);
        jFrame.add(new JScrollPane(list),BorderLayout.SOUTH);
        jFrame.add(textField, BorderLayout.NORTH);
        jFrame.add(new JButton("Hinzufügen") {
            {
                addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dlm.addElement(textField.getText());
                        keywords.add(textField.getText());
                    }
                });
            }
        }, BorderLayout.WEST);
        jFrame.add(new JButton("Sortieren") {
            {
                addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String keywordString;
                        if(keywords.size() <= 0){
                            keywordString = null;
                        }else{
                            keywordString = "";
                            for (int i = 0; i <= keywords.size(); i++){
                                keywordString = keywordString + keywords.get(0) +  ";";
                            }
                        }
                        try {
                            PropertiesHandler.addValue("keywords", keywordString);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        try {
                            Runner.startCategorization();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        jFrame.dispose();
                    }
                });
            }
        }, BorderLayout.EAST);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        return keywords;
    }

}
