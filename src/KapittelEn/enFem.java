package KapittelEn;

public class enFem {
    public static void main(String[] args) {
        //System.out.println(Metoder_enFem.a(10));

    }
}

class Metoder_enFem{
    /*
    public static int a(int n)           // n må være et ikke-negativt tall
    {
        if (n == 0) return 1;              // a0 = 1
        else if (n == 1) return 2;         // a1 = 2
        else return 2*a(n-1) + 3*a(n-2);   // to rekursive kall
    }


     */
    public static int tverrsum(int n)              // n må være >= 0
    {
        if (n < 10) return n;                        // kun ett siffer
        else return tverrsum(n / 10) + (n % 10);     // metoden kalles
    }

    /*
    public static <T> void perm(T[] a, int k, Oppgave<T[]> o)
    {
        if (k == a.length-1) o.utførOppgave(a);   // en ny permutasjon
        else
            for (int i = k; i < a.length; i++)
            {
                hjelpeMetoder.bytt(a,k,i);     // bytter om a[k] og a[i]
                perm(a,k+1,o);          // permuterer a[k+1:a.length>
                hjelpeMetoder.bytt(a,k,i);     // bytter tilbake
            }
     */
    /*
    public static void kvikksortering2(int[] a, int v, int h)
    {
        while (v < h)
        {
            int k = Tabell.sParter(a,v,h,(v + h)/2);   // Programkode 1.3.9 f)
            if (v < k - 1) kvikksortering2(a,v,k-1);   // minst to i a[v:k-1]
            v = k + 1;
        }
    }
    }
     */


}
