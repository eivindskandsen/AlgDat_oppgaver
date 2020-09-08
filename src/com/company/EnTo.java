package com.company;

public class EnTo {
    public static void main(String[] args) {
        int[]b={2,5,8,10};
        Tabell.maks(Tabell.a,0,3);


    }
}

class Tabell{
    static int[]a={2,7,5,9};

   static int maks(int []a, int fra, int til){
        if(fra<0 || til > a.length || fra >= til){
            throw new IllegalArgumentException("Illegalt intervall");
        }
        int m=fra;
        int minVerdi=a[fra];

        for(int i=fra+1; i<til; i++){
            if (a[i]< minVerdi){
                m=i;
                minVerdi=a[i];
            }
        }
        return m;
    }
}

class Arrayer{
   static int[]a={2,5,8,10};
}
