public class Wardrobe {
    // zoj --> bala
    // fard --> payin
    int number;
    int row;
    Swimmer swimmer = null;
    int cost = 0;

    public Wardrobe(int number, int numberOfWardrobes) {
        this.number = number;

            if (number<= numberOfWardrobes/3) row =1;
            else if (number>(2*numberOfWardrobes)/3) row =3;
            else row = 2;

    }
}
