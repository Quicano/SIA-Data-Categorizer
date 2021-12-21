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

    public void addKeywords(){
        JFrame jFrame = new JFrame();
        JTextField keywordField = new JTextField();
        keywordField.setBounds(50,100,200,30);
        jFrame.add(keywordField);
        DefaultListModel<String> dlm = new DefaultListModel<String>();
        JList<String> list = new JList<>(dlm);
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
        }, BorderLayout.NORTH);
        jFrame.add(new JButton("Done") {
            {

            }
        }, BorderLayout.SOUTH);

        jFrame.pack();
        jFrame.setVisible(true);
    }
}
