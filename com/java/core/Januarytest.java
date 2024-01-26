package org.example;

import java.util.HashMap;
import java.util.Map;

public class Januarytest {

    public static void main(String args[] ){

        Map<Integer , String> map1 = new HashMap<>();

        map1.put(1,"Hello");
        map1.put(2,"world");
        map1.put(3, "Jan");
        map1.put(4,"Monday");
        map1.put(5,"java");

        System.out.println(map1.toString());


    }
}
