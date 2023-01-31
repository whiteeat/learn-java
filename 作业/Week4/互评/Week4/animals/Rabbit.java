package animals;

public class Rabbit extends Animals {

    public Rabbit(int eatSpeed) {
        name = "兔子";
        this.eatSpeed = eatSpeed;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getEatSpeed() {
        return eatSpeed;
    }

    @Override
    public String say() {
        return "我喜欢胡萝卜。";
    }

    final private String name;
    private int eatSpeed;

}
