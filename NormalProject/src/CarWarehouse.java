import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarWarehouse {
    private static final String INPUT_FILE_NAME = "C:\\Users\\ASUS\\IdeaProjects\\NormalProject\\src\\in.txt";
    static Scanner scn = new Scanner(System.in);
    static Scanner reader = new Scanner(System.in);

    static List<Car> carObjs = new ArrayList<>();

    public static void main(String[] args) {

        String registrationNumber;
        Integer yearMade;
        String colour1;
        String colour2;
        String colour3;
        String carMake;
        String carModel;
        int price;
        try{
            String line;
            BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
            while(true){
                line = br.readLine();
                if(line == null)
                    break;
                String[] extract = line.split(",");
                yearMade = Integer.valueOf(extract[1]);
                price = Integer.valueOf(extract[7]);
                Car obj = new Car(extract[0],yearMade,extract[2],extract[3],extract[4],extract[5],extract[6],price);
                carObjs.add(obj);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        int input = 0;

        while(input != 4){
            System.out.println("\n(1)Search Cars");
            System.out.println("(2) Add Car");
            System.out.println("(3) Delete Car");
            System.out.println("(4) Exit System");
            System.out.println("\n\nEnter your option : ");
            input = scn.nextInt();


            switch (input){
                case 1 :
                    int inputLocal = 0;
                    while(inputLocal != 3){
                        System.out.println("\nSearch Cars:\n(1) By Registration Number");
                        System.out.println("(2) By Car Make and Car Model");
                        System.out.println("(3) Back to Main Menu");
                        System.out.println("\nEnter your option : ");

                        inputLocal = scn.nextInt();

                        switch (inputLocal) {
                            case 1:
                                String searchName;
                                System.out.println("Enter the registration number : ");
                                searchName = reader.nextLine();
                                int searchIndex = -1;
                                for (int i = 0; i < carObjs.size(); i++) {
                                    Car c = carObjs.get(i);
                                    if (c.getRegistrationNumber().equalsIgnoreCase(searchName)) {
                                        searchIndex = i;
                                    }
                                }
                                if (searchIndex != -1) {
                                    Car carPrint = carObjs.get(searchIndex);
                                    System.out.println("Registration Number : " + carPrint.getRegistrationNumber());
                                    System.out.println("Making year : " + carPrint.getYearMade());
                                    System.out.println("Colour 1 : " + carPrint.getColour1());
                                    System.out.println("Colour 2 : " + carPrint.getColour2());
                                    System.out.println("Colour 3 : " + carPrint.getColour3());
                                    System.out.println("Car Make : " + carPrint.getCarMake());
                                    System.out.println("Model Name : " + carPrint.getCarModel());
                                } else {
                                    System.out.println("\nERROR : No such car with this Registration Number\ntry again");
                                }
                                break;

                            case 2:
                                System.out.println("Enter Car Make : ");
                                String searchCarMake = reader.nextLine();
                                System.out.println("Enter Car Model : ");
                                String searchCarModel = reader.nextLine();

                                if(searchCarModel.equalsIgnoreCase("Any")){
                                    int[] searchInd = new int[carObjs.size()];
                                    for(int i = 0;i<searchInd.length;i++){
                                        searchInd[i] = -1;
                                    }
                                    int tracker = 0;
                                    for(int i=0;i<carObjs.size();i++){
                                        Car c = carObjs.get(i);
                                        if(c.getCarMake().equalsIgnoreCase(searchCarMake)){
                                            searchInd[tracker] = i;
                                            tracker++;
                                        }
                                    }
                                    if(searchInd[0] == -1){
                                        System.out.println("\nERROR : No such car with this Car Make and Car Model\nTry again");
                                    }else {
                                        int j = 0;
                                        while(searchInd[j] != -1){
                                            Car carPrint = carObjs.get(searchInd[j]);
                                            System.out.println("\nRegistration Number : " + carPrint.getRegistrationNumber());
                                            System.out.println("Making year : " + carPrint.getYearMade());
                                            System.out.println("Colour 1 : " + carPrint.getColour1());
                                            System.out.println("Colour 2 : " + carPrint.getColour2());
                                            System.out.println("Colour 3 : " + carPrint.getColour3());
                                            System.out.println("Car Make : " + carPrint.getCarMake());
                                            System.out.println("Model Name : " + carPrint.getCarModel());
                                            System.out.println();
                                            j++;
                                        }
                                    }
                                }else{
                                    int index = -1;
                                    for (int i = 0; i < carObjs.size(); i++) {
                                        Car c = carObjs.get(i);
                                        if (c.getCarMake().equalsIgnoreCase(searchCarMake) && c.getCarModel().equalsIgnoreCase(searchCarModel)) {
                                            index = i;
                                        }
                                    }
                                    if(index != -1){
                                        Car carPrint = carObjs.get(index);
                                        System.out.println("\nRegistration Number : " + carPrint.getRegistrationNumber());
                                        System.out.println("Making year : " + carPrint.getYearMade());
                                        System.out.println("Colour 1 : " + carPrint.getColour1());
                                        System.out.println("Colour 2 : " + carPrint.getColour2());
                                        System.out.println("Colour 3 : " + carPrint.getColour3());
                                        System.out.println("Car Make : " + carPrint.getCarMake());
                                        System.out.println("Model Name : " + carPrint.getCarModel());
                                    }else {
                                        System.out.println("\nERROR : No such car with this Car Make and Car Model\nTry again");
                                    }
                                }
                                break;
                            case 3 :
                                break;
                            default:
                                System.out.println("Invalid Input\nTry again");
                                break;
                        }
                    }
                    break;

                case 2 :
                    System.out.println("Enter registration number : ");
                    registrationNumber = reader.nextLine();

                    int flag = 1;

                    for(int i=0;i<carObjs.size();i++){
                        Car check = carObjs.get(i);
                        if(check.getRegistrationNumber().equalsIgnoreCase(registrationNumber)){
                            flag = 0;
                            break;
                        }
                    }
                    if(flag != 0){
                        System.out.println("Enter year made : ");
                        yearMade = scn.nextInt();
                        System.out.println("Enter Colour 1 : ");
                        colour1 = reader.nextLine();
                        System.out.println("Enter colour 2 : ");
                        colour2 = reader.nextLine();
                        System.out.println("Enter colour 3 : ");
                        colour3 = reader.nextLine();
                        System.out.println("Enter car make : ");
                        carMake = reader.nextLine();
                        System.out.println("Enter car model : ");
                        carModel = reader.nextLine();
                        System.out.println("WEnter price : ");
                        price = scn.nextInt();
                        carObjs.add(new Car(registrationNumber,yearMade,colour1,colour2,colour3,carMake,carModel,price));
                        writeToFile();
                    }else {
                        System.out.println("\nERROR : A car of this registration number already exists\nTry again");
                    }
                    break;
                case 3:
                    System.out.println("Enter the registration number of the car which you want to remove : ");
                    String regNum = reader.nextLine();
                    int searchIndex = -1;
                    for(int i=0;i<carObjs.size();i++){
                        Car tracker = carObjs.get(i);
                        if(tracker.getRegistrationNumber().equals(regNum)){
                            searchIndex = i;
                            break;
                        }
                    }
                    if(searchIndex != -1){
                        carObjs.remove(searchIndex);
                    }else{
                        System.out.println("\nERROR : There's no car with this registration number\nTry again");
                    }
                    writeToFile();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid Input\nTry again");
                    break;
            }
        }
    }

    public static void writeToFile(){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(INPUT_FILE_NAME));
            for(int i=0;i<carObjs.size();i++){
                Car gaari = carObjs.get(i);
                String text = gaari.getRegistrationNumber()+","+gaari.getYearMade()+","+gaari.getColour1()+","+gaari.getColour2()+","+gaari.getColour3()+","+gaari.getCarMake()+","+gaari.getCarModel()+","+gaari.getPrice();
                bw.write(text);
                bw.write("\n");
            }
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}


















