/*
 * Created by JFormDesigner on Fri Nov 22 20:25:33 EET 2019
 */

package org.yardimci.hue.gui.settings;

import org.yardimci.hue.config.HueAppSettings;
import org.yardimci.hue.core.HueConnection;
import org.yardimci.hue.gui.HueDesktopGUI;
import org.yardimci.hue.gui.common.Messagebox;
import org.yardimci.hue.gui.common.ProgressBar;
import org.yardimci.hue.lang.Bundle;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * @author AY
 */
public class SettingsDialogGUI extends JDialog {
    public SettingsDialogGUI(Window owner) {
        super(owner);
        initComponents();
        setValues();
    }

    private void setValues() {
        String appId = HueAppSettings.getInstance().getAppId();
        if (appId == null || appId.isEmpty()) {
            appIdValueLabel.setText("N/A");
            appIdValueLabel.setVisible(false);
            configureAppIdButton.setEnabled(true);
            configureAppIdButton.setVisible(true);
        } else {
            appIdValueLabel.setText(appId);
            configureAppIdButton.setEnabled(false);
            configureAppIdButton.setVisible(false);
        }
        languageCombobox.setSelectedIndex(0);
        String lang = HueAppSettings.getInstance().getLang();
        if (lang == null || lang.isEmpty()) {
            languageCombobox.setSelectedIndex(0);
        } else {
            if ("tr".equalsIgnoreCase(lang)) {
                languageCombobox.setSelectedIndex(1);
            }
        }


    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void saveSettingsButtonActionPerformed(ActionEvent e) {
        try {
            String lang = "en";
            if (languageCombobox.getSelectedIndex() == 1) {
                lang = "tr";
            }
            HueAppSettings.getInstance().setLang(lang);
            HueAppSettings.getInstance().applySettings();
            ((HueDesktopGUI)this.getOwner()).reloadLabels();
            this.dispose();
        } catch (Exception ex) {
            Messagebox.showError("error.savefailed");
        }
    }

    private void configureAppIdButtonActionPerformed(ActionEvent e) {
        if (Messagebox.showConfirmation("label.presslinkbutton")) {
            final ProgressBar progressBar = new ProgressBar(this);
            SwingWorker<String, Void> worker = new SwingWorker<String, Void>() {
                @Override
                protected String doInBackground() throws Exception {
                    Thread.sleep(1000);
                    boolean appIdCreated = HueConnection.getInstance().createAppId();
                    return String.valueOf(appIdCreated);
                }

                @Override
                protected void done() {
                    progressBar.dispose();
                }
            };

            worker.execute();
            progressBar.setVisible(true);
            try {
                String result = worker.get();
                boolean appIdCreated = Boolean.valueOf(result);
                if (appIdCreated) {
                    appIdValueLabel.setText(HueAppSettings.getInstance().getAppId());
                    appIdValueLabel.setToolTipText(appIdValueLabel.getText());
                    appIdValueLabel.setVisible(true);
                    configureAppIdButton.setEnabled(false);
                    configureAppIdButton.setVisible(false);
                } else {
                    Messagebox.showError("error.operationfailed");
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - AY
        ResourceBundle bundle = ResourceBundle.getBundle("Bundle");
        appIdLabel = new JLabel();
        appIdValueLabel = new JLabel();
        configureAppIdButton = new JButton();
        languageLabel = new JLabel();
        languageCombobox = new JComboBox<>();
        saveSettingsButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(bundle.getString("label.settings"));
        setModal(true);
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- appIdLabel ----
        appIdLabel.setText(bundle.getString("label.appid"));
        contentPane.add(appIdLabel);
        appIdLabel.setBounds(25, 40, 110, 20);
        contentPane.add(appIdValueLabel);
        appIdValueLabel.setBounds(145, 40, 170, 20);

        //---- configureAppIdButton ----
        configureAppIdButton.setIcon(new ImageIcon(getClass().getResource("/icons/hue.png")));
        configureAppIdButton.addActionListener(e -> configureAppIdButtonActionPerformed(e));
        contentPane.add(configureAppIdButton);
        configureAppIdButton.setBounds(150, 35, 55, configureAppIdButton.getPreferredSize().height);

        //---- languageLabel ----
        languageLabel.setText(bundle.getString("label.language"));
        contentPane.add(languageLabel);
        languageLabel.setBounds(new Rectangle(new Point(25, 90), languageLabel.getPreferredSize()));

        //---- languageCombobox ----
        languageCombobox.setModel(new DefaultComboBoxModel<>(new String[] {
            "English",
            "T\u00fcrk\u00e7e"
        }));
        contentPane.add(languageCombobox);
        languageCombobox.setBounds(new Rectangle(new Point(150, 85), languageCombobox.getPreferredSize()));

        //---- saveSettingsButton ----
        saveSettingsButton.setText(bundle.getString("label.save"));
        saveSettingsButton.addActionListener(e -> saveSettingsButtonActionPerformed(e));
        contentPane.add(saveSettingsButton);
        saveSettingsButton.setBounds(new Rectangle(new Point(310, 240), saveSettingsButton.getPreferredSize()));

        //---- cancelButton ----
        cancelButton.setText(bundle.getString("label.cancel"));
        cancelButton.addActionListener(e -> cancelButtonActionPerformed(e));
        contentPane.add(cancelButton);
        cancelButton.setBounds(new Rectangle(new Point(220, 240), cancelButton.getPreferredSize()));

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
    private JLabel appIdLabel;
    private JLabel appIdValueLabel;
    private JButton configureAppIdButton;
    private JLabel languageLabel;
    private JComboBox<String> languageCombobox;
    private JButton saveSettingsButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
