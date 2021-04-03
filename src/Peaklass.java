import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Peaklass {
    public static void main(String[] args) {
        String[] lasv_Küsimused ={"lasv_küs1", "lasv_küs2", "lasv_küs3"};
        String[] lasv_Vastused = {"lasv_vas1", "lasv_vas2", "lasv_vas3"};
        String[] plsv_Küsimused ={"plsv_küs1", "plsv_küs2"};
        String[] plsv_Vastused = {"plsv_vas1", "plsv_vas2"};
        //Et tahame hiljem listist eemaldada elemente, siis -
        List<String> lasvKüsimused = new LinkedList<>(Arrays.asList(lasv_Küsimused));
        List<String> plsvKüsimused = new LinkedList<>(Arrays.asList(plsv_Küsimused));
        List<String> lasvVastused = new LinkedList<>(Arrays.asList(lasv_Vastused));
        List<String> plsvVastused = new LinkedList<>(Arrays.asList(plsv_Vastused));
        //Küsime kasutajalt, kas ta tahab harjutada lausearvutus- või predikaatloogikasamaväärsusi
        //Olenevalt kasutaja vastusest väärtustatakse kas LASV või PLSV isend.



        Samaväärsused lausearvutus = new LASV(lasvKüsimused, lasvVastused, 0);

        Samaväärsused predikaatloogika = new PLSV(plsvKüsimused, plsvVastused, 0);

    }
}
