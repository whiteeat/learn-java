package animals;

public class Elephant extends Animals {

    public Elephant(int eatSpeed) {
        name = "大象";
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
        return "我的鼻子可以卷起许多西瓜。";
    }

    final private String name;
    private int eatSpeed;

}
