/*
 * Created by JFormDesigner on Fri Nov 22 23:40:04 EET 2019
 */

package org.yardimci.hue.gui.lampconfig;

import java.awt.event.*;

import org.yardimci.hue.core.HueConnection;
import org.yardimci.hue.core.model.response.lamp.Lamp;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * @author AY
 */
public class LampConfigGUI extends JDialog {

    private String lampOrderId;
    private boolean isOn = false;

    public LampConfigGUI(Window owner) {
        super(owner);
        initComponents();
    }

    public void setData(String lampOrderId, Lamp lamp) {
        this.lampOrderId = lampOrderId;
        nameValueLabel.setText(lamp.getName());
        idValueLabel.setText(lamp.getModelid());
        isOn = lamp.getState().isOn();

        //capabilities
        certifiedValueCheckbox.setSelected(lamp.getCapabilities().isCertified());
    }

    private void closeButtonActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void turnOnOfButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        if (isOn) {
            boolean success = HueConnection.getInstance().turnOffLamp(lampOrderId);
            if (success) {
                isOn = false;
            }
        } else {
            boolean success = HueConnection.getInstance().turnOnLamp(lampOrderId);
            if (success) {
                isOn = true;
            }
        }
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
        turnOnOfButton = new JButton();
        capabilitiesPanel = new JPanel();
        certifiedLabel = new JLabel();
        certifiedValueCheckbox = new JCheckBox();
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
                generalPanel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
                ( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing. border
                . TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
                . Color. red) ,generalPanel. getBorder( )) ); generalPanel. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
                propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
                ; }} );
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

                //---- turnOnOfButton ----
                turnOnOfButton.setText(bundle.getString("turnOnOfButton.text"));
                turnOnOfButton.addActionListener(e -> turnOnOfButtonActionPerformed(e));
                generalPanel.add(turnOnOfButton);
                turnOnOfButton.setBounds(new Rectangle(new Point(135, 200), turnOnOfButton.getPreferredSize()));

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

                //---- certifiedLabel ----
                certifiedLabel.setText(bundle.getString("label.certified"));
                certifiedLabel.setPreferredSize(new Dimension(52, 20));
                capabilitiesPanel.add(certifiedLabel);
                certifiedLabel.setBounds(new Rectangle(new Point(25, 30), certifiedLabel.getPreferredSize()));

                //---- certifiedValueCheckbox ----
                certifiedValueCheckbox.setEnabled(false);
                capabilitiesPanel.add(certifiedValueCheckbox);
                certifiedValueCheckbox.setBounds(new Rectangle(new Point(95, 30), certifiedValueCheckbox.getPreferredSize()));

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
    private JButton turnOnOfButton;
    private JPanel capabilitiesPanel;
    private JLabel certifiedLabel;
    private JCheckBox certifiedValueCheckbox;
    private JButton closeButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
