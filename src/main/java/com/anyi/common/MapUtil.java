package com.anyi.common;

public class MapUtil {

    public static String getValue4Map(Object param) {
        if (param instanceof String) {
            if (param == null || ((String) param).trim() == "") {
                return null;
            } else {
                return param.toString();
            }
        } else {
            if (param == null) {
                return null;
            } else {
                return param.toString();
            }
        }
    }
}
