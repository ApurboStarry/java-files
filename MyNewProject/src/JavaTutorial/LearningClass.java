package JavaTutorial;

public class LearningClass {
    public static void main(String[] args) {
        CarClasss ourCar = new CarClasss("TOYOTA","Premio",1500,40,"Starry");

        ourCar.printAllInfo();


        System.out.println("\n\n");
        SubCarClass hybridCar = new SubCarClass("BMW","I10",5000,50,"Starry","Grey",30);

        hybridCar.printAllInfo();
    }
}
