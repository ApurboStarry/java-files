package JavaOffline2;

enum Type{Circle, Cylinder, Sphere, Square, Cube}

public class Shape {
    protected final double PI = 3.1416;
    protected Type value;

    public Shape(String str){
        value = Type.valueOf(str);
    }

}
