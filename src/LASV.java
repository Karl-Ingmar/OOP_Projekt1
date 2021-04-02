import java.util.List;

public class LASV extends Samaväärsused{
    List<String> küsimused;

    public LASV(List<String> küsimused, List<String> vastused, int skoor) {
        super(küsimused, vastused, skoor);
    }


    @Override
    public List<String> getKüsimused() {
        return küsimused;
    }
}
