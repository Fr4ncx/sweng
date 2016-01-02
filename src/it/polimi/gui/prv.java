package it.polimi.gui;

import java.awt.*;
import java.sql.SQLException;

import javax.swing.*;
import it.polimi.*;

public class prv extends JFrame {

    prv() {
    	
		
        getContentPane().setLayout(new FlowLayout());
        Database db = new Database();
       
        try {
			for (progetto p : db.getProject())
			    getContentPane().add(new MyPanel(p.getNome(),p.getDesc()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    class MyPanel extends JPanel {

        MyPanel(String title,String desc) {
        
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            add(new JLabel(title, SwingConstants.CENTER));
            add(new JLabel(desc));
            add(new JButton("Details"));
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