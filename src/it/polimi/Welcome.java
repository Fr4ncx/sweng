package it.polimi;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class Welcome implements ActionListener {
	
	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public Welcome(String user) {
	

		JFrame frame = new JFrame("Benvenuto");
		frame.setSize(230,280);
		frame.setResizable(false);
		frame.setBackground(SystemColor.activeCaption);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setForeground(SystemColor.textHighlight);
		panel.setBounds(23, 21, 179, 80);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Benvenuto, "+user+"!");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setBounds(10, 22, 159, 31);
		panel.add(lblNewLabel);
		
		frame.setDefaultLookAndFeelDecorated(true);
		frame.setVisible(true);
        
	}
}
