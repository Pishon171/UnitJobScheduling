import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import com.toedter.calendar.JDateChooser;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class NewJob extends JFrame implements ActionListener {

	JButton newtaskButton, backButton;
	JLabel heading, task, tasktype, startDate, endDate, status, priority, reminder, description;
	JTextField fieldtask, fieldtype, descriptionField, fieldStartDate, endDateField;
	JComboBox statusDropdown, priorityDropdown;
	JRadioButton yesRadioButton, noRadioButton;

	private JPanel panel;

	NewJob() {

		this.panel = new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(Color.LIGHT_GRAY);

		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		heading = new JLabel("Add New Job");
		heading.setBounds(200, 5, 400, 40);
		heading.setFont(new Font("Candela", Font.BOLD, 18));
		add(heading);

		// name
		task = new JLabel("Task Name: ");
		task.setBounds(30, 50, 100, 30);
		add(task);
		fieldtask = new JTextField();
		fieldtask.setBounds(20, 80, 100, 30);
		fieldtask.setSize(200, 20);
		fieldtask.setSize(200, 40);
		add(fieldtask);

		// type
		tasktype = new JLabel("Task Type");
		tasktype.setBounds(350, 50, 100, 30);
		add(tasktype);
		fieldtype = new JTextField();
		fieldtype.setBounds(320, 80, 100, 30);
		fieldtype.setSize(200, 40);
		add(fieldtype);

		// start date (calendar)
		startDate = new JLabel(" Start Date: ");
		startDate.setBounds(30, 145, 100, 30);
		add(startDate);

		fieldStartDate = new JTextField();
		fieldStartDate.setBounds(20, 170, 100, 30);
		fieldStartDate.setSize(200, 20);
		add(fieldStartDate);

		// due date (calendar)
		endDate = new JLabel(" End Date: ");
		endDate.setBounds(270, 145, 100, 30);
		add(endDate);

		endDateField = new JTextField();
		endDateField.setBounds(270, 170, 100, 30);
		endDateField.setSize(200, 20);
		add(endDateField);

		// status (drop down)
		status = new JLabel(" Status: ");
		status.setBounds(30, 220, 100, 30);
		add(status);

		String statusList[] = { "Choose Status", "To-Do", "In Progress", "Finished" };
		statusDropdown = new JComboBox(statusList);
		statusDropdown.setBounds(20, 250, 100, 30);
		statusDropdown.setSize(180, 40);
		add(statusDropdown);

		// priority (drop down)
		priority = new JLabel(" Priority: ");
		priority.setBounds(270, 220, 100, 30);
		add(priority);

		String priorityList[] = { "Choose Priority", "Low", "Medium", "High", "Critical" };
		priorityDropdown = new JComboBox(priorityList);
		priorityDropdown.setBounds(260, 250, 100, 30);
		priorityDropdown.setSize(180, 40);
		add(priorityDropdown);

		// reminder (radio box)
		reminder = new JLabel(" Reminder ?: ");
		reminder.setBounds(30, 300, 100, 30);
		add(reminder);

		yesRadioButton = new JRadioButton("Yes");
		yesRadioButton.setBounds(140, 300, 60, 30);
		add(yesRadioButton);

		noRadioButton = new JRadioButton("No");
		noRadioButton.setBounds(200, 300, 60, 30);
		add(noRadioButton);

		ButtonGroup group = new ButtonGroup();
		group.add(yesRadioButton);
		group.add(noRadioButton);

		// description
		description = new JLabel(" Add Description : ");
		description.setBounds(30, 360, 100, 30);

		add(description);
		descriptionField = new JTextField();
		descriptionField.setBounds(20, 380, 100, 30);
		descriptionField.setSize(400, 70);
		add(descriptionField);

		// add task button
		newtaskButton = new JButton("Add Job");
		newtaskButton.setBounds(330, 490, 150, 30);
		newtaskButton.addActionListener(this);
		newtaskButton.setSize(150, 50);
		newtaskButton.setBackground(Color.BLUE);

		add(newtaskButton);

		backButton = new JButton("Back");
		backButton.setBounds(90, 490, 150, 30);
		backButton.addActionListener(this);
		backButton.setSize(150, 50);
		backButton.setBackground(Color.BLUE);
		setVisible(true);
		add(backButton);

		this.add(this.panel);

		this.setSize(600, 580);
		this.setLocationRelativeTo(null);
		this.setTitle("Add New Job");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == newtaskButton) {

			String task1 = fieldtask.getText();
			String taskype1 = fieldtype.getText();
			String startDate1 = fieldStartDate.getText();
			String endDate1 = endDateField.getText();
			String status1 = (String) statusDropdown.getSelectedItem();
			String priority1 = (String) priorityDropdown.getSelectedItem();
			String description1 = description.getText();
			String reminderChoice = "";
			if (yesRadioButton.isSelected()) {
				reminderChoice = "Yes";
			} else if (noRadioButton.isSelected()) {
				reminderChoice = "No";
			}

			try {
				Conn conn = new Conn();
				String query = "insert into tasks values('" + task1 + "', '" + taskype1 + "', '" + startDate1 + "', '"
						+ endDate1 + "', '" + status1 + "', '" + priority1 + "', '" + description1 + "')";
				conn.stm.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Details are added Successfully");
				setVisible(false);
				new Home();

			} catch (Exception e) {
				e.printStackTrace();
			}

//			

		}
		if (ae.getSource() == backButton) {

			System.out.println("addjobs pressed");
			Home hm = new Home();
			hm.setVisible(true);
			NewJob.this.setVisible(false);

		}

	}
}