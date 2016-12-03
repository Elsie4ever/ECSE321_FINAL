/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-c37463a modeling language!*/
package ftms.model;

import java.util.*;

// line 39 "model.ump"
// line 77 "model.ump"
public class Order
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Order Attributes
  private String ID;
  private String TIME;
  private String STATUS;

  //Order Associations
  private List<Menu> menus;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Order(String aID, String aTIME, String aSTATUS)
  {
    ID = aID;
    TIME = aTIME;
    STATUS = aSTATUS;
    menus = new ArrayList<Menu>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setID(String aID)
  {
    boolean wasSet = false;
    ID = aID;
    wasSet = true;
    return wasSet;
  }

  public boolean setTIME(String aTIME)
  {
    boolean wasSet = false;
    TIME = aTIME;
    wasSet = true;
    return wasSet;
  }

  public boolean setSTATUS(String aSTATUS)
  {
    boolean wasSet = false;
    STATUS = aSTATUS;
    wasSet = true;
    return wasSet;
  }

  public String getID()
  {
    return ID;
  }

  public String getTIME()
  {
    return TIME;
  }

  public String getSTATUS()
  {
    return STATUS;
  }

  public Menu getMenus(int index)
  {
    Menu aMenus = menus.get(index);
    return aMenus;
  }

  public List<Menu> getMenus()
  {
    List<Menu> newMenus = Collections.unmodifiableList(menus);
    return newMenus;
  }

  public int numberOfMenus()
  {
    int number = menus.size();
    return number;
  }

  public boolean hasMenus()
  {
    boolean has = menus.size() > 0;
    return has;
  }

  public int indexOfMenus(Menu aMenus)
  {
    int index = menus.indexOf(aMenus);
    return index;
  }

  public static int minimumNumberOfMenus()
  {
    return 0;
  }

  public boolean addMenus(Menu aMenus)
  {
    boolean wasAdded = false;
    if (menus.contains(aMenus)) { return false; }
    menus.add(aMenus);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeMenus(Menu aMenus)
  {
    boolean wasRemoved = false;
    if (menus.contains(aMenus))
    {
      menus.remove(aMenus);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addMenusAt(Menu aMenus, int index)
  {  
    boolean wasAdded = false;
    if(addMenus(aMenus))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMenus()) { index = numberOfMenus() - 1; }
      menus.remove(aMenus);
      menus.add(index, aMenus);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMenusAt(Menu aMenus, int index)
  {
    boolean wasAdded = false;
    if(menus.contains(aMenus))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMenus()) { index = numberOfMenus() - 1; }
      menus.remove(aMenus);
      menus.add(index, aMenus);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMenusAt(aMenus, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    menus.clear();
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "ID" + ":" + getID()+ "," +
            "TIME" + ":" + getTIME()+ "," +
            "STATUS" + ":" + getSTATUS()+ "]"
     + outputString;
  }
}