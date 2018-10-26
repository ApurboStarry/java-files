package JavaOffline2;

public class Sphere extends Shape implements Volume {
    private double radius;

    public Sphere(double radius){
        super("Sphere");
        this.radius = radius;
    }

    public double surfaceArea() {
        return 4*PI*radius*radius;
    }

    @Override
    public double volume() {
        return 4*PI*radius*radius*radius/3;
    }
}
