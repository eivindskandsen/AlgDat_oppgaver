package com.company;

import hjelpeklasser.Tabeller;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
      /* System.out.println(Methods.a(Array.etArray));
       System.out.println(Arrays.asList(Array.etArray).indexOf(Methods.a(Array.etArray)));
       System.out.println(Methods.returnArrayIndex(Array.etArray, 1));

       */
     /*   int[] a = hjelpeklasser.Tabeller.randPerm(20);              // en tilfeldig tabell
        for (int k : a) System.out.print(k + " ");  // skriver ut a

        int m = hjelpeklasser.Tabeller.maks(a);   // finner posisjonen til største verdi

        System.out.println("\nStørste verdi ligger på plass " + m);


       /* hjelpeklasser.Tabeller.skriv(a,0,20);
        //hjelpeklasser.Tabeller.skrivHele(a);

        hjelpeklasser.Tabeller.lnSkriv(a,0,19);
        hjelpeklasser.Tabeller.lnSkrivHele(a);
        System.out.print("3");




        Tabeller.maks(a,0,20);  */

        /* int[] a = {5,2,7,3,9,1,8,4,6};
        double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        String[] s = {"Sohil","Per","Thanh","Fatima","Kari","Jasmin"};
        char[] t="JASMIN".toCharArray();
        Integer[]e={5,7,34,5,7,9};

        int k = Tabeller.maks(a);     // posisjonen til den største i a
        int l = Tabeller.maksDouble(d);     // posisjonen til den største i d
        int m = Tabeller.maksString(s);     // posisjonen til den største i s
        int n=Tabeller.maksChar(t);
        int o=Tabeller.maksInteger(e);

        System.out.println(a[k] + "  " + d[l] + "  " + s[m]+" "+t[n]+" "+e[o]);

        Integer A=8;
        Integer B=8;
        System.out.println(A.compareTo(B));

        String q="Tomat";
        String z="Appelsin";

        System.out.println(q.compareTo(z));

        System.out.println(Boolean.compare(true, false));

        String[] u = {"Per","Kari","Ole","Anne","Ali","Eva"};
        Tabeller.innsettingssortering(s);
        System.out.println(Arrays.toString(u));  // [Ali, Anne, Eva, Kari, Ole, Per]

         */

        Integer[] a = Tabeller.randPermInteger(20);
        System.out.println(Arrays.toString(a));
        // En mulig utskrift: [7, 1, 8, 2, 10, 3, 4, 6, 5, 9]

        Tabeller.innsettingssortering(a);
        System.out.println(Arrays.toString(a));
        // Utskrift: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]




    } // main

} // class Program

class Array{
    static Integer[] etArray={2,3,5,8,1,1,1};
}

class Methods{
   static int a(Integer inputArray[]) {
       int min= Array.etArray[0];
        int teller=0;
       for(int i=0; i<Array.etArray.length; i=i+1){
           if(Array.etArray[i]<=min){
               min=Array.etArray[i];
               teller=i;
           }
       }

       return min;
    }

    static ArrayList<Integer> returnArrayIndex(Integer[] inputArray, int hvilketTall){
       ArrayList<Integer> ArrayIndex=new ArrayList<>();
       int teller;
       for (int i=0;i<inputArray.length; i=i+1){
           if(hvilketTall==inputArray[i]){
               teller=i;
               ArrayIndex.add(teller);
           }
       }
       return ArrayIndex;
    }
}
