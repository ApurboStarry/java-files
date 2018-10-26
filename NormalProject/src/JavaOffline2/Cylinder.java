package JavaOffline2;

public class Cylinder extends Shape implements Area,Volume {

    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        super("Cylinder");
        this.radius = radius;
        this.height = height;
    }


    @Override
    public double volume() {
        return PI*radius*radius*height;
    }

    @Override
    public double area(){
        return PI*radius*radius;
    }

    public double surfaceArea() {
        return 2*PI*radius*height;
    }

}
