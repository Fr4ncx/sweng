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

import javax.swing.JPanel;
import javax.swing.JList;
import java.awt.List;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import java.awt.BorderLayout;
import java.awt.GridLayout;

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
	public Welcome(String user) throws SQLException {
	
		Panel panel_1;
		JLabel lblNewLabel_1;
		JLabel lblNewLabel_2;
		JButton btnNewButton_2;
		JLabel label ;
		JLabel label_1;
		JLabel label_2;
		JFrame frame = new JFrame("Benvenuto");
		frame.setSize(432,508);
		frame.setBackground(SystemColor.activeCaption);
		
		JPanel panel = new JPanel();
		panel.setBounds(23, 48, 378, 80);
		panel.setBackground(SystemColor.activeCaption);
		panel.setForeground(SystemColor.textHighlight);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Benvenuto, "+user+"!");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setBounds(10, 24, 159, 31);
		panel.add(lblNewLabel);
		
	
		
		
		JButton btnNewButton = new JButton("Progetti");
		btnNewButton.setBounds(0, 0, 217, 37);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(0, 153, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_1 = new JButton("Attivit\u00E0");
		btnNewButton_1.setBounds(214, 0, 212, 37);
		btnNewButton_1.setBackground(new Color(0, 255, 0));
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
	
	

		frame.setDefaultLookAndFeelDecorated(true);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		
		
		
        
	}
}
