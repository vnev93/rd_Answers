package org.example.dz_6;

import java.util.*;

public class Dz62 {
        public static void removeRepetitions(List<String> strings){
            Set<String> uniqueStrings = new HashSet<>(strings);

            for (String uniqueString : uniqueStrings) {
                char[] charArray = uniqueString.toCharArray();
                System.out.println(Arrays.toString(charArray));
            }
            System.out.println("----");

            Iterator<String> iterator = uniqueStrings.iterator();
            while (iterator.hasNext()){
                String uniqueString = iterator.next();
                char[] charArray = uniqueString.toCharArray();
                System.out.println(Arrays.toString(charArray));
            }
        }

        public static void main(String[] args) {
            List<String> cities = Arrays.asList("London", "Lviv", "Lviv", "New York", "London");
            removeRepetitions(cities);
        }
    }
