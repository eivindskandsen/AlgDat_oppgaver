package eksempelklasser;

import hjelpeklasser.Tabeller;

import java.util.Arrays;
import java.util.Objects;

public class enfirefire {

    public static void main(String[] args) {
        int[] a = {5, 2, 7, 3, 9, 1, 8, 10, 4, 6};          // en int-tabell
        Heltall[] h = new Heltall[a.length];       // en Heltall-tabell

        for (int i = 0; i < h.length; i++) h[i] = new Heltall(a[i]);
        Tabeller.innsettingssortering(h);           // generisk sortering
        System.out.println(Arrays.toString(h));   // utskrift

        Heltall x = new Heltall(3), y = new Heltall(3);  // x og y er like
        System.out.println(x.compareTo(y) + "  " + x.equals(y));


        Person[] p = new Person[5];                   // en persontabell

        p[0] = new Person("Kari", "Svendsen");         // Kari Svendsen
        p[1] = new Person("Boris", "Zukanovic");       // Boris Zukanovic
        p[2] = new Person("Ali", "Kahn");              // Ali Kahn
        p[3] = new Person("Azra", "Zukanovic");        // Azra Zukanovic
        p[4] = new Person("Kari", "Pettersen");        // Kari Pettersen

        int m = Tabeller.maks(p);                       // posisjonen til den største
        System.out.println(p[m] + " er størst");      // skriver ut den største

        Tabeller.innsettingssortering(p);               // generisk sortering
        System.out.println(Arrays.toString(p));       // skriver ut sortert


    }

    public static final class Heltall implements Comparable<Heltall> {
        private final int verdi;    // et heltall som instansvariabel

        public Heltall(int verdi) {
            this.verdi = verdi;
        }   // konstruktør

        public int intVerdi() {
            return verdi;
        }             // aksessor

        public int compareTo(Heltall h)        // Heltall som parameter
        //
        {
           //return verdi < h.verdi ? -1 : (verdi == h.verdi ? 0 : 1);
            if (verdi < h.verdi) return -1;
            else if (verdi == h.verdi) return 0;
            else return h.verdi;


        }
    }

    public static class Person implements Comparable<Person>
    {
        private final String fornavn;         // personens fornavn
        private final String etternavn;       // personens etternavn

        public Person(String fornavn, String etternavn)   // konstruktør
        {
            this.fornavn = fornavn;
            this.etternavn = etternavn;
        }

        public String fornavn() { return fornavn; }       // aksessor
        public String etternavn() { return etternavn; }   // aksessor

        public int compareTo(Person p)    // pga. Comparable<Person>
        {
            int cmp = etternavn.compareTo(p.etternavn);     // etternavn
            if (cmp != 0) return cmp;             // er etternavnene ulike?
            return fornavn.compareTo(p.fornavn);  // sammenligner fornavn
        }

        public boolean equals(Object o)      // vår versjon av equals
        {
            if (o == this) return true;
            if (!(o instanceof Person)) return false;
            return compareTo((Person)o) == 0;
        }

        public int hashCode() { return Objects.hash(etternavn, fornavn); }

        public String toString() { return fornavn + " " + etternavn; }

    } // class Person

}