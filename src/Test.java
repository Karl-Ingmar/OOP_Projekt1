import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Scanner;

public class Test {
    public void Test(List<String> küsimused, List<String> vastused, Samaväärsused samaväärsus) {
        int i = 0;
        Scanner UserVastus = new Scanner(System.in);
        while (i < 10) {
            int pikkus = vastused.size();
            System.out.println("Järgmine küsimus (next), Skoor (sf), Katkesta(exit)");
            String vastus = UserVastus.nextLine();
            if (vastus.equals("next")) {
                int indeks = samaväärsus.suvalineKüsimus(pikkus); //prindib küsimuse ja annab indeksi
                küsimused.remove(indeks); //ei korda sama küsimust hiljem
                vastused.remove(indeks);
                i++;
            } else if (vastus.equals("sf")) {
                System.out.println("Skoor: " + samaväärsus.getSkoor());
            } else if (vastus.equals("Exit")) {
                return;
            }

        }
        System.out.println(samaväärsus.getSkoor()+" õiget vastust");
        UserVastus.close();
        return;

    }
}
