public class Address {   //class Address represents mailing address of customer 
    
    private int addressNumber;
    private String streetName;
    private String city;
    private String state;
    private String zipCode; 
    
    public Address()
    {
    	return;
    }
    
    // Customized constructor 
    public Address(int addressNumber, String streetName, String city, String state, String zipCode)
    {
        this.addressNumber = addressNumber;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
    public Address(Address a)
    {
    	this.addressNumber = a.addressNumber;
    	this.streetName = a.streetName;
    	this.city = a.city;
    	this.state = a.state;
    	this.zipCode = a.zipCode;
    }
    int getAddressNumber()
    {
        return this.addressNumber;
    }
    void setAddressNumber( int addressNum )
    {
    	this.addressNumber = addressNum;
    }
    
    String getStreetName()
    {
        return this.streetName;
    }
    void setStreetName( String street )
    {
    	this.streetName = street;
    }
    
    String getCity()
    {
        return this.city;
    }
    void setCity( String city1 )
    {
    	this.city = city1;
    }
    
    String getState()
    {
        return this.state;
    }
    void setState( String state1 )
    {
    	this.state = state1;
    }
    
    String getZipCode()
    {
        return this.zipCode;
    }  
    void setZipCode( String zip )
    {
    	this.zipCode = zip;
    }  
    
    public String toString()
    {
        String address = "";
        address += Integer.toString(addressNumber);
        address += " ";
        address += streetName;
        address += "\n";
        address += city;
        address += ", ";
        address += state;
        address += " ";
        address += zipCode;
        return address;
    }
}