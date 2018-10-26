package JavaOffline2;

import java.util.Scanner;

class InvalidAgeException extends Exception{
    InvalidAgeException(String s){
        super(s);
    }
}

public class Offline2 {

    static void validate(double age)throws InvalidAgeException {
        if(age<0)
            throw new InvalidAgeException("not valid");
    }

    public static void main(String[] args) {
        int input = 0,circleCount = 0,cylCount = 0,sphereCount = 0,squareCount = 0,cubeCount = 0;
        double radius,height,length;
        Scanner scn = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);
        while(input != 6){
            System.out.println("\n\nPlease select your choice: ");
            System.out.println("1. Circle");
            System.out.println("2. Cylinder");
            System.out.println("3. Sphere");
            System.out.println("4. Square");
            System.out.println("5. Cube");
            System.out.println("6. Exit");
            input = intScanner.nextInt();

            switch (input){
                case 1 :
                    circleCount++;
                    System.out.println("Enter radius : ");
                    radius = scn.nextDouble();
                    try{
                        validate(radius);
                        Circle cir = new Circle(radius);
                        System.out.println("Name: "+cir.value + circleCount);
                        System.out.println("Area: " + cir.area());
                        break;
                    }catch (Exception m){
                        System.out.println("\nYou cannot enter negative value\nTry again");
                        break;
                    }
                case 2 :
                    cylCount++;
                    System.out.println("Enter radius: ");
                    radius = scn.nextDouble();
                    System.out.println("Enter height: ");
                    height = scn.nextDouble();
                    try{
                        validate(radius);
                        validate(height);
                        Cylinder cyl = new Cylinder(radius,height);
                        System.out.println("Name: " + cyl.value + cylCount);
                        System.out.println("Area of the base: " + cyl.area());
                        System.out.println("Area of the surface: " + cyl.surfaceArea());
                        System.out.println("Volume: " + cyl.volume());
                        break;
                    }catch (Exception m){
                        System.out.println("\nYou cannot enter negative value\nTry again");
                        break;
                    }
                case 3 :
                    sphereCount++;
                    System.out.println("Enter radius: ");
                    radius = scn.nextDouble();
                    try{
                        validate(radius);
                        Sphere sph = new Sphere(radius);
                        System.out.println("Name: " + sph.value + sphereCount);
                        System.out.println("Surface Area: " + sph.surfaceArea());
                        System.out.println("Volume: " + sph.volume());
                    }catch (Exception m){
                        System.out.println("\nYou cannot enter negative value\nTry again");
                    }
                    break;

                case 4 :
                    squareCount++;
                    System.out.println("Enter length of the square: ");
                    length = scn.nextDouble();
                    try{
                        validate(length);
                        Square sqr = new Square(length);
                        System.out.println("Name: " + sqr.value + squareCount);
                        System.out.println("Area of the square: " + sqr.area());
                    }catch (Exception m){
                        System.out.println("\nYou cannot enter negative value\nTry again");
                    }
                    break;

                case 5 :
                    cubeCount++;
                    System.out.println("Enter the length of the cube: ");
                    length = scn.nextDouble();
                    try{
                        validate(length);
                        Cube cube = new Cube(length);
                        System.out.println("Name: " + cube.value + cubeCount);
                        System.out.println("Surface Area: " + cube.surfaceArea());
                        System.out.println("Volume: " + cube.volume());
                    }catch (Exception m){
                        System.out.println("\nYou cannot enter negative value\nTry again");
                    }
                    break;

                case 6 :
                    break;
                default:
                    System.out.println("ERROR : Invalid Input\nTry again");
                    break;
            }
        }
    }
}
