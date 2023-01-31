package animals;

public class Pig extends Animals {

    public Pig(int eatSpeed) {
        name = "猪";
        this.eatSpeed = eatSpeed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getEatSpeed() {
        return eatSpeed;
    }

    @Override
    public String say() {
        return "我有一个超级大的胃。";
    }

    final private String name;
    private int eatSpeed;

}
