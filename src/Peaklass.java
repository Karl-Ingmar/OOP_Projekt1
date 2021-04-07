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
        List<String> plsv_küsimused = Arrays.asList("¬∀xF(x)≡", "¬∃xF(x)≡","∀x(F(x)&G(x))≡",
                "∃x(F(x)∨G(x))≡", "∀x(F(x)&G)≡",  "∃x(F(x)&G) ≡", "∀x(F(x)∨G)≡",
                "∃x(F(x)∨G)≡", "∀x(F(x)⇒G)≡", "∃x(F(x)⇒G)≡", "∀x(F⇒G(x))≡", "∃x(F⇒G(x))≡",
                "∀x∀yF(x,y)≡", "∃x∃yF(x,y)≡");
        List<String>  plsv_vastused = Arrays.asList("∃x¬F(x)", "∀x¬F(x)", "∀xF(x)&∀xG(x)",
                "∃xF(x)∨∃xG(x)", "∀xF(x)&G", "∃xF(x)&G", "∀xF(x)∨G", "∃xF(x)∨G",
                "∃xF(x)⇒G", "∀xF(x)⇒G", "F⇒∀xG(x)", "F⇒∃xG(x)", "∀y∀xF(x,y)",
                "∃y∃xF(x,y)");
        List<String> definitsioonid_küsimused = Arrays.asList("Maatriks, mille ridade ja veergude arv on võrdne, m=n", "Mis on determinandi väärtus kahe võrdse või võrdelise rea korral?",
                "Maatriks mille peadiagonaali elemendid on kõik ühed ja kõrvaldiagonaali elemendid 0-d nimetatakse?","Ruutmaatriks, mille determinant võrdub 0-ga nimetatakse?",
                "Maatriksil eksisteerib pöördmaatriks parajasti siis, kui maatriks on ?", "nullmaatriksi astak on?", "Süsteem, millel lahend puudub nimetatakse",
                "Paarisfunktsiooni graafik on sümmetriline mis telje suhtes?", "limx->0 sinx/x=",
                "limx->inf(1+1/x)**x=", "Konstandi tuletis on alati", "(u/v)'=");
        List<String>  definitsioonid_vastused = Arrays.asList("ruutmaatriks","0","ühikmaatriksiks", "singulaarseks", "regulaarne",
                "0", "vastuoluliseks", "y", "1", "e", "0", "(u'v-uv')/v**2");

        System.out.println(lasv_küsimused.size());
        System.out.println(lasv_vastused.size());
        //Et tahame hiljem listist eemaldada elemente, siis -
        List<String> lasvKüsimused = new LinkedList<String>();
        List<String> plsvKüsimused = new LinkedList<String>();
        List<String> lasvVastused = new LinkedList<String>();
        List<String> plsvVastused = new LinkedList<String>();
        List<String> definitsioonid_Küsimused = new LinkedList<String>();
        List<String> definitsioonid_Vastused = new LinkedList<String>();

        lasvVastused.addAll(lasv_vastused);
        lasvKüsimused.addAll(lasv_küsimused);
        plsvVastused.addAll(plsv_vastused);
        plsvKüsimused.addAll(plsv_küsimused);
        definitsioonid_Küsimused.addAll(definitsioonid_küsimused);
        definitsioonid_Vastused.addAll(definitsioonid_vastused);
        //Küsime kasutajalt, kas ta tahab harjutada lihtsamad definitsioone, lausearvutus- või predikaatloogikasamaväärsusi
        //Olenevalt kasutaja vastusest väärtustatakse kas DEF, LASV või PLSV isend.

        LASV lausearvutus = new LASV(lasvKüsimused, lasvVastused, 0);
        PLSV predikaatloogika = new PLSV(plsv_küsimused, plsv_vastused, 0);
        DEF definitsioon =  new DEF(definitsioonid_küsimused, definitsioonid_vastused, 0);
       int i = 0;
       while(i<1) {
           System.out.println("Kas soovite harjutada kätt predikaatloogika(pred) küsimustega,lausearvutuse(lsv) küsimustega või korrata lihtsaid definitsioone(def)?");
           String vastus = UserVastus.nextLine();
           if (vastus.equals("lsv")) {
               System.out.println("Sista vastused tühikuteta ja samas muutujate järjekorras.");
               System.out.println("Sümbolid kopeerimiseks: & ∨ ⇒ ⇔");
               i = 1;
               Test test = new Test();
               test.Test(lasvKüsimused, lasvVastused, lausearvutus);
           } else if (vastus.equals("pred")) {
               System.out.println("Sista vastused tühikuteta ja samas muutujate järjekorras.");
               System.out.println("Sümbolid kopeerimiseks: & ∨ ⇒ ⇔ ∀ ∃");
               i = 1;
               Test test = new Test();
               test.Test(plsvKüsimused, plsvVastused, predikaatloogika);

           } else if (vastus.equals("def")) {
               System.out.println("Sisesta vastus.");

               i = 1;
               Test test = new Test();
               test.Test(definitsioonid_Küsimused, definitsioonid_Vastused, definitsioon);

           } else if (vastus.equals("exit")) {
               i = 1;
           } else {
               System.out.println("Vigane sisestus! Sobivad sisendid on (pred, lsv, def)" +
                       " Kui soovite programmi lõpetada, kirjuta exit");
           }
       }



    }
}
