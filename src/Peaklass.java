import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Peaklass {

    public static void main(String[] args) {
        Scanner UserVastus= new Scanner(System.in);

        List<String> lasv_küsimused = Arrays.asList("1+1=?", "lasv_küs2", "lasv_küs3");
        List<String> lasv_vastused = Arrays.asList("2", "lasv_vas2", "lasv_vas3");
        List<String> plsv_küsimused = Arrays.asList("plsv_küs1", "plsv_küs2");
        List<String>  plsv_vastused = Arrays.asList("plsv_vas1", "plsv_vas2");




        //Küsime kasutajalt, kas ta tahab harjutada lausearvutus- või predikaatloogikasamaväärsusi
        //Olenevalt kasutaja vastusest väärtustatakse kas LASV või PLSV isend.

        LASV lausearvutus = new LASV(lasv_küsimused, lasv_vastused, 0);
        PLSV predikaatloogika = new PLSV(plsv_küsimused, plsv_vastused, 0);
        int i = 0;
        while (i < 1) {
            System.out.println("Kas soovite harjutada kätt predikaatloogika või lausearvutuse küsimustega?");
            String vastus = UserVastus.nextLine();
            if (vastus.equals("lausearvutus")) {
                lausearvutus.suvalineKüsimus();
            } else if (vastus.equals("predikaatloogika")) {
                predikaatloogika.suvalineKüsimus();
            } else if (vastus.equals("sf")) {
                System.out.println(lausearvutus.getSkoor());
                System.out.println(predikaatloogika.getSkoor());

            } else if (vastus.equals("Exit")) {
                break;
            } else {
                System.out.println("Vigane sisestus! Kas soovite programmi lõpetada? Kui jah, kirjuta Exit");
            }
        }

        UserVastus.close();




    }
}
