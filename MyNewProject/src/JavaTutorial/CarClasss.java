package JavaTutorial;

public class CarClasss {

    //public variable
    public String manufacturerName;

    //private variable
    private String modelName;
    private double fuelAmount;
    private String keyvalue;
    final private double fuelConsumptionRate = 0.02;

    //default variable
    int engineCC;

    //protected variable
    protected int manufacturingYear;


    public CarClasss(){
        manufacturerName = new String();
        modelName = new String();
        engineCC = 1000;
        fuelAmount = 10;
        keyvalue = "984621";
        manufacturingYear = 0;
    }

    public CarClasss(String manuName){
        manufacturerName = new String(manuName);
        modelName = new String();
        engineCC = 1000;
        fuelAmount = 10;
        keyvalue = "984621";
        manufacturingYear = 0;
    }

    public CarClasss(String manuName,String model,int cc,double fuel,String key){
        manufacturerName = manuName;
        modelName = model;
        engineCC = cc;
        fuelAmount = fuel;
        keyvalue = key;
        manufacturingYear = 0;
    }

    public CarClasss(String manuName,String model,int cc,double fuel,String key,int year){
        this(manuName,model,cc,fuel,key);
        manufacturingYear = year;
    }

    public double getFuelAmount(){
        return fuelAmount;
    }

    public String getManufacturerName(){
        return manufacturerName;
    }

    public String getModelName(){
        return modelName;
    }

    public boolean matchPassword(String userInput){
        return (userInput == keyvalue);
    }

    public void addFuel(double fuel){
        fuelAmount += fuel;
    }

    public void runForSeconds(int time){
        double fuelUsed = fuelConsumptionRate*time;
        fuelAmount -= fuelUsed;
    }

    public void printAllInfo(){
        System.out.println("Manufacturer name : "+manufacturerName);
        System.out.println("Model Name : " +getModelName());
        System.out.println("Car CC : "+engineCC);
        System.out.println("Password Check : "+matchPassword("jkdcb"));
        System.out.println("Amount of fuel : "+getFuelAmount());
        addFuel(2);
        System.out.println("Amount of fuel : "+getFuelAmount());

        runForSeconds(60);
        System.out.println("Amount of fuel : "+getFuelAmount());
    }

}
