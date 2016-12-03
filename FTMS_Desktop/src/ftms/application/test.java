package ftms.application;



import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ftms.controller.FTMSController;
import ftms.controller.InvalidInputException;
import ftms.model.Food;
import ftms.model.Manager;
import ftms.model.Staff;
import ftms.persistence.HTTPconnector;

public class test {

	public static void main(String[] args) throws Exception {
		HTTPconnector conn = new HTTPconnector();
		String result = "";
//		result = conn.getData("food");
//		System.out.println(result);
//		
//		ArrayList<Food> array = new Gson().fromJson(result, new TypeToken<List<Food>>(){}.getType());
//		System.out.println(array.get(2));
		
//		Food food = new Food("test", 10, 99);
//		try {
//			result = conn.addData("add_food", "Manager", new Gson().toJson(food));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println(result);
		
//		String inputs = "{\"USERNAME\":\"" + "admin" + "\",\"PASSWORD\":\"" + "admin" +"\"}";
//		result = conn.addData("login", "", inputs);
//		System.out.println(result);
		
		FTMSController cc = new FTMSController(); 
		try{
			cc.login("admin", "147/258/369");
			Staff staff = cc.showProfile();
			System.out.println(staff.getSchedules().toString());
		} catch(InvalidInputException e) {
			result = e.getMessage();
		} catch(Exception e) {
			result = e.getMessage();
		}
		
	}
}
