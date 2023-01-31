package animals;

public class Lion extends Animals {

    public Lion(int eatSpeed) {
        name = "狮子";
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
        return "我是森林之王。";
    }

    final private String name;
    private int eatSpeed;

}
