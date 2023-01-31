/** Week4 互评作业
 * 接口有Flyable，Jumpable和Runable。
 * Flyable提供了关于飞行的抽象方法，有takeoff()，fly()和land()；
 * Runable提供了run()方法；
 * Jumplable提供了jump()方法。
 * 抽象类有FlyingObject和Animal。
 * FlyingObject有printName()方法，可以打印飞行器的名字。
 * Animal有个age字段，可以通过setAge()和getAge()设置和访问。还有个eat()抽象方法。
 * 具体类有Airplane，Bird, Sparrow和Superman。
 * Airplane从FlyingObject继承，覆盖了printName()方法，实现了Flyable接口；
 * Bird从Animal继承，覆盖了eat()方法，实现了Flyable接口；
 * Sparrow从Bird继承，覆盖了eat()方法；
 * Superman从Animal继承，覆盖了eat()方法，实现了Runable，Jumpable和Flyable接口,并且有String类型静态常量line和枚举类型只读字段gender，最后有个speak()方法可以打印line里存储的台词。
 */

interface Flyable { 
    abstract public void takeoff();
	abstract public void fly(); 
	abstract public void land(); 
}

interface Runable{
    abstract public void run();
}

interface Jumpable{
    abstract public void jump();
}

enum Gender {
    MALE,
    FEMALE
}

abstract class FlyingObject{
	public void printName(){
        System.out.println("Unidentified Flying Object");
    };
}

abstract class Animal {
    protected int age = 1;

    public void setAge(int age) throws Exception{
        if (age>=0 && age<100){
            this.age = age;
        }
        else{
            throw new Exception("invalid age!");
        }
    }

    public int getAge(){
		return age;
	}

	abstract public void eat();
}

class Airplane extends FlyingObject implements Flyable {
    @Override
    public final void printName()
    {
        System.out.println("Airplane");
    }

    @Override
    public final void takeoff()
    {
        System.out.println("The airplane is takingoff");
    }

    @Override
    public final void fly()
    {
        System.out.println("The airplane is flying");
    }

    @Override
	public final void land()
    {
        System.out.println("The airplane is landing");
    }
}

class Bird extends Animal implements Flyable {
    @Override
    public void eat()
    {
        System.out.println("The bird is eating bird food");
    }

    @Override
    public final void takeoff()
    {
        System.out.println("The bird is takingoff");
    }

    @Override
    public final void fly()
    {
        System.out.println("The bird is flying");
    }

    @Override
	public final void land()
    {
        System.out.println("The bird is landing");
    } 
}

class Sparrow extends Bird {
    public Sparrow()
    {
        age = 4;
    }

    @Override
    public void eat()
    {
        System.out.println("The sparrow is eating sparrow food");
    }

}

final class Superman extends Animal implements Runable, Jumpable, Flyable {
    private static final String line = "I'm the Superman!";
    public final Gender gender;

    public Superman(int age, Gender gender)
    {
        this.age = age;
        this.gender = gender;
    }

    @Override
    public void eat()
    {
        System.out.println("I never eat!");
    }

    @Override
    public void run()
    {
        System.out.println( "I'm running!");
    }

    @Override
    public void jump()
    {
        System.out.println( "I'm jumping!");
    }

    @Override
    public void takeoff()
    {
        System.out.println( "I'm takingoff!");
    }

    @Override
    public void fly()
    {
        System.out.println( "I'm flying!");
    }

    @Override
    public void land()
    {
        System.out.println( "I'm landing!");
    }

    public void speak()
    {
        System.out.println(line);
    }
}

public class Week4 {
    public static void main(String[] args){
        FlyingObject flyingObject = new Airplane();
        flyingObject.printName();
        Flyable flyable_1 = (Flyable) flyingObject;
        flyable_1.takeoff();
        flyable_1.fly();
        flyable_1.land();

        Animal animal_1 = new Bird();
        int age = animal_1.getAge();
        System.out.println("The bird's age is: " + age);
        try
        {
            animal_1.setAge(2);
        }
        catch (Exception exception)
        {
            System.out.println("Bad age value!");
        }
        // finally
        // {
        //     System.out.println("Continue to run!");
        // }
        
        age = animal_1.getAge();
        System.out.println("The bird's new age is: " + age);

        animal_1.eat();

        Flyable flyable_2 = (Flyable) animal_1;
        flyable_2.takeoff();
        flyable_2.fly();
        flyable_2.land();

        Bird bird = new Sparrow();
        age = bird.getAge();
        System.out.println("The sparrow's age is: " + age);

        bird.eat();

        bird.takeoff();
        bird.fly();
        bird.land();
        
        Animal animal_2 = new Superman(20, Gender.FEMALE);

        Superman superman = (Superman) animal_2;
        superman.speak();

        age = animal_2.getAge();
        System.out.println("My age is: " + age + '!');

        animal_2.eat();

        superman.run();
        superman.jump();
        superman.takeoff();
        superman.fly();
        superman.land();
    }
}