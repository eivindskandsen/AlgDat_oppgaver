package KapittelEn;

import java.util.Arrays;
import java.util.Random;

public class enEn {
    public static void main(String[] args) {

    }
}

class Maks{
public static int maks(int[] a)  // a er en heltallstabell
        {
        if (a.length < 1)
        throw new java.util.NoSuchElementException("Tabellen a er tom!");

        int m = 0;  // indeks til foreløpig største verdi

        for (int i = 1; i < a.length; i++) // obs: starter med i = 1
        {
        if (a[i] > a[m]) m = i;  // indeksen oppdateres
        }

        return m;  // returnerer indeksen/posisjonen til største verdi

        } // maks


        public static int[] randPerm(int n)  // en effektiv versjon
        {
                Random r = new Random();         // en randomgenerator
                int[] a = new int[n];            // en tabell med plass til n tall

                Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

                for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
                {
                        int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
                        hjelpeMetoder.bytt(a,k,i);                   // bytter om
                }

                return a;                        // permutasjonen returneres
        }

        public static void randPerm(int[] a)  // stokker om a
        {
                Random r = new Random();     // en randomgenerator

                for (int k = a.length - 1; k > 0; k--)
                {
                        int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
                        hjelpeMetoder.bytt(a,k,i);
                }
        }



        }
