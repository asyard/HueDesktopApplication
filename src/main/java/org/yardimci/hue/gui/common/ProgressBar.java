/*
 * Created by JFormDesigner on Sat Nov 23 02:52:05 EET 2019
 */

package org.yardimci.hue.gui.common;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * @author AY
 */
public class ProgressBar extends JDialog {
    public ProgressBar(Window owner) {
        super(owner);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - AY
        ResourceBundle bundle = ResourceBundle.getBundle("Bundle");
        progressImageLabel = new JLabel();
        progressInfoLabel = new JLabel();

        //======== this ========
        setModal(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //---- progressImageLabel ----
        progressImageLabel.setIcon(new ImageIcon(getClass().getResource("/icons/info.png")));
        contentPane.add(progressImageLabel, BorderLayout.LINE_START);

        //---- progressInfoLabel ----
        progressInfoLabel.setText(bundle.getString("label.pleasewait"));
        contentPane.add(progressInfoLabel, BorderLayout.CENTER);
        setSize(95, 55);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - AY
    private JLabel progressImageLabel;
    private JLabel progressInfoLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
