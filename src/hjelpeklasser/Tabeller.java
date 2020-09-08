package hjelpeklasser;

import java.util.*;

public class Tabeller {


    private Tabeller(){

    }
    static void bytt(int []a, int i, int j){
        int temp= a[i]; a[i]=a[j]; a[j]=temp;
    }

    static void charBytt(char[]b, int i, int j){
        char charTemp=b[i]; b[i]= b[j]; b[j]=charTemp;
    }

    public static int [] randPerm(int n) {
        Random r = new Random();
        int[] a = new int[n];

        Arrays.setAll(a, i -> i + 1);

        for (int k = n - 1; k > 0; k--) {
            int i = r.nextInt(k + 1);
            bytt(a, k, i);
        }
        return a;

    }

    void randPerm(int [] a){
        Random r= new Random();
        for (int k= a.length -1; k > 0; k--){
            int i = r.nextInt(k+1);
            bytt(a,k,i);
        }
    }
    public static int maks(int[] a, int fra, int til) {
       /* if (fra < 0 || til > a.length || fra >= til)
        {
            throw new IllegalArgumentException("Illegalt intervall!");
        }
        */

        if (fra < 0) {                                 // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");
        }
        if (til > a.length) {                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + a.length + ")");
        }
        if (fra > til) {                               // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
        }

        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
        {
            if (a[i] > maksverdi)
            {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }
    public static int maks(int[] a)  // bruker hele tabellen
    {
        return maks(a,0,a.length);     // kaller metoden over
    }

    public static void skriv(int [] a, int fra, int til){
        for(int i=fra; i<til;i++){
            System.out.print(a[i]);
            if(i==til-1){
                break;
            }else{
                System.out.print(" ");
            }
        }
    }
    public static void skrivHele(int[] a){
        skriv(a,0, a.length);
    }

    public static void lnSkriv(int[] a, int fra, int til){
        for(int i=fra; i<til; i++){
            System.out.print(a[i]);
            if(i==til-1){
                System.out.print("\n");
            }else{
                System.out.print(" ");
            }
        }
    }

    public static void lnSkrivHele(int[] a){
        lnSkriv(a, 0, a.length);
    }

    public static void fratilKontroll(int tablengde, int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    public static void vhKontroll(int tablengde, int v, int h)
    {
        if (v < 0)
            throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");

        if (h >= tablengde)
            throw new ArrayIndexOutOfBoundsException
                    ("h(" + h + ") >= tablengde(" + tablengde + ")");

        if (v > h + 1)
            throw new IllegalArgumentException
                    ("v = " + v + ", h = " + h);
    }

    public static int maksDouble(double[] a)     // legges i class Tabell
    {
        int m = 0;                           // indeks til største verdi
        double maksverdi = a[0];             // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdaters
        }
        return m;     // returnerer posisjonen til største verdi
    }

    public static int maksString(String[] a)    // legges i class Tabell
    {
        int m = 0;                          // indeks til største verdi
        String maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi
    }

    
}
