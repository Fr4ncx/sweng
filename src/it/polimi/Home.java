package it.polimi;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Home  {
	
	
	private static JFrame frame;
	private static JLabel lblUser;
	private static JLabel lblPassword;
	private static JButton btnLogin;
	private static JLabel lblOr;
	private static JButton btnSignIn;
	private static JButton btnReset;
	private static JTextField textField;
	private static JTextField textField_1;

	public static void main(String[] args) {
		
		{
			//Set Look & Feel
			try {
				javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		

		frame = new JFrame("Login or Register");
		lblUser = new JLabel("User");
		textField = new JTextField();
		lblPassword = new JLabel("Password");
		textField_1 = new JTextField();
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new LoginListener());
		lblOr = new JLabel("or");
		btnSignIn = new JButton("Sign in");
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ResetListener());
		init();
	}
	
	private static void init(){
		frame.setSize(230,280);
		frame.setResizable(false);
		frame.setBackground(SystemColor.activeCaption);
		frame.getContentPane().setLayout(null);
		lblUser.setBounds(46, 22, 46, 14);
		frame.getContentPane().add(lblUser);
		textField.setBounds(87, 19, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		lblPassword.setBounds(21, 68, 60, 14);
		frame.getContentPane().add(lblPassword);
		textField_1.setBounds(87, 65, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		btnLogin.setBounds(84, 105, 89, 23);
		frame.getContentPane().add(btnLogin);
		lblOr.setBounds(124, 139, 21, 14);
		frame.getContentPane().add(lblOr);
		btnSignIn.setBounds(87, 164, 89, 23);
		frame.getContentPane().add(btnSignIn);
		btnReset.setBounds(21, 198, 89, 23);
		frame.getContentPane().add(btnReset);	
		frame.setDefaultLookAndFeelDecorated(true);
		frame.setVisible(true);
	}
	
	private static class LoginListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
					Database d = new Database();
										
					try {
						
						if(d.verifyCredentials(textField.getText(), textField_1.getText())){
							frame.dispose();
							new Welcome(textField.getText());
						}else{
							textField_1.setText("Wrong name");
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					}
		}	
	}
	private static class ResetListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			textField_1.setText("");
			textField.setText("");
			
		}
	}
}
