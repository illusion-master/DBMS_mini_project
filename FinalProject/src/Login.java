import java.awt.Container;


import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import java.util.concurrent.*; 

import javax.swing.*; 

import java.awt.*; 
import java.awt.event.*; 
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*; 
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;



class MyFrame4 extends JFrame implements ActionListener { 
	  
    // Components of the Form 
    private Container c; 
    private JButton a1;
    private JButton a2;
    private JButton a3;
    private JButton a4;
    private JLabel a;
    
    private JLabel b1;
    private JLabel b;
    private JTextField b2;
    private JLabel b3;
    private JPasswordField b4;
    private JTextField b5;
    
    private String username;
    private String password;
    
    
    public MyFrame4() throws IOException 
		    { 
    	
    	
    	
    	
        setTitle("BayMax Clinic"); 
   
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE); 
        setBounds(300,90,1000,1000);
        setResizable(true); 
        
        
        
        BufferedImage img = ImageIO.read(new File("C:/Users/Aboli/Desktop/TE/imgs/r3.jpg"));
        JLabel background = new JLabel(new ImageIcon(img));
        background.setSize(1000,1000);
        
        setContentPane(background);
        setLayout(null);
        
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        
        b = new JLabel("Welcome to  the BayMax Clinic!"); 
        b.setFont(new Font("Arial", Font.BOLD, 60)); 
        b.setSize(1200, 200); 
        b.setLocation(500, 20);
        b.setForeground(Color.BLACK);
        add(b);
        
        b1 = new JLabel("Username"); 
        b1.setFont(new Font("Arial", Font.PLAIN, 20)); 
        b1.setSize(300, 40); 
        b1.setLocation(700, 400);

        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        //id.setForeground(Color.WHITE);
        add(b1); 
  
        b2 = new JTextField(); 
        b2.setFont(new Font("Arial", Font.PLAIN, 20)); 
        b2.setSize(300, 40); 
        b2.setLocation(900, 400); 

        b2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        add(b2); 
        
        b3 = new JLabel("Password"); 
        b3.setFont(new Font("Arial", Font.PLAIN, 20)); 
        b3.setSize(300, 40); 
        b3.setLocation(700, 500);
        b3.setBackground(Color.WHITE);
        b3.setForeground(Color.BLACK);
        add(b3); 
  
        b4 = new JPasswordField(); 
        b4.setFont(new Font("Arial", Font.PLAIN, 20)); 
        b4.setSize(300, 40); 
        b4.setLocation(900, 500); 
        b4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
     
        add(b4); 
       
        
        b5 = new JTextField(); 
        b5.setFont(new Font("Arial", Font.PLAIN, 20)); 
        b5.setSize(500, 100); 
        b5.setLocation(700, 600); 
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        add(b5); 
        
        a1 = new JButton("Sign In"); 
        a1.setBounds(1400,200,200,100);
        a1.setBackground(Color.yellow); 
        a1.setForeground(Color.BLACK);
        a1.setFont(new Font("Arial", Font.PLAIN, 30));
        a1.setOpaque(true);
        a1.addActionListener(this); 
        a1.setBorder(border);
        add(a1);
        
        a2 = new JButton("Sign Up"); 
        a2.setBounds(1400,400,200,100);
        a2.setBackground(Color.MAGENTA); 
        a2.setForeground(Color.BLACK);
        a2.setFont(new Font("Arial", Font.PLAIN, 30));
        a2.setOpaque(true);
        a2.addActionListener(this); 
        a2.setBorder(border);
        add(a2);
        
        a3 = new JButton("Reset"); 
        a3.setBounds(1400,600,200,100);
        a3.setBackground(Color.green); 
        a3.setForeground(Color.BLACK);
        a3.setFont(new Font("Arial", Font.PLAIN, 30));
        a3.setOpaque(true);
        a3.addActionListener(this); 
        a3.setBorder(border);
        add(a3);
        
        a4 = new JButton("Guidelines"); 
        a4.setBounds(1400,800,200,100);
        a4.setBackground(Color.RED); 
        a4.setForeground(Color.BLACK);
        a4.setFont(new Font("Arial", Font.PLAIN, 30));
        a4.setOpaque(true);
        a4.addActionListener(this); 
        a4.setBorder(border);
        add(a4);
 
        setVisible(true);

    	
    
    } 
    
    
    public void actionPerformed(ActionEvent e) 
    { 
        if (e.getSource() == a1) 
        	
        {
        	username = b2.getText();
        	password = b4.getText();
        	String s = null;
        	
        	try 
    		{
    				String url = "jdbc:mysql://localhost/medical";		
    		        Connection conn = DriverManager.getConnection(url,"root","root");
    		        Statement stmt = conn.createStatement();
    		        ResultSet rs;
    		        rs = stmt.executeQuery("SELECT * FROM users where Username='" + username + "';");
    		        while ( rs.next() )
    		        {
    		        	s = rs.getString("password");
    		            
    	            
    		        }
    		        conn.close();
    		} 
    		catch (Exception e2) 
    		{
    		       
    		        System.err.println(e2.getMessage());
    	    }	
        	
        	if (password.equalsIgnoreCase("admin") &&  password.equalsIgnoreCase(s))
        	{
        	
        		b5.setText("Admin Succesfully Logged In");
	        	Admin aut = new Admin(); 
	        	try 
	        	{
					aut.main(new String[0]);
				} catch (InterruptedException e1) 
	        	{
			
					e1.printStackTrace();
				}
        	}
        	
        	else if (password.equalsIgnoreCase("doctor") &&  password.equalsIgnoreCase(s))
        	{
        		b5.setText("Doctor Succesfully Logged In");
        		Doctor emp = new Doctor(); 
        		emp.main(new String[0]);
        	}
        	
        	else if (password.equalsIgnoreCase("patient") &&  password.equalsIgnoreCase(s))
        	{
        	
        		b5.setText("Patient Succesfully Logged In");
        		Patient pas = new Patient(); try {
    				pas.main(new String[0]);
    			} catch (IOException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
        	}
        	else
        	{
        		
        		b5.setText("Invalid credentials");
        	}
    
        
        
       
        
        
        }
        
        if (e.getSource() == a2) 
        {
        	
        	username = b2.getText();
        	password = b4.getText();
        	String s = null;
        	try 
    		{
    				String url = "jdbc:mysql://localhost/medical";		
    		        Connection conn = DriverManager.getConnection(url,"root","root");
    		        Statement stmt = conn.createStatement();
    		        Statement stmt1 = conn.createStatement();
    		        
    		        ResultSet rs;
    		        rs = stmt.executeQuery("SELECT * FROM users where Username='" + username + "';");
    		        if( rs.next())
    		        {
    		        	b5.setText("User already exists.");
    		                	            
    		        }
    		        else
    		        {
    		        	
    		        	stmt1.executeUpdate("insert into users values (null,'" + username +  "','" + password + "');");
    		        	b5.setText("New user account created.");
    		        }
    		        conn.close();
    		} 
    		catch (Exception e2) 
    		{
    		       
    		        System.err.println(e2.getMessage());
    	    }	
        	
        	
        }
        
        
        
        if (e.getSource() == a3) 
        {
        	
        	String def = ""; 
            
            b2.setText(def);
            b5.setText(def);
            b4.setText(def);
        	
        	
        }
        
        if(e.getSource() == a4)
        {
        	guidelines g = new guidelines(); try {
				g.main(new String[0]);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
       
    
    }
    
    
    
    
}


public class Login {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		MyFrame4 f = new MyFrame4();

	}

}


