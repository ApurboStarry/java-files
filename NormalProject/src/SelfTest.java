class MyException extends Exception{

    public String toString(){
        return "You cannot enter negative value";
    }
}

public class SelfTest{

    static void compute(int a) throws MyException{
        if(a<0)
            throw new MyException();
        System.out.println(a);
    }
    public static void main(String args[]){
        try{
            compute(23);
            compute(-9);
            compute(23);
        }catch (MyException e){
            System.out.println(e);
        }
    }
}  