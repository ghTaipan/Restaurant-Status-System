public class Comperator implements Comparable<Comperator>{
    private double first;
    private double second;

    public Comperator(double first, double second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public double compareTo() {
        if(second <= first)
            return 1;
        else
            return -1;

    }
}
