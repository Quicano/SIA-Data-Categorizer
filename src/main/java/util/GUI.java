package util;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends Component {

    public String chooseFile(){
        String result = null;
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Select A Directory with unsorted Papers");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            result = chooser.getSelectedFile().toString();
        }
        else {
            result = null;
        }
        return result;
    }

    public void addKeywordList(){
        JFrame jFrame = new JFrame();
        jFrame.setBounds(0,0,1000,1000);
        JTextField textField = new JTextField();
        textField.setBounds(0,0,200,30);
        jFrame.add(textField);
        DefaultListModel<String> dlm = new DefaultListModel<String>();
        JList<String> list = new JList<>(dlm);
        list.setBounds(0,200, 200, 400);
        jFrame.add(new JScrollPane(list));

        jFrame.add(new JButton("Add") {
            {
                addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dlm.addElement(textField.getText());
                    }
                });
            }
        }, BorderLayout.PAGE_END);


        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public void addKeywords(){
        JFrame jFrame = new JFrame();
        JTextField keywordField = new JTextField();
        keywordField.setBounds(200,100,200,30);
        jFrame.add(keywordField);
        DefaultListModel<String> dlm = new DefaultListModel<String>();
        JList<String> list = new JList<>(dlm);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        jFrame.add(new JScrollPane(list));
        jFrame.add(new JButton("Add") {
            {
                addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dlm.addElement(keywordField.getText());
                    }
                });
            }
        }, BorderLayout.PAGE_START);
        jFrame.add(new JButton("Search") {
            {

            }
        }, BorderLayout.PAGE_END);

        jFrame.pack();
        jFrame.setVisible(true);
    }
}
