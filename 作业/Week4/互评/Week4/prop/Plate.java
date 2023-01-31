package prop;

import java.util.concurrent.ArrayBlockingQueue;

public class Plate<T> {
    private ArrayBlockingQueue<T> container;

    public Plate(int limits) {
        this.container = new ArrayBlockingQueue<T>(limits);
    }

    public boolean add(T one) {
        return container.add(one);
    }

    public T reduce() {
        return container.poll();
    }

    public boolean isEmpty() {
        return container.isEmpty();
    }

    public T getOne() {
        return container.peek();
    }

}
