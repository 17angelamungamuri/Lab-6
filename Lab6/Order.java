/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/



// line 21 "UML.ump"
public class Order
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Order Attributes
  private long acctNum;
  private order orderNum;
  private String creationDate;
  private String deliveryDate;

  //Order Associations
  private Account account;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Order(long aAcctNum, order aOrderNum, String aCreationDate, String aDeliveryDate, Account aAccount)
  {
    acctNum = aAcctNum;
    orderNum = aOrderNum;
    creationDate = aCreationDate;
    deliveryDate = aDeliveryDate;
    boolean didAddAccount = setAccount(aAccount);
    if (!didAddAccount)
    {
      throw new RuntimeException("Unable to create order due to account");
    }
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

  public boolean setOrderNum(order aOrderNum)
  {
    boolean wasSet = false;
    orderNum = aOrderNum;
    wasSet = true;
    return wasSet;
  }

  public boolean setCreationDate(String aCreationDate)
  {
    boolean wasSet = false;
    creationDate = aCreationDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setDeliveryDate(String aDeliveryDate)
  {
    boolean wasSet = false;
    deliveryDate = aDeliveryDate;
    wasSet = true;
    return wasSet;
  }

  public long getAcctNum()
  {
    return acctNum;
  }

  public order getOrderNum()
  {
    return orderNum;
  }

  public String getCreationDate()
  {
    return creationDate;
  }

  public String getDeliveryDate()
  {
    return deliveryDate;
  }

  public Account getAccount()
  {
    return account;
  }

  public boolean setAccount(Account aAccount)
  {
    boolean wasSet = false;
    if (aAccount == null)
    {
      return wasSet;
    }

    Account existingAccount = account;
    account = aAccount;
    if (existingAccount != null && !existingAccount.equals(aAccount))
    {
      existingAccount.removeOrder(this);
    }
    account.addOrder(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Account placeholderAccount = account;
    this.account = null;
    placeholderAccount.removeOrder(this);
  }


  public String toString()
  {
    return super.toString() + "["+
            "acctNum" + ":" + getAcctNum()+ "," +
            "creationDate" + ":" + getCreationDate()+ "," +
            "deliveryDate" + ":" + getDeliveryDate()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "orderNum" + "=" + (getOrderNum() != null ? !getOrderNum().equals(this)  ? getOrderNum().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "account = "+(getAccount()!=null?Integer.toHexString(System.identityHashCode(getAccount())):"null");
  }
}