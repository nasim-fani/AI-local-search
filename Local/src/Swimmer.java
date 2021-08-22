import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Swimmer implements Comparable<Swimmer> {
    int enterTime;
    int exitTime;
    int height;
    Wardrobe wardrobe = null ;

    public Swimmer(int enterTime, int exitTime, int height) {
        this.enterTime = enterTime;
        this.exitTime = exitTime;
        this.height = height;

    }


    @Override
    public int compareTo(Swimmer o) {
        return Integer.compare(this.enterTime, o.enterTime);
    }


    public ArrayList<Wardrobe> costCompute(ArrayList<Wardrobe> wardrobes) {
        ArrayList<Wardrobe> newWardrobes = new ArrayList<>();
        for (Wardrobe w :
                wardrobes) {
            Wardrobe wardrobe = new Wardrobe(w.number, wardrobes.size());
            wardrobe.swimmer = w.swimmer;
            newWardrobes.add(wardrobe);
        }
        for (Wardrobe wr : newWardrobes) {
            if (wr.swimmer != null && wr.swimmer.exitTime > this.enterTime) {
                wr.cost += 1000;
            }
            if (this.height > 175 && wr.number % 2 != 0) {
                wr.cost += 100;
            }
            if (this.height < 175 && wr.number % 2 == 0) {
                wr.cost += 100;
            }
            if (wr.number % 2 == 0) {
                if (wr.row == 1) {
                    if (wr.number != 2 && wardrobes.get(wr.number - 3).swimmer != null) {
                        if (wardrobes.get(wr.number - 3).swimmer.exitTime > this.enterTime) {
                            wr.cost += 100;
                        }
                    }
                    if (wr.number != wardrobes.size() / 3 && wardrobes.get(wr.number + 2).swimmer != null) {
                        if (wardrobes.get(wr.number + 1).swimmer.exitTime > this.enterTime) {
                            wr.cost += 100;
                        }
                    }
                    if (wardrobes.get(wr.number - 2).swimmer != null) {
                        if (wardrobes.get(wr.number - 2).swimmer.exitTime > this.enterTime) {
                            wr.cost += 100;
                        }
                    }

                } else if (wr.row == 2) {
                    if ((wr.number != (wardrobes.size() / 3) + 2) && wardrobes.get(wr.number - 3).swimmer != null) {
                        if (wardrobes.get(wr.number - 3).swimmer.exitTime > this.enterTime) {
                            wr.cost += 100;
                        }
                    }
                    if (wr.number != (2 * wardrobes.size()) / 3 && wardrobes.get(wr.number + 1).swimmer != null) {
                        if (wardrobes.get(wr.number + 1).swimmer.exitTime > this.enterTime) {
                            wr.cost += 100;
                        }
                    }
                    if (wardrobes.get(wr.number - 2).swimmer != null) {
                        if (wardrobes.get(wr.number - 2).swimmer.exitTime > this.enterTime) {
                            wr.cost += 100;
                        }
                    }

                } else if (wr.row == 3) {


                    if ((wr.number != (2 * wardrobes.size() / 3) + 2) && wardrobes.get(wr.number - 3).swimmer != null) {
                        if (wardrobes.get(wr.number - 3).swimmer.exitTime > this.enterTime) {
                            wr.cost += 100;
                        }
                    }
                    if (wr.number != wardrobes.size() && wardrobes.get(wr.number + 1).swimmer != null) {
                        if (wardrobes.get(wr.number + 1).swimmer.exitTime > this.enterTime) {
                            wr.cost += 100;
                        }
                    }
                    if (wardrobes.get(wr.number - 2).swimmer != null) {
                        if (wardrobes.get(wr.number -2).swimmer.exitTime > this.enterTime) {
                            wr.cost += 100;
                        }
                    }
                }
            } else {
                if (wr.row == 1) {

                    if (wr.number != 1 && wardrobes.get(wr.number - 3).swimmer != null) {
                        if (wardrobes.get(wr.number - 3).swimmer.exitTime > this.enterTime) {
                            wr.cost += 100;
                        }
                    }
                    if (wr.number != (wardrobes.size() / 3) - 1 && wardrobes.get(wr.number + 1).swimmer != null) {
                        if (wardrobes.get(wr.number + 1).swimmer.exitTime > this.enterTime) {
                            wr.cost += 100;
                        }
                    }
                    if (wardrobes.get(wr.number ).swimmer != null) {
                        if (wardrobes.get(wr.number).swimmer.exitTime > this.enterTime) {
                            wr.cost += 100;
                        }
                    }

                } else if (wr.row == 2) {

                    if ((wr.number != (wardrobes.size() / 3) + 1) && wardrobes.get(wr.number - 3).swimmer != null) {
                        if (wardrobes.get(wr.number - 3).swimmer.exitTime > this.enterTime) {
                            wr.cost += 100;
                        }
                    }
                    if (wr.number != ((2 * wardrobes.size()) / 3) - 1 && wardrobes.get(wr.number + 1).swimmer != null) {
                        if (wardrobes.get(wr.number + 1).swimmer.exitTime > this.enterTime) {
                            wr.cost += 100;
                        }
                    }
                    if (wardrobes.get(wr.number ).swimmer != null) {
                        if (wardrobes.get(wr.number ).swimmer.exitTime > this.enterTime) {
                            wr.cost += 100;
                        }
                    }

                } else if (wr.row == 3) {

                    if ((wr.number != (2 * wardrobes.size() / 3) + 1) && wardrobes.get(wr.number - 3).swimmer != null) {
                        if (wardrobes.get(wr.number - 3).swimmer.exitTime > this.enterTime) {
                            wr.cost += 100;
                        }
                    }
                    if (wr.number != wardrobes.size() - 1 && wardrobes.get(wr.number + 1).swimmer != null) {
                        if (wardrobes.get(wr.number + 1).swimmer.exitTime > this.enterTime) {
                            wr.cost += 100;
                        }
                    }
                    if (wardrobes.get(wr.number ).swimmer != null) {
                        if (wardrobes.get(wr.number).swimmer.exitTime > this.enterTime) {
                            wr.cost += 100;
                        }
                    }

                }

            }

        }
        return newWardrobes;
    }
}
