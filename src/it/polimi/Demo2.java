package it.polimi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import it.polimi.gui.Welcome;

public class Demo2{
	
	private static JFrame frame;
	private static JButton next;
	private static JLabel lblBenvenutoCliccaAvantui;
	
	public static void main(String[] args) {
	
		{
			//Set Look & Feel
			try {
				javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		frame = new JFrame("Welcome!");
		next = new JButton("Avanti");
		lblBenvenutoCliccaAvantui = new JLabel("Benvenuto clicca avantui poer fare il loguin");
		next.addActionListener(new NextListener());
		init();
		
	}
	
	private static void init(){
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(next);
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		next.setBounds(43, 97, 180, 129);
		lblBenvenutoCliccaAvantui.setBounds(40, 26, 218, 51);
		frame.getContentPane().add(lblBenvenutoCliccaAvantui);
		frame.setVisible(true);
	}
	
	private static class NextListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new Welcome("Benvenuto");
		}
	}
	
}