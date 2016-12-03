/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-c37463a modeling language!*/
package ftms.model;


// line 25 "model.ump"
// line 72 "model.ump"
public class Food
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Food Attributes
  private String NAME;
  private int QUANTITY;
  private float PRICE;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Food(String aNAME, int aQUANTITY, float aPRICE)
  {
    NAME = aNAME;
    QUANTITY = aQUANTITY;
    PRICE = aPRICE;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNAME(String aNAME)
  {
    boolean wasSet = false;
    NAME = aNAME;
    wasSet = true;
    return wasSet;
  }

  public boolean setQUANTITY(int aQUANTITY)
  {
    boolean wasSet = false;
    QUANTITY = aQUANTITY;
    wasSet = true;
    return wasSet;
  }

  public boolean setPRICE(float aPRICE)
  {
    boolean wasSet = false;
    PRICE = aPRICE;
    wasSet = true;
    return wasSet;
  }

  public String getNAME()
  {
    return NAME;
  }

  public int getQUANTITY()
  {
    return QUANTITY;
  }

  public float getPRICE()
  {
    return PRICE;
  }

  public void delete()
  {}


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "NAME" + ":" + getNAME()+ "," +
            "QUANTITY" + ":" + getQUANTITY()+ "," +
            "PRICE" + ":" + getPRICE()+ "]"
     + outputString;
  }
}