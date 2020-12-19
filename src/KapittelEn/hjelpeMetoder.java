package KapittelEn;

import java.util.Random;

public class hjelpeMetoder {
    public static void main(String[] args) {

    }

    public static void bytt(int []a, int i, int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static int min(int[]a,int begin, int end){
        int minimumVerdi=a[begin];
        int minimumIndex=0;
        for(int i=begin+1; i<end; i++){
            if(a[i]<minimumVerdi){
                minimumVerdi=a[i];
                minimumIndex=i;
            }
        }
        return minimumIndex;
    }
    public static int [] minRandomArray(int n){
        Random a=new Random();
        int [] arr=new int[n];

        for (int i=0; i<arr.length; i++){
            arr[i]=a.nextInt();
        }
        return arr;
    }

}
