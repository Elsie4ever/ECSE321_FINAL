/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-c37463a modeling language!*/
package ftms.model;

import java.util.*;

// line 31 "model.ump"
// line 94 "model.ump"
public class Menu
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Menu Attributes
  private String ID;
  private String NAME;
  private float PRICE;
  private int POPULARITY;

  //Menu Associations
  private List<Food> foods;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Menu(String aID, String aNAME, float aPRICE, int aPOPULARITY)
  {
    ID = aID;
    NAME = aNAME;
    PRICE = aPRICE;
    POPULARITY = aPOPULARITY;
    foods = new ArrayList<Food>();
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

  public boolean setNAME(String aNAME)
  {
    boolean wasSet = false;
    NAME = aNAME;
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

  public boolean setPOPULARITY(int aPOPULARITY)
  {
    boolean wasSet = false;
    POPULARITY = aPOPULARITY;
    wasSet = true;
    return wasSet;
  }

  public String getID()
  {
    return ID;
  }

  public String getNAME()
  {
    return NAME;
  }

  public float getPRICE()
  {
    return PRICE;
  }

  public int getPOPULARITY()
  {
    return POPULARITY;
  }

  public Food getFood(int index)
  {
    Food aFood = foods.get(index);
    return aFood;
  }

  public List<Food> getFoods()
  {
    List<Food> newFoods = Collections.unmodifiableList(foods);
    return newFoods;
  }

  public int numberOfFoods()
  {
    int number = foods.size();
    return number;
  }

  public boolean hasFoods()
  {
    boolean has = foods.size() > 0;
    return has;
  }

  public int indexOfFood(Food aFood)
  {
    int index = foods.indexOf(aFood);
    return index;
  }

  public static int minimumNumberOfFoods()
  {
    return 0;
  }

  public boolean addFood(Food aFood)
  {
    boolean wasAdded = false;
    if (foods.contains(aFood)) { return false; }
    foods.add(aFood);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeFood(Food aFood)
  {
    boolean wasRemoved = false;
    if (foods.contains(aFood))
    {
      foods.remove(aFood);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addFoodAt(Food aFood, int index)
  {  
    boolean wasAdded = false;
    if(addFood(aFood))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFoods()) { index = numberOfFoods() - 1; }
      foods.remove(aFood);
      foods.add(index, aFood);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveFoodAt(Food aFood, int index)
  {
    boolean wasAdded = false;
    if(foods.contains(aFood))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFoods()) { index = numberOfFoods() - 1; }
      foods.remove(aFood);
      foods.add(index, aFood);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addFoodAt(aFood, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    foods.clear();
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "ID" + ":" + getID()+ "," +
            "NAME" + ":" + getNAME()+ "," +
            "PRICE" + ":" + getPRICE()+ "," +
            "POPULARITY" + ":" + getPOPULARITY()+ "]"
     + outputString;
  }
}