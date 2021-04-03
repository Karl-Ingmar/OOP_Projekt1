import java.util.List;

abstract class Samaväärsused {
    List<String> Küsimused;
    List<String> Vastused;
    //Küsimusele vastav vastus on sama indeksiga, mis küsimus
    private int skoor;
    public int suvalineKüsimus(List<String> küsimused, List<String> vastused, int skoor){
        //kasutab Math.randomit indeksi genereerimisel (int küsimuseIndeks)
        //väljastab kasutajale küsimuse
        //pärast kasutaja vastamist kutsub välja meetodi kontrolli(küsimuseIndeks)
        //vastavalt meetodi tagastatud tõeväärtusele siis lisab skoorile punkti või mitte
        //Tagastatakse genereeritud indeks, mida kasutame peameetodis selleks et küsitud küsimus/vastus listidest välja visata
        int indeks = (int)(Math.random()* küsimused.size());
        String kasutajaVastus = küsiJaTagasta(küsimused.get(indeks));
        if (kasutajaVastus.equals(vastused.get(indeks))){
            setSkoor(skoor+1);
            System.out.println("Õige vastus!");
        }else{
            System.out.println("Vale vastus.\n Õige vastus on: "+ vastused.get(indeks));
        }
        return indeks;
    };

    public String küsiJaTagasta(String küsimus) {
        //Prindib küsimuse, tagastab kasutaja vastuse
        System.out.println(küsimus);
        String kasutajaVastus="";
        return kasutajaVastus;
    }

    public void setSkoor(int skoor) {
        this.skoor = skoor;
    }

    public Samaväärsused(List<String> küsimused, List<String> vastused, int skoor) {
        this.Küsimused = küsimused;
        this.Vastused = vastused;
        this.skoor = skoor;
    }

    public List<String> getKüsimused() {
        return Küsimused;
    }
}
