import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HillClimbing {
    ArrayList<Swimmer> swimmers;
    ArrayList<Wardrobe> wardrobes;

    public HillClimbing(ArrayList<Swimmer> swimmers, ArrayList<Wardrobe> wardrobes) {
        this.swimmers = swimmers;
        this.wardrobes = wardrobes;
    }

    public void hillClimbing(){
        Collections.sort(swimmers);
        for (Swimmer s :
                swimmers) {
            ArrayList<Wardrobe> newWardrobes = s.costCompute(wardrobes);
            Wardrobe min = Collections.min(newWardrobes, Comparator.comparing(w -> w.cost));
            s.wardrobe = min;
            wardrobes.get(newWardrobes.indexOf(min)).swimmer = s;

        }
    }
}
