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
        JFrame jFrame = new JFrame("Schlüssebegriffe");
        jFrame.setBounds(0,0,1000,1000);
        JTextField textField = new JTextField();
        textField.setBounds(0,0,300,30);
        DefaultListModel<String> dlm = new DefaultListModel<String>();
        JList<String> list = new JList<>(dlm);
        list.setBounds(0,200, 200, 400);
        jFrame.add(new JScrollPane(list),BorderLayout.SOUTH);
        jFrame.add(textField, BorderLayout.NORTH);
        jFrame.add(new JButton("Hinzufügen") {
            {
                addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dlm.addElement(textField.getText());
                    }
                });
            }
        }, BorderLayout.WEST);
        jFrame.add(new JButton("Sortieren") {
            {
                addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dlm.addElement(textField.getText());
                    }
                });
            }
        }, BorderLayout.EAST);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

}
