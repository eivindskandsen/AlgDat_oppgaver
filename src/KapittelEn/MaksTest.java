package KapittelEn;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaksTest {
    public static void main(String[] args) {
        makstest();
    }
    @Test
    public static void makstest()
    {
        int[] a = {8,3,5,7,9,6,10,2,1,4};  // maksverdien 10 er i posisjon 6

        if (Maks.maks(a) != 6)  // kaller maks-metoden
            System.out.println("Kodefeil: Gir feil posisjon for maksverdien!");

        a = new int[0];  // en tom tabell, lengde lik 0
        boolean unntak = false;

        try
        {
            Maks.maks(a);  // kaller maks-metoden
        }
        catch (Exception e)
        {
            unntak = true;
            if (!(e instanceof java.util.NoSuchElementException))
                System.out.println("Kodefeil: Feil unntak for en tom tabell!");
        }

        if (!unntak)
            System.out.println("Kodefeil: Mangler unntak for en tom tabell!");
    }
}