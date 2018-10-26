public class OurThread extends Thread{
    private String threadName;
    private int counter;
    private int timeDifference;
    private int adder;
    private int startingPoint;
    private boolean threadAliveFlag;
    private OurThread dependantThread;

    public OurThread(String threadName,OurThread dependantThread, int startingPoint,int adder,int timeDifference, boolean threadAliveFlag) {
        this.threadName = threadName;
        this.dependantThread = dependantThread;
        this.timeDifference = timeDifference;
        this.adder = adder;
        this.startingPoint = startingPoint;
        this.threadAliveFlag = threadAliveFlag;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getTimeDifference() {
        return timeDifference;
    }

    public void setTimeDifference(int timeDifference) {
        this.timeDifference = timeDifference;
    }

    public int getAdder() {
        return adder;
    }

    public void setAdder(int adder) {
        this.adder = adder;
    }

    public int getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(int startingPoint) {
        this.startingPoint = startingPoint;
    }

    public boolean isThreadAliveFlag() {
        return threadAliveFlag;
    }

    public void setThreadAliveFlag(boolean threadAliveFlag) {
        this.threadAliveFlag = threadAliveFlag;
    }

    public void run(){
        counter = startingPoint;
        if(dependantThread !=null){
            try {
                dependantThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while(threadAliveFlag){
            counter += adder;
            try{
                sleep(timeDifference);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void stopThread(){
        threadAliveFlag = false;
    }
}
