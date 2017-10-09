/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/


import java.util.*;

// line 11 "UML.ump"
public class Account
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Account Attributes
  private long acctNum;
  private double acctBalance;
  private String firstName;
  private String lastName;

  //Account Associations
  private List<Order> orders;
  private Customer customer;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Account(long aAcctNum, double aAcctBalance, String aFirstName, String aLastName, Customer aCustomer)
  {
    acctNum = aAcctNum;
    acctBalance = aAcctBalance;
    firstName = aFirstName;
    lastName = aLastName;
    orders = new ArrayList<Order>();
    if (aCustomer == null || aCustomer.getAccount() != null)
    {
      throw new RuntimeException("Unable to create Account due to aCustomer");
    }
    customer = aCustomer;
  }

  public Account(long aAcctNum, double aAcctBalance, String aFirstName, String aLastName, String aFirstNameForCustomer, String aLastNameForCustomer, int aTheirAgeForCustomer, int aCustomerNumForCustomer)
  {
    acctNum = aAcctNum;
    acctBalance = aAcctBalance;
    firstName = aFirstName;
    lastName = aLastName;
    orders = new ArrayList<Order>();
    customer = new Customer(aFirstNameForCustomer, aLastNameForCustomer, aTheirAgeForCustomer, aCustomerNumForCustomer, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAcctNum(long aAcctNum)
  {
    boolean wasSet = false;
    acctNum = aAcctNum;
    wasSet = true;
    return wasSet;
  }

  public boolean setAcctBalance(double aAcctBalance)
  {
    boolean wasSet = false;
    acctBalance = aAcctBalance;
    wasSet = true;
    return wasSet;
  }

  public boolean setFirstName(String aFirstName)
  {
    boolean wasSet = false;
    firstName = aFirstName;
    wasSet = true;
    return wasSet;
  }

  public boolean setLastName(String aLastName)
  {
    boolean wasSet = false;
    lastName = aLastName;
    wasSet = true;
    return wasSet;
  }

  public long getAcctNum()
  {
    return acctNum;
  }

  public double getAcctBalance()
  {
    return acctBalance;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public Order getOrder(int index)
  {
    Order aOrder = orders.get(index);
    return aOrder;
  }

  public List<Order> getOrders()
  {
    List<Order> newOrders = Collections.unmodifiableList(orders);
    return newOrders;
  }

  public int numberOfOrders()
  {
    int number = orders.size();
    return number;
  }

  public boolean hasOrders()
  {
    boolean has = orders.size() > 0;
    return has;
  }

  public int indexOfOrder(Order aOrder)
  {
    int index = orders.indexOf(aOrder);
    return index;
  }

  public Customer getCustomer()
  {
    return customer;
  }

  public static int minimumNumberOfOrders()
  {
    return 0;
  }

  public Order addOrder(long aAcctNum, order aOrderNum, String aCreationDate, String aDeliveryDate)
  {
    return new Order(aAcctNum, aOrderNum, aCreationDate, aDeliveryDate, this);
  }

  public boolean addOrder(Order aOrder)
  {
    boolean wasAdded = false;
    if (orders.contains(aOrder)) { return false; }
    Account existingAccount = aOrder.getAccount();
    boolean isNewAccount = existingAccount != null && !this.equals(existingAccount);
    if (isNewAccount)
    {
      aOrder.setAccount(this);
    }
    else
    {
      orders.add(aOrder);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrder(Order aOrder)
  {
    boolean wasRemoved = false;
    //Unable to remove aOrder, as it must always have a account
    if (!this.equals(aOrder.getAccount()))
    {
      orders.remove(aOrder);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addOrderAt(Order aOrder, int index)
  {  
    boolean wasAdded = false;
    if(addOrder(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrderAt(Order aOrder, int index)
  {
    boolean wasAdded = false;
    if(orders.contains(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrderAt(aOrder, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=orders.size(); i > 0; i--)
    {
      Order aOrder = orders.get(i - 1);
      aOrder.delete();
    }
    Customer existingCustomer = customer;
    customer = null;
    if (existingCustomer != null)
    {
      existingCustomer.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "acctNum" + ":" + getAcctNum()+ "," +
            "acctBalance" + ":" + getAcctBalance()+ "," +
            "firstName" + ":" + getFirstName()+ "," +
            "lastName" + ":" + getLastName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "customer = "+(getCustomer()!=null?Integer.toHexString(System.identityHashCode(getCustomer())):"null");
  }
}