package com.example.observabledemo.Utils;

public class BindingUtils {

    /**
     * converts a number to human readable format. eg.  5500L will be converted as 5.5k and
     * 5050890L will be converted as 5.1m.
     * @param count - long number
     * @return - human readable number
     */
    public static String convertToSuffix(long count) {
        if (count < 1000) return "" + count;
        int exp = (int) (Math.log(count) / Math.log(1000));
        return String.format("%.1f%c",
                count / Math.pow(1000, exp),
                "kmgtpe".charAt(exp - 1));
    }
}
