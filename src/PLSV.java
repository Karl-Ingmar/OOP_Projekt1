import java.util.List;

public class PLSV extends Samaväärsused{
    List<String> küsimused;

    public PLSV(List<String> küsimused, List<String> vastused, int skoor) {
        super(küsimused, vastused, skoor);
    }

    @Override
    public List<String> getKüsimused() {
        return küsimused;
    }
}
