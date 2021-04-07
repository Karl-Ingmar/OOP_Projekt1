import java.util.List;
import java.util.Scanner;

public abstract class Samaväärsused {
    List<String> küsimused;
    List<String> vastused;
    //Küsimusele vastav vastus on sama indeksiga, mis küsimus
    private int skoor;

    public Samaväärsused(List<String> küsimused, List<String> vastused, int skoor) {
        this.küsimused = küsimused;
        this.vastused = vastused;
        this.skoor = skoor;
    }

    public int suvalineKüsimus(int pikkus){

        //Tagastatakse genereeritud indeks, mida kasutame peameetodis selleks et küsitud küsimus/vastus listidest välja visata
        int indeks = suvalineIndeks(pikkus);
        String küsimus = võtaküsimuses(indeks);
        String vastus = võtavastus(indeks);
        String kasutajaVastus = küsiJaTagasta(küsimus);
        if (kasutajaVastus.equals(vastus)) {
            setSkoor(skoor + 1);
            System.out.println("Õige vastus!");
        }else{
            System.out.println("Vale vastus.\n Õige vastus on: "+ vastus);
        }
        return indeks;
    }


//Prindi küsimus ja küsi vastus
    public String küsiJaTagasta(String küsimus) {
        //Prindib küsimuse, tagastab kasutaja vastuse
        System.out.println(küsimus);
        Scanner userVastus= new Scanner(System.in);
        String vastus =  userVastus.nextLine();
 //       userVastus.close();  //tekitas vea - pärast esimest loopi tõlgendas kasutaja vastust kui 'null'
        return vastus;
    }
    // Võtab suvalise arvu küsimuste listi suurusest
    private int suvalineIndeks(int pikkus){
        return (int)(Math.random()* pikkus);
    }
    // eelnevalt suvaliselt genereeritud numbriga võtab indeksi küsimuste listist
    private String võtaküsimuses(int indeks){
        return küsimused.get(indeks);
    }
    private String võtavastus(int indeks){
        return vastused.get(indeks);
    }

    public void setSkoor(int skoor) {
        this.skoor = skoor;
    }

    public int getSkoor() {
        return skoor;
    }
}
