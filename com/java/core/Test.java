





public class Test{
    public static void main(Sting args[]){

        System.out.println("--------------Hello-----------");


        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();

        int[][] arr = new int[][];

        for(int i =0; i<row;i++){
            for(int j=o;j<col;j++){
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println("================Printing the input arrray===============");

        Map<Integer, Integer> mp = new HashMap<>();

        for(int row=0; row< arr.length;row++){
            for(int col = 0; col<arr[col].length;col++){
                System.out.println(arr[row][col]);
                if(col == row)
               mp.put(arr[row][col],arr[row][col+1]);
            }
        }







    }
}