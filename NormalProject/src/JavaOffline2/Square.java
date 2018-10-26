package JavaOffline2;

public class Square extends Shape implements Area {

    private double length;

    public Square(double length) {
        super("Square");
        this.length = length;
    }

    @Override
    public double area() {
        return length*length;
    }
}
