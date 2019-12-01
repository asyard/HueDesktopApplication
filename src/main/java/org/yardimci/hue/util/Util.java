package org.yardimci.hue.util;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Util {

    public static String getNotNullValue(Object data) {
        if (data == null) {
            return "";
        }
        return data.toString();
    }

    public static Color convertFromHueForm(double[] xy, int bri) { //x = 0.2477 y = 0.5425
        Color hueColor = Color.white;
        double x = xy[0];
        double y = xy[1];


        double z = 1.0 - x - y;
        double Y = bri / 255.0; // Brightness of lamp
        double X = (Y / y) * x;
        double Z = (Y / y) * z;
        double r = X * 1.612 - Y * 0.203 - Z * 0.302;
        double g = -X * 0.509 + Y * 1.412 + Z * 0.066;
        double b = X * 0.026 - Y * 0.072 + Z * 0.962;
        r = r <= 0.0031308 ? 12.92 * r : (1.0 + 0.055) * Math.pow(r, (1.0 / 2.4)) - 0.055;
        g = g <= 0.0031308 ? 12.92 * g : (1.0 + 0.055) * Math.pow(g, (1.0 / 2.4)) - 0.055;
        b = b <= 0.0031308 ? 12.92 * b : (1.0 + 0.055) * Math.pow(b, (1.0 / 2.4)) - 0.055;

        double maxValue = Math.max(Math.max(r,g),b);
        r /= maxValue;
        g /= maxValue;
        b /= maxValue;
        r = r * 255;   if (r < 0) { r = 255; }
        g = g * 255;   if (g < 0) { g = 255; }
        b = b * 255;   if (b < 0) { b = 255; }

        hueColor = new Color((int)r, (int)g, (int)b);

        return hueColor;
    }

    public static int[] convertToHueForm(int hue, int sat, int li) {
        int hsb[] = new int[3];
        hsb[0] = (int) Math.floor(65535 * hue / 360);
        hsb[1] = (int) Math.floor(sat * 255);
        hsb[2] = (int) Math.floor(li * 255);
        return hsb;
    }

    public static List<Double> convertToHueForm(Color c) {
        // For the hue bulb the corners of the triangle are:
        // -Red: 0.675, 0.322
        // -Green: 0.4091, 0.518
        // -Blue: 0.167, 0.04
        double[] normalizedToOne = new double[3];
        float cred, cgreen, cblue;
        cred = c.getRed();
        cgreen = c.getGreen();
        cblue = c.getBlue();
        normalizedToOne[0] = (cred / 255);
        normalizedToOne[1] = (cgreen / 255);
        normalizedToOne[2] = (cblue / 255);
        float red, green, blue;

        // Make red more vivid
        if (normalizedToOne[0] > 0.04045) {
            red = (float) Math.pow(
                    (normalizedToOne[0] + 0.055) / (1.0 + 0.055), 2.4);
        } else {
            red = (float) (normalizedToOne[0] / 12.92);
        }

        // Make green more vivid
        if (normalizedToOne[1] > 0.04045) {
            green = (float) Math.pow((normalizedToOne[1] + 0.055)
                    / (1.0 + 0.055), 2.4);
        } else {
            green = (float) (normalizedToOne[1] / 12.92);
        }

        // Make blue more vivid
        if (normalizedToOne[2] > 0.04045) {
            blue = (float) Math.pow((normalizedToOne[2] + 0.055)
                    / (1.0 + 0.055), 2.4);
        } else {
            blue = (float) (normalizedToOne[2] / 12.92);
        }

        float X = (float) (red * 0.649926 + green * 0.103455 + blue * 0.197109);
        float Y = (float) (red * 0.234327 + green * 0.743075 + blue * 0.022598);
        float Z = (float) (red * 0.0000000 + green * 0.053077 + blue * 1.035763);

        float x = X / (X + Y + Z);
        float y = Y / (X + Y + Z);

        double[] xy = new double[2];
        xy[0] = x;
        xy[1] = y;
        List<Double> xyAsList = DoubleStream.of(xy).boxed().collect(Collectors.toList()); //Doubles.asList(xy);
        System.out.println(xyAsList);
        return xyAsList;
    }

}
