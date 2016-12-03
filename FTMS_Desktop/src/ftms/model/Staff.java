/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-c37463a modeling language!*/
package ftms.model;

import java.util.*;

// line 2 "model.ump"
// line 56 "model.ump"
public class Staff
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Staff Attributes
  private String ID;
  private String NAME;
  private String ROLE;
  private String GENDER;
  private int AGE;
  private long TEL;

  //Staff Associations
  private List<Schedule> schedules;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Staff(String aID, String aNAME, String aROLE, String aGENDER, int aAGE, long aTEL)
  {
    ID = aID;
    NAME = aNAME;
    ROLE = aROLE;
    GENDER = aGENDER;
    AGE = aAGE;
    TEL = aTEL;
    schedules = new ArrayList<Schedule>();
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

  public boolean setROLE(String aROLE)
  {
    boolean wasSet = false;
    ROLE = aROLE;
    wasSet = true;
    return wasSet;
  }

  public boolean setGENDER(String aGENDER)
  {
    boolean wasSet = false;
    GENDER = aGENDER;
    wasSet = true;
    return wasSet;
  }

  public boolean setAGE(int aAGE)
  {
    boolean wasSet = false;
    AGE = aAGE;
    wasSet = true;
    return wasSet;
  }

  public boolean setTEL(long aTEL)
  {
    boolean wasSet = false;
    TEL = aTEL;
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

  public String getROLE()
  {
    return ROLE;
  }

  public String getGENDER()
  {
    return GENDER;
  }

  public int getAGE()
  {
    return AGE;
  }

  public long getTEL()
  {
    return TEL;
  }

  public Schedule getSchedule(int index)
  {
    Schedule aSchedule = schedules.get(index);
    return aSchedule;
  }

  public List<Schedule> getSchedules()
  {
    List<Schedule> newSchedules = Collections.unmodifiableList(schedules);
    return newSchedules;
  }

  public int numberOfSchedules()
  {
    int number = schedules.size();
    return number;
  }

  public boolean hasSchedules()
  {
    boolean has = schedules.size() > 0;
    return has;
  }

  public int indexOfSchedule(Schedule aSchedule)
  {
    int index = schedules.indexOf(aSchedule);
    return index;
  }

  public static int minimumNumberOfSchedules()
  {
    return 0;
  }

  public boolean addSchedule(Schedule aSchedule)
  {
    boolean wasAdded = false;
    if (schedules.contains(aSchedule)) { return false; }
    schedules.add(aSchedule);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSchedule(Schedule aSchedule)
  {
    boolean wasRemoved = false;
    if (schedules.contains(aSchedule))
    {
      schedules.remove(aSchedule);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addScheduleAt(Schedule aSchedule, int index)
  {  
    boolean wasAdded = false;
    if(addSchedule(aSchedule))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSchedules()) { index = numberOfSchedules() - 1; }
      schedules.remove(aSchedule);
      schedules.add(index, aSchedule);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveScheduleAt(Schedule aSchedule, int index)
  {
    boolean wasAdded = false;
    if(schedules.contains(aSchedule))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSchedules()) { index = numberOfSchedules() - 1; }
      schedules.remove(aSchedule);
      schedules.add(index, aSchedule);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addScheduleAt(aSchedule, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    schedules.clear();
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "ID" + ":" + getID()+ "," +
            "NAME" + ":" + getNAME()+ "," +
            "ROLE" + ":" + getROLE()+ "," +
            "GENDER" + ":" + getGENDER()+ "," +
            "AGE" + ":" + getAGE()+ "," +
            "TEL" + ":" + getTEL()+ "]"
     + outputString;
  }
}