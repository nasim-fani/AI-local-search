import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Swimmer> swimmers = new ArrayList<>();
        ArrayList<Wardrobe> wardrobes = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of wardrobes : ");
        int numberOfWardrobes = input.nextInt();

        for (int i = 0; i < numberOfWardrobes; i++) {
            wardrobes.add(new Wardrobe(i+1,numberOfWardrobes));
        }
        System.out.println("Enter number of swimmers: ");
        int numberOfSwimmers = input.nextInt();

        for (int i = 0; i < numberOfSwimmers; i++) {
            System.out.println("Enter enterTime, exitTime and height of swimmer "+i + " ");
            int enterTime = input.nextInt();
            int exitTime = input.nextInt();
            int height = input.nextInt();
            swimmers.add(new Swimmer(enterTime,exitTime,height));
        }


//
//        swimmers.add(new Swimmer(0,10,178));
//        swimmers.add(new Swimmer(2,5,170));
//        swimmers.add(new Swimmer(4,8,176));
//        swimmers.add(new Swimmer(6,10,170));
//
//        wardrobes.add(new Wardrobe(1,6));
//        wardrobes.add(new Wardrobe(2,6));
//        wardrobes.add(new Wardrobe(3,6));
//        wardrobes.add(new Wardrobe(4,6));
//        wardrobes.add(new Wardrobe(5,6));
//        wardrobes.add(new Wardrobe(6,6));
//        wardrobes.add(new Wardrobe(7,6));
//        wardrobes.add(new Wardrobe(8,6));
//        wardrobes.add(new Wardrobe(9,6));
//        wardrobes.add(new Wardrobe(10,6));
//        wardrobes.add(new Wardrobe(11,6));
//        wardrobes.add(new Wardrobe(12,6));

//        HillClimbing hc = new HillClimbing(swimmers,wardrobes);
//        hc.hillClimbing();

        Genetic gn = new Genetic(swimmers,wardrobes);
        gn.genetic();

//        for (int i = 0; i < swimmers.size(); i++) {
//            System.out.println("swimmer "+i+" -> wardrobe "+swimmers.get(i).wardrobe.number);
//        }
    }

}
