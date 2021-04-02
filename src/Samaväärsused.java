import java.util.List;

abstract class Samaväärsused {
    List<String> Küsimused;
    List<String> Vastused;
    //Küsimusele vastav vastus on sama indeksiga, mis küsimus
    private int skoor;
    public String suvalineKüsimus(){
        //kasutab Math.randomit indeksi genereerimisel (int küsimuseIndeks)
        //väljastab kasutajale küsimuse
//pärast kasutaja vastamist kutsub välja meetodi kontrolli(küsimuseIndeks)
//vastavalt meetodi tagastatud tõeväärtusele siis lisab skoorile punkti või //mitte
//Küsimuste ja vastuste listist visatakse välja küsimuseIndeks-ile //vastavad elemendid
        return null;
    };
    public boolean kontroll(int küsimuseIndeks){
        //kontrollib kas kasutajaVastus.equals(Vastused.get(küsimuseIndeks)
        return true;
    };

    public void setSkoor(int skoor) {
        this.skoor = skoor;
    }

    public Samaväärsused(List<String> küsimused, List<String> vastused, int skoor) {
        Küsimused = küsimused;
        Vastused = vastused;
        this.skoor = skoor;
    }

    public List<String> getKüsimused() {
        return Küsimused;
    }
}
