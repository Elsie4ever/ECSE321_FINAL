package ftms.view;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import ftms.controller.FTMSController;
import ftms.controller.InvalidInputException;

public class FTMSUIPage extends JFrame {
	
	private static final long serialVersionUID = -8062635784771606869L;
	
	//UI elements
	private JLabel errorMessage;
	private JTextField staffNameTextField;
	private JLabel staffNameLabel;
	private JTextField staffUserIDTextField;
	private JLabel staffUserIDLabel;
	private JTextField staffPositionTextField;
	private JLabel staffPositionLabel;
	private JButton addStaffButton;
	
	//data elements
	private String error = null;
	
	//create new form of FTMSUIPage
	public FTMSUIPage() {
		initComponents();
		refreshData();
		
	}
	
	private void initComponents() {
		//elements for error message
		errorMessage = new JLabel();
		errorMessage.setForeground(Color.RED);
		
		
		//elements for staff
		staffNameTextField = new JTextField();
		staffNameLabel = new JLabel();
		staffUserIDTextField = new JTextField();
		staffUserIDLabel = new JLabel();
		staffPositionTextField = new JTextField();
		staffPositionLabel = new JLabel();
		addStaffButton = new JButton();
		
		//global settings and listeners
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Food Truck Manager");
		
		staffNameLabel.setText("Name:");
		staffUserIDLabel.setText("User ID:");
		staffPositionLabel.setText("Position:");
		addStaffButton.setText("Add Staff");
		addStaffButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addStaffButtonActionPerformed(evt);
			}
		});
		
		//layout
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(
				layout.createParallelGroup()
				.addComponent(errorMessage)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createSequentialGroup()
						.addComponent(staffNameLabel)
						.addComponent(staffUserIDLabel)
						.addComponent(staffPositionLabel))
						.addGroup(layout.createParallelGroup()
					.addComponent(staffNameTextField, 200, 200, 400)
						.addComponent(staffUserIDTextField)
						.addComponent(staffPositionTextField)
						.addComponent(addStaffButton)))
				);
				
		layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {addStaffButton, staffNameTextField, staffUserIDTextField, staffPositionTextField});
		
		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addComponent(errorMessage)
				.addGroup(layout.createParallelGroup()
						.addComponent(staffNameLabel)
						.addComponent(staffNameTextField)
						.addComponent(staffUserIDLabel)
						.addComponent(staffUserIDTextField)
						.addComponent(staffPositionLabel)
						.addComponent(staffPositionTextField))
				.addComponent(addStaffButton)
				);
		
		pack();
	}
	
	private void refreshData() {
		//error
		errorMessage.setText(error);
		//staff
		staffNameTextField.setText("");
		staffUserIDTextField.setText("");
		staffPositionTextField.setText("");
		
		pack();
	}
	
	private void addStaffButtonActionPerformed(java.awt.event.ActionEvent evt) {
		FTMSController ftmsc = new FTMSController();
		error = null;
		
		refreshData();
	}
	
	
	

}
