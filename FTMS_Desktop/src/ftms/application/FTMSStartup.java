package ftms.application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.CardLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;
import javax.swing.ListSelectionModel;

import ftms.controller.FTMSController;
import ftms.controller.InvalidInputException;
import ftms.model.Equipment;
import ftms.model.Food;
import ftms.model.Manager;
import ftms.model.Menu;
import ftms.model.Order;
import ftms.model.Schedule;
import ftms.model.Staff;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ScrollPaneConstants;

public class FTMSStartup {

	private JFrame frmFoodTruckManager;
	private JTextField textField;
	private JPanel panelStartup;
	private JPanel panelMain;
	private JPanel panelProfile;
	private JPanel panelStaff;
	private JPanel panelFood;
	private JPanel panelEquipment;
	private JPanel panelMenu;
	private JPanel panelOrder;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPasswordField passwordField_1;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_9;
	private JTextField textField_6;
	private JTable tableStaff;
	private JTable tableFood;
	private JTable tableEquipment;
	private JTable tableMenu;
	private JTable tableOrder;
	private JTextField textField_1;
	private JTable tableCheckOrder;
	private JTextField textField_18;
	private JTextField textField_username;
	private JTextField textField_password;
	private String userID = "";
	private String position = "";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FTMSStartup window = new FTMSStartup();
					window.frmFoodTruckManager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FTMSStartup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//set up the application window
		frmFoodTruckManager = new JFrame();
		
		frmFoodTruckManager.setFont(new Font("Arial", Font.PLAIN, 30));
		frmFoodTruckManager.setTitle("Food Truck Manager System");
		frmFoodTruckManager.setBounds(50, 30, 1240, 660);
		frmFoodTruckManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFoodTruckManager.getContentPane().setLayout(new CardLayout(0, 0));
		
		//set up all panels
		//each card layer
		final JPanel panelStartup = new JPanel();
		frmFoodTruckManager.getContentPane().add(panelStartup, "name_624301188520749");
		panelStartup.setLayout(null);
		panelStartup.setVisible(true);
		
		
		final JPanel panelMain = new JPanel();
		frmFoodTruckManager.getContentPane().add(panelMain, "name_624602326430611");
		panelMain.setVisible(false);
		
		
		final JPanel panelProfile = new JPanel();
		frmFoodTruckManager.getContentPane().add(panelProfile, "name_624844133057563");
		panelProfile.setLayout(null);
		panelProfile.setVisible(false);
		
		
		final JPanel panelStaff = new JPanel();
		frmFoodTruckManager.getContentPane().add(panelStaff, "name_624301196846050");
		panelStaff.setLayout(null);
		panelStaff.setVisible(false);
		
		final JPanel panelAddStaff = new JPanel();
		frmFoodTruckManager.getContentPane().add(panelAddStaff, "name_1208458719040606");
		panelAddStaff.setLayout(null);
		
		
		final JPanel panelFood = new JPanel();
		frmFoodTruckManager.getContentPane().add(panelFood, "name_624884669342704");
		panelFood.setLayout(null);
		panelFood.setVisible(false);
		
		final JPanel panelAddFood = new JPanel();
		frmFoodTruckManager.getContentPane().add(panelAddFood, "name_1208519948227577");
		panelAddFood.setLayout(null);
		

		final JPanel panelEquipment = new JPanel();
		frmFoodTruckManager.getContentPane().add(panelEquipment, "name_624301205231593");
		panelEquipment.setLayout(null);
		panelEquipment.setVisible(false);
		
		final JPanel panelAddEquipment = new JPanel();
		frmFoodTruckManager.getContentPane().add(panelAddEquipment, "name_1208613821371263");
		panelAddEquipment.setLayout(null);
		
		
		final JPanel panelMenu = new JPanel();
		frmFoodTruckManager.getContentPane().add(panelMenu, "name_624912005083891");
		panelMenu.setLayout(null);
		panelMenu.setVisible(false);
		
		final JPanel panelAddMenu = new JPanel();
		frmFoodTruckManager.getContentPane().add(panelAddMenu, "name_1208856121488175");
		panelAddMenu.setLayout(null);
		
		
		final JPanel panelOrder = new JPanel();
		frmFoodTruckManager.getContentPane().add(panelOrder, "name_624926226062918");
		panelOrder.setLayout(null);
		panelOrder.setVisible(false);
		
		final JPanel panelAddOrder = new JPanel();
		frmFoodTruckManager.getContentPane().add(panelAddOrder, "name_1208859909014279");
		panelAddOrder.setLayout(null);
		
		final JPanel panelCheckOrder = new JPanel();
		frmFoodTruckManager.getContentPane().add(panelCheckOrder, "name_728311134036765");
		panelCheckOrder.setLayout(null);
		
		
		//add staff labels
		JLabel lblStaffName = new JLabel("First Name:");
		lblStaffName.setFont(new Font("Arial", Font.PLAIN, 30));
		lblStaffName.setBounds(108, 65, 218, 40);
		panelAddStaff.add(lblStaffName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Arial", Font.PLAIN, 30));
		lblLastName.setBounds(108, 130, 177, 40);
		panelAddStaff.add(lblLastName);
		
		JLabel lblStaffRole = new JLabel("Position:");
		lblStaffRole.setFont(new Font("Arial", Font.PLAIN, 30));
		lblStaffRole.setBounds(108, 195, 143, 40);
		panelAddStaff.add(lblStaffRole);
		
		JLabel lblStaffGender = new JLabel("Gender:");
		lblStaffGender.setFont(new Font("Arial", Font.PLAIN, 30));
		lblStaffGender.setBounds(108, 260, 190, 40);
		panelAddStaff.add(lblStaffGender);
		
		JLabel lblStaffAge = new JLabel("Age:");
		lblStaffAge.setFont(new Font("Arial", Font.PLAIN, 30));
		lblStaffAge.setBounds(766, 260, 127, 40);
		panelAddStaff.add(lblStaffAge);
		
		JLabel lblStaffTel = new JLabel("Phone Number:");
		lblStaffTel.setFont(new Font("Arial", Font.PLAIN, 30));
		lblStaffTel.setBounds(108, 325, 218, 40);
		panelAddStaff.add(lblStaffTel);
		
		//set up text spaces for profile display
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_7.setColumns(10);
		textField_7.setBounds(336, 65, 763, 40);
		panelAddStaff.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_8.setColumns(10);
		textField_8.setBounds(336, 195, 763, 40);
		panelAddStaff.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_9.setColumns(10);
		textField_9.setBounds(336, 130, 763, 40);
		panelAddStaff.add(textField_9);
		
		
		//limit age to be numbers only
		final JFormattedTextField jFormattedTextField_age = new JFormattedTextField();
		jFormattedTextField_age.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char vchar = arg0.getKeyChar();
				if(!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACK_SPACE) || 
						(vchar == KeyEvent.VK_DELETE)) {
					arg0.consume();
				}
			}
		});
		jFormattedTextField_age.setFont(new Font("Arial", Font.PLAIN, 30));
		jFormattedTextField_age.setColumns(10);
		jFormattedTextField_age.setBounds(851, 260, 248, 40);
		panelAddStaff.add(jFormattedTextField_age);
		
		//limit phone number to be numbers only
		final JFormattedTextField jFormattedTextField_tel = new JFormattedTextField();
		jFormattedTextField_tel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char vchar = e.getKeyChar();
				if(!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACK_SPACE) || 
						(vchar == KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		jFormattedTextField_tel.setColumns(10);
		jFormattedTextField_tel.setFont(new Font("Arial", Font.PLAIN, 30));
		jFormattedTextField_tel.setBounds(336, 325, 763, 40);
		panelAddStaff.add(jFormattedTextField_tel);
		
		//set up gender radio button group
		final JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setSelected(true);
		rdbtnMale.setFont(new Font("Arial", Font.PLAIN, 30));
		rdbtnMale.setBounds(336, 260, 110, 40);
		panelAddStaff.add(rdbtnMale);
		
		final JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Arial", Font.PLAIN, 30));
		rdbtnFemale.setBounds(523, 260, 143, 40);
		panelAddStaff.add(rdbtnFemale);
		panelAddStaff.setVisible(false);
		
		final ButtonGroup group = new ButtonGroup();
		group.add(rdbtnMale);
		group.add(rdbtnFemale);
	
		//add staff function
		JButton btnNewButton_6 = new JButton("Add");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAddStaff.setVisible(false);
				panelStaff.setVisible(true);
				DefaultTableModel model = (DefaultTableModel) tableStaff.getModel();
				model.addRow(new Object[] {textField_7.getText() + " " + textField_9.getText(), textField_8.getText(), jFormattedTextField_tel.getText()});
				
				//clear all fields after adding
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");
				jFormattedTextField_age.setText("");
				jFormattedTextField_tel.setText("");
				textField_username.setText("");
				textField_password.setText("");
				

			}
		});
		btnNewButton_6.setFont(new Font("Arial", Font.PLAIN, 30));
		btnNewButton_6.setBounds(445, 500, 150, 50);
		panelAddStaff.add(btnNewButton_6);
		
		//cancel adding staff function
		JButton btnNewButton_7 = new JButton("Cancel");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAddStaff.setVisible(false);
				panelStaff.setVisible(true);
			}
		});
		btnNewButton_7.setFont(new Font("Arial", Font.PLAIN, 30));
		btnNewButton_7.setBounds(660, 500, 150, 50);
		panelAddStaff.add(btnNewButton_7);
		
		
		//set food labels
		JLabel lblName_2 = new JLabel("Name:");
		lblName_2.setFont(new Font("Arial", Font.PLAIN, 30));
		lblName_2.setBounds(253, 128, 145, 40);
		panelAddFood.add(lblName_2);
		
		JLabel lblQuantity_1 = new JLabel("Quantity:");
		lblQuantity_1.setFont(new Font("Arial", Font.PLAIN, 30));
		lblQuantity_1.setBounds(253, 251, 145, 40);
		panelAddFood.add(lblQuantity_1);
		
		JLabel lblPrice_1 = new JLabel("Price:");
		lblPrice_1.setFont(new Font("Arial", Font.PLAIN, 30));
		lblPrice_1.setBounds(253, 383, 145, 40);
		panelAddFood.add(lblPrice_1);
		
		//set adding error message labels	
		final JLabel lblAddStaffError = new JLabel("");
		lblAddStaffError.setForeground(Color.RED);
		lblAddStaffError.setFont(new Font("Arial", Font.PLAIN, 25));
		lblAddStaffError.setBounds(445, 452, 578, 32);
		panelAddStaff.add(lblAddStaffError);
		
		final JLabel lblAddFoodError = new JLabel("");
		lblAddFoodError.setForeground(Color.RED);
		lblAddFoodError.setFont(new Font("Arial", Font.PLAIN, 25));
		lblAddFoodError.setBounds(455, 446, 355, 32);
		panelAddFood.add(lblAddFoodError);
		panelAddFood.setVisible(false);

		final JLabel lblAddEquipmentError = new JLabel("");
		lblAddEquipmentError.setForeground(Color.RED);
		lblAddEquipmentError.setFont(new Font("Arial", Font.PLAIN, 25));
		lblAddEquipmentError.setBounds(445, 447, 605, 32);


		final JLabel lblAddMenuError = new JLabel("");
		lblAddMenuError.setForeground(Color.RED);
		lblAddMenuError.setFont(new Font("Arial", Font.PLAIN, 25));
		lblAddMenuError.setBounds(444, 424, 355, 32);


		final JLabel lblAddOrderError = new JLabel("");
		lblAddOrderError.setForeground(Color.RED);
		lblAddOrderError.setFont(new Font("Arial", Font.PLAIN, 25));
		lblAddOrderError.setBounds(445, 446, 355, 32);


		//add food function
		JButton button_6 = new JButton("Add");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FTMSController controller = new FTMSController();
				String error = "";
				//check all kinds of error
				if(textField_13.getText().compareTo("")==0) {
					error = "Quantity cannot be empty!";
				} else if(textField_14.getText().compareTo("")==0) {
					error = "Price cannot be empty!";
				} else {
					try {
						controller.setPosition(position);
						controller.createFood(textField_12.getText(), Integer.parseInt(textField_13.getText()), Float.parseFloat(textField_14.getText()));
					} catch (Exception e1) {
						error = e1.getMessage();
						e1.printStackTrace();
					}
				}
				//add food if there is no error
				if(error.length() == 0) {
					panelAddFood.setVisible(false);
					panelFood.setVisible(true);
					DefaultTableModel model = (DefaultTableModel) tableFood.getModel();
					model.addRow(new Object[] {textField_12.getText(), textField_13.getText(), textField_14.getText()});
					textField_12.setText("");
					textField_13.setText("");
					textField_14.setText("");
					lblAddFoodError.setText("");
				}
				else {
					lblAddFoodError.setText(error);
				}
							
		
			}
		});
		button_6.setFont(new Font("Arial", Font.PLAIN, 30));
		button_6.setBounds(445, 500, 150, 50);
		panelAddFood.add(button_6);
		
		//cancel adding food
		JButton button_7 = new JButton("Cancel");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAddFood.setVisible(false);
				panelFood.setVisible(true);
				//clear all fields after adding food
				textField_12.setText("");
				textField_13.setText("");
				textField_14.setText("");
				lblAddFoodError.setText("");
			}
		});
		button_7.setFont(new Font("Arial", Font.PLAIN, 30));
		button_7.setBounds(660, 500, 150, 50);
		panelAddFood.add(button_7);
		
		//set food text fields
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_12.setBounds(408, 128, 594, 40);
		panelAddFood.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		//limit quantity typed in to be numbers only
		textField_13.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char vchar = e.getKeyChar();
				if(!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACK_SPACE) || 
						(vchar == KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		textField_13.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_13.setColumns(10);
		textField_13.setBounds(407, 251, 595, 40);
		panelAddFood.add(textField_13);
		
		textField_14 = new JTextField();
		//limit price to be numbers and decimal only
		textField_14.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(Character.isLetter(c) && !e.isAltDown()) {
					e.consume();
				}
			}
		});
		textField_14.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_14.setColumns(10);
		textField_14.setBounds(445, 383, 558, 40);
		panelAddFood.add(textField_14);
		
		JLabel lblNewLabel = new JLabel("$");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel.setBounds(408, 383, 43, 40);
		panelAddFood.add(lblNewLabel);
		

		//set error when deleting without permission
		final JLabel lblEquipmentError = new JLabel("");
		lblEquipmentError.setForeground(Color.RED);
		lblEquipmentError.setFont(new Font("Arial", Font.PLAIN, 25));
		lblEquipmentError.setBounds(445, 438, 355, 32);
		panelEquipment.add(lblEquipmentError);
		
		final JLabel lblFoodError = new JLabel("");
		lblFoodError.setForeground(Color.RED);
		lblFoodError.setFont(new Font("Arial", Font.PLAIN, 25));
		lblFoodError.setBounds(445, 438, 355, 32);
		panelFood.add(lblFoodError);
		
		final JLabel lblMenuError = new JLabel("");
		lblMenuError.setForeground(Color.RED);
		lblMenuError.setFont(new Font("Arial", Font.PLAIN, 25));
		lblMenuError.setBounds(445, 438, 355, 32);
		panelMenu.add(lblMenuError);
		
		//add equipment function
		JButton button_8 = new JButton("Add");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FTMSController controller = new FTMSController();
				String error = "";
				//check all kinds of error
				if(textField_16.getText().compareTo("")==0) {
					error = "Quantity cannot be empty!";
				} else if(textField_17.getText().compareTo("")==0) {
					error = "Price cannot be empty!";
				} else {
					try {
						controller.setPosition(position);
						controller.createEquipment(textField_15.getText(), Integer.parseInt(textField_16.getText()), 
								Float.parseFloat(textField_17.getText()));
					} catch (Exception e1) {
						error = e1.getMessage();
						e1.printStackTrace();
					}
				}
				//add equipment if error free
				if(error.length() == 0) {
					panelAddEquipment.setVisible(false);
					panelEquipment.setVisible(true);
					DefaultTableModel model = (DefaultTableModel) tableEquipment.getModel();
					model.addRow(new Object[] {textField_15.getText(), textField_16.getText(), textField_17.getText()});
					//clear all fields after adding
					textField_15.setText("");
					textField_16.setText("");
					textField_17.setText("");
					lblAddEquipmentError.setText("");
				}
				else {
					lblAddEquipmentError.setText(error);
				}		
		
			}
		});

		button_8.setFont(new Font("Arial", Font.PLAIN, 30));
		button_8.setBounds(445, 500, 150, 50);
		panelAddEquipment.add(button_8);
		
		//cancel adding equipment
		JButton button_9 = new JButton("Cancel");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAddEquipment.setVisible(false);
				panelEquipment.setVisible(true);
				lblAddEquipmentError.setText("");
			}
		});
		button_9.setFont(new Font("Arial", Font.PLAIN, 30));
		button_9.setBounds(660, 500, 150, 50);
		panelAddEquipment.add(button_9);
		
		//set labels for adding equipment
		JLabel label_6 = new JLabel("Name:");
		label_6.setFont(new Font("Arial", Font.PLAIN, 30));
		label_6.setBounds(253, 128, 145, 40);
		panelAddEquipment.add(label_6);
		
		textField_15 = new JTextField();
		textField_15.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_15.setColumns(10);
		textField_15.setBounds(408, 128, 594, 40);
		panelAddEquipment.add(textField_15);
		
		JLabel label_7 = new JLabel("Quantity:");
		label_7.setFont(new Font("Arial", Font.PLAIN, 30));
		label_7.setBounds(253, 251, 145, 40);
		panelAddEquipment.add(label_7);
		
		textField_16 = new JTextField();
		//limit quantity to be numbers only
		textField_16.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char vchar = e.getKeyChar();
				if(!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACK_SPACE) || 
						(vchar == KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		textField_16.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_16.setColumns(10);
		textField_16.setBounds(407, 251, 595, 40);
		panelAddEquipment.add(textField_16);
		
		JLabel label_8 = new JLabel("Price:");
		label_8.setFont(new Font("Arial", Font.PLAIN, 30));
		label_8.setBounds(253, 383, 145, 40);
		panelAddEquipment.add(label_8);
		
		textField_17 = new JTextField();
		textField_17.addKeyListener(new KeyAdapter() {
			//set price to be numbers only
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(Character.isLetter(c) && !e.isAltDown()) {
					e.consume();
				}
			}
		});
		textField_17.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_17.setColumns(10);
		textField_17.setBounds(445, 383, 558, 40);
		panelAddEquipment.add(textField_17);
		
		JLabel label_1 = new JLabel("$");
		label_1.setFont(new Font("Arial", Font.PLAIN, 30));
		label_1.setBounds(408, 383, 43, 40);
		panelAddEquipment.add(label_1);
		
		//set labels for adding menu
		JLabel lblName_3 = new JLabel("Name:");
		lblName_3.setFont(new Font("Arial", Font.PLAIN, 30));
		lblName_3.setBounds(252, 176, 145, 40);
		panelAddMenu.add(lblName_3);
		
		JLabel label_11 = new JLabel("Price:");
		label_11.setFont(new Font("Arial", Font.PLAIN, 30));
		label_11.setBounds(252, 321, 145, 40);
		panelAddMenu.add(label_11);
		
		textField_19 = new JTextField();
		textField_19.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_19.setColumns(10);
		textField_19.setBounds(407, 176, 594, 40);
		panelAddMenu.add(textField_19);
		
		textField_20 = new JTextField();
		//limit menu price to be numbers only
		textField_20.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(Character.isLetter(c) && !e.isAltDown()) {
					e.consume();
				}
			}
		});
		textField_20.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_20.setColumns(10);
		textField_20.setBounds(444, 321, 557, 40);
		panelAddMenu.add(textField_20);
		
		//add menu function
		JButton button_10 = new JButton("Add");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				FTMSController controller = new FTMSController();
				String error = "";
				//check all kinds of error
				if(textField_19.getText() == "") {
					error = "Name cannot be empty!";
				}
				if(textField_20.getText().compareTo("")==0) {
					error = "Price cannot be empty!";
				} else {
					try {
						controller.setPosition(position);
						controller.createMenu(textField_19.getText(), Float.parseFloat(textField_20.getText()), 0);
					} catch (Exception e1) {
						error = e1.getMessage();
						e1.printStackTrace();
					}
				}
				//add to menu if there is no error
				if(error.length() == 0) {
					panelAddMenu.setVisible(false);
					panelMenu.setVisible(true);
					DefaultTableModel model = (DefaultTableModel) tableMenu.getModel();
					model.addRow(new Object[] {textField_19.getText(), textField_20.getText(), 0});
					textField_19.setText("");
					textField_20.setText("");
					lblAddMenuError.setText("");				
				}
				else {
					lblAddMenuError.setText(error);
				}
			}
		});
				
		button_10.setFont(new Font("Arial", Font.PLAIN, 30));
		button_10.setBounds(445, 500, 150, 50);
		panelAddMenu.add(button_10);
		
		//cancel adding menu
		JButton button_11 = new JButton("Cancel");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAddMenu.setVisible(false);
				panelMenu.setVisible(true);
				lblAddMenuError.setText("");
			}
		});
		button_11.setFont(new Font("Arial", Font.PLAIN, 30));
		button_11.setBounds(660, 500, 150, 50);
		panelAddMenu.add(button_11);
		
		JLabel label_2 = new JLabel("$");
		label_2.setFont(new Font("Arial", Font.PLAIN, 30));
		label_2.setBounds(407, 321, 43, 40);
		panelAddMenu.add(label_2);
		
		//go back to order from viewing order details
		JButton button_19 = new JButton("Back");
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelOrder.setVisible(true);
				panelCheckOrder.setVisible(false);
			}
		});
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(303, 89, 677, 350);
		panelCheckOrder.add(scrollPane_6);
		
		//display order table
		tableCheckOrder = new JTable();
		tableCheckOrder.setRowHeight(40);
		tableCheckOrder.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Order ID", "Item", "Quantity", "Note"
			}
		));
		tableCheckOrder.getColumnModel().getColumn(0).setPreferredWidth(60);
		tableCheckOrder.getColumnModel().getColumn(1).setPreferredWidth(125);
		tableCheckOrder.getColumnModel().getColumn(2).setPreferredWidth(50);
		tableCheckOrder.getColumnModel().getColumn(3).setPreferredWidth(120);
		tableCheckOrder.setFont(new Font("Arial", Font.PLAIN, 30));
		scrollPane_6.setViewportView(tableCheckOrder);
		button_19.setFont(new Font("Arial", Font.PLAIN, 30));
		button_19.setBounds(553, 481, 150, 50);
		panelCheckOrder.add(button_19);
		panelAddOrder.setVisible(false);
		
		//set order placed date
		final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		final Date date = new Date();
		final JTextArea textArea = new JTextArea();
		JLabel labelNote = new JLabel("Note:");
		labelNote.setFont(new Font("Arial", Font.PLAIN, 30));
		labelNote.setBounds(345, 297, 99, 30);
		panelAddOrder.add(labelNote);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(445, 297, 422, 139);
		panelAddOrder.add(scrollPane_5);
		scrollPane_5.setViewportView(textArea);
		textArea.setFont(new Font("Arial", Font.PLAIN, 30));
		JButton btnSubmit = new JButton("Add");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAddOrder.setVisible(false);
				panelOrder.setVisible(true);
				DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();
				model.addRow(new Object[] {textField_19.getText(), dateFormat.format(date), "Order in process"});
				
				DefaultTableModel model2 = (DefaultTableModel) tableCheckOrder.getModel();
				model2.addRow(new Object[] {"", textField_1.getText(), textField_18.getText(), textArea.getText()});
				
				textField_1.setText("");
				textField_18.setText("");
				textArea.setText("");
			}
		});
		btnSubmit.setFont(new Font("Arial", Font.PLAIN, 30));
		btnSubmit.setBounds(445, 500, 150, 50);
		panelAddOrder.add(btnSubmit);
		
		//cancel adding order
		JButton button_13 = new JButton("Cancel");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAddOrder.setVisible(false);
				panelOrder.setVisible(true);
			}
		});
		button_13.setFont(new Font("Arial", Font.PLAIN, 30));
		button_13.setBounds(660, 500, 150, 50);
		panelAddOrder.add(button_13);
		

		//set login page labels
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 30));
		textField.setBounds(468, 262, 440, 38);
		panelStartup.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(309, 250, 180, 53);
		panelStartup.add(lblUsername);
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 30));
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 30));
		lblPassword.setBounds(309, 347, 180, 74);
		panelStartup.add(lblPassword);
		
		JLabel lblFoodTruckManagement = new JLabel("Food Truck Management System");
		lblFoodTruckManagement.setFont(new Font("Arial Black", Font.PLAIN, 32));
		lblFoodTruckManagement.setBounds(330, 107, 613, 87);
		panelStartup.add(lblFoodTruckManagement);
		
		//set login error label
		final JLabel lblLoginError = new JLabel("");
		lblLoginError.setFont(new Font("Arial", Font.PLAIN, 25));
		lblLoginError.setForeground(Color.RED);
		lblLoginError.setBounds(468, 431, 475, 32);
		panelStartup.add(lblLoginError);
		
		JLabel lblUsername_1 = new JLabel("Username:");
		lblUsername_1.setFont(new Font("Arial", Font.PLAIN, 30));
		lblUsername_1.setBounds(108, 390, 218, 40);
		panelAddStaff.add(lblUsername_1);
		
		JLabel lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setFont(new Font("Arial", Font.PLAIN, 30));
		lblPassword_1.setBounds(660, 390, 177, 40);
		panelAddStaff.add(lblPassword_1);
		
		textField_username = new JTextField();
		textField_username.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_username.setColumns(10);
		textField_username.setBounds(336, 390, 270, 40);
		panelAddStaff.add(textField_username);
		
		textField_password = new JTextField();
		textField_password.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_password.setColumns(10);
		textField_password.setBounds(829, 390, 270, 40);
		panelAddStaff.add(textField_password);


		//log in button
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FTMSController controller = new FTMSController();
				String error = "";
				String username = textField.getText();
				String password = passwordField_1.getText();
				try {
					controller.login(username, password);
					userID = controller.getUserID();
					position = controller.getPosition();
				} catch (InvalidInputException e1) {
					error = e1.getMessage();
				} catch (Exception e2) {
					error = e2.getMessage();
					e2.printStackTrace();
				} 
				//log in if user name & password are correct
				if(error.length()==0) {
					panelMain.setVisible(true);
					panelStartup.setVisible(false);
				}
				//show error messages
				else if (error.compareTo("NO SUCH USER") == 0){
					lblLoginError.setText("INVALID USERNAME");
				}
				else if (error.compareTo("WRONG PASSWORD") == 0) {
					lblLoginError.setText("INVALID PASSWORD");
				}
				else {
					lblLoginError.setText(error);
				}

			}
		});
		btnLogIn.setFont(new Font("Arial", Font.PLAIN, 28));
		btnLogIn.setBounds(532, 486, 165, 53);
		panelStartup.add(btnLogIn);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Arial", Font.PLAIN, 30));
		passwordField_1.setBounds(468, 370, 440, 38);
		panelStartup.add(passwordField_1);
		

		//logout function
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				passwordField_1.setText("");
				lblLoginError.setText("");
				panelStartup.setVisible(true);
				panelMain.setVisible(false);
			}
		});
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(356, 400, 751, 71);
		panelProfile.add(scrollPane_7);
		
		final JTextArea textField_schedule = new JTextArea();
		textField_schedule.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_schedule.setEditable(false);
		scrollPane_7.setViewportView(textField_schedule);
		
		//check profile function
		JButton btnNewButton = new JButton("Profile");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get info for each field from database
				FTMSController cc = new FTMSController();
				try {
					cc.setUserID(userID);
					Staff s = cc.showProfile();
					String name = s.getNAME();
					String gender = s.getGENDER();
					String role = s.getROLE();
					int age = s.getAGE();
					long tel = s.getTEL();
					List<Schedule> schedulelist = s.getSchedules();
					String schedule = "";
					textField_2.setText(name);
					textField_3.setText(gender);
					textField_4.setText(role);
					textField_5.setText(Integer.toString(age));
					textField_6.setText(Long.toString(tel));
					for(int i = 0; i < schedulelist.size(); i++) {
						schedule += "Start Time: " + schedulelist.get(i).getSTART_TIME() + "\n" + 
					"End Time: " + schedulelist.get(i).getEND_TIME() + "\n";
					}
					textField_schedule.setText(schedule);
					
				} catch(InvalidInputException e2) {
					e2.printStackTrace();
				} catch(Exception e1) {
					e1.printStackTrace();
				}
							
				panelProfile.setVisible(true);
				panelMain.setVisible(false);
			}
		});
		//set panel for main menu
		panelMain.setLayout(null);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 30));
		btnNewButton.setBounds(376, 103, 225, 120);
		panelMain.add(btnNewButton);
		
		//check staff function
		JButton btnNewButton_3 = new JButton("Staff");
		btnNewButton_3.setFont(new Font("Arial", Font.PLAIN, 30));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get staff list from database
				FTMSController controller = new FTMSController();
				try {
					controller.showStaff();
				} catch (InvalidInputException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				Manager m = Manager.getInstance();
				List<Staff> stafflist = m.getStaffs();
				DefaultTableModel model = (DefaultTableModel) tableStaff.getModel();
				model.setRowCount(0);
				for(int i=0; i<stafflist.size(); i++) {
					String name = stafflist.get(i).getNAME();
					String role = stafflist.get(i).getROLE();
					long tel = stafflist.get(i).getTEL();
					model.addRow(new Object[] {name, role, tel});
				}
				panelStaff.setVisible(true);
				panelMain.setVisible(false);
			}
		});
		btnNewButton_3.setBounds(633, 103, 225, 120);
		panelMain.add(btnNewButton_3);
		btnLogout.setFont(new Font("Arial", Font.PLAIN, 28));
		btnLogout.setBounds(933, 39, 200, 61);
		panelMain.add(btnLogout);
		
		//check food list from database
		JButton btnNewButton_1 = new JButton("Food");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FTMSController controller = new FTMSController();
				try {
					controller.showFood();
				} catch (InvalidInputException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				Manager m = Manager.getInstance();
				List<Food> foodlist = m.getFoods();
				DefaultTableModel model = (DefaultTableModel) tableFood.getModel();
				model.setRowCount(0);
				for(int i=0; i<foodlist.size(); i++) {
					String name = foodlist.get(i).getNAME();
					int quantity = foodlist.get(i).getQUANTITY();
					float price = foodlist.get(i).getPRICE();
					model.addRow(new Object[] {name, quantity, price});
				}
				
				panelFood.setVisible(true);
				panelMain.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 30));
		btnNewButton_1.setBounds(376, 260, 225, 120);
		panelMain.add(btnNewButton_1);
		
		//check menu list from database
		JButton btnNewButton_2 = new JButton("Menu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FTMSController controller = new FTMSController();
				try {
					controller.showMenu();;
				} catch (InvalidInputException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				Manager m = Manager.getInstance();
				List<Menu> menulist = m.getMenus();
				DefaultTableModel model = (DefaultTableModel) tableMenu.getModel();
				model.setRowCount(0);
				for(int i=0; i<menulist.size(); i++) {
					String name = menulist.get(i).getNAME();
					float price = menulist.get(i).getPRICE();
					int popularity = menulist.get(i).getPOPULARITY();
					model.addRow(new Object[] {name, price, popularity});
				}
				panelMenu.setVisible(true);
				panelMain.setVisible(false);
			}
		});
		
		//check equipment list from database
		JButton btnNewButton_4 = new JButton("Equipment");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FTMSController controller = new FTMSController();
				try {
					controller.showEquipment();
				} catch (InvalidInputException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				Manager m = Manager.getInstance();
				List<Equipment> equiplist = m.getEquipments();
				DefaultTableModel model = (DefaultTableModel) tableEquipment.getModel();
				model.setRowCount(0);
				for(int i=0; i<equiplist.size(); i++) {
					String name = equiplist.get(i).getNAME();
					int quantity = equiplist.get(i).getQUANTITY();
					float price = equiplist.get(i).getPRICE();
					model.addRow(new Object[] {name, quantity, price});
				}
				panelEquipment.setVisible(true);
				panelMain.setVisible(false);
			}
		});
		btnNewButton_4.setFont(new Font("Arial", Font.PLAIN, 30));
		btnNewButton_4.setBounds(633, 260, 225, 120);
		panelMain.add(btnNewButton_4);
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 30));
		btnNewButton_2.setBounds(376, 417, 225, 120);
		panelMain.add(btnNewButton_2);
		
		//check orders from database
		JButton btnNewButton_5 = new JButton("Order");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FTMSController controller = new FTMSController();
				try {
					controller.showOrder();;
				} catch (InvalidInputException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				Manager m = Manager.getInstance();
				List<Order> orderlist = m.getOrders();
				DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();
				model.setRowCount(0);
				for(int i=0; i<orderlist.size(); i++) {
					String id = orderlist.get(i).getID();
					String time = orderlist.get(i).getTIME();
					String status = orderlist.get(i).getSTATUS();
					if(status.compareTo("1") == 0) {
						status = "Completed";
					} else {
						status = "In process";
					}
					model.addRow(new Object[] {id, time, status});
				}
				panelOrder.setVisible(true);
				panelMain.setVisible(false);
			}
		});
		btnNewButton_5.setFont(new Font("Arial", Font.PLAIN, 30));
		btnNewButton_5.setBounds(633, 417, 225, 120);
		panelMain.add(btnNewButton_5);
		
		//set profile labels
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Arial", Font.PLAIN, 30));
		lblName.setBounds(98, 75, 232, 40);
		panelProfile.add(lblName);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Arial", Font.PLAIN, 30));
		lblGender.setBounds(98, 140, 232, 40);
		panelProfile.add(lblGender);
		
		JLabel lblStaffId = new JLabel("Position:");
		lblStaffId.setFont(new Font("Arial", Font.PLAIN, 30));
		lblStaffId.setBounds(98, 205, 232, 40);
		panelProfile.add(lblStaffId);
		
		JLabel lblPosition = new JLabel("Age:");
		lblPosition.setFont(new Font("Arial", Font.PLAIN, 30));
		lblPosition.setBounds(98, 270, 232, 40);
		panelProfile.add(lblPosition);
		
		JLabel lblContactNumber = new JLabel("Contact Number:");
		lblContactNumber.setFont(new Font("Arial", Font.PLAIN, 30));
		lblContactNumber.setBounds(98, 334, 232, 40);
		panelProfile.add(lblContactNumber);
		
		JLabel lblWeeklySchedule = new JLabel("Weekly Schedule:");
		lblWeeklySchedule.setFont(new Font("Arial", Font.PLAIN, 30));
		lblWeeklySchedule.setBounds(98, 384, 257, 60);
		panelProfile.add(lblWeeklySchedule);
		
		//go back to main menu from viewing profile
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(true);
				panelProfile.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Arial", Font.PLAIN, 30));
		btnBack.setBounds(519, 506, 150, 50);
		panelProfile.add(btnBack);
		
		//set display fields for profile
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_2.setEditable(false);
		textField_2.setBounds(356, 74, 751, 40);
		panelProfile.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(356, 139, 751, 40);
		panelProfile.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(356, 204, 751, 40);
		panelProfile.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(356, 269, 751, 40);
		panelProfile.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_6.setColumns(10);
		textField_6.setBounds(356, 334, 751, 40);
		panelProfile.add(textField_6);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(297, 64, 774, 364);
		panelStaff.add(scrollPane);
		
		//table displays staff
		tableStaff = new JTable();
		scrollPane.setViewportView(tableStaff);
		tableStaff.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tableStaff.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableStaff.setRowHeight(40);
		tableStaff.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Position", "Phone #"
			}
		));
		tableStaff.setFont(new Font("Arial", Font.PLAIN, 30));
		
		
		//go back to main menu from viewing staff
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(true);
				panelStaff.setVisible(false);
			}
		});
		button.setFont(new Font("Arial", Font.PLAIN, 30));
		button.setBounds(660, 480, 150, 50);
		panelStaff.add(button);
		
		//add staff function
		JButton btnNewButton_8 = new JButton("+");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelStaff.setVisible(false);
				panelAddStaff.setVisible(true);
			}
		});
		btnNewButton_8.setFont(new Font("Arial", Font.PLAIN, 30));
		btnNewButton_8.setBounds(169, 64, 58, 57);
		panelStaff.add(btnNewButton_8);
		
		//delete staff function
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) tableStaff.getModel();
				if(tableStaff.getSelectedRow() != -1) {
					model.removeRow(tableStaff.getSelectedRow());
				}
			}
		});
		btnDelete.setFont(new Font("Arial", Font.PLAIN, 30));
		btnDelete.setBounds(445, 480, 150, 50);
		panelStaff.add(btnDelete);
		
		JLabel lblStaffError = new JLabel("");
		lblStaffError.setForeground(Color.RED);
		lblStaffError.setFont(new Font("Arial", Font.PLAIN, 25));
		lblStaffError.setBounds(445, 438, 355, 32);
		panelStaff.add(lblStaffError);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(297, 64, 774, 364);
		panelFood.add(scrollPane_1);
		
		//table displays food
		tableFood = new JTable();
		scrollPane_1.setViewportView(tableFood);
		tableFood.setRowHeight(40);
		tableFood.setModel(new DefaultTableModel(
			new Object[][] {
					
			},
			new String[] {
				"Food", "Quantity", "Price"
			}
		));
		tableFood.setFont(new Font("Arial", Font.PLAIN, 30));
		

		////go back to main menu from viewing food
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(true);
				panelFood.setVisible(false);
				lblFoodError.setText("");
			}
		});
		button_1.setFont(new Font("Arial", Font.PLAIN, 30));
		button_1.setBounds(660, 480, 150, 50);
		panelFood.add(button_1);
		
		//add food function
		JButton button_12 = new JButton("+");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelFood.setVisible(false);
				panelAddFood.setVisible(true);
				lblFoodError.setText("");
			}
		});
		button_12.setFont(new Font("Arial", Font.PLAIN, 30));
		button_12.setBounds(169, 64, 58, 57);
		panelFood.add(button_12);

		//delete food function
		JButton button_5 = new JButton("Delete");
		button_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FTMSController controller = new FTMSController();
				String error = "";
				//check if selected and permission
				try {
					int selectedRowIndex = tableFood.getSelectedRow();
					int selectedColumnIndex = tableFood.getSelectedColumn();
					if(selectedRowIndex != -1 && selectedColumnIndex != -1) {
						String selected = (String) tableFood.getModel().getValueAt(selectedRowIndex, selectedColumnIndex);
						Food food = new Food(selected,0,0);
						controller.setPosition(position);
						controller.removeFood(food);
					}
				} catch (Exception e1) {
					error = e1.getMessage();
					e1.printStackTrace();
				}
				//delete food if permission granted
				if(error.length()==0) {
					DefaultTableModel model = (DefaultTableModel) tableFood.getModel();
					if(tableFood.getSelectedRow() != -1) {
						model.removeRow(tableFood.getSelectedRow());
					}
				} else {
					lblFoodError.setText(error);
				}
				
			}
		});
		button_5.setFont(new Font("Arial", Font.PLAIN, 30));
		button_5.setBounds(445, 480, 150, 50);
		panelFood.add(button_5);
		

		//go back to main menu from viewing equipment
		JButton button_2 = new JButton("Back");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(true);
				panelEquipment.setVisible(false);
				lblEquipmentError.setText("");
			}
		});
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(297, 64, 774, 364);
		panelEquipment.add(scrollPane_2);
		
		//table displays equipment
		tableEquipment = new JTable();
		tableEquipment.setFont(new Font("Arial", Font.PLAIN, 30));
		tableEquipment.setRowHeight(40);
		tableEquipment.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Equipment", "Quantity", "Price"
			}
		));
		scrollPane_2.setViewportView(tableEquipment);
		button_2.setFont(new Font("Arial", Font.PLAIN, 30));
		button_2.setBounds(660, 480, 150, 50);
		panelEquipment.add(button_2);
		
		//add equipment function
		JButton button_14 = new JButton("+");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEquipment.setVisible(false);
				panelAddEquipment.setVisible(true);
				lblEquipmentError.setText("");
			}
		});
		button_14.setFont(new Font("Arial", Font.PLAIN, 30));
		button_14.setBounds(169, 64, 58, 57);
		panelEquipment.add(button_14);
		
		//delete equipment function
		JButton button_17 = new JButton("Delete");
		button_17.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {			
				FTMSController controller = new FTMSController();
				String error = "";
				//check for error and permission
				try {
					int selectedRowIndex = tableEquipment.getSelectedRow();
					int selectedColumnIndex = tableEquipment.getSelectedColumn();
					if(selectedRowIndex != -1 && selectedColumnIndex != -1) {
						String selected = (String) tableEquipment.getModel().getValueAt(selectedRowIndex, selectedColumnIndex);
						Equipment equip = new Equipment(selected,0,0);
						controller.setPosition(position);
						controller.removeEquipment(equip);
					}
					
				} catch (Exception e1) {
					error = e1.getMessage();
					e1.printStackTrace();
				}
				//delete equipment if permission granted
				if(error.length()==0) {
					DefaultTableModel model = (DefaultTableModel) tableEquipment.getModel();
					if(tableEquipment.getSelectedRow() != -1) {
						model.removeRow(tableEquipment.getSelectedRow());
					}
				} else {
					lblEquipmentError.setText(error);
				}
				
			}
		});

		button_17.setFont(new Font("Arial", Font.PLAIN, 30));
		button_17.setBounds(445, 480, 150, 50);
		panelEquipment.add(button_17);
		
		//go back to main menu from viewing menu
		JButton button_3 = new JButton("Back");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(true);
				panelMenu.setVisible(false);
			}
		});
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(297, 64, 774, 364);
		panelMenu.add(scrollPane_3);
		
		//table displays menu
		tableMenu = new JTable();
		tableMenu.setToolTipText("");
		tableMenu.setRowHeight(40);
		tableMenu.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Dish Name", "Price", "Popularity"
			}
		));
		tableMenu.setFont(new Font("Arial", Font.PLAIN, 30));
		scrollPane_3.setViewportView(tableMenu);
		button_3.setFont(new Font("Arial", Font.PLAIN, 30));
		button_3.setBounds(660, 480, 150, 50);
		panelMenu.add(button_3);
		
		//add menu function
		JButton button_15 = new JButton("+");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(false);
				panelAddMenu.setVisible(true);
			}
		});
		button_15.setFont(new Font("Arial", Font.PLAIN, 30));
		button_15.setBounds(169, 64, 58, 57);
		panelMenu.add(button_15);
		

		//delete dish form menu
		JButton button_18 = new JButton("Delete");
		button_18.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				FTMSController controller = new FTMSController();
				String error = "";
				//check for error and permission
				Manager m = Manager.getInstance();
				List<Menu> menulist = m.getMenus();
				int row = tableMenu.getSelectedRow();
				if(row > -1) {
					try {
						controller.setPosition(position);
						controller.removeMenu(menulist.get(row));
					} catch (Exception e1) {
						error = e1.getMessage();
						e1.printStackTrace();
					}
					//delete selected dish from menu if permission granted
					if(error.length()==0) {
						DefaultTableModel model = (DefaultTableModel) tableMenu.getModel();
						if(tableMenu.getSelectedRow() != -1) {
							model.removeRow(tableMenu.getSelectedRow());
						}
					} else {
						lblMenuError.setText(error);
					}
				}
				
			}
		});
		button_18.setFont(new Font("Arial", Font.PLAIN, 30));
		button_18.setBounds(445, 480, 150, 50);
		panelMenu.add(button_18);
		

		////go back to main menu from viewing orders
		JButton button_4 = new JButton("Back");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(true);
				panelOrder.setVisible(false);
			}
		});
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(297, 64, 774, 364);
		panelOrder.add(scrollPane_4);
		
		//table displays orders
		tableOrder = new JTable();
		tableOrder.setRowHeight(40);
		tableOrder.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Order ID", "Date", "Order Status"
			}
		));
		tableOrder.getColumnModel().getColumn(0).setPreferredWidth(52);
		tableOrder.getColumnModel().getColumn(1).setPreferredWidth(149);
		tableOrder.setFont(new Font("Arial", Font.PLAIN, 30));
		scrollPane_4.setViewportView(tableOrder);
		button_4.setFont(new Font("Arial", Font.PLAIN, 30));
		button_4.setBounds(660, 480, 150, 50);
		panelOrder.add(button_4);
		
		//add order function
		JButton button_16 = new JButton("+");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelOrder.setVisible(false);
				panelAddOrder.setVisible(true);
			}
		});
		button_16.setFont(new Font("Arial", Font.PLAIN, 30));
		button_16.setBounds(169, 64, 58, 57);
		panelOrder.add(button_16);
		
		//check existing orders function
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FTMSController controller = new FTMSController();
				try {
					controller.showOrder();;
				} catch (InvalidInputException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				Manager m = Manager.getInstance();
				List<Order> orderlist = m.getOrders();
				DefaultTableModel model = (DefaultTableModel) tableCheckOrder.getModel();
				model.setRowCount(0);
				for(int i=0; i<orderlist.size(); i++) {
					String id = orderlist.get(i).getID();
					String time = orderlist.get(i).getTIME();
					String status = orderlist.get(i).getSTATUS();
					if(status.compareTo("1") == 0) {
						status = "Completed";
					} else {
						status = "In process";
					}
					model.addRow(new Object[] {id, "", ""});
				}
				
				panelCheckOrder.setVisible(true);
				panelOrder.setVisible(false);
			}
		});
		btnCheck.setFont(new Font("Arial", Font.PLAIN, 30));
		btnCheck.setBounds(445, 480, 150, 50);
		panelOrder.add(btnCheck);
		
		//set labels for placing order
		JLabel lblOrderError = new JLabel("");
		lblOrderError.setForeground(Color.RED);
		lblOrderError.setFont(new Font("Arial", Font.PLAIN, 25));
		lblOrderError.setBounds(445, 438, 355, 32);
		panelOrder.add(lblOrderError);
		
		JLabel lblItem = new JLabel("Item");
		lblItem.setFont(new Font("Arial", Font.PLAIN, 30));
		lblItem.setBounds(345, 115, 99, 30);
		panelAddOrder.add(lblItem);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Arial", Font.PLAIN, 30));
		lblQuantity.setBounds(748, 105, 143, 50);
		panelAddOrder.add(lblQuantity);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_1.setBounds(345, 197, 294, 50);
		panelAddOrder.add(textField_1);
		textField_1.setColumns(10);
		
		textField_18 = new JTextField();
		textField_18.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char vchar = e.getKeyChar();
				if(!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACK_SPACE) || 
						(vchar == KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		textField_18.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_18.setColumns(10);
		textField_18.setBounds(748, 197, 119, 50);
		panelAddOrder.add(textField_18);

		//adding error to designated panel
		panelAddEquipment.add(lblAddEquipmentError);
		panelAddEquipment.setVisible(false);
		panelAddMenu.add(lblAddMenuError);
		panelAddMenu.setVisible(false);
		panelAddOrder.add(lblAddOrderError);

	}
}