package it.polimi.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import it.polimi.*;
import javax.swing.border.TitledBorder;

public class prv extends JFrame {
	
 	
   
	
    prv() {
    	setTitle("Creazione Progetto");
    	getContentPane().setLayout(null);
    	
    	JPanel panel = new JPanel();
    	panel.setBounds(10, 11, 427, 88);
    	
    	
    	JMenuBar menu = new JMenuBar();
    	menu.setBounds(0, 34, 117, -34);
    	JMenu  m1 = new JMenu("Options");
    	JMenu m2 = new JMenu("Programs");
    	JMenu m3 = new JMenu("Help");

    	JMenuItem AddNew = new JMenuItem("AddNew");

    	JMenuItem Search = new JMenuItem("Search");

    	JMenuItem  Display = new JMenuItem("Display");
    	JMenuItem Delete = new JMenuItem("Delete");
    	JMenuItem Modify = new JMenuItem("Modify");
    	JMenuItem Exit = new JMenuItem("Exit");
    	JMenuItem  Help = new JMenuItem("Help");
    	
    	 m1.add(AddNew);
  	   m1.add(Search);
  	   m1.add(Display);
  	   m1.add(Delete);
  	   m1.add(Modify);

  	   m2.add(Exit);
  	   m3.add(Help);

  	   menu.add(m1);
  	   menu.add(m2);
  	   menu.add(m3);
  	

	   panel.add(menu);
	   getContentPane().add(panel);
      
    }

    class MyPanel extends JPanel {

        MyPanel(String title,String desc) {
        
            setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    		//this.setBackground(Color.WHITE);
            this.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
           this.setBorder(new EmptyBorder(10, 10, 10, 10));
         
    		JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
    		titleLabel.setForeground(Color.DARK_GRAY);
    		titleLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
    		add(titleLabel, BorderLayout.PAGE_START);
    		JLabel descLabel = new JLabel("<html>"+desc);
    		descLabel.setForeground(Color.GRAY);
    		descLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
    		add(descLabel);  
    		   JLabel picLabel = new JLabel(new ImageIcon(Home.class.getResource("/it/polimi/icon/party.jpg")));
    		   picLabel.setIconTextGap(-310);
    		   picLabel.setOpaque(true);
    		   picLabel.setLayout(null);
       		add(picLabel);
       		picLabel.setText("<html><font color='white' size='4'><b>"+desc+"</b></font></html>");

         setVisible(true);
       		
    		JButton btnDetails = new JButton("Dettagli");
    		btnDetails.setBounds(130, 11, 163, 44);
    		btnDetails.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
    		btnDetails.setForeground(Color.DARK_GRAY);
    		btnDetails.setBackground(Color.RED);
    		btnDetails.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent arg0) {
    			}
    		});
            add(btnDetails,BorderLayout.PAGE_END);
        
           
        }
    }

    public static void main(String[] args) {
    	{
			//Set Look & Feel
			try {
				javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
        SwingUtilities.invokeLater(() -> new prv());
    }
}