package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class ColonStringListToMap {

    public static void main(String[] args){

        List<String> list = new ArrayList<String>();

        list.add("Apple:Fruit");
        list.add("Potato:Vegetable");
        list.add("Banana:Fruit");
        list.add("Onion:Vegetable");
        list.add("Papaya:Fruit");

        System.out.println("-------List Before converting in to map------"+ list);

        //Fruit = [Apple, Banana, Papaya] , Vegitable= [Onion, Potato]

        Map<String, List<String>> listMap = list.stream()
                .map(a->a.split(":"))
                .collect(Collectors.groupingBy(a->a[1],
                        Collectors.mapping(a->a[0],Collectors.toList())));

        System.out.println("-----------list convert in to map----------"+ listMap);


    }
}
