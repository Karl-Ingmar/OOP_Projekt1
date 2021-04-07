import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.in;

public class Peaklass {

    public static void main(String[] args) {
        Scanner UserVastus= new Scanner(System.in);

        List<String> lasv_küsimused = Arrays.asList("F&F≡","F∨F≡","F&G≡ (kommutatiivsus)","F∨G ≡", "(F&G)&H", "(F∨G)∨H≡",
                "F&(F∨G)≡", "F∨F&G≡", "F&(G∨H)≡", "F∨G&H≡", "¬(F&G)≡", "¬(F∨G)≡", "F⇒G≡ (konjunktsiooni kaudu)", "F⇒G ≡(disjunktsiooni kaudu)", "F&G≡(implikatsiooni kaudu)",
                "F∨G≡ (implikatsiooni kaudu)","F⇔G≡ (ilma implikatsioonita)", "F⇔G ≡ (implikatsioonide kaudu)" );
        List<String> lasv_vastused = Arrays.asList("F", "F", "G&F", "G∨F", "F&(G&H)", "F∨(G∨H)",
                "F", "F", "F&G ∨ F&H ", "(F∨G)&(F∨H)","¬F∨¬G","¬F&¬G", "¬(F&¬G)", "¬F ∨ G",
                "¬(F⇒¬G)", "¬F⇒G", "F&G ∨ ¬F&¬G", "(F⇒G)&(G⇒F)");
        List<String> plsv_küsimused = Arrays.asList("¬∀xF(x)≡", "¬∃xF(x)≡","∀x(F(x)&G(x))≡",   //seotud muutujate ümbernimetamise jätsin välja
                "∃x(F(x)∨G(x))≡", "∀x(F(x)&G)≡",  "∃x(F(x)&G) ≡", "∀x(F(x)∨G)≡",
                "∃x(F(x)∨G)≡", "∀x(F(x)⇒G)≡", "∃x(F(x)⇒G)≡", "∀x(F⇒G(x))≡", "∃x(F⇒G(x))≡",
                "∀x∀yF(x,y)≡", "∃x∃yF(x,y)≡");
        List<String>  plsv_vastused = Arrays.asList("∃x¬F(x)", "∀x¬F(x)", "∀xF(x)&∀xG(x)",
                "∃xF(x)∨∃xG(x)", "∀xF(x)&G", "∃xF(x)&G", "∀xF(x)∨G", "∃xF(x)∨G",
                "∃xF(x)⇒G", "∀xF(x)⇒G", "F⇒∀xG(x)", "F⇒∃xG(x)", "∀y∀xF(x,y)",
                "∃y∃xF(x,y)");

        System.out.println(lasv_küsimused.size());
        System.out.println(lasv_vastused.size());
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
               System.out.println("Sista vastused tühikuteta ja samas muutujate järjekorras.");
               System.out.println("Sümbolid kopeerimiseks: & ∨ ⇒ ⇔");
               i = 1;
               Test test = new Test();
               test.Test(lasvKüsimused, lasvVastused, lausearvutus);
           } else if (vastus.equals("predikaatloogika")) {
               System.out.println("Sista vastused tühikuteta ja samas muutujate järjekorras.");
               System.out.println("Sümbolid kopeerimiseks: & ∨ ⇒ ⇔ ∀ ∃");
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
