package view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomDialog extends JDialog {
    private JPanel myPanel = null;
    private JButton yesButton = null;
    private JButton noButton = null;

    public CustomDialog(JFrame frame, boolean modal, String myMessage, int x, int y) {
    super(frame, modal);
    myPanel = new JPanel();
    getContentPane().add(myPanel);
    myPanel.add(new JLabel(myMessage));
    yesButton = new JButton("Yes");
    myPanel.add(yesButton);
    noButton = new JButton("No");
    myPanel.add(noButton);
    pack();
    //setLocationRelativeTo(frame);
    setLocation(x, y); // <--
    setVisible(true);
    }

}