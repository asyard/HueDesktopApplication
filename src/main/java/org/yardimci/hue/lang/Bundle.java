package org.yardimci.hue.lang;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Bundle {

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("Bundle", new Locale("tr"));

    public static String getValue(String key) {
        //TODO return resourceBundle.getString(key);
        try {
            return new String(resourceBundle.getString(key).getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return resourceBundle.getString(key);
        } catch (Exception e) {
            return key;
        }
    }

    public static void setLocale(String locale) {
        resourceBundle = ResourceBundle.getBundle("Bundle", new Locale(locale));
    }

}
