package JavaTutorial;

public class SubCarClass extends CarClasss{
    private double chargeInBattery;
    private String colour;

    public double getChargeInBattery() {
        return chargeInBattery;
    }

    public void setChargeInBattery(double chargeInBattery) {
        this.chargeInBattery = chargeInBattery;
    }

    public String getColour() {
        return colour;
    }

    public SubCarClass(){
        super();
        colour = "Black";
        chargeInBattery = 20;
    }

    public SubCarClass(String manu,String model,int cc, double fuel,String key,String colour,double charge){
        super(manu,model,cc,fuel,key);
        this.colour = colour;
        chargeInBattery = charge;
    }

    public SubCarClass(String manu,String model,int cc, double fuel,String key,int year,String colour,double charge){
        super(manu,model,cc,fuel,key,year);
        this.colour = colour;
        chargeInBattery = charge;
    }

    @Override
    public void printAllInfo(){
        super.printAllInfo();
        System.out.println("Charge in battery : "+getChargeInBattery() + "V");
        System.out.println("Colour of the car : "+getColour());
    }


}
