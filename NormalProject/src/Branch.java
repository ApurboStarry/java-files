public class Branch {

    private int id;
    private String name;
    private Account []  accounts;
    
    private int accountCount;
    private static Branch [] branches=new Branch[20];
    private static int branchcount=0;
    // add your code here
    // there can be at most 20 branches  

     // you are not allowed to write any other constructor
    public Branch(int id, String name) {
        this.id = id;
        this.name = name;
        this.accounts = new Account[10];
        this.accountCount = 0;
        
        branches[branchcount++]=this;
        // add your code here
    }

    public void addAccount(Account a) {
        accounts[accountCount++] = a;
    }
    
    public double getBranchBalance(){
        double totalBalance = 0;
        for(int i=0;i<accounts.length;i++){
            totalBalance = totalBalance + accounts[i].getBalance();
        }
        return totalBalance;
    }
    
    public Account getMinBalanceAccount(){
        double minBalance = accounts[0].getBalance();
        Account minBalAccount = accounts[0];
        for(int i=1;i<accounts.length;i++){
            if(accounts[i].getBalance() < minBalance){
                minBalance = accounts[i].getBalance();
                minBalAccount = accounts[i];
            }
        }
        return minBalAccount;
    }
    
    public static void transferBalance(Account from, Account to, double amount){
        from.removeBalance(amount);
        to.addBalance(amount);
    }
    
    public static void printAllBranchesInfo(){
        for(int i=0;i<branchcount;i++)
        {
            for(int j=0;j<branches[i].accountCount;j++)
            {
                
            }
            
        }
        
    }

    // add your code here

}
