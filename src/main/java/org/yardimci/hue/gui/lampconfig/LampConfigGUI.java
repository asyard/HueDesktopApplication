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
        isOn = lamp.getState().isOn();

        // general
        nameValueLabel.setText(lamp.getName());
        modelIdValueLabel.setText(lamp.getManufacturername() + " - " + lamp.getModelid());
        uniqueIdValueLabel.setText(lamp.getUniqueid());
        swVersionValueLabel.setText(lamp.getSwversion());
        productIdValueLabel.setText(lamp.getProductid());
        productNameValueLabel.setText(lamp.getProductname());


        //capabilities
        certifiedValueCheckbox.setSelected(lamp.getCapabilities().isCertified());
    }

    private void closeButtonActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void turnOnOfButtonActionPerformed(ActionEvent e) {
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
        generalPanelScrollPane = new JScrollPane();
        generalPanel = new JPanel();
        nameLabel = new JLabel();
        nameValueLabel = new JLabel();
        modelIdLabel = new JLabel();
        modelIdValueLabel = new JLabel();
        uniqueIdLabel = new JLabel();
        uniqueIdValueLabel = new JLabel();
        swVersionLabel = new JLabel();
        swVersionValueLabel = new JLabel();
        productIdLabel = new JLabel();
        productIdValueLabel = new JLabel();
        productNameLabel = new JLabel();
        productNameValueLabel = new JLabel();
        swUpdateLabel = new JLabel();
        swUpdateValueLabel = new JLabel();
        capabilitiesPanel = new JPanel();
        certifiedLabel = new JLabel();
        certifiedValueCheckbox = new JCheckBox();
        lightControlPanel = new JPanel();
        turnOnOfButton = new JButton();
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

            //======== generalPanelScrollPane ========
            {

                //======== generalPanel ========
                {
                    generalPanel.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax
                    . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e" , javax. swing
                    .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .
                    Font ( "D\u0069al\u006fg", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red
                    ) ,generalPanel. getBorder () ) ); generalPanel. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override
                    public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062or\u0064er" .equals ( e. getPropertyName (
                    ) ) )throw new RuntimeException( ) ;} } );
                    generalPanel.setLayout(null);

                    //---- nameLabel ----
                    nameLabel.setText(bundle.getString("label.name"));
                    nameLabel.setToolTipText(bundle.getString("label.name"));
                    generalPanel.add(nameLabel);
                    nameLabel.setBounds(10, 10, 110, 20);
                    generalPanel.add(nameValueLabel);
                    nameValueLabel.setBounds(130, 10, 200, 20);

                    //---- modelIdLabel ----
                    modelIdLabel.setText(bundle.getString("label.modelid"));
                    modelIdLabel.setToolTipText(bundle.getString("label.modelid"));
                    generalPanel.add(modelIdLabel);
                    modelIdLabel.setBounds(10, 35, 110, 20);
                    generalPanel.add(modelIdValueLabel);
                    modelIdValueLabel.setBounds(130, 35, 200, 20);

                    //---- uniqueIdLabel ----
                    uniqueIdLabel.setText(bundle.getString("label.uniqueid"));
                    uniqueIdLabel.setToolTipText(bundle.getString("label.uniqueid"));
                    generalPanel.add(uniqueIdLabel);
                    uniqueIdLabel.setBounds(10, 60, 110, 20);

                    //---- uniqueIdValueLabel ----
                    uniqueIdValueLabel.setText(null);
                    generalPanel.add(uniqueIdValueLabel);
                    uniqueIdValueLabel.setBounds(130, 60, 200, 20);

                    //---- swVersionLabel ----
                    swVersionLabel.setText(bundle.getString("label.swversion"));
                    swVersionLabel.setToolTipText(bundle.getString("label.swversion"));
                    generalPanel.add(swVersionLabel);
                    swVersionLabel.setBounds(10, 135, 110, 20);

                    //---- swVersionValueLabel ----
                    swVersionValueLabel.setText(null);
                    generalPanel.add(swVersionValueLabel);
                    swVersionValueLabel.setBounds(130, 135, 200, 20);

                    //---- productIdLabel ----
                    productIdLabel.setText(bundle.getString("label.productid"));
                    productIdLabel.setToolTipText(bundle.getString("label.productid"));
                    generalPanel.add(productIdLabel);
                    productIdLabel.setBounds(10, 85, 110, 20);

                    //---- productIdValueLabel ----
                    productIdValueLabel.setText(null);
                    generalPanel.add(productIdValueLabel);
                    productIdValueLabel.setBounds(130, 85, 200, 20);

                    //---- productNameLabel ----
                    productNameLabel.setText(bundle.getString("label.productname"));
                    productNameLabel.setToolTipText(bundle.getString("label.productname"));
                    generalPanel.add(productNameLabel);
                    productNameLabel.setBounds(10, 110, 110, 20);

                    //---- productNameValueLabel ----
                    productNameValueLabel.setText(null);
                    generalPanel.add(productNameValueLabel);
                    productNameValueLabel.setBounds(130, 110, 200, 20);

                    //---- swUpdateLabel ----
                    swUpdateLabel.setText(bundle.getString("label.swupdate"));
                    swUpdateLabel.setToolTipText(bundle.getString("label.swupdate"));
                    generalPanel.add(swUpdateLabel);
                    swUpdateLabel.setBounds(10, 160, 110, 20);

                    //---- swUpdateValueLabel ----
                    swUpdateValueLabel.setText(null);
                    generalPanel.add(swUpdateValueLabel);
                    swUpdateValueLabel.setBounds(130, 160, 200, 20);

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
                generalPanelScrollPane.setViewportView(generalPanel);
            }
            lightDetailsPane.addTab(bundle.getString("label.General"), generalPanelScrollPane);

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

            //======== lightControlPanel ========
            {
                lightControlPanel.setLayout(null);

                //---- turnOnOfButton ----
                turnOnOfButton.setText(bundle.getString("label.turnonoff"));
                turnOnOfButton.addActionListener(e -> turnOnOfButtonActionPerformed(e));
                lightControlPanel.add(turnOnOfButton);
                turnOnOfButton.setBounds(new Rectangle(new Point(125, 15), turnOnOfButton.getPreferredSize()));

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < lightControlPanel.getComponentCount(); i++) {
                        Rectangle bounds = lightControlPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = lightControlPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    lightControlPanel.setMinimumSize(preferredSize);
                    lightControlPanel.setPreferredSize(preferredSize);
                }
            }
            lightDetailsPane.addTab(bundle.getString("label.control"), lightControlPanel);
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
    private JScrollPane generalPanelScrollPane;
    private JPanel generalPanel;
    private JLabel nameLabel;
    private JLabel nameValueLabel;
    private JLabel modelIdLabel;
    private JLabel modelIdValueLabel;
    private JLabel uniqueIdLabel;
    private JLabel uniqueIdValueLabel;
    private JLabel swVersionLabel;
    private JLabel swVersionValueLabel;
    private JLabel productIdLabel;
    private JLabel productIdValueLabel;
    private JLabel productNameLabel;
    private JLabel productNameValueLabel;
    private JLabel swUpdateLabel;
    private JLabel swUpdateValueLabel;
    private JPanel capabilitiesPanel;
    private JLabel certifiedLabel;
    private JCheckBox certifiedValueCheckbox;
    private JPanel lightControlPanel;
    private JButton turnOnOfButton;
    private JButton closeButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
