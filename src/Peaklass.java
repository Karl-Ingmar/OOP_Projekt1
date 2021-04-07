import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.in;

public class Peaklass {

    public static void main(String[] args) {
        Scanner UserVastus= new Scanner(System.in);

        List<String> lasv_küsimused = Arrays.asList("1+1=?", "lasv_küs2", "lasv_küs3");
        List<String> lasv_vastused = Arrays.asList("2", "lasv_vas2", "lasv_vas3");
        List<String> plsv_küsimused = Arrays.asList("¬∀x F(x)≡", "¬∃x F(x)≡","∀x (F(x) & G(x))≡",   //seotud muutujate ümbernimetamise jätsin välja
                "∃x (F(x) ∨ G(x))≡", "∀x (F(x) & G)≡",  "∃x (F(x) & G) ≡", "∀x (F(x) ∨ G)≡",
                "∃x (F(x) ∨ G) ≡", "∀x (F(x) ⇒ G)≡", "∃x (F(x) ⇒ G)≡", "∀x (F ⇒ G(x))≡", "∃x (F ⇒ G(x))≡",
                "∀x∀y F(x, y)≡", "∃x∃y F(x, y)≡");
        List<String>  plsv_vastused = Arrays.asList("∃x¬F(x)", "∀x¬F(x)", "∀xF(x)&∀xG(x)",
                "∃xF(x)∨∃xG(x)", "∀xF(x)&G", "∃xF(x)&G", "∀xF(x)∨G", "∃xF(x)∨G)",
                "∃xF(x)⇒G", "∀xF(x)⇒G", "F⇒∀xG(x)", "F⇒∃xG(x)", "∀y∀xF(x,y)",
                "∃y∃xF(x,y)");

        //Et tahame hiljem listist eemaldada elemente, siis -
        List<String> lasvKüsimused = new LinkedList<String>();
        List<String> plsvKüsimused = new LinkedList<String>();
        List<String> lasvVastused = new LinkedList<String>();
        List<String> plsvVastused = new LinkedList<String>();

        lasvVastused.addAll(lasv_vastused);
        lasvKüsimused.addAll(lasv_küsimused);
        plsvVastused.addAll(plsv_vastused);
        plsvKüsimused.addAll(plsv_küsimused);
        //Küsime kasutajalt, kas ta tahab harjutada lausearvutus- või predikaatloogikasamaväärsusi
        //Olenevalt kasutaja vastusest väärtustatakse kas LASV või PLSV isend.

        LASV lausearvutus = new LASV(lasvKüsimused, lasvVastused, 0);
        PLSV predikaatloogika = new PLSV(plsv_küsimused, plsv_vastused, 0);
       int i = 0;
       while(i<1) {
           System.out.println("Kas soovite harjutada kätt predikaatloogika või lausearvutuse küsimustega?");
           String vastus = UserVastus.nextLine();
           if (vastus.equals("lausearvutus")) {
               i = 1;
               Test test = new Test();
               test.Test(lasvKüsimused, lasvVastused, lausearvutus);
           } else if (vastus.equals("predikaatloogika")) {
               i = 1;
               Test test = new Test();
               test.Test(plsvKüsimused, plsvVastused, predikaatloogika);

           } else if (vastus.equals("exit")) {
               i = 1;
           } else {
               System.out.println("Vigane sisestus! Sobivad sisendid on (predikaatloogika, lausearvutus)" +
                       " Kui soovite programmi lõpetada, kirjuta exit");
           }
       }



    }
}
