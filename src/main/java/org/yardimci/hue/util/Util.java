package org.yardimci.hue.util;

public class Util {

    public static String getNotNullValue(Object data) {
        if (data == null) {
            return "";
        }
        return data.toString();
    }

}
