/*
 * Created by JFormDesigner on Fri Nov 22 23:40:04 EET 2019
 */

package org.yardimci.hue.gui.lampconfig;

import org.yardimci.hue.core.HueConnection;
import org.yardimci.hue.core.model.response.lamp.Lamp;
import org.yardimci.hue.gui.common.Messagebox;
import org.yardimci.hue.lang.Bundle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ResourceBundle;

/**
 * @author AY
 */
public class LampConfigGUI extends JDialog {

    private String lampOrderId;
    private boolean isOn = false;
    private int lastBrightnessValue = 1;

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

        //control
        changeLightStatusLabel();
        controlLightNameTextfield.setText(lamp.getName());
        lastBrightnessValue = lamp.getState().getBri();
        brightnessSlider.setValue(lastBrightnessValue);

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
        changeLightStatusLabel();
    }

    private void changeLightStatusLabel() {
        lightStatusValueLabel.setText(isOn ? Bundle.getValue("label.on") : Bundle.getValue("label.off"));
    }

    private void changeLightNameButtonActionPerformed(ActionEvent e) {
        String newName = controlLightNameTextfield.getText();
        if (newName.isEmpty()) {
            Messagebox.showError("error.namecannotbeempty");
            return;
        }

        boolean success = HueConnection.getInstance().changeLampName(lampOrderId, newName);
        if (success) {
            Messagebox.showInformation("label.success");
            nameValueLabel.setText(newName);
        } else {
            Messagebox.showError("error.operationfailed");
        }
    }

    private void brightnessSliderMouseReleased(MouseEvent e) {
        //todo isOpen check?
        int brightness = brightnessSlider.getValue();
        if (brightness != lastBrightnessValue) {
            try {
                HueConnection.getInstance().editLampBrightness(lampOrderId, brightness);
                lastBrightnessValue = brightness;
            } catch (Exception ex) {
                Messagebox.showError("error.operationfailed");
                brightnessSlider.setValue(lastBrightnessValue);
            }
        }
    }

    private void changeColourButtonActionPerformed(ActionEvent e) {
        /*System.setProperty("ColorChooser.okText", Bundle.getValue("label.ok"));
        colorChooser.setPreviewPanel(new JPanel());
        Color newColor = colorChooser.showDialog(null, "Choose a color", Color.RED);
        System.out.println(newColor);*/
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
        capabilitiesScrollPane = new JScrollPane();
        capabilitiesPanel = new JPanel();
        certifiedLabel = new JLabel();
        certifiedValueCheckbox = new JCheckBox();
        controlScrollPane = new JScrollPane();
        lightControlPanel = new JPanel();
        turnOnOfButton = new JButton();
        changeLightNameButton = new JButton();
        lightStatusLabel = new JLabel();
        lightStatusValueLabel = new JLabel();
        controlNameLabel = new JLabel();
        controlLightNameTextfield = new JTextField();
        brightnessLabel = new JLabel();
        brightnessSlider = new JSlider();
        colourLabel = new JLabel();
        changeColourButton = new JButton();
        closeButton = new JButton();
        colorChooser = new JColorChooser();

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
                    generalPanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing
                    .border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder
                    .CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.
                    awt.Font.BOLD,12),java.awt.Color.red),generalPanel. getBorder()))
                    ;generalPanel. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
                    ){if("\u0062ord\u0065r".equals(e.getPropertyName()))throw new RuntimeException();}})
                    ;
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

            //======== capabilitiesScrollPane ========
            {

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
                capabilitiesScrollPane.setViewportView(capabilitiesPanel);
            }
            lightDetailsPane.addTab(bundle.getString("label.capabilities"), capabilitiesScrollPane);

            //======== controlScrollPane ========
            {

                //======== lightControlPanel ========
                {
                    lightControlPanel.setLayout(null);

                    //---- turnOnOfButton ----
                    turnOnOfButton.setText(bundle.getString("label.turnonoff"));
                    turnOnOfButton.addActionListener(e -> turnOnOfButtonActionPerformed(e));
                    lightControlPanel.add(turnOnOfButton);
                    turnOnOfButton.setBounds(245, 10, turnOnOfButton.getPreferredSize().width, 30);

                    //---- changeLightNameButton ----
                    changeLightNameButton.setText(bundle.getString("label.changename"));
                    changeLightNameButton.addActionListener(e -> changeLightNameButtonActionPerformed(e));
                    lightControlPanel.add(changeLightNameButton);
                    changeLightNameButton.setBounds(new Rectangle(new Point(235, 80), changeLightNameButton.getPreferredSize()));

                    //---- lightStatusLabel ----
                    lightStatusLabel.setText(bundle.getString("label.status"));
                    lightControlPanel.add(lightStatusLabel);
                    lightStatusLabel.setBounds(15, 15, 110, 20);

                    //---- lightStatusValueLabel ----
                    lightStatusValueLabel.setText(null);
                    lightControlPanel.add(lightStatusValueLabel);
                    lightStatusValueLabel.setBounds(135, 15, 60, 20);

                    //---- controlNameLabel ----
                    controlNameLabel.setText(bundle.getString("label.name"));
                    lightControlPanel.add(controlNameLabel);
                    controlNameLabel.setBounds(15, 50, 110, 20);
                    lightControlPanel.add(controlLightNameTextfield);
                    controlLightNameTextfield.setBounds(135, 50, 225, 25);

                    //---- brightnessLabel ----
                    brightnessLabel.setText(bundle.getString("label.brightness"));
                    lightControlPanel.add(brightnessLabel);
                    brightnessLabel.setBounds(15, 125, 110, 20);

                    //---- brightnessSlider ----
                    brightnessSlider.setMinimum(1);
                    brightnessSlider.setMaximum(254);
                    brightnessSlider.setValue(1);
                    brightnessSlider.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            brightnessSliderMouseReleased(e);
                        }
                    });
                    lightControlPanel.add(brightnessSlider);
                    brightnessSlider.setBounds(new Rectangle(new Point(155, 125), brightnessSlider.getPreferredSize()));

                    //---- colourLabel ----
                    colourLabel.setText(bundle.getString("label.colour"));
                    lightControlPanel.add(colourLabel);
                    colourLabel.setBounds(15, 155, 110, 20);

                    //---- changeColourButton ----
                    changeColourButton.setText(bundle.getString("label.change"));
                    changeColourButton.addActionListener(e -> changeColourButtonActionPerformed(e));
                    lightControlPanel.add(changeColourButton);
                    changeColourButton.setBounds(new Rectangle(new Point(175, 155), changeColourButton.getPreferredSize()));

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
                controlScrollPane.setViewportView(lightControlPanel);
            }
            lightDetailsPane.addTab(bundle.getString("label.control"), controlScrollPane);
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

        //---- colorChooser ----
        colorChooser.setMaximumSize(new Dimension(681, 365));
        colorChooser.setVisible(false);
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
    private JScrollPane capabilitiesScrollPane;
    private JPanel capabilitiesPanel;
    private JLabel certifiedLabel;
    private JCheckBox certifiedValueCheckbox;
    private JScrollPane controlScrollPane;
    private JPanel lightControlPanel;
    private JButton turnOnOfButton;
    private JButton changeLightNameButton;
    private JLabel lightStatusLabel;
    private JLabel lightStatusValueLabel;
    private JLabel controlNameLabel;
    private JTextField controlLightNameTextfield;
    private JLabel brightnessLabel;
    private JSlider brightnessSlider;
    private JLabel colourLabel;
    private JButton changeColourButton;
    private JButton closeButton;
    private JColorChooser colorChooser;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
