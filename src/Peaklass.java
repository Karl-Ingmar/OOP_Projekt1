import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Peaklass extends Samaväärsused{
    public Peaklass(List<String> küsimused, List<String> vastused, int skoor) {
        super(küsimused, vastused, skoor);
    }

    public static void main(String[] args) {
        Scanner UserVastus= new Scanner(System.in);
        String Vastus;
        String[] lasv_Küsimused ={"1+1=?", "lasv_küs2", "lasv_küs3"};
        String[] lasv_Vastused = {"2", "lasv_vas2", "lasv_vas3"};
        String[] plsv_Küsimused ={"plsv_küs1", "plsv_küs2"};
        String[] plsv_Vastused = {"plsv_vas1", "plsv_vas2"};
        //Et tahame hiljem listist eemaldada elemente, siis -
        List<String> lasvKüsimused = new LinkedList<>(Arrays.asList(lasv_Küsimused));
        List<String> plsvKüsimused = new LinkedList<>(Arrays.asList(plsv_Küsimused));
        List<String> lasvVastused = new LinkedList<>(Arrays.asList(lasv_Vastused));
        List<String> plsvVastused = new LinkedList<>(Arrays.asList(plsv_Vastused));

        //Küsime kasutajalt, kas ta tahab harjutada lausearvutus- või predikaatloogikasamaväärsusi
        //Olenevalt kasutaja vastusest väärtustatakse kas LASV või PLSV isend.
        System.out.println("Kas soovite harjutada kätt predikaatloogika või lausearvutuse küsimustega?");
        Vastus = UserVastus.nextLine();
        Samaväärsused lausearvutus = new LASV(lasvKüsimused, lasvVastused, 0);
        if (Vastus.equals("lausearvutus")){
            lausearvutus.suvalineKüsimus( List<String> lasvKüsimused,  List<String> lasvVastused, 0);


        }else {
            Samaväärsused predikaatloogika = new PLSV(plsvKüsimused, plsvVastused, 0);
        }
        UserVastus.close();




    }
}
