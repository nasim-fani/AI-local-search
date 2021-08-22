import java.util.ArrayList;
import java.util.Random;

public class Genetic {
    ArrayList<Swimmer> swimmers;
    ArrayList<Wardrobe> wardrobes;


    public Genetic(ArrayList<Swimmer> swimmers, ArrayList<Wardrobe> wardrobes) {
        this.swimmers = swimmers;
        this.wardrobes = wardrobes;
    }

    ArrayList<Swimmer> genetic() {
        ArrayList<ArrayList<Swimmer>> population = new ArrayList<>();
        while (population.size() < 100) {
            ArrayList<Swimmer> randomState = generateRandomState(this.swimmers);
            if (isValid(randomState)) {
                population.add(randomState);
            }
        }
        while (true) {
            int totalCost = 0;
            ArrayList<Integer> costs = new ArrayList<>();
            for (int i = 0; i < population.size() - 1; i++) {
                costs.add(i, cost(population.get(i)));
                if (cost(population.get(i)) < 300) return population.get(i);
                totalCost += cost(population.get(i));
            }

            ArrayList<Integer> probability = new ArrayList<>();
            for (int i = 0; i < population.size(); i++) {
                probability.add(i, (1 - (costs.get(i) / totalCost)) * 100);
            }
            ArrayList<ArrayList<Swimmer>> weightedPopulation = new ArrayList<>();
            for (int p :
                    probability) {
                for (int i = 0; i < p; i++) {
                    weightedPopulation.add(population.get(probability.indexOf(p)));
                }
            }
            ArrayList<ArrayList<Swimmer>> chosen = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                chosen.add(weightedPopulation.get(getRandomNum(0, weightedPopulation.size() - 1)));
            }
            for (int i = 0; i < 100; i += 2) {
                ArrayList<Swimmer> p1 = chosen.get(i);
                ArrayList<Swimmer> p2 = chosen.get(i + 1);
                int cut = getRandomNum(1, swimmers.size() - 2);
                for (int j = 0; j < cut; j++) {
                    p1.get(j).wardrobe = p1.get(j).wardrobe;
                    p2.get(j).wardrobe = p2.get(j).wardrobe;
                }
                for (int j = cut; j < swimmers.size() - 1; j++) {
                    p1.get(j).wardrobe = p2.get(j).wardrobe;
                    p2.get(j).wardrobe = p1.get(j).wardrobe;
                }
            }
            for (int i = 0; i < 100; i++) {
                chosen.get(i).get(getRandomNum(0, swimmers.size() - 1)).wardrobe = wardrobes.get(getRandomNum(0, wardrobes.size()));
            }
            population = chosen;
            
        }

    }

    private ArrayList<Swimmer> generateRandomState(ArrayList<Swimmer> swimmers) {
        ArrayList<Swimmer> newSwimmer = new ArrayList<>();
        for (Swimmer s :
                swimmers) {
            newSwimmer.add(new Swimmer(s.enterTime, s.exitTime, s.height));
        }

        for (Swimmer swimmer :
                newSwimmer) {
            swimmer.wardrobe = wardrobes.get(getRandomNum(0, wardrobes.size() - 1));
        }
        return newSwimmer;
    }


    private int getRandomNum(int minimum, int maximum) {
        Random rn = new Random();
        int range = maximum - minimum + 1;
        return rn.nextInt(range) + minimum;
    }

    boolean isValid(ArrayList<Swimmer> swimmers) {
        for (int i = 0; i < swimmers.size(); i++) {
            for (int j = i + 1; j < swimmers.size(); j++) {
                if (swimmers.get(i).wardrobe.number == swimmers.get(j).wardrobe.number) {
                    if (swimmers.get(i).exitTime > swimmers.get(j).enterTime)
                        return false;
                }

            }
        }

        return true;
    }
    int cost(ArrayList<Swimmer> swimmers){
        int cost = 0;
        for (Swimmer s :
                swimmers) {

        }

        return 1;
        
    }

}
