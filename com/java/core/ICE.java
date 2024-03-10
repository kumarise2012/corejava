package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class ICE {

    public static void main(String[] args){

        List<Weather> weathers = new ArrayList<>();
        weathers.add(new Weather ("Sunny", 33.0));
        weathers.add(new Weather ("Rainy", 17.0));
        weathers.add(new Weather ("Cloudy", 23.0));
        weathers.add(new Weather ("Cold", 3.0));
        weathers.add(new Weather ("Hot", 37.0));
        weathers.add(new Weather ("Hot", 20.0));
        weathers.add(new Weather ("Windy", 13.0));
        weathers.add(new Weather ("Snowy", 0.0));
        weathers.add(new Weather ("Freezing", -15.0));
        weathers.add(new Weather ("Freezing", -10.0));
        weathers.stream().map(Weather::getTemp) .sorted().forEach(System.out::println);
        System.out.println();

        //Both the methods can be used for sorting Start
        weathers.stream() .sorted((p1, p2)-> p1.getTemp().compareTo(p2.getTemp())).forEach(System.out::println);
        System.out.println("===========================Different Method============================");
        weathers.stream().sorted((Comparator.comparing(Weather::getTemp))).forEach(System.out::println);
        //Both the methods can be used for soring End

        System.out.println("================Convert List In to Map=========================");

        Map<String, Set<Weather>> listToMap = weathers.stream().collect(Collectors.groupingBy(Weather::getWeather, TreeMap::new,Collectors.toSet()));

        System.out.println(listToMap.toString());

        System.out.println("================Find Average of temp per weather category=========================");

        Map<String , Double> calculateAvg = weathers.stream().collect(Collectors.groupingBy(Weather::getWeather ,Collectors.averagingDouble(Weather::getTemp)));

        System.out.println(calculateAvg);

        //Convert a list in to map

        List<String> stringList = new ArrayList<>();
        stringList.add("Apple:Fruit");
        stringList.add("Banana:Fruit");
        stringList.add("Grapes:Fruit");
        stringList.add("Potato:Vegetable");
        stringList.add("Onion:Vegetable");

        Map <String,List<String>> newList= stringList.stream().map(a->a.split(":")).collect(Collectors.groupingBy(a->a[1] ,Collectors.mapping( a->a[0] , Collectors.toList())));

        System.out.println(newList.toString());

        //Convert a list in to Map

        Map<Double,String> listToMapcon = weathers.stream().collect(Collectors.toMap(Weather::getTemp ,Weather::getWeather));
        System.out.println(listToMapcon);

        //weathers.stream().collect(Collectors.toMap(Weather::getTemp , Weather::getWeather, (oldvalue->newValue)->newValue)).f



        Runnable task = new Runnable() {
            public void run() {
                System.out.println("Executing task...");
            }
        };














    }
}

class Weather{
    String weather;
    Double temp;


    public Weather(String weather, Double temp) {
        this.weather = weather;
        this.temp = temp;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }


    @Override
    public String toString() {
        return "Weather{" +
                "weather='" + weather + '\'' +
                ", temp=" + temp +
                '}';
    }
}
