package org.yardimci.hue.gui.common;

import org.yardimci.hue.lang.Bundle;

import javax.swing.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class Messagebox {
    private static ImageIcon errorIcon = new ImageIcon(Messagebox.class.getResource("/icons/error.png"));
    private static ImageIcon infoIcon = new ImageIcon(Messagebox.class.getResource("/icons/check.png"));
    private static ImageIcon confirmIcon = new ImageIcon(Messagebox.class.getResource("/icons/exclamation.png"));

    public static void showInformation(String message) {
        showMessageDialog(null, Bundle.getValue(message), Bundle.getValue("label.information"), JOptionPane.INFORMATION_MESSAGE, infoIcon);
    }

    public static void showError(String message) {
        showMessageDialog(null, Bundle.getValue(message), Bundle.getValue("label.error"), JOptionPane.ERROR_MESSAGE, errorIcon);
    }

    public static boolean showConfirmation(String message) {
        int reply = JOptionPane.showConfirmDialog(null,
                Bundle.getValue(message), Bundle.getValue("label.information"), JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, confirmIcon);
        return (reply == JOptionPane.YES_OPTION);
    }
}
