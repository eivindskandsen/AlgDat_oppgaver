package KapittelEn;

import java.util.Arrays;

public class enFire {
    public static void main(String[] args) {
        Double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
       // Metoder_enFire.innsettingssortering(d, Metoder_enFire.Komparator.naturligOrden());

        System.out.println(Arrays.toString(d));
        // Utskrift: [3.14, 3.9, 5.7, 6.5, 7.1, 7.11, 7.12]

        // Metoder_enFire.innsettingssortering(d, Metoder_enFire.Komparator.omvendtOrden());

        System.out.println(Arrays.toString(d));
        // Utskrift: [7.12, 7.11, 7.1, 6.5, 5.7, 3.9, 3.14]
    }

    // Se 1.4.7 oppgaver
}

class Metoder_enFire{


    @FunctionalInterface
    public interface Funksjon<T,R>    // T for argumenttype, R for returtype
    {
        R anvend(T t);
    }

    @FunctionalInterface
    public interface Komparator<T>      // et funksjonsgrensesnitt
    {
        int compare(T o1, T o2);          // en abstrakt metode

        public static <T extends Comparable<? super T>> Komparator<T> naturligOrden()
        {
            return (x, y) -> x.compareTo(y);
        }

        public static <T extends Comparable<? super T>> Komparator<T> omvendtOrden()
        {
            return (x, y) -> y.compareTo(x);
        }

        public static <T, R extends Comparable<? super R>>
        Komparator<T> orden(Funksjon<? super T, ? extends R> velger)
        {
            return (x, y) -> velger.anvend(x).compareTo(velger.anvend(y));
        }

        public static <T, R> Komparator<T> orden
                (Funksjon<? super T, ? extends R> velger, Komparator<? super R> c)
        {
            return (x, y) -> c.compare(velger.anvend(x), velger.anvend(y));
        }

    }

}
