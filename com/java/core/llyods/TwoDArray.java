package org.example.llyods;


import java.util.*;
import java.util.stream.Collectors;

public class TwoDArray {

    static houses2 hs = null;
    static Map<Integer,Integer> map =  new HashMap<>();;


    public static void collectlist(ArrayList<Integer> al){

        hs = new houses2();
        for (int i =0; i< al.size();i++){
            if(i==0) {
                hs.setPlotNo(al.get(i));
            }
            if(i==1) {
                hs.setPlotsize(al.get(i));
            }
        }
        System.out.println("=====================Printing Houses============"+ hs.toString());
        map.put(hs.getPlotNo(),hs.getPlotsize());
    }


    public static int[] mapiterate(Map<Integer,Integer> map){

        int arr[] = new int[2];


        final Map<Integer,Integer> ls =  map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry:: getKey, Map.Entry::getValue, (e1, e2) -> e1 , LinkedHashMap::new));

        System.out.println("mAp ---------"+ ls);

        int key1  =  ls.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .findFirst()
                .get().getKey();

        System.out.println("Key1 "+ key1);

        int key2 =ls.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .skip(1)
                .findFirst()
                .get().getKey();

        System.out.println("Key1 "+ key1 + "key2 "+ key2 );



        arr[0] =key1;
        arr[1] = key2;



        System.out.println("Array "+ arr.toString());

        return arr;

    }




    public static int[] largestLand(int[][] arr){

        int[] answer = new int[2];



        Map<Integer, Integer> mp = new HashMap<>();

        ArrayList<Integer> list;

        for(int i=0; i< arr.length;i++){
            list =  new ArrayList<>();
            for(int j = 0; j<arr[i].length;j++){
                System.out.print(arr[i][j] + " ");
                list.add(arr[i][j]);

            }
            //call method
            collectlist(list);
            System.out.println();
        }
        System.out.println("--------------------print list element----------");
        return mapiterate(map);
        //System.out.println(list);

        //list.stream().forEach(System.out::println);

    }

    public static void main(String [] args){
        Scanner in = new Scanner(System.in);

        //input for houses
        int houses_row = in.nextInt();
        int houses_col = in.nextInt();
        int houses[][] = new int[houses_row][houses_col];

        for(int idx = 0; idx< houses_row;idx++){

            for(int jdx= 0;jdx< houses_col;jdx++){

                houses[idx][jdx]= in.nextInt();
            }
        }

        int[] result = largestLand(houses);

        for(int idx =0;idx <result.length-1;idx++){
            System.out.println(result[idx] + " ");
        }
        System.out.print(result[result.length - 1]);


    }
}



class houses2{
    int plotNo;
    int plotsize;

    public houses2(int plotNo, int plotsize) {
        this.plotNo = plotNo;
        this.plotsize = plotsize;
    }

    public houses2() {

    }

    public int getPlotNo() {
        return plotNo;
    }

    public void setPlotNo(int plotNo) {
        this.plotNo = plotNo;
    }

    public int getPlotsize() {
        return plotsize;
    }

    public void setPlotsize(int plotsize) {
        this.plotsize = plotsize;
    }

    @Override
    public String toString() {
        return "houses{" +
                "plotNo=" + plotNo +
                ", plotsize=" + plotsize +
                '}';
    }
}