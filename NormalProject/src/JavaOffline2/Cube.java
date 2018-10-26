package JavaOffline2;

public class Cube extends Shape implements Volume {

    private double length;

    public Cube(double length) {
        super("Cube");
        this.length = length;
    }

    public double surfaceArea() {
        return 6*length*length;
    }

    @Override
    public double volume() {
        return length*length*length;
    }
}
