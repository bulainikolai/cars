package com.cars.framework.utils;

import java.util.ArrayList;

public class ListUtil {
    private final static int START_OF_STRING = 0;
    private static String removeLastCommaIfPresent(String string) {
        int index = string.indexOf(",", string.length() - 2);
        return index > 0 ? string.substring(START_OF_STRING, index) : string;
    }

    public static ArrayList<String> removeFromElementsOfListLastComma(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String result = removeLastCommaIfPresent(list.get(i));
            list.set(i, result);
        }
        return list;
    }
}