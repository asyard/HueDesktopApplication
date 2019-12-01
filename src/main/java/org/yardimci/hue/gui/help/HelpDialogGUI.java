/*
 * Created by JFormDesigner on Fri Nov 22 23:08:46 EET 2019
 */

package org.yardimci.hue.gui.help;

import java.awt.event.*;
import org.yardimci.hue.lang.Bundle;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * @author AY
 */
public class HelpDialogGUI extends JDialog {
    public HelpDialogGUI(Window owner) {
        super(owner);
        initComponents();
        init();
    }

    private void init() {
        String appVersion = "";
        try {
            appVersion = "v." + Package.getPackage("org.yardimci.hue.HueDesktopApplication").getImplementationVersion();
        } catch (Exception e) {
        }

        String appName = Bundle.getValue("label.apptitle") + appVersion;
        appVersionLabel.setText(appName);
        appVersionLabel.setToolTipText(appName);
        label2.setToolTipText(label2.getText());
        setTitle(Bundle.getValue("label.help"));
    }

    private void closeButtonActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - AY
        ResourceBundle bundle = ResourceBundle.getBundle("Bundle");
        closeButton = new JButton();
        appVersionLabel = new JLabel();
        imageLabel = new JLabel();
        label2 = new JLabel();

        //======== this ========
        setResizable(false);
        setTitle(bundle.getString("label.help"));
        setModal(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- closeButton ----
        closeButton.setText(bundle.getString("label.ok"));
        closeButton.addActionListener(e -> closeButtonActionPerformed(e));
        contentPane.add(closeButton);
        closeButton.setBounds(new Rectangle(new Point(300, 240), closeButton.getPreferredSize()));

        //---- appVersionLabel ----
        appVersionLabel.setMinimumSize(new Dimension(25, 125));
        appVersionLabel.setMaximumSize(new Dimension(25, 125));
        contentPane.add(appVersionLabel);
        appVersionLabel.setBounds(100, 15, 215, 25);

        //---- imageLabel ----
        imageLabel.setIcon(new ImageIcon(getClass().getResource("/icons/applogo-100.png")));
        contentPane.add(imageLabel);
        imageLabel.setBounds(140, 50, 90, 105);

        //---- label2 ----
        label2.setText("icons : www.flaticon.com @Freepik");
        contentPane.add(label2);
        label2.setBounds(90, 165, 215, 25);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - AY
    private JButton closeButton;
    private JLabel appVersionLabel;
    private JLabel imageLabel;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
