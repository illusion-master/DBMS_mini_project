
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;





class MyFrame6 extends JFrame implements ActionListener { 
	  
    // Components of the Form 
    private Container c; 
    private JButton a1;
    private JButton a2;
    private JButton a3;
    private static JTextArea src1;
    private JTextArea src3;
    private JTextField a7;
    
    
    public MyFrame6() 
    { 
        setTitle("Flight Booking Portal"); 
        setBounds(300, 90, 700, 700); 
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE); 
        setResizable(true); 
  	  
        BufferedImage img = null;
		try {
			img = ImageIO.read(new File("C:/Users/Aboli/Desktop/TE/imgs/pq.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        JLabel background = new JLabel(new ImageIcon(img));
        background.setSize(1000,1000);
        
        setContentPane(background);
        setLayout(null);
        
        
        
        
        /////////////////////////////////////////////////////////
        
        a1 = new JButton("See cancellations"); 
        a1.setFont(new Font("Arial", Font.BOLD, 20)); 
        a1.setSize(220, 60); 
        a1.setLocation(530, 30); 
        a1.setBackground(Color.GREEN ); 
        a1.setForeground(Color.BLACK);
        a1.addActionListener(this); 
        add(a1); 
  
        a2 = new JButton("Search Disease"); 
        a2.setFont(new Font("Arial", Font.BOLD, 20)); 
        a2.setSize(220, 60); 
        a2.setLocation(830, 30); 
        a2.setBackground(Color.GREEN ); 
        a2.setForeground(Color.BLACK);
        a2.addActionListener(this); 
        add(a2);
        
        a7 = new JTextField("Id"); 
        a7.setFont(new Font("Arial", Font.BOLD, 20)); 
        a7.setSize(220, 60); 
        a7.setLocation(830, 100); 
        a7.setBackground(Color.BLACK); 
        a7.setForeground(Color.GREEN);
        add(a7);
        
        a3 = new JButton("Search Branch"); 
        a3.setFont(new Font("Arial", Font.BOLD, 20)); 
        a3.setSize(220, 60); 
        a3.setLocation(1130, 30); 
        a3.setBackground(Color.GREEN ); 
        a3.setForeground(Color.BLACK);
        a3.addActionListener(this); 
        add(a3);
        
        src1 = new JTextArea(); 
        src1.setFont(new Font("Arial", Font.PLAIN, 20)); 
        src1.setSize(800, 410); 
        src1.setLocation(600, 430); 
        src1.setBackground(Color.BLACK); 
        src1.setForeground(Color.GREEN);
        src1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        add(src1); 
             
        
  
        setVisible(true); 
    } 
    
    
    public void actionPerformed(ActionEvent e) 
    
    
    { 
        if (e.getSource() == a1) 
        {
        	
        	src1.append("\nAppointment id\tDate\tTime\n");
        	try 
			{
				
			        String url = "jdbc:mysql://localhost/medical";
			        Connection conn = DriverManager.getConnection(url,"root","root");
			        Statement stmt = conn.createStatement();
			        ResultSet rs;

			        rs = stmt.executeQuery("SELECT * FROM cancelled_appointment;");
			        while ( rs.next() )
			        {
			        	
			        	String p = rs.getString("appointment_id");
			        	String s = rs.getString("date");
			        	String t = rs.getString("time");
			        	src1.append("\n"+ p + "\t\t" + s + "\t" + t);
			        }
			        conn.close();
			} 
			catch (Exception e7) 
			{
			
			}
        	
        }
    
        if (e.getSource() == a2) 
        {
        	int id = Integer.parseInt(a7.getText());
        	src1.append("\nAilment\n");
        	try 
			{
				
			        String url = "jdbc:mysql://localhost/medical";
			        Connection conn = DriverManager.getConnection(url,"root","root");
			        Statement stmt = conn.createStatement();
			        ResultSet rs;

			        rs = stmt.executeQuery("call curdemo('" + id + "');");
			        
			        while ( rs.next() )
			        {
			        	
			        	String p = rs.getString("ail");
			        	src1.append("\n"+ p);
			        }
			        conn.close();
			} 
			catch (Exception e7) 
			{
			
			}
									
				
        }
        
        if (e.getSource() == a3) 
        {
        	
        	int id = Integer.parseInt(a7.getText());
        	src1.append("\nBranch\n");
        	try 
			{
				
			        String url = "jdbc:mysql://localhost/medical";
			        Connection conn = DriverManager.getConnection(url,"root","root");
			        Statement stmt = conn.createStatement();
			        ResultSet rs;

			        rs = stmt.executeQuery("select medic(doctor_id) as med from doctor where doctor_id='" + id + "';");
			        
			        while ( rs.next() )
			        {
			        	
			        	String p = rs.getString("med");
			        	src1.append("\n"+ p);
			        }
			        conn.close();
			} 
			catch (Exception e7) 
			{
			
			}
					
        
        }
        
        
      
    
    }
    
   
    
}







public class Admin {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException 
	{
	MyFrame6 f = new MyFrame6();
	}

}

