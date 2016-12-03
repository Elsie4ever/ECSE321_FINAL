/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-c37463a modeling language!*/
package ftms.model;


// line 12 "model.ump"
// line 62 "model.ump"
public class Schedule
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Schedule Attributes
  private String ID;
  private String UID;
  private String START_TIME;
  private String END_TIME;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Schedule(String aID, String aUID, String aSTART_TIME, String aEND_TIME)
  {
    ID = aID;
    UID = aUID;
    START_TIME = aSTART_TIME;
    END_TIME = aEND_TIME;
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

  public boolean setUID(String aUID)
  {
    boolean wasSet = false;
    UID = aUID;
    wasSet = true;
    return wasSet;
  }

  public boolean setSTART_TIME(String aSTART_TIME)
  {
    boolean wasSet = false;
    START_TIME = aSTART_TIME;
    wasSet = true;
    return wasSet;
  }

  public boolean setEND_TIME(String aEND_TIME)
  {
    boolean wasSet = false;
    END_TIME = aEND_TIME;
    wasSet = true;
    return wasSet;
  }

  public String getID()
  {
    return ID;
  }

  public String getUID()
  {
    return UID;
  }

  public String getSTART_TIME()
  {
    return START_TIME;
  }

  public String getEND_TIME()
  {
    return END_TIME;
  }

  public void delete()
  {}


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "ID" + ":" + getID()+ "," +
            "UID" + ":" + getUID()+ "," +
            "START_TIME" + ":" + getSTART_TIME()+ "," +
            "END_TIME" + ":" + getEND_TIME()+ "]"
     + outputString;
  }
}