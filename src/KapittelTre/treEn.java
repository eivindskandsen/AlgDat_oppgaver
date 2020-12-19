package KapittelTre;


import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

import java.util.*;

public class treEn {
    public static void main(String[] args) {

    }
}

class Grensesnitt{

    public interface Beholder<T> extends Iterable<T>
    {
        public boolean leggInn(T t);       // legger inn t i beholderen
        public boolean inneholder(T t);    // sjekker om den inneholder t
        public boolean fjern(T t);         // fjerner t fra beholderen
        public int antall();               // returnerer antallet i beholderen
        public boolean tom();              // sjekker om beholderen er tom
        public void nullstill();           // tømmer beholderen
        public Iterator<T> iterator();     // returnerer en iterator

        default boolean fjernHvis(Predicate<? super T> p)  // betingelsesfjerning
        {
            Objects.requireNonNull(p);                       // kaster unntak

            boolean fjernet = false;
            for (Iterator<T> i = iterator(); i.hasNext(); )  // løkke
            {
                if (p.test(i.next()))                          // betingelsen
                {
                    i.remove();                                  // fjerner
                    fjernet = true;                              // minst en fjerning
                }
            }
            return fjernet;
        }

    } // grensesnitt Beholder



    public abstract class AbstraktBeholder<T> implements Beholder<T>
    {
        @Override
        public abstract boolean leggInn(T t);    // en abstrakt metode

        @Override
        public boolean inneholder(T t)
        {
            if (t == null)  // tillatt med null-verdier?
            {
                for (T s : this) if (s == null) return true;
            }
            else
            {
                for (T s : this) if (t.equals(s)) return true;
            }
            return false;
        }

        @Override
        public boolean fjern(T t)
        {
            Iterator<T> i = iterator();

            if (t == null)
            {
                while (i.hasNext())
                {
                    if (i.next() == null)
                    {
                        i.remove();
                        return true;
                    }
                }
            }
            else
            {
                while (i.hasNext())
                {
                    if (t.equals(i.next()))
                    {
                        i.remove();
                        return true;
                    }
                }
            }
            return false;
        }

        @Override
        public int antall()
        {
            int antall = 0;
            for (T t : this) antall++;   // bruker en forAlle-løkke
            return antall;
        }

        @Override
        public boolean tom()
        {
            return antall() == 0;    // ferdig kode
        }

        @Override
        public void nullstill()
        {
            for (Iterator<T> i = iterator(); i.hasNext(); )
            {
                i.next();
                i.remove();
            }
        }

        @Override
        public abstract Iterator<T> iterator();    // en abstrakt metode

        @Override
        public String toString()
        {
            StringBuilder s = new StringBuilder("[");

            Iterator<T> i = iterator();

            if (i.hasNext()) s.append(i.next());  // første verdi

            while (i.hasNext())
            {
                s.append(',');        // komma
                s.append(' ');        // blank
                s.append(i.next());   // verdi
            }

            s.append(']');

            return s.toString();
        }

    } // AbstraktBeholder


    public class TabellBeholder<T> extends AbstraktBeholder<T>
    {
        private T[] a;
        private int antall;

        public TabellBeholder()    // konstruktør
        {
            this(10);     // bruker 10 som startdimensjon
        }

        public TabellBeholder(int størrelse)  // konstruktør
        {
            a = (T[])new Object[størrelse];
            antall = 0;
        }

        public TabellBeholder(Iterable<T> itererbar)  // konstruktør
        {
            for (T verdi : itererbar) leggInn(verdi);
        }

        @Override
        public boolean leggInn(T t)
        {
            // En full tabell utvides med 50%
            if (antall == a.length) a = Arrays.copyOf(a,(3*antall)/2 + 1);
            a[antall++] = t;
            return true;  // vellykket innlegging
        }

        private class TabellBeholderIterator implements Iterator<T>
        {
            private int denne = 0;              // instansvariabel
            private boolean removeOK = false;   // instansvariabel

            @Override
            public boolean hasNext()     // sjekker om det er flere igjen
            {
                return denne < antall;     // sjekker verdien til denne
            }

            @Override
            public T next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("Tomt eller ingen verdier igjen!");

                T temp = a[denne];         // henter aktuell verdi
                denne++;                   // flytter indeksen
                removeOK = true;           // nå kan remove() kalles
                return temp;               // returnerer verdien
            }

            @Override
            public void remove()
            {
                if (!removeOK) throw
                        new IllegalStateException("Ulovlig tilstand!");

                removeOK = false;          // remove() kan ikke kalles på nytt

                // verdien i posisjon denne - 1 skal fjernes siden den ble returnert
                // i det siste kallet på next(), verdiene fra og med denne flyttes
                // derfor en enhet mot venstre

                antall--;           // en verdi vil bli fjernet
                denne--;            // denne må flyttes til venstre

                for (int i = denne; i < antall; i++)
                {
                    a[i] = a[i+1];    // verdiene flyttes
                }

                a[antall] = null;   // verdien som lå lengst til høyre nulles
            }

        }  // class TabellBeholderIterator

        @Override
        public Iterator<T> iterator()
        {
            return new TabellBeholderIterator();
        }

    }  // class TabellBeholder


    public interface List<T> extends Collection<T>
    {
        public boolean add(T element);              // leggInn
        public void add(int index, T element);      // leggInn
        public boolean contains(Object o);          // inneholder
        public T get(int index);                    // hent
        public int indexOf(Object o);               // indeksTil
        public T set(int index, T element);         // oppdater
        public T remove(int index);                 // fjern
        public boolean remove(Object o);            // fjern
        public int size();                          // antall
        public boolean isEmpty();                   // tom
        public void clear();                        // nullstill
        public Iterator<T> iterator();              // iterator

        // samt mange andre metoder
    }

}
