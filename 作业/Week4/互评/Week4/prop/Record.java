package prop;

public class Record implements Comparable<Record>{

    public Record(String name, double time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public double getTime() {
        return time;
    }

    @Override
    public int compareTo(Record o) {
        return Double.compare(this.time,o.time);
    }

    private String name;
    private Double time;

}
