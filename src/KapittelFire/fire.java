package KapittelFire;

import java.util.NoSuchElementException;

public class fire {
    public static void main(String[] args) {

    }
}
class grensesnitt {


    public interface Kø<T>              // eng: Queue
    {
        public boolean leggInn(T verdi); // eng: offer/add/enqueue    inn bakerst

        public T kikk();                 // eng: peek/element/front   den første

        public T taUt();                 // eng: poll/remove/dequeue  tar ut den første

        public int antall();             // eng: size                 køens antall

        public boolean tom();            // eng: isEmpty              er køen tom?

        public void nullstill();         // eng: clear                tømmer køen
    }
        public interface Toveiskø<T>          // eng: Deque
        {
            public void leggInnFørst(T verdi);  // legger inn først i køen
            public void leggInnSist(T verdi);   // legger inn sist i køen
            public T kikkFørst();               // ser på den første
            public T kikkSist();                // ser på den siste
            public T taUtFørst();               // tar ut den første
            public T taUtSist();                // tar ut den siste
            public boolean tom();               // er køen tom?
            public int antall();                // antall i køen
            public void nullstill();            // nullstiller køen

        } // interface Toveiskø

     // interface Kø
/*
     class LenketKø<T> implements Kø<T> {
        private static final class Node<T>   // en indre nodeklasse
        {
            private T verdi;        // nodens verdi
            private Node<T> neste;  // peker til neste node

            Node(Node<T> neste)     // nodekonstruktør
            {
                verdi = null;
                this.neste = neste;
            }

        }   // class Node

        private Node<T> fra, til;  // fra: først i køen, til: etter den siste
        private int antall;        // antall i køen

        private static final int START_STØRRELSE = 8;

        public LenketKø(int størrelse)  // konstruktør
        {
            // kode mangler
        }

        public LenketKø()  // standardkonstruktør
        {
            this(START_STØRRELSE);
        }

        public int antall() {
            return antall;
        }

        public boolean tom() {
            return fra == til;  // eller antall == 0
        }

        // resten av metodene skal inn her

    } // class LenketKø

    public class TabellKø<T> implements Kø<T> {
        private T[] a;      // en tabell
        private int fra;    // posisjonen til den første i køen
        private int til;    // posisjonen til første ledige plass

        @SuppressWarnings("unchecked")      // pga. konverteringen: Object[] -> T[]
        public TabellKø(int lengde) {
            if (lengde < 1)
                throw new IllegalArgumentException("Må ha positiv lengde!");

            a = (T[]) new Object[lengde];

            fra = til = 0;    // a[fra:til> er tom
        }

        public TabellKø()   // standardkonstruktør
        {
            this(8);
        }

        // Her skal resten av metodene settes inn

    } // class TabellKø



    public class LenketToveiskø<T> implements Toveiskø<T>
    {
        private static final class Node<T>     // en indre nodeklasse
        {
            T verdi;                             // nodens verdi
            Node<T> forrige;                     // peker til forrige node
            Node<T> neste;                       // peker til neste node

            Node(T verdi, Node<T> forrige, Node<T> neste)  // konstruktør
            {
                this.verdi = verdi;
                this.forrige = forrige;
                this.neste = neste;
            }
        } // class Node

        private Node<T> start;                 // køens start
        private Node<T> slutt;                 // køens slutt
        private int antall;                    // antall i køen

        public LenketToveiskø()                // standardkonstruktør
        {
            start = slutt = null;
            antall = 0;
        }

        // her skal resten av metodene inn

        public void leggInnFørst(T verdi)
        {
            if (antall == 0)   // køen er tom
                start = slutt = new Node<T>(verdi,null,null);
            else
                start = start.forrige = new Node<T>(verdi,null,start);

            antall++;
        }
        public T taUtFørst()
        {
            if (antall == 0)  // køen er tom
                throw new NoSuchElementException("Køen er tom!");

            T temp = start.verdi;
            start.verdi = null;
            start = start.neste;

            if (antall == 1) slutt = null;
            else start.forrige = null;

            antall--;
            return temp;
        }

        public void leggInnFørst(T verdi)
        {
            if (fra == 0) fra = a.length - 1; else fra--;
            a[fra] = verdi;
            if (fra == til) a = utvidTabell(2*a.length);  // dobler tabellen
        }

        public T kikkSist()
        {
            if (fra == til) throw new NoSuchElementException("Køen er tom!");
            if (til == 0) return a[a.length - 1];
            else return a[til - 1];
        }

        public T taUtSist()
        {
            if (fra == til) throw new NoSuchElementException("Køen er tom!");
            if (til == 0) til = a.length - 1; else til--;
            T temp = a[til];
            a[til] = null;
            return temp;
        }

    } // class LenketToveiskø

 */
}