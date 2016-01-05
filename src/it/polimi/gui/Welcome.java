package it.polimi.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import it.polimi.*;
import it.polimi.gui.prv.MyPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import it.polimi.*;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;

public class Welcome extends JFrame implements ActionListener  {
	private JFrame f;
	private Database db;
	private JPanel pan5;
	
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
	Welcome(String user) throws SQLException, IOException {
	
		Panel panel_1;
		JLabel lblNewLabel_1;
		JLabel lblNewLabel_2;
		JButton btnNewButton_2;
		JLabel label ;
		JLabel label_1;
		JLabel label_2;
		f = new JFrame("Social Planner");
		
	    f.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    
		JPanel pan1 = new JPanel();
		pan1.setLayout(new BorderLayout());
		//pan1.setBackground(Color.GREEN);
		
		JPanel pan2 = new JPanel();
		//pan2.setBackground(Color.ORANGE);
		JPanel pan3 = new JPanel();
		pan3.setBackground(Color.BLUE);
		JPanel pan4 = new JPanel();
		pan4.setBackground(Color.BLUE);
		pan5 = new JPanel();
		
		JPanel textPanel = new JPanel();
        textPanel.setPreferredSize(new Dimension(240, 180));
        pan1.add(textPanel,BorderLayout.CENTER);
        
       JLabel usernameLabel = new JLabel("Progetti amministrati");
        textPanel.add(usernameLabel);
	
		JButton jb3 = new JButton("Profilo");
		jb3.setSize(50, 50);
		pan3.add(jb3);
		JButton contact = new JButton("Contatti");
		contact.setSize(50, 50);
		pan3.add(contact);
		JButton logout = new JButton("Esci");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				f.dispose();
				new Home();
			}
		});
		
		logout.setSize(50, 50);
		pan3.add(logout);
		JButton jb4 = new JButton("Crea Progetto");
		jb4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateProject dialog = new CreateProject();
			    dialog.setModal(true);
			    dialog.setVisible(true);
			}
		});
		
		
		
		jb4.setSize(50, 50);
		pan4.add(jb4);
		/*JButton jb5 = new JButton("Center");
		jb.setSize(50, 50);
		pan5.add(jb5);*/
		JScrollPane scroll = new JScrollPane(pan5,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		f.getContentPane().add(pan1,BorderLayout.WEST);
		f.getContentPane().add(pan2,BorderLayout.EAST);
		
		JPanel panel = new JPanel();
		pan2.add(panel);
		panel.setLayout(null);
		
		JPanel panelEast = new JPanel();
		panelEast.setPreferredSize(new Dimension(250, 320));
        pan2.add(panelEast,BorderLayout.CENTER);
		panelEast.setLayout(null);
        
		JLabel lblNewLabel = new JLabel("Notifiche");
		lblNewLabel.setBounds(104, 5, 42, 14);
		panelEast.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("I tuoi contatti sono stati sincronizzati");
		lblNewLabel_3.setIcon(new ImageIcon(Welcome.class.getResource("/it/polimi/icon/contact.png")));
		lblNewLabel_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel_3.setBounds(0, 81, 250, 52);
		panelEast.add(lblNewLabel_3);
		
		JLabel label_3 = new JLabel("Il progetto Ing. del Software \u00E8 stato avviato");
		label_3.setIcon(new ImageIcon(Welcome.class.getResource("/it/polimi/icon/verified.png")));
		label_3.setBounds(new Rectangle(4, 0, 0, 0));
		label_3.setAlignmentY(Component.TOP_ALIGNMENT);
		label_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label_3.setBounds(0, 30, 250, 52);
		panelEast.add(label_3);
		f.getContentPane().add(pan3,BorderLayout.NORTH);
		f.getContentPane().add(pan4,BorderLayout.SOUTH);
		f.getContentPane().add(scroll,BorderLayout.CENTER);
		
		db = new Database();
	       
	        try {
				for (progetto p : db.getProject()){
					MyPanel p1 = new MyPanel(p.getId(),p.getNome(),p.getDesc(),p.getCat());
				    pan5.add(p1,new BoxLayout(p1, BoxLayout.X_AXIS));
				   // getContentPane().add(new MyPanel(p.getNome(),p.getDesc()));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		f.setVisible(true);
		
		
      
	}
	 class MyPanel extends JPanel {

	        MyPanel(Integer id,String title,String desc,String cat) {
	        
	            setLayout(new BorderLayout());
	    		//this.setBackground(Color.WHITE);
	            this.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	            this.setBorder(new EmptyBorder(10, 10, 10, 10));
	            JPanel labelPanel = new JPanel(new BorderLayout());
	    		JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
	    		titleLabel.setForeground(Color.DARK_GRAY);
	    		titleLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
	    		labelPanel.add(titleLabel, BorderLayout.NORTH);
	    		JLabel descLabel = new JLabel("<html>Francesco Tria",SwingConstants.CENTER);
	    		descLabel.setForeground(Color.GRAY);
	    		descLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
	    		labelPanel.add(descLabel, BorderLayout.SOUTH);  
	    		add(labelPanel,BorderLayout.NORTH);
	    		JLabel descLabel2 = new JLabel("<html>"+desc);
	    		descLabel2.setForeground(Color.GRAY);
	    		descLabel2.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
	    		add(descLabel2);
	    		   JLabel picLabel = new JLabel(new ImageIcon(Home.class.getResource("/it/polimi/icon/"+cat)));
	    		   picLabel.setIconTextGap(-310);
	    		   picLabel.setOpaque(true);
	    		   picLabel.setLayout(null);
	       		add(picLabel, BorderLayout.CENTER);
	       		picLabel.setText("<html><font color='white' size='4'><b></b></font></html>");

	       		JPanel buttonPanel = new JPanel();
	           buttonPanel.setPreferredSize(new Dimension(50,40));
	       		ButtonGroup group = new ButtonGroup();
	       		
	    		JButton btnDetails = new JButton("Dettagli");
	    		//btnDetails.setBounds(130, 11, 393, 44);
	    		btnDetails.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
	    		btnDetails.setForeground(Color.DARK_GRAY);
	    		btnDetails.setBackground(Color.GREEN);
	    		btnDetails.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent arg0) {
	    			}
	    		});
	    		JButton btnDetails2 = new JButton("Modifica");
	    		btnDetails2.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
	    		btnDetails2.setForeground(Color.DARK_GRAY);
	    		btnDetails2.setBackground(Color.BLUE);
	    		btnDetails2.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent arg0) {
	    				ModifyProject dialogMod = new ModifyProject(id,title,desc);
	    				dialogMod.setModal(true);
	    			    dialogMod.setVisible(true);
	    			}
	    		});
	    		
	    		JButton btnDetails3 = new JButton("Elimina");
	    		btnDetails3.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
	    		btnDetails3.setForeground(Color.DARK_GRAY);
	    		btnDetails3.setBackground(Color.RED);
	    		btnDetails3.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent arg0) {
	    				setVisible(false);
	    				try {
							db.deleteProject(id);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	    			}
	    		});
	            group.add(btnDetails);
	            group.add(btnDetails2);
	            group.add(btnDetails3);
	            buttonPanel.add(btnDetails);
	            buttonPanel.add(btnDetails2);
	            buttonPanel.add(btnDetails3);
	            add(buttonPanel, BorderLayout.SOUTH);
	            setVisible(true);
	        }
	    }
	 /*
	  * Class for creating project
	  */
	 private class CreateProject extends JDialog implements ActionListener
	  {
	    private JButton okButton = new JButton("OK");
	 
	    private CreateProject()
	    {
	      super(f, "Creazione Progetto", true);

	    	getContentPane().setLayout(null);
	    	
	    	JLabel lblTitolo = new JLabel("Titolo");
	    	lblTitolo.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
	    	lblTitolo.setBounds(10, 11, 46, 14);
	    	getContentPane().add(lblTitolo);
	    	
	    	JTextField textField = new JTextField();
	    	textField.setBounds(10, 29, 203, 20);
	    	getContentPane().add(textField);
	    	textField.setColumns(10);
	    	
	    	JLabel lblDescrizione = new JLabel("Descrizione");
	    	lblDescrizione.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
	    	lblDescrizione.setBounds(10, 60, 79, 14);
	    	getContentPane().add(lblDescrizione);
	    	
	    	JTextField textField_1 = new JTextField();
	    	textField_1.setBounds(10, 80, 203, 140);
	    	getContentPane().add(textField_1);
	    	textField_1.setColumns(10);
	    	JButton btnSalvaEdAvvia = new JButton("Salva ed avvia");
	    	btnSalvaEdAvvia.setBounds(10, 231, 103, 23);
	    	getContentPane().add(btnSalvaEdAvvia);
	    	
	    	JLabel lblCategoria = new JLabel("Categoria");
	    	lblCategoria.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
	    	lblCategoria.setBounds(263, 11, 73, 14);
	    	getContentPane().add(lblCategoria);
	    	
	    	JComboBox comboBox = new JComboBox();
	    	comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sport", "Lavoro", "Party"}));
	    	comboBox.setBounds(246, 29, 108, 20);
	    	getContentPane().add(comboBox);
	    	
	    	JLabel label = new JLabel("Partecipanti");
	        JCheckBox a = new JCheckBox("Francesco Tria");
	        JCheckBox b = new JCheckBox("Francesco Succi");
	        JCheckBox c = new JCheckBox("Luigi Provenzano");
	        JCheckBox d = new JCheckBox("Lorenzo Neri");
	        JCheckBox e = new JCheckBox("Alessandro Brigandì");
	        JCheckBox f = new JCheckBox("Alessandro Brigandì");
	        JCheckBox g = new JCheckBox("Alessandro Brigandì");

	        Box box = Box.createVerticalBox();

	        box.add(label);
	        box.add(a);
	        box.add(b);
	        box.add(c);
	        box.add(d);
	        box.add(e);
	        box.add(f);
	        box.add(g);

	        JScrollPane jscrlpBox = new JScrollPane(box);
	        jscrlpBox.setPreferredSize(new Dimension(140, 90));
	        jscrlpBox.setBounds(240, 80, 149, 140);
	        getContentPane().add(jscrlpBox);
	    
	      setPreferredSize(new Dimension(500, 350));
	      pack();
	      setLocationRelativeTo(f);
	    }
	 
	    public void actionPerformed(ActionEvent ev)
	    {
	      setVisible(false);
	    }
	  }
	 
	 /*
	  * Class for creating project
	  */
	 private class ModifyProject extends JDialog implements ActionListener
	  {
	    private JButton okButton = new JButton("OK");
	 
	    private ModifyProject(Integer id,String title,String desc)
	    {
	      super(f, "Modifica Progetto", true);

	    	getContentPane().setLayout(null);
	    	
	    	JLabel lblTitolo = new JLabel("Titolo");
	    	lblTitolo.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
	    	lblTitolo.setBounds(10, 11, 46, 14);
	    	getContentPane().add(lblTitolo);
	    	
	    	JTextField textField = new JTextField();
	    	textField.setText(title);
	    	textField.setBounds(10, 29, 203, 20);
	    	getContentPane().add(textField);
	    	textField.setColumns(10);
	    	
	    	JLabel lblDescrizione = new JLabel("Descrizione");
	    	lblDescrizione.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
	    	lblDescrizione.setBounds(10, 60, 79, 14);
	    	getContentPane().add(lblDescrizione);
	    	
	    	JTextField textField_1 = new JTextField();
	    	textField_1.setText(desc);
	    	textField_1.setBounds(10, 80, 203, 140);
	    	getContentPane().add(textField_1);
	    	textField_1.setColumns(10);
	    	JButton btnSalvaEdAvvia = new JButton("Salva ed avvia");
	    	btnSalvaEdAvvia.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent arg0) {
    				
    				 try {
    						for (progetto p : db.getProject()){
    							if(p.getId()==id){
    								p.modifyNome(textField.getText());
    								setVisible(false);
    							}
    						}
    					} catch (SQLException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
    			}
    		});
	    	  
	    	btnSalvaEdAvvia.setBounds(10, 231, 103, 23);
	    	getContentPane().add(btnSalvaEdAvvia);
	    	
	    	JLabel lblCategoria = new JLabel("Categoria");
	    	lblCategoria.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
	    	lblCategoria.setBounds(263, 11, 73, 14);
	    	getContentPane().add(lblCategoria);
	    	
	    	JComboBox comboBox = new JComboBox();
	    	comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sport", "Lavoro", "Party"}));
	    	comboBox.setBounds(246, 29, 108, 20);
	    	getContentPane().add(comboBox);
	    	
	    	JLabel label = new JLabel("Partecipanti");
	        JCheckBox a = new JCheckBox("Francesco Tria");
	        JCheckBox b = new JCheckBox("Francesco Succi");
	        JCheckBox c = new JCheckBox("Luigi Provenzano");
	        JCheckBox d = new JCheckBox("Lorenzo Neri");
	        JCheckBox e = new JCheckBox("Alessandro Brigandì");
	        JCheckBox f = new JCheckBox("Alessandro Brigandì");
	        JCheckBox g = new JCheckBox("Alessandro Brigandì");

	        Box box = Box.createVerticalBox();

	        box.add(label);
	        box.add(a);
	        box.add(b);
	        box.add(c);
	        box.add(d);
	        box.add(e);
	        box.add(f);
	        box.add(g);

	        JScrollPane jscrlpBox = new JScrollPane(box);
	        jscrlpBox.setPreferredSize(new Dimension(140, 90));
	        jscrlpBox.setBounds(240, 80, 149, 140);
	        getContentPane().add(jscrlpBox);
	    
	      setPreferredSize(new Dimension(500, 350));
	      pack();
	      setLocationRelativeTo(f);
	    }
	 
	    public void actionPerformed(ActionEvent ev)
	    {
	      setVisible(false);
	    }
	  }
}
