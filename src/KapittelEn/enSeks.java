package KapittelEn;

public class enSeks {
    public static void main(String[] args) {

    }
}

class Meteode_enSeks{
    public static void skriv(String[][] a, int feltbredde)
    {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a[i].length; j++)
            {
                System.out.printf("%-" + feltbredde + "s", a[i][j]);
            }
            System.out.printf("\n"); // ny linje
        }
    }

}
