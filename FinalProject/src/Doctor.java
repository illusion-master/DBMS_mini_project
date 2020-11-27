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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*; 

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class MyFrame8 extends JFrame implements ActionListener { 
	  
    // Components of the Form 
    private Container c; 
    private JButton a1;
    private JTextArea a2;
    private JTextField t1;
    private JLabel j1;


    public MyFrame8() 
    { 
        setTitle("Appointment Database"); 
        setBounds(300, 90, 700, 700); 
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE); 
        setResizable(true); 
  
        BufferedImage img = null;
		try {
			img = ImageIO.read(new File("C:/Users/Aboli/Desktop/TE/imgs/a9.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        JLabel background = new JLabel(new ImageIcon(img));
        background.setSize(1000,1000);
        
        setContentPane(background);
        setLayout(null);
        
        /////////////////////////////////////////////////////////
        
        a1 = new JButton("View Appointments"); 
        a1.setFont(new Font("Arial", Font.PLAIN, 30)); 
        a1.setSize(300, 40); 
        a1.setLocation(700, 200); 
        a1.setBackground(Color.white); 
        a1.setForeground(Color.darkGray);
       
        a1.addActionListener(this); 
        add(a1); 
        
        j1 = new JLabel("Enter Doctor Id"); 
        j1.setFont(new Font("Arial", Font.PLAIN, 30)); 
        j1.setSize(300, 40); 
        j1.setLocation(500, 100); 
        j1.setBackground(Color.darkGray); 
        j1.setForeground(Color.white);
        add(j1); 
        
        t1 = new JTextField(); 
        t1.setFont(new Font("Arial", Font.PLAIN, 30)); 
        t1.setSize(300, 40); 
        t1.setLocation(1000, 100); 
        t1.setBackground(Color.white); 
        t1.setForeground(Color.darkGray);
        t1.addActionListener(this); 
        add(t1); 
  
        a2 = new JTextArea(); 
        a2.setFont(new Font("Arial", Font.PLAIN, 20)); 
        a2.setSize(700, 600); 
        a2.setLocation(500, 300);  
        a2.setBackground(Color.darkGray); 
        a2.setForeground(Color.WHITE);
        add(a2);
        
        setVisible(true); 
        
    }
        
        public void actionPerformed(ActionEvent e) 
        { 
        	
        	if (e.getSource() == a1) 
            {
        		
        		a2.append("\nPatient Id\tDate\tTime");
        		try 
				{
					
        				int id = Integer.parseInt(t1.getText());
				        String url = "jdbc:mysql://localhost/medical";
				        Connection conn = DriverManager.getConnection(url,"root","root");
				        Statement stmt = conn.createStatement();
				        ResultSet rs;

				        rs = stmt.executeQuery("SELECT patient_id, date, time FROM appointment WHERE  appointment_id IN (SELECT appointment_id FROM appointment WHERE doctor_id ='"  + id + "');");
				        while ( rs.next() )
				        {
				        	
				        	String p = rs.getString("patient_id");
				        	String s = rs.getString("date");
				        	String t = rs.getString("time");
				        	a2.append("\n"+ p + "\t" + s + "\t" + t);
				        }
				        conn.close();
				} 
				catch (Exception e7) 
				{
				
				}
        		 
            }
        	
        	
        	
        }
        
        
    }


class MyFrame9 extends JFrame implements ActionListener { 
	  
    // Components of the Form 
    private Container c; 
  

    private JTextArea a2;
    private JLabel a1;
    private JTextField t1;
    private JButton sub;
    private JButton reset;


    public MyFrame9() 
    { 
  	
    	
        setTitle("Runway Operations"); 
        setBounds(300, 90, 1000, 1000); 
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE); 
      
    	
    	setResizable(true); 
    	  
        BufferedImage img = null;
		try {
			img = ImageIO.read(new File("C:/Users/Aboli/Desktop/TE/imgs/n1.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        JLabel background = new JLabel(new ImageIcon(img));
        background.setSize(1000,1000);
        
        setContentPane(background);
        setLayout(null);
    	/////////////////////////////////////////////////////////
        a1 = new JLabel("Enter Doctor Id: "); 
        a1.setFont(new Font("Arial", Font.PLAIN, 30)); 
        a1.setSize(300,50); 
        a1.setLocation(400, 100); 
        a1.setBackground(Color.BLACK ); 
        a1.setForeground(Color.WHITE);
        add(a1);
        
        t1 = new JTextField(); 
        t1.setFont(new Font("Arial", Font.PLAIN, 30)); 
        t1.setSize(300,50); 
        t1.setLocation(1200, 100); 
        t1.setBackground(Color.BLACK ); 
        t1.setForeground(Color.WHITE);
        add(t1);
        
        a2 = new JTextArea(); 
        a2.setFont(new Font("Arial", Font.PLAIN, 30)); 
        a2.setSize(600,600); 
        a2.setLocation(700, 200); 
        a2.setBackground(Color.BLACK ); 
        a2.setForeground(Color.WHITE);
        add(a2);
        
        sub = new JButton("Submit"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 30)); 
        sub.setSize(300, 50); 
        sub.setLocation(400, 850); 
        sub.addActionListener(this); 
        add(sub); 
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 30)); 
        reset.setSize(300, 50); 
        reset.setLocation(1200, 850); 
        reset.addActionListener(this); 
        add(reset);
        
        
        
        
        setVisible(true); 
        
    }
        
        public void actionPerformed(ActionEvent e) 
        { 
        	
        	
        	a2.append("\nPatient Id\tCategory");
        	if (e.getSource() == sub) 
            {
        		
        		int idi = Integer.parseInt(t1.getText());
        		try {
                    String url = "jdbc:mysql://localhost/medical";
                    Connection conn = DriverManager.getConnection(url,"root","root");
                    Statement stmt = conn.createStatement();
                    ResultSet rs;
         
                    rs = stmt.executeQuery("SELECT patient.patient_id, patientLevel(age) FROM appointment inner join patient on appointment.patient_id=patient.patient_id  where doctor_id ='" + idi + "';");	
                    while ( rs.next() ) {
                    	String id = rs.getString("patient_id");
                    	String category = rs.getString("patientLevel(age)");
                        a2.append("\n" + id + "\t" + category);
                    	
                        
                    }
                    conn.close();
                } catch (Exception e3) {
                    System.err.println("Got an exception! ");
                    System.err.println(e3.getMessage());
                }
        		
       							
       						
       			}
               
        
        
        
        
        	}
     
        
        
       	     
        
       
        
        
    }





















































class MyFrame7 extends JFrame implements ActionListener { 
	  
    // Components of the Form 
    private Container c; 
    private JButton a1;
    private JButton a2;
    private JButton a3;

    public MyFrame7() 
    { 
        setTitle("Employee Portal"); 
        setBounds(300, 90, 700, 700); 
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE); 
        setResizable(true); 
        
        BufferedImage img = null;
		try {
			img = ImageIO.read(new File("C:/Users/Aboli/Desktop/TE/imgs/o1.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        JLabel background = new JLabel(new ImageIcon(img));
        background.setSize(1000,1000);
        
        setContentPane(background);
        setLayout(null);
        
 
        
        
        
        
        /////////////////////////////////////////////////////////
        
        a1 = new JButton("Upcoming appointments "); 
        a1.setFont(new Font("Arial", Font.PLAIN, 40)); 
        a1.setSize(500, 200); 
        a1.setLocation(400, 150); 
        a1.addActionListener(this); 
        a1.setBackground(Color.BLACK);
        a1.setForeground(Color.WHITE);
        add(a1); 
  
        a2 = new JButton("Patient Statistics"); 
        a2.setFont(new Font("Arial", Font.PLAIN, 40)); 
        a2.setSize(500, 200); 
        a2.setLocation(1100, 150); 
        a2.addActionListener(this);
        a2.setBackground(Color.BLACK);
        a2.setForeground(Color.WHITE);
        add(a2);
        
        a3 = new JButton("Medical Queries"); 
        a3.setFont(new Font("Arial", Font.PLAIN, 40)); 
        a3.setSize(500, 200); 
        a3.setLocation(750, 400); 
        a3.addActionListener(this);
        a3.setBackground(Color.BLACK);
        a3.setForeground(Color.WHITE);
        add(a3);
        
        setVisible(true); 
        
    }
        
        public void actionPerformed(ActionEvent e) 
        { 
        	
        	if (e.getSource() == a1) 
            {
        		MyFrame8 f = new MyFrame8();
            }
        	
        	if (e.getSource() == a2) 
            {
        		MyFrame9 f = new MyFrame9();
            }
        	if (e.getSource() == a3) 
            {
        		MyFramey f = new MyFramey();
            }
        	
        }
        
        
    }

class MyFramey extends JFrame implements ActionListener { 
	  
    // Components of the Form 
    private Container c; 
    private JTextArea a;

    public MyFramey() 
    { 
        setTitle("Employee Portal"); 
        setBounds(300, 90, 700, 700); 
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE); 
        setResizable(true); 
        
        BufferedImage img = null;
		try {
			img = ImageIO.read(new File("C:/Users/Aboli/Desktop/TE/imgs/q9.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        JLabel background = new JLabel(new ImageIcon(img));
        background.setSize(1000,1000);
        
        setContentPane(background);
        setLayout(null);
        
 
        
        
        
        
        /////////////////////////////////////////////////////////
        
        a = new JTextArea(); 
        a.setFont(new Font("Arial", Font.PLAIN, 20)); 
        a.setSize(700, 600); 
        a.setLocation(300, 200); 
        a.setBackground(Color.DARK_GRAY);
        a.setForeground(Color.WHITE);
        add(a); 
        
        a.append("\nMedical Queries\n");
  
        
        try {
            String url = "jdbc:mysql://localhost/medical";
            Connection conn = DriverManager.getConnection(url,"root","root");
            Statement stmt = conn.createStatement();
            ResultSet rs;
 
            rs = stmt.executeQuery("SELECT query_text FROM chatbot UNION SELECT ailments FROM patient;");	
            while ( rs.next() ) {
            	String id = rs.getString("query_text");
                a.append("\n" + id );
            	
                
            }
            conn.close();
        } catch (Exception e3) {
            System.err.println("Got an exception! ");
            System.err.println(e3.getMessage());
        }
        
       
        
        setVisible(true); 
        
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
        
      
        
        
    }










class Flight
{
	
	public int priority;			 // Airport employee can assign flight priority
	public String status;            //Eg. In hangar or On Runway or Departing or Landing
	public String destination_code;  //Eg. LAX or PNX
	public String source_code;       //Eg. LAX or PNX
	public int fuel;                 // Current fuel situation
	public int flight_code;       // The special code that each flight is assigned like F1007
	public String airline;           // Eg. Indigo or AirIndia
	public String date_of_departure;
	public String date_of_arrival;
	public String time_of_departure;
	public String time_of_arrival;
	
	public void Flight()
	{
		priority = 0;
		status = "In hangar";
		flight_code = 0;       
		airline = "XYZ";          
		date_of_departure = "2020-20-20";
		date_of_arrival = "2020-20-20";
		time_of_departure = "00:00:00";
		time_of_arrival = "00:00:00";
		destination_code = "ABC";  
		source_code = "ABC"; 
		fuel = 5;
	}




}

public class Doctor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		MyFrame7 f = new MyFrame7();
		
		}
		

	
	
	
	
		
		
		
	}



