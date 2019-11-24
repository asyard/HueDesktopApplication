package org.yardimci.hue.config;

import org.ini4j.Ini;
import org.yardimci.hue.lang.Bundle;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class HueAppSettings {

    private static String configFileLocation = System.getProperty("user.dir") + File.separator + "hueappconfig.ini";
    private String appId;
    private String lang = "en";

    private static HueAppSettings instance;

    public static HueAppSettings getInstance() {
        if (instance == null) {
            instance = new HueAppSettings();
            loadSettings();
        }

        return instance;
    }

    public static void loadSettings() {
        Ini ini = null;
        try {
            File configFile = new File(configFileLocation);
            if (!configFile.exists()) {
                configFile.createNewFile();
            }
            ini = new Ini(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            instance.appId = ini.get("CONFIG", "APPID");
            instance.lang = ini.get("CONFIG", "LANG");
            if (instance.lang == null) {
                instance.lang = "en";
                ini.put("CONFIG", "LANG", "en");
                ini.store();
            }
            instance.setLang(instance.lang);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setLang(String locale) {
        instance.lang = locale;
        Bundle.setLocale(instance.lang);
        Locale.setDefault(new Locale(instance.lang)); // for jformdesigner
        // for messagebox buttons
        UIManager.put("OptionPane.cancelButtonText", Bundle.getValue("label.cancel"));
        UIManager.put("OptionPane.okButtonText", Bundle.getValue("label.ok"));
    }

    public String getLang() {
        return instance.lang;
    }

    public void applySettings() {
        try {
            Ini ini = new Ini(new File(configFileLocation));
            ini.put("CONFIG", "LANG", instance.lang);
            ini.put("CONFIG", "APPID", instance.appId);
            ini.store();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
