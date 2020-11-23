public class Transaction {
    private String vendor; 
    private double amount; //(represents the transaction amount in dollar/cents)
    private boolean isWithdrawal; //(true if it a withdrawal, and false if it a deposit)
    
    public static int transactionCount;
    
    public Transaction()
    {
    	transactionCount += 1;
    	return;
    }
    
    // Customized constructor
    public Transaction(String vendor, double amount, boolean isWithdrawal)
    {
        this.vendor = vendor;
        this.amount = amount;
        this.isWithdrawal = isWithdrawal;
    }
    public Transaction(Transaction t)
    {
    	this.vendor = t.vendor;
    	this.amount = t.amount;
    	this.isWithdrawal = t.isWithdrawal;
    }
            
    public String getVendor()
    {
       return this.vendor; 
    }
    public void setVendor(String vendor1)
    {
        this.vendor = vendor1;
    }
    public double getAmount()
    {
        return this.amount;
    }
    public void setAmount(double amount1)
    {
        this.amount = amount1;
    }
    public boolean getIsWithdrawal()
    {
        return this.isWithdrawal;
    }
    public void setIsWithdrawal(boolean isWithdrawal1)
    {
        this.isWithdrawal = isWithdrawal1;
    }
}