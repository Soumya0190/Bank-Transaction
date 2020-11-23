import java.util.ArrayList;

public class Customer {
    private int accountNumber = 1;
    private String firstName;
    private String lastName;
    private double balance;
    private double interestRate;  //(as a decimal, so 4.3% would be 0.043)
    
    
    public double totalTransactions;
    public double compoundedBalance;
    
    //- an object representing the mailing address of the customer
    Address Address = new Address(12345, "streetName", "city", "state", "zipCode");
    
    //List transactions - a List of transaction objects
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    
    static int lastAccountNumber = 1;
    
    //Constructor
    public Customer() 
    {
    	lastAccountNumber += 1;
        return;
    }
    public Customer(int acctNum, String fName, String lName, double bal, double intRate, Address a)
    {
    	this.accountNumber = acctNum;
    	this.firstName = fName;
    	this.lastName = lName;
    	this.balance = bal;
    	this.interestRate = intRate;
    	this.Address = a;
    }
    //customized constructor
    public Customer(String fName, String lName, int balance2, double interest, Address a)
    {
    	this.firstName = fName;
        this.lastName = lName;
        this.balance = balance2;
        this.interestRate = interest;
        this.Address = a;
    }
    // copy constructor 
    public Customer(Customer c)
    {
    	this.accountNumber = c.accountNumber;
    	this.firstName = c.firstName;
        this.lastName = c.lastName;
        this.balance = c.balance;
        this.interestRate = c.interestRate;  
    }
    int getAccountNumber()
    {
        return this.accountNumber;
    }
    void setAccountNumber(int newAcctNum)
    {
        this.accountNumber = newAcctNum;
    }
    String getFirstName()
    {
        return this.firstName;
    }
    void setFirstName(String newFirstName)
    {
        this.firstName = newFirstName;
    }
    String getLastName()
    {
        return this.lastName;
    }
    void setLastName(String newLastName)
    {
        this.lastName = newLastName;
    }
    double getBalance()
    {
        return this.balance + totalTransactions;
    }
    void setBalance(double newBalance)
    {
        this.balance = newBalance;
    }
    double getInterestRate() 
    {
        return this.interestRate;
    }
    void setInterestRate(double newInterest) 
    {
        this.interestRate = newInterest/100;
    }
    
    Address getAddress()
    {
        return this.Address;
    }
    void setAddress(Address a)
    {
        this.Address = a;
    }
    
    ArrayList<Transaction> getTransactions()
    {
    	return this.transactions;
    }
    void setTransactions(ArrayList<Transaction> additions)
    {
    	for (int i = 0; i < additions.size(); i++)
    	{
    		this.transactions.add(additions.get(i));
    	}
    }
    public void addTransaction( String vendor,  double amount, boolean isWithdrawal )
    {
        Transaction acct = new Transaction(vendor, amount, isWithdrawal);
        
        acct.setVendor(vendor);
        acct.setAmount(amount);
        acct.setIsWithdrawal(isWithdrawal);
        
        if (isWithdrawal == true) //withdrawal
        {
            totalTransactions -= amount;
        }
        if (isWithdrawal == false) //deposit
        {
            totalTransactions += amount;
        }
        
        this.transactions.ensureCapacity(Transaction.transactionCount);
        this.transactions.add(acct);
    }
    public double getTotalTransactions()
    {
        return this.totalTransactions;
    }
    public double getInterest()
    {
        double interest = getInterestRate();
        double balance2 = getBalance();
        double compoundedBalance = balance2 * interest;
        this.balance += compoundedBalance;
        return compoundedBalance;
    }
    
    public String toString()
    {
        String output = "";
        output += String.format("First Name: %s\n", firstName);
        output += String.format("Last Name: %s\n", lastName);
        output += String.format("Account Number: %d\n", lastAccountNumber);
        output += String.format("Address: %s\n", Address.toString());
        for (int i = 0; i < this.transactions.size(); i++)
        { 
        	String sign =  "";
        	if (this.transactions.get(i).getIsWithdrawal() == true)
        	{
        		sign = "-";
        	}
        	if (this.transactions.get(i).getIsWithdrawal() == false)
        	{
        		sign = "+";
        	}
        	output += String.format("%s: %s$%.2f\n", this.transactions.get(i).getVendor(), sign, this.transactions.get(i).getAmount());
        }
        output += String.format("Total Balance: $%.2f", getBalance());
        return output;
    }
}