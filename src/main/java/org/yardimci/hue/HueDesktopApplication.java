package org.yardimci.hue;

import org.yardimci.hue.gui.HueDesktopGUI;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class HueDesktopApplication {

    public static void main(String[] args) {
        HueDesktopGUI hueDesktopGUI = new HueDesktopGUI();
        hueDesktopGUI.setVisible(true);


        /* try {
            ResourceBundle crunchifyResourceBundle = ResourceBundle.getBundle("Bundle", new Locale("tr"));
            Enumeration<String> crunchifyKeys = crunchifyResourceBundle.getKeys();
            while (crunchifyKeys.hasMoreElements()) {
                String crunchifyKey = crunchifyKeys.nextElement();
                String value = crunchifyResourceBundle.getString(crunchifyKey);
                System.out.println(crunchifyKey + ": " + value);
            }

        } catch (Exception e) {
            System.out.println("Error retrieving properties file: " + e);
        }*/
    }
}
