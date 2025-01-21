package org.example.dz_6;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Dz6 {
    public static boolean searchInList(String[] strings, String searchString) {
        char[] searchArray = searchString.toCharArray();
        for (String string : strings) {
            char[] stringArray = string.toCharArray();
            if (Arrays.equals(stringArray, searchArray)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] cities = {"London","Lviv", "New York"};
        String searchString = "Lviv";
        System.out.println(searchInList(cities,searchString));
    }
}

