package util;

import javax.swing.*;
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
            result = chooser.getSelectedFile().getAbsolutePath();
        }
        else {
            result = null;
        }
        return result;
    }

    public void addKeywordList(){
        JFrame jFrame = new JFrame("Demo");
        jFrame.setBounds(0,0,1000,1000);
        JTextField textField = new JTextField();
        textField.setBounds(0,0,200,30);
        jFrame.add(textField, BorderLayout.NORTH);
        DefaultListModel<String> dlm = new DefaultListModel<String>();
        JList<String> list = new JList<>(dlm);
        list.setBounds(0,200, 200, 400);
        jFrame.add(new JScrollPane(list),BorderLayout.SOUTH);
        jFrame.add(new JButton("Add") {
            {
                addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dlm.addElement(textField.getText());
                    }
                });
            }
        }, BorderLayout.WEST);
        jFrame.add(new JButton("Start") {
            {
                addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dlm.addElement(textField.getText());
                    }
                });
            }
        }, BorderLayout.EAST);
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
