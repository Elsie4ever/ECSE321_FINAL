package ftms.persistence;

import java.util.Iterator;

import ftms.model.Food;
import ftms.model.Manager;
import ftms.model.Staff;

public class PersistenceFTMSManager {
	
	private static void initializeXStream() {
		PersistenceXStream.setFilename("ftmsmanager.xml");
		PersistenceXStream.setAlias("staff", Staff.class);
		PersistenceXStream.setAlias("food", Food.class);
		PersistenceXStream.setAlias("manager", Manager.class);
	}
	
	public static void loadFTMSModel() {
		Manager m = Manager.getInstance();
		PersistenceFTMSManager.initializeXStream();
		Manager m2 = (Manager) PersistenceXStream.loadFromXMLwithXStream();
		if (m2 != null) {
			Iterator<Staff> sIt = m2.getStaffs().iterator();
			while (sIt.hasNext())
				m.addStaff(sIt.next());
			Iterator<Food> fIt = m2.getFoods().iterator();
			while (fIt.hasNext())
				m.addFood(fIt.next());
		}
	}

}
