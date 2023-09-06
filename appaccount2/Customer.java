
package appaccount2;
  
import java.io.Serializable;
public class Customer implements Serializable{
    
     // Private variables for customer id, name, and address
    public int custId;
    private String name;
    private String address;

    // A constructor that takes id, name, and address as parameters
    public Customer(int custId, String name, String address) {
        this.custId = custId;
        this.name = name;
        this.address = address;
    }

    // A public method that returns the customer id
    public int getId() {
        return custId;
    }

    // A public method that returns the customer name
    public String getName() {
        return name;
    }

    // A public method that returns the customer address
    public String getAddress() {
        return address;
    }

    // A public method that sets the customer address
    public void setAddress(String address) {
        this.address = address;
    }

    // A public method that returns a string representation of the customer object
    @Override
    public String toString() {
        return "Customer ID: " + custId + "\n" +
               "Name: " + name + "\n" +
               "Address: " + address + "\n";
    }
    
    
    
}
