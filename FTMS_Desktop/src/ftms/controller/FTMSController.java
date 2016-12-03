package ftms.controller;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ftms.model.Equipment;
import ftms.model.Food;
import ftms.model.Manager;
import ftms.model.Menu;
import ftms.model.Order;
import ftms.model.Schedule;
import ftms.model.Staff;
import ftms.persistence.HTTPconnector;

public class FTMSController {
	private String position = "Manager";
	private String userID = "";
	
	public FTMSController() {}
	
	public void login(String username, String password) throws Exception, InvalidInputException {
		HTTPconnector conn = new HTTPconnector();
		String inputs = "{\"USERNAME\":\"" + username + "\",\"PASSWORD\":\"" + password +"\"}";
		String response = conn.addData("login", "", inputs);
		if(response.compareTo("NO SUCH USER")==0 || response.compareTo("WRONG PASSWORD")==0) {
			throw new InvalidInputException(response);
		} else {
			userID = response;
			ArrayList<Staff> stafflist = new Gson().fromJson(conn.getData("staff/"+userID), new TypeToken<List<Staff>>(){}.getType());
			Staff staff = stafflist.get(0);
			position = staff.getROLE();
		}
	}
	
	public Staff showProfile() throws Exception {
		HTTPconnector conn = new HTTPconnector();
		ArrayList<Staff> stafflist = new Gson().fromJson(conn.getData("staff/"+userID), new TypeToken<List<Staff>>(){}.getType());
		Staff staff = new Staff(stafflist.get(0).getID(),stafflist.get(0).getNAME(),stafflist.get(0).getROLE(),stafflist.get(0).getGENDER(),stafflist.get(0).getAGE(),stafflist.get(0).getTEL());
		//get staff's schedule
		String data = conn.getData("schedule");
		if(data.compareTo("empty")!=0) {
			ArrayList<Schedule> schedulelist = new Gson().fromJson(data, new TypeToken<List<Schedule>>(){}.getType());
			for(int i=0; i<schedulelist.size(); i++) {
				if(schedulelist.get(i).getUID().compareTo(userID) == 0){
					staff.addSchedule(schedulelist.get(i));
				}
			}
		}
		return staff;
	}
	
	
	public void showFood() throws Exception, InvalidInputException {
		Manager m = Manager.getInstance();
		m.deleteFoods();
		HTTPconnector conn = new HTTPconnector();
		String data = conn.getData("food");
		if(data.compareTo("empty")!=0) {
			ArrayList<Food> foodlist = new Gson().fromJson(data, new TypeToken<List<Food>>(){}.getType());
			for(int i=0; i<foodlist.size(); i++) {
				m.addFood(foodlist.get(i));
			}
		}
	}
	
	public void createFood(String name, int quantity, float price) throws Exception, InvalidInputException{
		Manager m = Manager.getInstance();
		String error = "";
		if(name == null || name.trim().length() == 0)
			error = "Food name cannot be empty!";
		if(quantity <= 0 ){
			error = "Food quantity cannot be negative!";}
		if(price <= 0){
			error = "Food price cannot be less than 0!";}
		if(error.length() > 0) {
			throw new InvalidInputException(error);
		} else if (error.length() == 0) {
			Food food = new Food(name, quantity, price);
			HTTPconnector conn = new HTTPconnector();
			String result = conn.addData("add_food", position, new Gson().toJson(food));
			if(result.compareTo("SUCCESS")==0) {
				m.addFood(food);
			} else {
				throw new InvalidInputException(result);}
		}
	}
	
	public void removeFood(Food food) throws Exception, InvalidInputException{
		Manager m = Manager.getInstance();
		String error = "";
		HTTPconnector conn = new HTTPconnector();
		String response = conn.deleteData("delete_food/"+food.getNAME(), position);
		m.removeFood(food);
		if(response.compareTo("SUCCESS")!=0) {
			error = response;
		}
		if(error.length() > 0)
			throw new InvalidInputException(error);
	}
	
	public void showEquipment() throws Exception, InvalidInputException {
		Manager m = Manager.getInstance();
		m.deleteEquipments();
		HTTPconnector conn = new HTTPconnector();
		String data = conn.getData("equipment");
		if(data.compareTo("empty")!=0) {
			ArrayList<Equipment> equiplist = new Gson().fromJson(data, new TypeToken<List<Equipment>>(){}.getType());
			for(int i=0; i<equiplist.size(); i++) {
				m.addEquipment(equiplist.get(i));
			}
		}
	}
	
	public void createEquipment(String name, int quantity, float price) throws Exception, InvalidInputException{
		Manager m = Manager.getInstance();
		String error = "";
		if(name == null || name.trim().length() == 0)
			error = "Equipment name cannot be empty!";
		if(quantity <= 0 ){
			error = "Equipment quantity cannot be negative!";}
		if(price <= 0){
			error = "Equipment price cannot be less than 0!";}
		if(error.length() > 0) {
			throw new InvalidInputException(error);
		} else if (error.length() == 0) {
			Equipment equip = new Equipment(name, quantity, price);
			HTTPconnector conn = new HTTPconnector();
			String result = conn.addData("add_equipment", position, new Gson().toJson(equip));
			if(result.compareTo("SUCCESS")==0) {
				m.addEquipment(equip);
			} else {
				throw new InvalidInputException(result);}
		}
	}
	
	public void removeEquipment(Equipment equip) throws Exception, InvalidInputException{
		Manager m = Manager.getInstance();
		String error = "";
		HTTPconnector conn = new HTTPconnector();
		String response = conn.deleteData("delete_equipment/"+equip.getNAME(), position);
		m.removeEquipment(equip);
		if(response.compareTo("SUCCESS")!=0) {
			error = response;
		}
		if(error.length() > 0)
			throw new InvalidInputException(error);
	}
	
	public void showStaff() throws Exception, InvalidInputException {
		Manager m = Manager.getInstance();
		m.deleteStaffs();
		HTTPconnector conn = new HTTPconnector();
		String data = conn.getData("staff");
		if(data.compareTo("empty")!=0) {
			ArrayList<Staff> stafflist = new Gson().fromJson(data, new TypeToken<List<Staff>>(){}.getType());
			for(int i=0; i<stafflist.size(); i++) {
				m.addStaff(stafflist.get(i));
			}
		}
	}
	
	public void createStaff(String userID, String name, String position, String gender, int age, int tel, String username, String password) throws Exception, InvalidInputException{
		Manager m = Manager.getInstance();
		String error = "";
		
		if(name == null || name.trim().length() == 0)
			error = "Staff name cannot be empty!";
		if(position == null || position.trim().length() == 0)
			error = "Staff role cannot be empty!";
		if(position == null || position.trim().length() == 0)
			error = "Staff role cannot be empty!";
		if(gender == null || gender.trim().length() == 0)
			error = "Staff gender cannot be empty!";
		if(age != (int)age) {
			error = "Staff age must be Integer!";
		} else if(age <= 0 ){
			error = "Staff age cannot be negative!";}
		if(tel != (float)tel)
			error = "Staff Tel must be number!";
		if(username == null || username.trim().length() == 0)
			error = "Username cannot be empty!";
		if(password == null || password.trim().length() == 0)
			error = "Password cannot be empty!";
		if(error.length() > 0) {
			throw new InvalidInputException(error);
		} else if (error.length() == 0) {
			Staff staff = new Staff(userID, name, position, gender, age, tel);
			HTTPconnector conn = new HTTPconnector();
			String result = conn.addData("add_staff", position, new Gson().toJson(staff));
			if(result.compareTo("SUCCESS")==0) {
				m.addStaff(staff);
			} else {
				throw new InvalidInputException(result);}
		}
	}
	
	public void removeStaff(Staff staff) throws Exception, InvalidInputException{
		Manager m = Manager.getInstance();
		String error = "";
		HTTPconnector conn = new HTTPconnector();
		String response = conn.deleteData("delete_staff/"+staff.getID(), position);
		m.removeStaff(staff);
		if(response.compareTo("SUCCESS")!=0) {
			error = response;
		}
		if(error.length() > 0)
			throw new InvalidInputException(error);
	}
	
	public void showMenu() throws Exception, InvalidInputException {
		Manager m = Manager.getInstance();
		m.deleteMenus();
		HTTPconnector conn = new HTTPconnector();
		String data = conn.getData("menu");
		if(data.compareTo("empty")!=0) {
			ArrayList<Menu> menulist = new Gson().fromJson(data, new TypeToken<List<Menu>>(){}.getType());
			for(int i=0; i<menulist.size(); i++) {
				m.addMenus(menulist.get(i));
			}
		}
	}
	
	public void createMenu(String name, float price, int popularity) throws Exception, InvalidInputException{
		Manager m = Manager.getInstance();
		String error = "";
		String id = randomID(32);
		if(name == null || name.trim().length() == 0)
			error = "Menu name cannot be empty!";
		if(price <= 0){
			error = "Menu price cannot be less than 0!";}
		if(error.length() > 0) {
			throw new InvalidInputException(error);
		} else if (error.length() == 0) {
			Menu menu = new Menu(id, name, price, popularity);
			HTTPconnector conn = new HTTPconnector();
			String result = conn.addData("add_menu", position, new Gson().toJson(menu));
			if(result.compareTo("SUCCESS")==0) {
				m.addMenus(menu);
			} else {
				throw new InvalidInputException(result);}
		}
	}
	
	public void removeMenu(Menu menu) throws Exception, InvalidInputException{
		Manager m = Manager.getInstance();
		String error = "";
		HTTPconnector conn = new HTTPconnector();
		String response = conn.deleteData("delete_menu/"+menu.getID(), position);
		m.removeMenus(menu);
		if(response.compareTo("SUCCESS")!=0) {
			error = response;
		}
		if(error.length() > 0)
			throw new InvalidInputException(error);
	}
	
	public void showOrder() throws Exception, InvalidInputException {
		Manager m = Manager.getInstance();
		m.deleteOrders();
		HTTPconnector conn = new HTTPconnector();
		String data = conn.getData("order");
		if(data.compareTo("empty")!=0) {
			ArrayList<Order> orderlist = new Gson().fromJson(data, new TypeToken<List<Order>>(){}.getType());
			for(int i=0; i<orderlist.size(); i++) {
				m.addOrder(orderlist.get(i));
			}
		}
	}
	
	public void createOrder(String status) throws Exception, InvalidInputException{
		Manager m = Manager.getInstance();
		String error = "";
		String id = randomID(32);
		String time = currentDate();
		if(status == null || status.trim().length() == 0)
			error = "Order status cannot be empty!";
		if(error.length() > 0) {
			throw new InvalidInputException(error);
		} else if (error.length() == 0) {
			Order order = new Order(id, time, status);
			HTTPconnector conn = new HTTPconnector();
			String result = conn.addData("add_order", position, new Gson().toJson(order));
			if(result.compareTo("SUCCESS")==0) {
				m.addOrder(order);
			} else {
				throw new InvalidInputException(result);}
		}
	}
	
	public void removeOrder(Order order) throws Exception, InvalidInputException{
		Manager m = Manager.getInstance();
		String error = "";
		HTTPconnector conn = new HTTPconnector();
		String response = conn.deleteData("delete_order/"+order.getID(), position);
		m.removeOrder(order);
		if(response.compareTo("SUCCESS")!=0) {
			error = response;
		}
		if(error.length() > 0)
			throw new InvalidInputException(error);
	}
	// generate a random string id with certain bytes
	public String randomID(int len) {
		SecureRandom rnd = new SecureRandom();
		String AB = "0123456789abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder(len);
		for( int i = 0; i < len; i++ ) 
			sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		return sb.toString();
	}
	// get current date in ideal format
	public String currentDate() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	public String getUserID() {
		return this.userID;
	}
	
	public void setUserID(String id) {
		this.userID = id;
	}
	
	public String getPosition() {
		return this.position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
}