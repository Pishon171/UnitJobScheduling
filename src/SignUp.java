
import javax.swing.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
class SignUp extends JFrame
{
	
	private JPanel panel;
	private JLabel labelUsername, labelPassword,labelimg;
	private JTextField textUsername;
	private JPasswordField textPassword;
	private JButton buttonLogin, buttonCancel;
	
	public SignUp()
	{
		this.InitializeComponents();
	}
	
	private void InitializeComponents()
	{
		this.panel = new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(Color.white);
		
		this.labelUsername = new JLabel("Email");
		this.labelUsername.setBounds(220, 80, 80, 20);
		this.panel.add(this.labelUsername);
		
		
		this.textUsername = new JTextField();
		this.textUsername.setBounds(300, 80, 150, 20);
		this.panel.add(this.textUsername);
		
		
		this.labelPassword = new JLabel("Password");
		this.labelPassword.setBounds(220, 120, 120, 20);
		this.panel.add(this.labelPassword);
		
		
		this.textPassword = new JPasswordField();
		this.textPassword.setBounds(300, 120, 150, 20);
		this.panel.add(this.textPassword);
		
		this.buttonLogin = new JButton("Sign Up");
		this.buttonLogin.setBounds(350, 160, 120, 30);
		this.buttonLogin.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{	
				String username = textUsername.getText();
				String password = textPassword.getText();
				
				Utils utils = new Utils();
				boolean email_verified = utils.isEmailValid(username);
				if(!email_verified) {
					JOptionPane.showMessageDialog(null, "Your provided email is not a valid email, Please Provide a valid email.", "Message", JOptionPane.INFORMATION_MESSAGE);
					return ;
				}
				DataAccess api = new DataAccess();
				String resp = api.signUp(username,password);
				JOptionPane.showMessageDialog(null, resp, "Message", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
			
				);
		
		this.buttonCancel = new JButton("Already Have an account? SignIn");
		this.buttonCancel.setBounds(220, 200, 250, 30);
		this.buttonCancel.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{

				Signin si=new Signin();
				si.setVisible(true);
				SignUp.this.setVisible(false);
			}
		});
		this.panel.add(this.buttonCancel);
		
		
		
		this.panel.add(this.buttonLogin);
		
		this.add(this.panel);
		
		
		this.labelimg = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/applogin.png")).getImage();
		this.labelimg.setIcon(new ImageIcon(img));
		this.labelimg.setBounds(50,30, 150, 150);
		this.panel.add(this.labelimg);
		
		
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setTitle("User Signup");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}