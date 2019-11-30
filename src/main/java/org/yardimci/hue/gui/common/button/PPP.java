/*
 * Created by JFormDesigner on Sun Nov 24 12:46:55 EET 2019
 */

package org.yardimci.hue.gui.common.button;

import java.awt.event.*;
import org.yardimci.hue.gui.common.custom.ToggleSwitch;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * @author AY
 */
public class PPP extends JFrame {

    ToggleSwitch ts;

    public static void main(String[] args) {
        PPP p = new PPP();
        p.setVisible(true);
    }
    public PPP() {
        initComponents();
        ts = new ToggleSwitch();
        ts.setLocation(5, 135);
        this.add(ts);


        SteelCheckBox sc = new SteelCheckBox();
        sc.setLocation(100, 133);
        sc.setVisible(true);
        sc.setUI();
        this.add(sc);


        //SteelCheckBoxUI scu = new SteelCheckBoxUI(sc);
        //this.add(scu);



    }

    private void checkBox1ActionPerformed(ActionEvent e) {
        System.out.println(ts.isActivated());
        ts.setActivated(checkBox1.isSelected());
        ts.repaint();
        System.out.println(ts.isActivated());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - AY
        ResourceBundle bundle = ResourceBundle.getBundle("Bundle");
        label1 = new JLabel();
        checkBox1 = new JCheckBox();
        toggleButton1 = new JToggleButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label.apptitle"));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(180, 160), label1.getPreferredSize()));

        //---- checkBox1 ----
        checkBox1.setText(bundle.getString("error.responseisnotvalid"));
        checkBox1.addActionListener(e -> checkBox1ActionPerformed(e));
        contentPane.add(checkBox1);
        checkBox1.setBounds(new Rectangle(new Point(15, 35), checkBox1.getPreferredSize()));

        //---- toggleButton1 ----
        toggleButton1.setText(bundle.getString("error.unabletolistlamps"));
        contentPane.add(toggleButton1);
        toggleButton1.setBounds(new Rectangle(new Point(50, 105), toggleButton1.getPreferredSize()));

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
    private JLabel label1;
    private JCheckBox checkBox1;
    private JToggleButton toggleButton1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
