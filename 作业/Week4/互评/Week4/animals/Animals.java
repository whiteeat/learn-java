package animals;

import prop.Plate;
import prop.Watermelon;

public abstract class Animals {
    abstract public String say();

    abstract public int getEatSpeed();
    public double eatWatermelon(Plate<Watermelon> plate) {
        int sum = 0;
        while (!plate.isEmpty()) {
            Watermelon w = plate.reduce();
            sum += w.getSize();
        }
        return sum*1.0/getEatSpeed();
    }

    abstract public String getName();
}
