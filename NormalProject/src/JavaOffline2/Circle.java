package JavaOffline2;

public class Circle extends Shape implements Area {

    private double radius;

    public Circle(double radius){
        super("Circle");
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    @Override
    public double area() {
        return PI*radius*radius;
    }

}
