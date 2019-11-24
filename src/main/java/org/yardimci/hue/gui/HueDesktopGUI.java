/*
 * Created by JFormDesigner on Fri Nov 22 19:37:27 EET 2019
 */

package org.yardimci.hue.gui;

import java.awt.event.*;

import com.apple.eawt.Application;
import org.yardimci.hue.config.HueAppSettings;
import org.yardimci.hue.core.HueConnection;
import org.yardimci.hue.core.model.response.lamp.Lamp;
import org.yardimci.hue.gui.common.LampTableModel;
import org.yardimci.hue.gui.common.Messagebox;
import org.yardimci.hue.gui.help.HelpDialogGUI;
import org.yardimci.hue.gui.settings.SettingsDialogGUI;
import org.yardimci.hue.lang.Bundle;

import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;

/**
 * @author AY
 */
public class HueDesktopGUI extends JFrame {

    public HueDesktopGUI() {
        initComponents();
        init();
    }

    public void reloadLabels() {
        setTitle(Bundle.getValue("label.apptitle"));
        connectButton.setText(Bundle.getValue("label.connect")); //todo disconnect
        settingsButton.setText(Bundle.getValue("label.settings"));
        helpButton.setText(Bundle.getValue("label.help"));
        ((LampTableModel) lampTable.getModel()).fireTableStructureChanged(); //to change column headers
    }

    private void connectButtonActionPerformed(ActionEvent e) {
        String appId = HueAppSettings.getInstance().getAppId();
        if (appId == null || appId.isEmpty()) {
            Messagebox.showError("error.appnotconfigured");
            return;
        }

        if (HueConnection.getInstance().isConnected()) {
            boolean disconnected = HueConnection.getInstance().disconnect();
            if (disconnected) {
                connectButton.setIcon(new ImageIcon(getClass().getResource("/icons/connect.png")));
                connectButton.setText(Bundle.getValue("label.connect"));
                clearLamps();
            } else {
                return;
            }
        } else {
            boolean connected = HueConnection.getInstance().connect();
            if (connected) {
                connectButton.setIcon(new ImageIcon(getClass().getResource("/icons/disconnect.png")));
                connectButton.setText(Bundle.getValue("label.disconnect"));

                listAvailableLamps();
            } else {
                Messagebox.showError("error.connectionfailed");
                return;
            }
        }
    }

    private void init() {
        HueAppSettings.getInstance().loadSettings();
        LampTableModel lampTableModel = new LampTableModel();
        lampTableModel.clear();
        lampTable.setModel(lampTableModel);
        reloadLabels();
        Application.getApplication().setDockIconImage(new ImageIcon(getClass().getResource("/icons/applogo-100.png")).getImage());
    }

    private void clearLamps() {
        refreshLampListButton.setEnabled(false);
        LampTableModel model = (LampTableModel) lampTable.getModel();
        model.clear();
        model.fireTableDataChanged(); // notifies the JTable that the model has changed
    }

    private void listAvailableLamps() {
        clearLamps();
        try {
            List<Lamp> lampList = HueConnection.getInstance().listLamps();
            lampTable.setModel(new LampTableModel(lampList));
            LampTableModel model = (LampTableModel) lampTable.getModel();
            model.fireTableDataChanged();
            refreshLampListButton.setEnabled(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            Messagebox.showError("error.unabletolistlamps"); //todo for known types, else show generic message
            return;
        }

    }

    private void settingsButtonActionPerformed(ActionEvent e) {
        SettingsDialogGUI settingsGUI = new SettingsDialogGUI(this);
        settingsGUI.setVisible(true);
    }

    private void helpButtonActionPerformed(ActionEvent e) {
        HelpDialogGUI helpDialogGUI = new HelpDialogGUI(this);
        helpDialogGUI.setVisible(true);
    }

    private void lampTableMouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {     // to detect doble click events
            JTable target = (JTable)e.getSource();
            int row = target.getSelectedRow(); // select a row
            int column = target.getSelectedColumn(); // select a column
            Messagebox.showError(row + "- " + column);
        }
    }

    private void refreshLampListButtonActionPerformed(ActionEvent e) {
        listAvailableLamps();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - AY
        ResourceBundle bundle = ResourceBundle.getBundle("Bundle");
        toolBar = new JToolBar();
        connectButton = new JButton();
        settingsButton = new JButton();
        helpButton = new JButton();
        scrollPane = new JScrollPane();
        lampTable = new JTable();
        refreshLampListButton = new JButton();

        //======== this ========
        setTitle(bundle.getString("label.apptitle"));
        setMinimumSize(new Dimension(400, 350));
        setMaximizedBounds(new Rectangle(0, 0, 800, 700));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/icons/applogo.png")).getImage());
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== toolBar ========
        {

            //---- connectButton ----
            connectButton.setText(bundle.getString("label.connect"));
            connectButton.setIcon(new ImageIcon(getClass().getResource("/icons/connect.png")));
            connectButton.addActionListener(e -> connectButtonActionPerformed(e));
            toolBar.add(connectButton);

            //---- settingsButton ----
            settingsButton.setText(bundle.getString("label.settings"));
            settingsButton.setIcon(new ImageIcon(getClass().getResource("/icons/settings.png")));
            settingsButton.addActionListener(e -> settingsButtonActionPerformed(e));
            toolBar.add(settingsButton);

            //---- helpButton ----
            helpButton.setText(bundle.getString("label.help"));
            helpButton.setIcon(new ImageIcon(getClass().getResource("/icons/help.png")));
            helpButton.addActionListener(e -> helpButtonActionPerformed(e));
            toolBar.add(helpButton);
        }
        contentPane.add(toolBar);
        toolBar.setBounds(0, 0, 400, 40);

        //======== scrollPane ========
        {

            //---- lampTable ----
            lampTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            lampTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    lampTableMouseClicked(e);
                }
            });
            scrollPane.setViewportView(lampTable);
        }
        contentPane.add(scrollPane);
        scrollPane.setBounds(5, 40, 395, 190);

        //---- refreshLampListButton ----
        refreshLampListButton.setIcon(new ImageIcon(getClass().getResource("/icons/refresh.png")));
        refreshLampListButton.setEnabled(false);
        refreshLampListButton.addActionListener(e -> refreshLampListButtonActionPerformed(e));
        contentPane.add(refreshLampListButton);
        refreshLampListButton.setBounds(340, 235, 45, refreshLampListButton.getPreferredSize().height);

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
    private JToolBar toolBar;
    private JButton connectButton;
    private JButton settingsButton;
    private JButton helpButton;
    private JScrollPane scrollPane;
    private JTable lampTable;
    private JButton refreshLampListButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
