package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class OnlineTest {


    static houses hs = null;
    static Map<Integer,Integer> map =  new HashMap<>();;

    public static void main(String args[]){

        System.out.println("=============Hello=============");

        System.out.println("--------------Hello-----------");


        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();

        int[][] arr = new int[row][col];

        for(int i =0; i<row;i++){
            for(int j=0;j<col;j++){
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println("================Printing the input array===============");

//        for(int i=0; i< arr.length;i++){
//            for(int j = 0; j<arr[i].length;j++){
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println("================Printing the input array===============");

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
        mapiterate(map);
       //System.out.println(list);
        System.out.println("--------------------print list element----------");
        //list.stream().forEach(System.out::println);
    }
   public static void collectlist(ArrayList<Integer> al){

        hs = new houses();
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

    public static void mapiterate(Map<Integer,Integer> map){

        int arr[] = new int[2];


       final Map<Integer,Integer> ls =  map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(Map.Entry:: getKey, Map.Entry::getValue, (e1,e2) -> e1 ,LinkedHashMap::new));

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







    }


}

class houses{
    int plotNo;
    int plotsize;

    public houses(int plotNo, int plotsize) {
        this.plotNo = plotNo;
        this.plotsize = plotsize;
    }

    public houses() {

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