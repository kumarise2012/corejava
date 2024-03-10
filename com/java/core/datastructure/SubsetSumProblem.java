package org.example.datastructure;

public class SubsetSumProblem {

    public static void main(String [] args){

        int set[] = {3,34,4,12,5,2};

        int sum = 9;

        int n = set.length;

        if(findSubsetSum(set,n,sum)==true) {
            System.out.println("SubSet Found");
        }
        else {
            System.out.println("No SubSet Found for given sum");
        }

    }


    static boolean findSubsetSum(int arr[],int n, int sum){

        if(sum == 0)
            return false;
        if(n == 0)
            return true;

        if(arr[n -1] > sum){
            return findSubsetSum(arr,n-1,sum);
        }

        return findSubsetSum(arr,n-1,sum) || findSubsetSum(arr,n-1,sum - arr[n-1]);


    }
}
