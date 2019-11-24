/*
 * Created by JFormDesigner on Fri Nov 22 23:40:04 EET 2019
 */

package org.yardimci.hue.gui.lampconfig;

import java.awt.event.*;
import org.yardimci.hue.core.model.response.lamp.Lamp;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * @author AY
 */
public class LampConfigGUI extends JDialog {
    public LampConfigGUI(Window owner) {
        super(owner);
        initComponents();
    }

    public void setData(Lamp lamp) {
        nameValueLabel.setText(lamp.getName());
        idValueLabel.setText(lamp.getModelid());
    }

    private void closeButtonActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - AY
        ResourceBundle bundle = ResourceBundle.getBundle("Bundle");
        lightDetailsPane = new JTabbedPane();
        generalPanel = new JPanel();
        nameLabel = new JLabel();
        nameValueLabel = new JLabel();
        idLabel = new JLabel();
        idValueLabel = new JLabel();
        capabilitiesPanel = new JPanel();
        closeButton = new JButton();

        //======== this ========
        setModal(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle(bundle.getString("label.details"));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== lightDetailsPane ========
        {

            //======== generalPanel ========
            {
                generalPanel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
                EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax. swing
                . border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ),
                java. awt. Color. red) ,generalPanel. getBorder( )) ); generalPanel. addPropertyChangeListener (new java. beans. PropertyChangeListener( )
                { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () ))
                throw new RuntimeException( ); }} );
                generalPanel.setLayout(null);

                //---- nameLabel ----
                nameLabel.setText(bundle.getString("label.name"));
                generalPanel.add(nameLabel);
                nameLabel.setBounds(30, 25, 70, 20);
                generalPanel.add(nameValueLabel);
                nameValueLabel.setBounds(95, 30, 200, 20);

                //---- idLabel ----
                idLabel.setText(bundle.getString("label.id"));
                generalPanel.add(idLabel);
                idLabel.setBounds(30, 60, 45, 20);
                generalPanel.add(idValueLabel);
                idValueLabel.setBounds(95, 60, 200, 20);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < generalPanel.getComponentCount(); i++) {
                        Rectangle bounds = generalPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = generalPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    generalPanel.setMinimumSize(preferredSize);
                    generalPanel.setPreferredSize(preferredSize);
                }
            }
            lightDetailsPane.addTab(bundle.getString("label.General"), generalPanel);

            //======== capabilitiesPanel ========
            {
                capabilitiesPanel.setLayout(null);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < capabilitiesPanel.getComponentCount(); i++) {
                        Rectangle bounds = capabilitiesPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = capabilitiesPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    capabilitiesPanel.setMinimumSize(preferredSize);
                    capabilitiesPanel.setPreferredSize(preferredSize);
                }
            }
            lightDetailsPane.addTab(bundle.getString("label.capabilities"), capabilitiesPanel);
        }
        contentPane.add(lightDetailsPane);
        lightDetailsPane.setBounds(0, 5, 395, 265);

        //---- closeButton ----
        closeButton.setText(bundle.getString("label.ok"));
        closeButton.addActionListener(e -> closeButtonActionPerformed(e));
        contentPane.add(closeButton);
        closeButton.setBounds(new Rectangle(new Point(310, 295), closeButton.getPreferredSize()));

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
    private JTabbedPane lightDetailsPane;
    private JPanel generalPanel;
    private JLabel nameLabel;
    private JLabel nameValueLabel;
    private JLabel idLabel;
    private JLabel idValueLabel;
    private JPanel capabilitiesPanel;
    private JButton closeButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
