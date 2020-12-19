package KapittelFem;


import java.util.Iterator;

public class femEn {
    public static void main(String[] args) {

    }

}/*
 class BinTre<T> implements Iterable<T>      // et generisk binærtre
{
    private static final class Node<T>  // en indre nodeklasse
    {
        private T verdi;            // nodens verdi
        private Node<T> venstre;    // referanse til venstre barn/subtre
        private Node<T> høyre;      // referanse til høyre barn/subtre

        private Node(T verdi, Node<T> v, Node<T> h)    // konstruktør
        {
            this.verdi = verdi; venstre = v; høyre = h;
        }

        private Node(T verdi) { this.verdi = verdi; }  // konstruktør

    } // class Node<T>

    private Node<T> rot;      // referanse til rotnoden
    private int antall;       // antall noder i treet

    public BinTre() { rot = null; antall = 0; }          // konstruktør


        public final void leggInn(int posisjon, T verdi)  // final: kan ikke overstyres
        {
            if (posisjon < 1) throw new
                    IllegalArgumentException("Posisjon (" + posisjon + ") < 1!");

            Node<T> p = rot, q = null;    // nodereferanser

            int filter = Integer.highestOneBit(posisjon) >> 1;   // filter = 100...00

            while (p != null && filter > 0)
            {
                q = p;
                p = (posisjon & filter) == 0 ? p.venstre : p.høyre;
                filter >>= 1;  // bitforskyver filter
            }

            if (filter > 0) throw new
                    IllegalArgumentException("Posisjon (" + posisjon + ") mangler forelder!");
            else if (p != null) throw new
                    IllegalArgumentException("Posisjon (" + posisjon + ") finnes fra før!");

            p = new Node<>(verdi);          // ny node

            if (q == null) rot = p;         // tomt tre - ny rot
            else if ((posisjon & 1) == 0)   // sjekker siste siffer i posisjon
                q.venstre = p;                // venstre barn til q
            else
                q.høyre = p;                  // høyre barn til q

            antall++;                       // en ny verdi i treet

    }  // kode utelatt

    public int antall() { return antall; }               // returnerer antallet

    public boolean tom() { return antall == 0; }         // tomt tre?


    public void nivåorden()                // skal ligge i class BinTre
    {
        if (tom()) return;                   // tomt tre

        KapittelFire.grensesnitt.Kø<Node<T>> kø = new TabellKø<>();   // Se Avsnitt 4.2.2
        kø.leggInn(rot);                     // legger inn roten

        while (!kø.tom())                    // så lenge som køen ikke er tom
        {
            Node<T> p = kø.taUt();             // tar ut fra køen
            System.out.print(p.verdi + " ");   // skriver ut

            if (p.venstre != null) kø.leggInn(p.venstre);
            if (p.høyre != null) kø.leggInn(p.høyre);
        }

    }

    public Iterator<T> iterator()     // skal ligge i class BinTre
{
    return new InordenIterator();
}

    private InordenIterator()          // konstruktør
    {
        if (tom()) return;               // treet er tomt
        stakk = new TabellStakk<>();     // oppretter stakken
        p = først(rot);                  // bruker hjelpemetoden
    }

}

class enFem_metoder{
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


    public int[] nivåer()   // returnerer en tabell som inneholder nivåantallene
    {
        if (tom()) return new int[0];       // en tom tabell for et tomt tre

        int[] a = new int[8];               // hjelpetabell
        Kø<Node<T>> kø = new TabellKø<>();  // hjelpekø
        int nivå = 0;                       // hjelpevariabel

        kø.leggInn(rot);    // legger roten i køen

        while (!kø.tom())   // så lenge som køen ikke er tom
        {
            // utvider a hvis det er nødvendig
            if (nivå == a.length) a = Arrays.copyOf(a,2*nivå);

            int k = a[nivå] = kø.antall();  // antallet på dette nivået

            for (int i = 0; i < k; i++)  // alle på nivået
            {
                Node<T> p = kø.taUt();

                if (p.venstre != null) kø.leggInn(p.venstre);
                if (p.høyre != null) kø.leggInn(p.høyre);
            }

            nivå++;  // fortsetter på neste nivå
        }

        return Arrays.copyOf(a, nivå);  // fjerner det overflødige
    }


}
}
*/
