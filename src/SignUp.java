
import javax.swing.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;

class SignUp extends JFrame implements ActionListener {

	private JPanel panel;
	private JLabel labelUsername, labelPassword, labelimg;
	private JTextField textUsername;
	private JPasswordField textPassword;
	private JButton buttonSignup, buttonCancel;
	private JTextField profileNameTextField;

	public SignUp() {
		this.InitializeComponents();
	}

	private void InitializeComponents() {

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.white);

		labelUsername = new JLabel("Email");
		labelUsername.setBounds(257, 173, 47, 20);
		panel.add(labelUsername);

		textUsername = new JTextField();
		textUsername.setBounds(354, 173, 175, 20);
		panel.add(textUsername);

		labelPassword = new JLabel("Password");
		labelPassword.setBounds(257, 205, 65, 20);
		panel.add(labelPassword);

		textPassword = new JPasswordField();
		textPassword.setBounds(354, 205, 175, 20);
		panel.add(textPassword);

//		panel.add(buttonCancel);
//		panel.add(buttonSignup);
		getContentPane().add(panel);
		
		labelimg = new JLabel("");
		Image img = new ImageIcon(getClass().getResource("/applogin.png")).getImage();
		labelimg.setIcon(new ImageIcon(img));
		labelimg.setBounds(60, 136, 150, 150);
		panel.add(labelimg);
		//back to sign up button
		buttonCancel = new JButton("Already Have an account? SignIn");
		buttonCancel.setBounds(207, 322, 322, 30);
		panel.add(buttonCancel);
		buttonCancel.addActionListener(this);
		
		//sign in button
		buttonSignup = new JButton("Sign Up");
		buttonSignup.setBounds(384, 267, 120, 30);
		panel.add(buttonSignup);
		
		profileNameTextField = new JTextField();
		profileNameTextField.setBounds(354, 136, 175, 20);
		panel.add(profileNameTextField);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(257, 136, 85, 20);
		panel.add(lblUserName);
		buttonSignup.addActionListener(this);
		
		
		setSize(700, 600);
		setLocationRelativeTo(null);
		setTitle("User Signup");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == buttonSignup) {

			String username = textUsername.getText();
			String password = textPassword.getText();
			String profile_name = profileNameTextField.getText();

			Utils utils = new Utils();
			boolean email_verified = utils.isEmailValid(username);
			if (!email_verified) {
				JOptionPane.showMessageDialog(null,
						"Your provided email is not a valid email, Please Provide a valid email.", "Message",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			DataAccess api = new DataAccess();
			String resp = api.signUp(username, password,profile_name);
			JOptionPane.showMessageDialog(null, resp, "Message", JOptionPane.INFORMATION_MESSAGE);
		}
		if (ae.getSource() == buttonCancel) {

			SignIn si = new SignIn();
			si.setVisible(true);
			SignUp.this.setVisible(false);
		}

	}
}