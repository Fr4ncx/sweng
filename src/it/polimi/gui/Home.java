package it.polimi.gui;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import it.polimi.*;
import it.polimi.gui.Welcome;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class Home  {
	
	
	private static JFrame frame;
	private static JLabel lblUser;
	private static JLabel lblPassword;
	private static JButton btnLogin;
	private static JButton btnSignIn;
	private static JTextField textField;
	private static JPanel panel_1;
	private static JPasswordField passwordField;

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
		init();
	}
	
	private static void init(){
		frame.setSize(291,280);
		frame.setResizable(false);
		frame.setBackground(SystemColor.activeCaption);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 11, 285, 240);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 171, 265, 58);
		panel.add(panel_1);
		panel_1.setLayout(null);
		btnLogin = new JButton("Login");
		btnLogin.setIcon(new ImageIcon(Home.class.getResource("/it/polimi/icon/login.png")));
		btnLogin.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnLogin.setBounds(10, 11, 107, 36);
		panel_1.add(btnLogin);
		btnSignIn = new JButton("Sign in");
		btnSignIn.setIcon(new ImageIcon(Home.class.getResource("/it/polimi/icon/register.png")));
		btnSignIn.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnSignIn.setBounds(127, 11, 113, 36);
		panel_1.add(btnSignIn);
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblPassword.setBounds(24, 89, 60, 28);
		panel.add(lblPassword);
		lblUser = new JLabel("Username");
		lblUser.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblUser.setBounds(24, 40, 61, 24);
		panel.add(lblUser);
		textField = new JTextField();
		textField.setBounds(91, 42, 157, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(94, 89, 154, 25);
		panel.add(passwordField);
		btnLogin.addActionListener(new LoginListener());
		frame.setDefaultLookAndFeelDecorated(true);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	private static class LoginListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(textField.getText().length()>0 && passwordField.getText().length()>0){
				Database d = new Database();
									
				try {
					
					if(d.verifyCredentials(textField.getText(), passwordField.getText())){
						frame.dispose();
						new Welcome(textField.getText());
					}else{
						passwordField.setText("Wrong name");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
			}
		}	
	}
}
