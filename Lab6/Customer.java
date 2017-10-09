/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/



// line 1 "UML.ump"
public class Customer
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Customer Attributes
  private String firstName;
  private String lastName;
  private int theirAge;
  private int customerNum;

  //Customer Associations
  private Account account;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Customer(String aFirstName, String aLastName, int aTheirAge, int aCustomerNum, Account aAccount)
  {
    firstName = aFirstName;
    lastName = aLastName;
    theirAge = aTheirAge;
    customerNum = aCustomerNum;
    if (aAccount == null || aAccount.getCustomer() != null)
    {
      throw new RuntimeException("Unable to create Customer due to aAccount");
    }
    account = aAccount;
  }

  public Customer(String aFirstName, String aLastName, int aTheirAge, int aCustomerNum, long aAcctNumForAccount, double aAcctBalanceForAccount, String aFirstNameForAccount, String aLastNameForAccount)
  {
    firstName = aFirstName;
    lastName = aLastName;
    theirAge = aTheirAge;
    customerNum = aCustomerNum;
    account = new Account(aAcctNumForAccount, aAcctBalanceForAccount, aFirstNameForAccount, aLastNameForAccount, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

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

  public boolean setTheirAge(int aTheirAge)
  {
    boolean wasSet = false;
    theirAge = aTheirAge;
    wasSet = true;
    return wasSet;
  }

  public boolean setCustomerNum(int aCustomerNum)
  {
    boolean wasSet = false;
    customerNum = aCustomerNum;
    wasSet = true;
    return wasSet;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public int getTheirAge()
  {
    return theirAge;
  }

  public int getCustomerNum()
  {
    return customerNum;
  }

  public Account getAccount()
  {
    return account;
  }

  public void delete()
  {
    Account existingAccount = account;
    account = null;
    if (existingAccount != null)
    {
      existingAccount.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "firstName" + ":" + getFirstName()+ "," +
            "lastName" + ":" + getLastName()+ "," +
            "theirAge" + ":" + getTheirAge()+ "," +
            "customerNum" + ":" + getCustomerNum()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "account = "+(getAccount()!=null?Integer.toHexString(System.identityHashCode(getAccount())):"null");
  }
}