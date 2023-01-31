package animals;

public class Monkey extends Animals {

    public Monkey(int eatSpeed) {
        name = "猴子";
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
        return "我要让你看看我吃的有多快。";
    }

    final private String name;
    private int eatSpeed;

}
