import java.util.List;

public class PLSV extends Samaväärsused{


    public PLSV(List<String> küsimused, List<String> vastused, int skoor) {
        super(küsimused, vastused, skoor);
    }

    @Override
    public List<String> getKüsimused() {
        return super.Küsimused;
    }
}
