import java.sql.Connection;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.security.SecureRandom; 
import java.util.Scanner; 
  




import javax.crypto.Cipher; 
import javax.crypto.KeyGenerator; 
import javax.crypto.SecretKey; 
import javax.crypto.spec 
    .IvParameterSpec; 
import javax.xml.bind 
    .DatatypeConverter; 

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.util.concurrent.*; 

import javax.swing.*; 

import java.awt.*; 
import java.awt.event.*; 
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*; 
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import java.security 
.SecureRandom; 

import javax.crypto 
.KeyGenerator; 
import javax.crypto.SecretKey; 
import javax.xml.bind 
.DatatypeConverter; 


 
    	 

	    
class CipherSample {
	
	final static String AES 
    = "AES"; 

// We are using a Block cipher(CBC mode) 
static String AES_CIPHER_ALGORITHM  = "AES/CBC/PKCS5PADDING"; 

Scanner message; 
	
	public static SecretKey createAESKey() 
	        throws Exception 
	    { 
	        SecureRandom securerandom 
	            = new SecureRandom(); 
	        KeyGenerator keygenerator 
	            = KeyGenerator.getInstance(AES); 
	  
	        keygenerator.init(256, securerandom); 
	        SecretKey key 
	            = keygenerator.generateKey(); 
	  
	        return key; 
	    } 
	  
	    // Function to initialize a vector 
	    // with an arbitrary value 
	    public static byte[] createInitializationVector() 
	    { 
	  
	        // Used with encryption 
	        byte[] initializationVector 
	            = new byte[16]; 
	        SecureRandom secureRandom 
	            = new SecureRandom(); 
	        secureRandom.nextBytes(initializationVector); 
	        return initializationVector; 
	    } 
	  
	    // This function takes plaintext, 
	    // the key with an initialization 
	    // vector to convert plainText 
	    // into CipherText. 
	    public static byte[] do_AESEncryption( 
	        String plainText, 
	        SecretKey secretKey, 
	        byte[] initializationVector) 
	        throws Exception 
	    { 
	        Cipher cipher 
	            = Cipher.getInstance( 
	                AES_CIPHER_ALGORITHM); 
	  
	        IvParameterSpec ivParameterSpec 
	            = new IvParameterSpec( 
	                initializationVector); 
	  
	        cipher.init(Cipher.ENCRYPT_MODE, 
	                    secretKey, 
	                    ivParameterSpec); 
	  
	        return cipher.doFinal( 
	            plainText.getBytes()); 
	    } 
	  
	    // This function performs the 
	    // reverse operation of the 
	    // do_AESEncryption function. 
	    // It converts ciphertext to 
	    // the plaintext using the key. 
	    public static String do_AESDecryption( 
	        byte[] cipherText, 
	        SecretKey secretKey, 
	        byte[] initializationVector) 
	        throws Exception 
	    { 
	        Cipher cipher 
	            = Cipher.getInstance( AES_CIPHER_ALGORITHM); 
	  
	        IvParameterSpec ivParameterSpec 
	            = new IvParameterSpec( 
	                initializationVector); 
	  
	        cipher.init( 
	            Cipher.DECRYPT_MODE, 
	            secretKey, 
	            ivParameterSpec); 
	  
	        byte[] result 
	            = cipher.doFinal(cipherText); 
	  
	        return new String(result); 
	    } 
	  
	  
   
   
   
   public static String hashed(String q) throws Exception
   {
	   
	   
 
	   
	   SecretKey Symmetrickey= createAESKey(); 

   System.out.println( 
       "The Symmetric Key is :"
       + DatatypeConverter.printHexBinary( 
             Symmetrickey.getEncoded())); 

   byte[] initializationVector 
       = createInitializationVector(); 

   String plainText 
       = "This is the message "
         + "I want To Encrypt."; 

   // Encrypting the message 
   // using the symmetric key 
   byte[] cipherText 
       = do_AESEncryption(   plainText, Symmetrickey, initializationVector); 

  return (DatatypeConverter.printHexBinary(            cipherText)); 

   
	   
	   
	   
   }
}


















class MyFrame10 extends JFrame implements ActionListener { 
	  
    // Components of the Form 
    private Container c; 
    private JButton a1;
    private JButton a2;
    private JButton a3;
    private JButton a4;

    public MyFrame10() throws IOException 
    { 
        setTitle("Patient Portal"); 
        setBounds(300, 90, 700, 700); 
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        setResizable(true); 
  
      
        
        
        
        BufferedImage img = ImageIO.read(new File("C:/Users/Aboli/Desktop/TE/imgs/a1.jpg"));
        JLabel background = new JLabel(new ImageIcon(img));
        background.setSize(1000,1000);

        Border border = BorderFactory.createLineBorder(Color.WHITE);
        
        setContentPane(background);
        setLayout(null);
 
        
        
        
        
        /////////////////////////////////////////////////////////
        
        a1 = new JButton("Register"); 
        a1.setFont(new Font("Arial", Font.PLAIN, 40)); 
        a1.setBounds(50, 100 , 200 ,200); 
        a1.setBackground(Color.BLACK);
        a1.setForeground(Color.WHITE);
        a1.addActionListener(this); 
        a1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
        add(a1); 
  
        a2 = new JButton("Book"); 
        a2.setFont(new Font("Arial", Font.PLAIN, 40)); 
        a2.setBounds(300, 100 , 200 ,200);
        a2.addActionListener(this); 
        a2.setBackground(Color.BLACK);
        a2.setForeground(Color.WHITE);
        a2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
        add(a2);
        
        a3 = new JButton("Modify"); 
        a3.setFont(new Font("Arial", Font.PLAIN, 40)); 
        a3.setBounds(1400, 100 , 200 ,200);
        a3.addActionListener(this); 
        a3.setBackground(Color.BLACK);
        a3.setForeground(Color.WHITE);
        a3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
        add(a3); 
  
        a4 = new JButton("Calender"); 
        a4.setFont(new Font("Arial", Font.PLAIN, 40)); 
        a4.setBounds(1650, 100 , 200 ,200);
        a4.addActionListener(this); 
        a4.setBackground(Color.BLACK);
        a4.setForeground(Color.WHITE);
        a4.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
        add(a4);
        
        setVisible(true); 
        
    }
        
        public void actionPerformed(ActionEvent e) 
        { 
        	
        	if(e.getSource() ==a1) 
    		{
    			try {
					MyFrame f = new MyFrame();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    		}
    		
        	if(e.getSource() ==a2)
    		{
    		
    		try {
				MyFrame1 f = new MyFrame1();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		
    	    }
    		
        	if(e.getSource() ==a3) 
        	{
    		
    	     try {
				MyFrame3 f = new MyFrame3();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	    
    	    
    	    }
        	if(e.getSource() ==a4)
        	{
    		
    		
    		try {
				MyFramex f = new MyFramex();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

    	    	
        	
        	}
        
        
        }
        
}


class MyFramex extends JFrame implements ActionListener { 
	  
    // Components of the Form 
    private Container c; 
    private JButton a1;
    private JButton a6;
    private JLabel a2;
    private JTextField a3;
   

    public MyFramex() throws IOException 
    { 
        setTitle("Patient Portal"); 
        setBounds(300, 90, 700, 700); 
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        setResizable(true); 
  
      
        
        
        
        BufferedImage img = ImageIO.read(new File("C:/Users/Aboli/Desktop/TE/imgs/q3.jpg"));
        JLabel background = new JLabel(new ImageIcon(img));
        background.setSize(1000,1000);

        Border border = BorderFactory.createLineBorder(Color.WHITE);
        
        setContentPane(background);
        setLayout(null);
 
        
        a2 = new JLabel("Patient Id: "); 
        a2.setFont(new Font("Arial", Font.PLAIN, 20)); 
        a2.setForeground(Color.BLACK);
        a2.setSize(400, 40); 
        a2.setLocation(300, 440); 
        //fid.setForeground(Color.WHITE);
        add(a2); 
  
        a3 = new JTextField(); 
        a3.setFont(new Font("Arial", Font.PLAIN, 15)); 
        a3.setSize(400, 40); 
        a3.setLocation(1150, 440); 
        
        add(a3); 
        
        
        /////////////////////////////////////////////////////////
        
        a1 = new JButton("View Plan"); 
        a1.setFont(new Font("Arial", Font.PLAIN, 40)); 
        a1.setBounds(300, 600 , 400 ,200); 
        a1.setBackground(Color.BLACK);
        a1.setForeground(Color.WHITE);
        a1.addActionListener(this); 
        a1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
        add(a1); 
  
        a6 = new JButton("Talk to bot"); 
        a6.setFont(new Font("Arial", Font.PLAIN, 40)); 
        a6.setBounds(1150, 600 , 400 ,200); 
        a6.setBackground(Color.BLACK);
        a6.setForeground(Color.WHITE);
        a6.addActionListener(this); 
        a6.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
        add(a6);
        
        
        setVisible(true); 
        
    }
        
        public void actionPerformed(ActionEvent e) 
        { 
        	
        	if(e.getSource() ==a1) 
        		
        		
    		{
        		int id = Integer.parseInt(a3.getText());
    			MyFrame2 f = new MyFrame2(id);
    		}
        	if(e.getSource() ==a6) 
        		
        		
    		{
        		int id = Integer.parseInt(a3.getText());
    			try {
					MyFrameq a = new MyFrameq(id);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    		}
        
        
        
        }
        
}













  
class MyFrame extends JFrame implements ActionListener 

{ 
  
    // Components of the Form 
    private Container c; 
    private JLabel title; 
    private JLabel nameair;  
    private JLabel id; 
    private JTextField tid;
    private JTextField tname2;
    private JTextField tname3;
    private JLabel time; 
    private JLabel time1; 
    private JLabel mno; 
    private JTextField tmno; 
    private JLabel qty;
    private JComboBox qty1;
    private JLabel fid;
    private JTextField tfid;
    private JLabel ch;
    private JTextField choice;
    private JLabel dod;
    private JLabel doa;
    private JLabel ticket;
    private JComboBox price;
    private JComboBox date; 
    private JComboBox month; 
    private JComboBox year; 
    private JComboBox date1; 
    private JComboBox month1; 
    private JComboBox year1; 
    private JTextField airline1; 
    private JButton sub; 
    private JButton reset; 
    private JLabel dest; 
    private JTextField dest1; 
    private JTextArea dets; 
    private JLabel src; 
    private JTextField src1; 
    private JLabel res;
    private JRadioButton j1; 
    private JRadioButton j2;
    private ButtonGroup G;
    private JTable table;
    private JPanel controlPanel;
    private String dates[] 
        = { "1", "2", "3", "4", "5", 
            "6", "7", "8", "9", "10", 
            "11", "12", "13", "14", "15", 
            "16", "17", "18", "19", "20", 
            "21", "22", "23", "24", "25", 
            "26", "27", "28", "29", "30", 
            "31" }; 
    private String months[] 
        = { "1", "2", "3", "4", 
            "5", "6", "7", "8", 
            "9", "10", "11", "12" }; 
    
    /*
    private String years[] 
        = { "2020", "2021", "2022", "2023", 
            "2024", "2025", "2026", "2027", 
            "2028", "2029", "2030", "2031" 
             }; 
             
   */
    
    private String years[] 
            = { "1900",  "1901",  "1902",  "1903",  "1904",  "1905",  "1906",  "1907",  "1908",  "1909",  "1910",  "1911",  "1912",  "1913",  "1914",  "1915",  "1916",  "1917",  "1918",  "1919",  "1920",  "1921",  "1922",  "1923",  "1924",  "1925",  "1926",  "1927",  "1928",  "1929",  "1930",  "1931",  "1932",  "1933",  "1934",  "1935",  "1936",  "1937",  "1938",  "1939",  "1940",  "1941",  "1942",  "1943",  "1944",  "1945",  "1946",  "1947",  "1948",  "1949",  "1950",  "1951",  "1952",  "1953",  "1954",  "1955",  "1956",  "1957",  "1958",  "1959",  "1960",  "1961",  "1962",  "1963",  "1964",  "1965",  "1966",  "1967",  "1968",  "1969",  "1970",  "1971",  "1972",  "1973",  "1974",  "1975",  "1976",  "1977",  "1978",  "1979",  "1980",  "1981",  "1982",  "1983",  "1984",  "1985",  "1986",  "1987",  "1988",  "1989",  "1990",  "1991",  "1992",  "1993",  "1994",  "1995",  "1996",  "1997",  "1998",  "1999",  "2000",  "2001",  "2002",  "2003",  "2004",  "2005",  "2006",  "2007",  "2008",  "2009",  "2010",  "2011",  "2012",  "2013",  "2014",  "2015",  "2016",  "2017",  "2018",  "2019",  "2020"}; 
    
  
    
    private String diets[] 
            = {"1","2","3","4","5","6","7","8","9","10" };
    private String exercises[] 
            = {"1","2","3","4","5","6","7","8","9","10" };
    
   
    
    
    
    
    public MyFrame() throws IOException 
    { 
    	setTitle("Patient Information Portal"); 
        setBounds(300, 90, 1500, 1500); 
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE); 
        setResizable(true);       
        
    
  
        
        fid = new JLabel("Name"); 
        fid.setFont(new Font("Arial", Font.PLAIN, 20)); 
        fid.setSize(300, 20); 
        fid.setLocation(100, 440); 
        //fid.setForeground(Color.WHITE);
        add(fid); 
  
        tfid = new JTextField(); 
        tfid.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tfid.setSize(300, 20); 
        tfid.setLocation(400, 440); 
        
        add(tfid); 
        ///////////////////////////////////////////
        nameair = new JLabel("Age"); 
        nameair.setFont(new Font("Arial", Font.PLAIN, 20)); 
        nameair.setSize(300, 20); 
        nameair.setLocation(1000, 500); 
       // nameair.setForeground(Color.WHITE);
        add(nameair);
        
        
        airline1 = new JTextField(); 
        airline1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        airline1.setSize(300, 20); 
        airline1.setLocation(1300, 500); 

        add(airline1); 
  
        
        /////////////////////////////////////////////
        
                
        doa = new JLabel("Date of Birth"); 
        doa.setFont(new Font("Arial", Font.PLAIN, 20)); 
        doa.setSize(200, 20); 
        doa.setLocation(1000, 450); 
       // doa.setForeground(Color.WHITE);
        add(doa); 
  
             
        
        
        date1 = new JComboBox(dates); 
        date1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        date1.setSize(50, 20); 
        date1.setLocation(1300, 450); 
        add(date1); 
  
        month1 = new JComboBox(months); 
        month1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        month1.setSize(60, 20); 
        month1.setLocation(1350, 450); 
        add(month1); 
  
        year1 = new JComboBox(years); 
        year1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        year1.setSize(60, 20); 
        year1.setLocation(1410, 450); 
        add(year1);
        
        ////////////////////////////////////////////////////////////////
        
        time = new JLabel("Address"); 
        time.setFont(new Font("Arial", Font.PLAIN, 20)); 
        time.setSize(300, 20); 
        time.setLocation(1000, 550); 
       // time.setForeground(Color.WHITE);
      //  time.setForeground(Color.WHITE);
        add(time); 
  
        tname2 = new JTextField(); 
        tname2.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tname2.setSize(300, 20); 
        tname2.setLocation(1300, 550); 
        add(tname2); 
        
        
       
        
        
        /////////////////////////////////////////////////////////
        
        ticket = new JLabel("Select diet plan: "); 
        ticket.setFont(new Font("Arial", Font.PLAIN, 20)); 
        ticket.setSize(300, 20); 
        ticket.setLocation(100, 500); 
      //  ticket.setForeground(Color.WHITE);
      //  ticket.setForeground(Color.WHITE);
        add(ticket); 
        
        
        price = new JComboBox(diets); 
        price.setFont(new Font("Arial", Font.PLAIN, 15)); 
        price.setSize(300, 20); 
        price.setLocation(400, 500); 
        
        add(price); 
        
        
        
        /////////////////////////////////////////////////////////
        
        
        qty= new JLabel("Select exercise plan:"); 
        qty.setFont(new Font("Arial", Font.PLAIN, 20)); 
        qty.setSize(300, 20); 
        qty.setLocation(100, 550); 
       // qty.setForeground(Color.WHITE);
       // qty.setForeground(Color.WHITE);
        add(qty); 
        
        qty1 = new JComboBox(exercises); 
        qty1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        qty1.setSize(300, 20); 
        qty1.setLocation(400, 550); 
        add(qty1); 
        
        /////////////////////////////////////////////////////////
        
        
        dest = new JLabel("Medical History"); 
        dest.setFont(new Font("Arial", Font.PLAIN, 20)); 
        dest.setSize(300, 20); 
        dest.setLocation(100, 600);
      //  dest.setForeground(Color.WHITE);
      //  dest.setForeground(Color.WHITE);
        add(dest); 
  
        dest1 = new JTextField(); 
        dest1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        dest1.setSize(300, 20); 
        dest1.setLocation(400, 600); 
        add(dest1); 
        
        
        src= new JLabel("Ailments"); 
        src.setFont(new Font("Arial", Font.PLAIN, 20)); 
        src.setSize(300, 20); 
        src.setLocation(100, 650);
      //  src.setForeground(Color.WHITE);
      //  src.setForeground(Color.WHITE);
        add(src); 
  
        src1 = new JTextField(); 
        src1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        src1.setSize(300, 20); 
        src1.setLocation(400, 650); 
        
        add(src1); 
        
        j1 = new JRadioButton("Male");
        j1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        j1.setSize(300, 20); 
        j1.setLocation(1000, 650); 
      //  j1.setForeground(Color.WHITE);
      //  j1.setBackground(Color.BLACK);
        add(j1); 
        
        j2 = new JRadioButton("Female");
        j2.setFont(new Font("Arial", Font.PLAIN, 15)); 
        j2.setSize(300, 20); 
        j2.setLocation(1300, 650); 
     //   j2.setForeground(Color.WHITE);
     //   j2.setBackground(Color.BLACK);
        add(j2);
        
        
        
        /////////////////////////////////////////////////////////
        
        sub = new JButton("Submit"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 30)); 
        sub.setSize(300, 100); 
        sub.setLocation(100, 700); 
        sub.setBackground(Color.BLACK);
        sub.setForeground(Color.WHITE);
        sub.addActionListener(this); 
        add(sub); 
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 30)); 
        reset.setSize(300, 100); 
        reset.setLocation(1100, 700); 
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);
        reset.addActionListener(this); 
        add(reset);
        
        res= new JLabel(""); 
        res.setFont(new Font("Arial", Font.PLAIN, 20)); 
        res.setSize(1300, 20); 
        res.setLocation(300, 850); 
        add(res); 
        
        
        
     
        
        String column[] = {"diet_code","diet_name", "calories", "days","exercise_id","exercise_name", "calories", "days"};
        
         String data[][] = {};
       
       DefaultTableModel model = new DefaultTableModel(data, column);
       table = new JTable(model);
        
        try 
	    {	    	
        	 ArrayList<String> a1 = new ArrayList<>();
        	 ArrayList<String> a2 = new ArrayList<>();
        	 ArrayList<String> a3 = new ArrayList<>();
        	 ArrayList<String> a4 = new ArrayList<>();
        	 
	            String url = "jdbc:mysql://localhost/medical";
	            Connection conn = DriverManager.getConnection(url,"root","root");
	            Statement stmt = conn.createStatement();	         
	                      
	            ResultSet rs = stmt.executeQuery("Select * from diet;");	

	           	
	            
	            while(rs.next())
	            {
	                String d = rs.getString("diet_id");
	                String e = rs.getString("diet_name");
	                String f = rs.getString("calories");
	                String d1 = rs.getString("days");
	                a1.add(d);
	                a2.add(e);
	                a3.add(f);
	                a4.add(d1);
	               
	                
	                
	            }
	            conn.close();
	            
	            String url1 = "jdbc:mysql://localhost/medical";
	            Connection conn1 = DriverManager.getConnection(url,"root","root");
	            Statement stmt1 = conn1.createStatement();	         
	                      
	            ResultSet rs1 = stmt1.executeQuery("Select * from exercise;");
	            int i=0;
	            
	            while(rs1.next())
	            {
	            	 String e1 = rs1.getString("exercise_id");
		                String f1 = rs1.getString("exercise_name");
		                String d2 = rs1.getString("calories");
		                String e2 = rs1.getString("days");
		                
		                
		                model.addRow(new Object[]{a1.get(i), a2.get(i), a3.get(i),a4.get(i), e1, f1, d2, e2});
		                i = i+1;
	            }
	           
	            conn1.close();
	            
	            
	            
	            
        } 
	    catch (Exception e2) 
	    {
            System.err.println("Got an exception! ");
            System.err.println(e2.getMessage());
        }
        
       
        
        
        add(table.getTableHeader(), BorderLayout.PAGE_START);
        add(table, BorderLayout.CENTER);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        
        
       
        
        
        
        
        
  
        setVisible(true); 
    } 
    
    /////////////////////////////////////////////////////
  
    // method actionPerformed() 
    // to get the action performed 
    // by the user and act accordingly 
    public void actionPerformed(ActionEvent e) 
    { 
        if (e.getSource() == sub) { 
          
        	
        		String name;  
        		int age;
        		String date_of_birth;
        		String medical_history;
        		String ailments;
        		String address;
        		int diet_id;
        		int exercise_id;
        		int patient_id = 0;
        		String gender = null;
        		
        		
        		
                name = tfid.getText(); 
                age = Integer.parseInt((String)airline1.getText()); 
                diet_id = Integer.parseInt((String)price.getSelectedItem());
                exercise_id = Integer.parseInt((String)qty1.getSelectedItem());
                address = tname2.getText();
                medical_history = dest1.getText();
                ailments = src1.getText();         		
                date_of_birth = (String)year1.getSelectedItem() + "-" + (String)month1.getSelectedItem() + "-" + (String)date1.getSelectedItem() ; 
                if(j1.isSelected())
        		{
        			gender="Male";
        		}
        		else if(j2.isSelected())
        		{
        			gender = "Female";
        		}
                
                res.setText("Booking Successfully.."); 
                
               CipherSample s = new CipherSample();
        			
        			try 
        		    {	    	
        		            String url = "jdbc:mysql://localhost/medical";
        		            Connection conn = DriverManager.getConnection(url,"root","root");
        		            Statement stmt = conn.createStatement();	         
        		            
        		            stmt.executeUpdate("insert into patient(name,address,age,DOB,medical_history,ailments,diet_id,exercise_id,gender) values ( '"  + s.hashed(name) + "','" + address + "','" + age + "','" + date_of_birth + "','" + medical_history + "','" + ailments + "','" + diet_id + "','" +  exercise_id+  "','" +  gender + "');");	           
        		            conn.close();
        	        } 
        		    catch (Exception e1) 
        		    {
        	            System.err.println("Got an exception! ");
        	            System.err.println(e1.getMessage());
        	        }
        			
        			
        			try 
        		    {	    	
        		            String url = "jdbc:mysql://localhost/medical";
        		            Connection conn = DriverManager.getConnection(url,"root","root");
        		            Statement stmt = conn.createStatement();	         
        		            ResultSet rs;
        		            rs = stmt.executeQuery("Select MAX(patient_id) as MaxLevel from patient;");	    
        		            while(rs.next())
        		            {
        		            	patient_id = rs.getInt("MaxLevel");
        		            	
        		            }
        		            conn.close();
        	        } 
        		    catch (Exception e1) 
        		    {
        	            System.err.println("Got an exception! ");
        	            System.err.println(e1.getMessage());
        	        }
        			
        			res.setText("\n Please remember that your patient id is : " + patient_id + "\n If you want to make an appointment in the future, use this id");
        			       
        } 
  
        else if (e.getSource() == reset) { 
            String def = ""; 
            tfid.setText(def);
            airline1.setText(def);
            price.setSelectedIndex(0); 
            qty1.setSelectedIndex(0); 
            tname2.setText(def); 
            dest1.setText(def);
            src1.setText(def); 
            date1.setSelectedIndex(0); 
            month1.setSelectedIndex(0); 
            year1.setSelectedIndex(0);            
            j1.setSelected(false);
            j2.setSelected(false);    
        } 
   
        }
    
    
    
}


//----------------------------------------------------------------------------------------------------------





class MyFrame1 extends JFrame implements ActionListener 
{ 
	  
	// Components of the Form 
    private Container c; 
    private JLabel title; 
    private JLabel nameair;  
    private JLabel id; 
    private JTextField tid;
    private JTextField tname2;
    private JTextField tname3;
    private JLabel time; 
    private JLabel time1; 
    private JLabel mno; 
    private JTextField tmno; 
    private JLabel qty;
    private JComboBox qty1;
    private JLabel fid;
    private JTextField tfid;
    private JLabel ch;
    private JTextField choice;
    private JLabel dod;
    private JLabel doa;
    private JLabel ticket;
    private JComboBox price;
    private JComboBox date1; 
    private JComboBox month1; 
    private JComboBox year1; 
    private JTextField airline1; 
    private JButton sub; 
    private JButton reset; 
    private JLabel dest; 
    private JTextField dest1; 
    private JTextArea dets; 
    private JLabel src; 
    private JTextField src1; 
    private JLabel res;
    private JRadioButton j1; 
    private JRadioButton j2;
    private ButtonGroup G;
    private JTable table;
    private JPanel controlPanel;
    private String dates[] 
        = { "1", "2", "3", "4", "5", 
            "6", "7", "8", "9", "10", 
            "11", "12", "13", "14", "15", 
            "16", "17", "18", "19", "20", 
            "21", "22", "23", "24", "25", 
            "26", "27", "28", "29", "30", 
            "31" }; 
    private String months[] 
        = { "1", "2", "3", "4", 
            "5", "6", "7", "8", 
            "9", "10", "11", "12" }; 
    
   
    private String years[] 
        = { "2020", "2021", "2022", "2023", 
            "2024", "2025", "2026", "2027", 
            "2028", "2029", "2030", "2031" 
             }; 
             
   
   
    
    
    
    
    public MyFrame1() throws IOException 
    { 
    	setTitle("Patient Information Portal"); 
        setBounds(300, 90, 1500, 1500); 
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE); 
        setResizable(true);       
        
    
        
        fid = new JLabel("Doctor Id"); 
        fid.setFont(new Font("Arial", Font.PLAIN, 20)); 
        fid.setSize(300, 20); 
        fid.setLocation(100, 440); 
        //fid.setForeground(Color.WHITE);
        add(fid); 
  
        tfid = new JTextField(); 
        tfid.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tfid.setSize(300, 20); 
        tfid.setLocation(400, 440); 
        
        add(tfid); 
        ///////////////////////////////////////////
        nameair = new JLabel("Patient Id"); 
        nameair.setFont(new Font("Arial", Font.PLAIN, 20)); 
        nameair.setSize(300, 20); 
        nameair.setLocation(1000, 500); 
       // nameair.setForeground(Color.WHITE);
        add(nameair);
        
        
        airline1 = new JTextField(); 
        airline1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        airline1.setSize(300, 20); 
        airline1.setLocation(1300, 500); 

        add(airline1); 
  
        
        /////////////////////////////////////////////
        
                
        doa = new JLabel("Date of Appointment"); 
        doa.setFont(new Font("Arial", Font.PLAIN, 20)); 
        doa.setSize(200, 20); 
        doa.setLocation(1000, 450); 
       // doa.setForeground(Color.WHITE);
        add(doa); 
        
             
        
        
        date1 = new JComboBox(dates); 
        date1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        date1.setSize(50, 20); 
        date1.setLocation(1300, 450); 
        add(date1); 
  
        month1 = new JComboBox(months); 
        month1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        month1.setSize(60, 20); 
        month1.setLocation(1350, 450); 
        add(month1); 
  
        year1 = new JComboBox(years); 
        year1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        year1.setSize(60, 20); 
        year1.setLocation(1410, 450); 
        add(year1);
        
        ////////////////////////////////////////////////////////////////
        
        time = new JLabel("Time(HH:MM:SS)"); 
        time.setFont(new Font("Arial", Font.PLAIN, 20)); 
        time.setSize(300, 20); 
        time.setLocation(1000, 550); 
       // time.setForeground(Color.WHITE);
      //  time.setForeground(Color.WHITE);
        add(time); 
  
        tname2 = new JTextField(); 
        tname2.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tname2.setSize(300, 20); 
        tname2.setLocation(1300, 550); 
        add(tname2); 
        
        
        /////////////////////////////////////////////////////////
        
        sub = new JButton("Submit"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 30)); 
        sub.setSize(300, 100); 
        sub.setLocation(100, 700); 
        sub.setBackground(Color.BLACK);
        sub.setForeground(Color.WHITE);
        sub.addActionListener(this); 
        add(sub); 
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 30)); 
        reset.setSize(300, 100); 
        reset.setLocation(1100, 700); 
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);
        reset.addActionListener(this); 
        add(reset);
        
        res= new JLabel(""); 
        res.setFont(new Font("Arial", Font.PLAIN, 20)); 
        res.setSize(1300, 20); 
        res.setLocation(300, 850); 
        add(res); 
        
        
        
     
        
        String column[] = {"doctor_id","doctor_name", "branch", "contact"};
        
         String data[][] = {};
       
       DefaultTableModel model = new DefaultTableModel(data, column);
       table = new JTable(model);
        
        try 
	    {	    	
        	         	 
	            String url = "jdbc:mysql://localhost/medical";
	            Connection conn = DriverManager.getConnection(url,"root","root");
	            Statement stmt = conn.createStatement();	         
	                      
	            ResultSet rs = stmt.executeQuery("Select * from doctor;");	

	           	
	            
	            while(rs.next())
	            {
	                String d = rs.getString("doctor_id");
	                String e = rs.getString("name");
	                String f = rs.getString("branch");
	                String d1 = rs.getString("contact");
	             
	               
	                model.addRow(new Object[]{ d, e ,f , d1});
	                
	            }
	            conn.close();
	            
	    } 
	    catch (Exception e2) 
	    {
            System.err.println("Got an exception! ");
            System.err.println(e2.getMessage());
        }  
        
       
        
        
        add(table.getTableHeader(), BorderLayout.PAGE_START);
        add(table, BorderLayout.CENTER);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        
          
        
        
        
        
        
  
        setVisible(true); 
    } 
    
    /////////////////////////////////////////////////////
  
    // method actionPerformed() 
    // to get the action performed 
    // by the user and act accordingly 
    public void actionPerformed(ActionEvent e) 
    { 
        if (e.getSource() == sub) { 
          
        	
          
        		int pid;
        		int did;
        		String date_of_aptmt;        		
        		String time;
        		String contact=null;
        		
        		did = Integer.parseInt((String)tfid.getText()); 
        		pid = Integer.parseInt((String)airline1.getText()); 
                time = tname2.getText();      		
                date_of_aptmt = (String)year1.getSelectedItem() + "-" + (String)month1.getSelectedItem() + "-" + (String)date1.getSelectedItem() ; 
                
                int check = 0;
                String x =null;
                String y = null;
                
                try 
    		    {	    	
    		            String url = "jdbc:mysql://localhost/medical";
    		            Connection conn = DriverManager.getConnection(url,"root","root");
    		            Statement stmt = conn.createStatement();	         
    		            ResultSet rs;
    		            rs = stmt.executeQuery("Select time from appointment where doctor_id='" + did + "';");	    
    		            while(rs.next())
    		            {
    		            	y = rs.getString("date");
    		            	x = rs.getString("time");
    		            	if(time.equalsIgnoreCase(x) && y.equalsIgnoreCase(date_of_aptmt))
    		            	{
    		            		check = 1;
    		            	}
    		            	
    		            }
    		            conn.close();
    	        } 
    		    catch (Exception e1) 
    		    {
    	            System.err.println("Got an exception! ");
    	            System.err.println(e1.getMessage());
    	        }
                              
               
        		if(check==0)
        		{
        			try 
        		    {	    	
        		            String url = "jdbc:mysql://localhost/medical";
        		            Connection conn = DriverManager.getConnection(url,"root","root");
        		            Statement stmt = conn.createStatement();	         
        		            ResultSet rs;
        		            rs = stmt.executeQuery("select contact from doctor where doctor_id='" + did + "';");	 
        		            while(rs.next())
        		            {
        		            	contact = rs.getString("contact");
        		            	
        		            }
        		            
        		            conn.close();
        	        } 
        		    catch (Exception e1) 
        		    {
        	            System.err.println("Got an exception! ");
        	            System.err.println(e1.getMessage());
        	        }
        			try 
        		    {	    	
        		            String url = "jdbc:mysql://localhost/medical";
        		            Connection conn = DriverManager.getConnection(url,"root","root");
        		            Statement stmt = conn.createStatement();	         
        		            stmt.executeUpdate("insert into appointment(doctor_id,patient_id,date,time,contact) values ( '"  + did + "','" + pid + "','" + date_of_aptmt + "','" + time + "','" + contact + "');");	       	 
        		           
        		            
        		            conn.close();
        	        } 
        		    catch (Exception e1) 
        		    {
        	            System.err.println("Got an exception! ");
        	            System.err.println(e1.getMessage());
        	        }
        			
        			
        		
        			
        			int app_id=0;
        			
        			try 
        		    {	    	
        		            String url = "jdbc:mysql://localhost/medical";
        		            Connection conn = DriverManager.getConnection(url,"root","root");
        		            Statement stmt = conn.createStatement();	         
        		            ResultSet rs;
        		            rs = stmt.executeQuery("Select MAX(appointment_id) as MaxLevel from appointment;");	    
        		            while(rs.next())
        		            {
        		            	app_id = rs.getInt("MaxLevel");
        		            	
        		            }
        		            conn.close();
        	        } 
        		    catch (Exception e1) 
        		    {
        	            System.err.println("Got an exception! ");
        	            System.err.println(e1.getMessage());
        	        }
        			
        			res.setText("\n Please remember that your appoinment id is : " + app_id + "\n When you visit the clinic, use this id");
        			
        			
        		}
        		else
        		{
        			res.setText("\n The doctor is busy during this time slot, kindly choose another.");
        			String def = ""; 
        			tfid.setText(def);
                    airline1.setText(def);
                    tname2.setText(def);
                    date1.setSelectedIndex(0); 
                    month1.setSelectedIndex(0); 
                    year1.setSelectedIndex(0);  
        		}
        			       
        } 
  
        else if (e.getSource() == reset) { 
            String def = ""; 
            tfid.setText(def);
            airline1.setText(def);
            tname2.setText(def);
            date1.setSelectedIndex(0); 
            month1.setSelectedIndex(0); 
            year1.setSelectedIndex(0);            
               
        } 
   
        }
    }







//------------------------------------------------------------------------------------------------------------------






class MyFrame3 extends JFrame implements ActionListener { 
	  
	// Components of the Form 
    private Container c; 
    private JLabel title; 
    private JLabel nameair;  
    private JLabel id; 
    private JTextField tid;
    private JTextField tname2;
    private JTextField tname3;
    private JLabel time; 
    private JLabel time1; 
    private JLabel mno; 
    private JTextField tmno; 
    private JLabel qty;
    private JComboBox qty1;
    private JLabel fid;
    private JTextField tfid;
    private JLabel ch;
    private JTextField choice;
    private JLabel dod;
    private JLabel doa;
    private JLabel ticket;
    private JComboBox price;
    private JComboBox date1; 
    private JComboBox month1; 
    private JComboBox year1; 
    private JTextField airline1; 
    private JTextField tox;
    private JButton sub; 
    private JButton reset; 
    private JLabel dest; 
    private JTextField dest1; 
    private JTextArea dets; 
    private JLabel src; 
    private JTextField src1; 
    private JLabel res;
    private JRadioButton j1; 
    private JRadioButton j2;
    private ButtonGroup G;
    private JTable table;
    private JPanel controlPanel;
    private String dates[] 
        = { "1", "2", "3", "4", "5", 
            "6", "7", "8", "9", "10", 
            "11", "12", "13", "14", "15", 
            "16", "17", "18", "19", "20", 
            "21", "22", "23", "24", "25", 
            "26", "27", "28", "29", "30", 
            "31" }; 
    private String months[] 
        = { "1", "2", "3", "4", 
            "5", "6", "7", "8", 
            "9", "10", "11", "12" }; 
    
   
    private String years[] 
        = { "2020", "2021", "2022", "2023", 
            "2024", "2025", "2026", "2027", 
            "2028", "2029", "2030", "2031" 
             }; 
             
   
   
    
    
    
    
    public MyFrame3() throws IOException 
    { 
    	setTitle("Patient Information Portal"); 
        setBounds(300, 90, 1500, 1500); 
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE); 
        setResizable(true);       
        
    
        
        fid = new JLabel("Doctor Id"); 
        fid.setFont(new Font("Arial", Font.PLAIN, 20)); 
        fid.setSize(300, 20); 
        fid.setLocation(100, 440); 
        //fid.setForeground(Color.WHITE);
        add(fid); 
  
        tfid = new JTextField(); 
        tfid.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tfid.setSize(300, 20); 
        tfid.setLocation(400, 440); 
        
        add(tfid); 
        
        
        dest = new JLabel("Appointment Id"); 
        dest.setFont(new Font("Arial", Font.PLAIN, 20)); 
        dest.setSize(300, 20); 
        dest.setLocation(100, 500); 
        //fid.setForeground(Color.WHITE);
        add(dest); 
  
        tox = new JTextField(); 
        tox.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tox.setSize(300, 20); 
        tox.setLocation(400, 500); 
        
        add(tox); 
        ///////////////////////////////////////////
        nameair = new JLabel("Patient Id"); 
        nameair.setFont(new Font("Arial", Font.PLAIN, 20)); 
        nameair.setSize(300, 20); 
        nameair.setLocation(1000, 500); 
       // nameair.setForeground(Color.WHITE);
        add(nameair);
        
        
        airline1 = new JTextField(); 
        airline1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        airline1.setSize(300, 20); 
        airline1.setLocation(1300, 500); 

        add(airline1); 
  
        
        /////////////////////////////////////////////
        
                
        doa = new JLabel("Date of Appointment"); 
        doa.setFont(new Font("Arial", Font.PLAIN, 20)); 
        doa.setSize(200, 20); 
        doa.setLocation(1000, 450); 
       // doa.setForeground(Color.WHITE);
        add(doa); 
        
             
        
        
        date1 = new JComboBox(dates); 
        date1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        date1.setSize(50, 20); 
        date1.setLocation(1300, 450); 
        add(date1); 
  
        month1 = new JComboBox(months); 
        month1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        month1.setSize(60, 20); 
        month1.setLocation(1350, 450); 
        add(month1); 
  
        year1 = new JComboBox(years); 
        year1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        year1.setSize(60, 20); 
        year1.setLocation(1410, 450); 
        add(year1);
        
        ////////////////////////////////////////////////////////////////
        
        time = new JLabel("Time(HH:MM:SS)"); 
        time.setFont(new Font("Arial", Font.PLAIN, 20)); 
        time.setSize(300, 20); 
        time.setLocation(1000, 550); 
       // time.setForeground(Color.WHITE);
      //  time.setForeground(Color.WHITE);
        add(time); 
  
        tname2 = new JTextField(); 
        tname2.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tname2.setSize(300, 20); 
        tname2.setLocation(1300, 550); 
        add(tname2); 
        
        
        /////////////////////////////////////////////////////////
        
        sub = new JButton("Modify"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 30)); 
        sub.setSize(300, 100); 
        sub.setLocation(100, 700); 
        sub.setBackground(Color.BLACK);
        sub.setForeground(Color.WHITE);
        sub.addActionListener(this); 
        add(sub); 
  
        reset = new JButton("Cancel"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 30)); 
        reset.setSize(300, 100); 
        reset.setLocation(1100, 700); 
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);
        reset.addActionListener(this); 
        add(reset);
        
        res= new JLabel(""); 
        res.setFont(new Font("Arial", Font.PLAIN, 20)); 
        res.setSize(1300, 20); 
        res.setLocation(300, 850); 
        add(res); 
        
        String column[] = {"doctor_id","doctor_name", "branch", "contact"};

        String data[][] = {};
                  
                  DefaultTableModel model = new DefaultTableModel(data, column);
        		 
          	  
                  table = new JTable(model);    
                
                
                
        		
        		try 
        	    {	    	
              	         	 
        	            String url = "jdbc:mysql://localhost/medical";
        	            Connection conn = DriverManager.getConnection(url,"root","root");
        	            Statement stmt = conn.createStatement();	         
        	                      
        	            ResultSet rs = stmt.executeQuery("Select * from doctor;");	

        	           	
        	            
        	            while(rs.next())
        	            {
        	                String d = rs.getString("doctor_id");
        	                String e = rs.getString("name");
        	                String f = rs.getString("branch");
        	                String d1 = rs.getString("contact");
        	             
        	               
        	                model.addRow(new Object[]{ d, e ,f , d1});
        	                
        	            }
        	            conn.close();
        
        	    } 
        	    catch (Exception e2) 
        	    {
                System.err.println("Got an exception! ");
                System.err.println(e2.getMessage());
            }
       
        	            add(table.getTableHeader(), BorderLayout.PAGE_START);
        	            add(table, BorderLayout.CENTER);

        	            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        	            pack();
        	            setLocationRelativeTo(null);
        	            
        
       
       
          
        
        
        
        
        
  
        setVisible(true); 
    } 
    
    /////////////////////////////////////////////////////
  
    // method actionPerformed() 
    // to get the action performed 
    // by the user and act accordingly 
    
    
  
    
    
    
    
    
    
    
    public void actionPerformed(ActionEvent e) 
    { 
        if (e.getSource() == sub) { 
          
        	
        		
        		int pid;
        		int did;
        		String date_of_aptmt;        		
        		String time;
        		String contact=null;
        		int aid;
        		aid=Integer.parseInt((String)tox.getText()); 
        		
        		did = Integer.parseInt((String)tfid.getText()); 
        		pid = Integer.parseInt((String)airline1.getText()); 
                time = tname2.getText();      		
                date_of_aptmt = (String)year1.getSelectedItem() + "-" + (String)month1.getSelectedItem() + "-" + (String)date1.getSelectedItem() ; 
                
                int check = 0;
                String x =null;
                String y=null;
                
                try 
    		    {	    	
    		            String url = "jdbc:mysql://localhost/medical";
    		            Connection conn = DriverManager.getConnection(url,"root","root");
    		            Statement stmt = conn.createStatement();	         
    		            ResultSet rs;
    		            rs = stmt.executeQuery("Select date,time from appointment where doctor_id='" + did + "';");	    
    		            while(rs.next())
    		            {
    		            	y = rs.getString("date");
    		            	x = rs.getString("time");
    		            	if(time.equalsIgnoreCase(x) && y.equalsIgnoreCase(date_of_aptmt))
    		            	{
    		            		check = 1;
    		            	}
    		            	
    		            }
    		            conn.close();
    	        } 
    		    catch (Exception e1) 
    		    {
    	            System.err.println("Got an exception! ");
    	            System.err.println(e1.getMessage());
    	        }
                              
               
        		if(check==0)
        		{
        			
        			
        			try 
        		    {	    	
        		            String url = "jdbc:mysql://localhost/medical";
        		            Connection conn = DriverManager.getConnection(url,"root","root");
        		            Statement stmt = conn.createStatement();	         
        		            stmt.executeUpdate("Delete from appointment where appointment_id='" + aid + "';");	    
        		            
        		            conn.close();
        	        } 
        		    catch (Exception e1) 
        		    {
        	            System.err.println("Got an exception! ");
        	            System.err.println(e1.getMessage());
        	        }
        			
        			 			
        			  			
        			      			
        			        			
        			
        			
        			try 
        		    {	    	
        		            String url = "jdbc:mysql://localhost/medical";
        		            Connection conn = DriverManager.getConnection(url,"root","root");
        		            Statement stmt = conn.createStatement();	         
        		            ResultSet rs;
        		            rs = stmt.executeQuery("select contact from doctor where doctor_id='" + did + "';");	 
        		            while(rs.next())
        		            {
        		            	contact = rs.getString("contact");
        		            	
        		            }
        		            
        		            conn.close();
        	        } 
        		    catch (Exception e1) 
        		    {
        	            System.err.println("Got an exception! ");
        	            System.err.println(e1.getMessage());
        	        }
        			try 
        		    {	    	
        		            String url = "jdbc:mysql://localhost/medical";
        		            Connection conn = DriverManager.getConnection(url,"root","root");
        		            Statement stmt = conn.createStatement();	         
        		            stmt.executeUpdate("insert into appointment(doctor_id,patient_id,date,time,contact) values ( '"  + did + "','" + pid + "','" + date_of_aptmt + "','" + time + "','" + contact + "');");	       	 
        		           
        		            
        		            conn.close();
        	        } 
        		    catch (Exception e1) 
        		    {
        	            System.err.println("Got an exception! ");
        	            System.err.println(e1.getMessage());
        	        }
        			
        			
        		
        			
        			int app_id=0;
        			
        			try 
        		    {	    	
        		            String url = "jdbc:mysql://localhost/medical";
        		            Connection conn = DriverManager.getConnection(url,"root","root");
        		            Statement stmt = conn.createStatement();	         
        		            ResultSet rs;
        		            rs = stmt.executeQuery("Select MAX(appointment_id) as MaxLevel from appointment;");	    
        		            while(rs.next())
        		            {
        		            	app_id = rs.getInt("MaxLevel");
        		            	
        		            }
        		            conn.close();
        	        } 
        		    catch (Exception e1) 
        		    {
        	            System.err.println("Got an exception! ");
        	            System.err.println(e1.getMessage());
        	        }
        			
        			res.setText("\n Please remember that your appoinment id is : " + app_id + "\n When you visit the clinic, use this id");
        			
        			
        		}
        		else
        		{
        			res.setText("\n The doctor is busy during this time slot, kindly choose another.");
        			String def = ""; 
        			tfid.setText(def);
                    airline1.setText(def);
                    tname2.setText(def);
                    date1.setSelectedIndex(0); 
                    month1.setSelectedIndex(0); 
                    year1.setSelectedIndex(0);  
        		}
        			       
        } 
  
        else if (e.getSource() == reset) { 
        	
        	
        	int aid;
    		aid=Integer.parseInt((String)tox.getText()); 
        	try 
		    {	    	
		            String url = "jdbc:mysql://localhost/medical";
		            Connection conn = DriverManager.getConnection(url,"root","root");
		            Statement stmt = conn.createStatement();	         
		            stmt.executeUpdate("Delete from appointment where appointment_id='" + aid + "';");	    
		            
		            conn.close();
	        } 
		    catch (Exception e1) 
		    {
	            System.err.println("Got an exception! ");
	            System.err.println(e1.getMessage());
	        }
        	
        	
        	res.setText("\n The appointment has been successfully cancelled.");
        } 
   
        }
    }






//---------------------------------------------------------------------------------------------------------


class MyFrame2 extends JFrame implements ActionListener { 
	  
    // Components of the Form 
    private Container c; 
    private JLabel title; 
    private JLabel nameair;  
    private JLabel id; 
    private JTextField tid;
    private JLabel qty;
    private JTextArea qty1;
    private JButton sub; 
    private JButton reset; 
    private JLabel res;
    private JTable table;
    private JPanel controlPanel;
    private int iid;

  
    public MyFrame2(int idi) 
    { 
    	
    	iid = idi;
        setTitle("View Status"); 
        setBounds(300, 90, 1500, 1500); 
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE); 
        setResizable(true); 
        
       
        
        
        title = new JLabel("Patient Portal"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(300, 50); 
        title.setLocation(800, 20); 
        title.setForeground(Color.WHITE);
        add(title); 
  
        id = new JLabel("Patient Id"); 
        id.setFont(new Font("Arial", Font.PLAIN, 30)); 
        id.setSize(300, 50); 
        id.setLocation(200, 300); 
        id.setForeground(Color.WHITE);
        add(id); 
  
       
        
        
        
        /////////////////////////////////////////////////////////
        
        
       
        
        qty1 = new JTextArea(); 
        qty1.setFont(new Font("Arial", Font.PLAIN, 30)); 
        qty1.setSize(650, 400); 
        qty1.setLocation(650, 300); 
        qty1.setBackground(Color.BLACK);
        qty1.setForeground(Color.WHITE);
        add(qty1); 
        
       
        
        
        
        
        /////////////////////////////////////////////////////////
        
        sub = new JButton("View appt"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 30)); 
        sub.setSize(300, 50); 
        sub.setLocation(400, 850); 
        sub.addActionListener(this); 
        add(sub); 
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 30)); 
        reset.setSize(300, 50); 
        reset.setLocation(1000, 850); 
        reset.addActionListener(this); 
        add(reset);
        
  
        String column[] = {"Monday","Tuesday", "Wedneday", "Thursday","Friday","Saturday", "Sunday"};
        
        String data[][] = {};
      
      DefaultTableModel model = new DefaultTableModel(data, column);
      table = new JTable(model);
      ArrayList<String> diet = new ArrayList<>();
 	 ArrayList<String> exe = new ArrayList<>();
 	 String d1 = null,e1 = null;
 	 String dname=null,ename=null;
    
    try 
	    {	    	
    	       	String url = "jdbc:mysql://localhost/medical";
	            Connection conn = DriverManager.getConnection(url,"root","root");
	            Statement stmt = conn.createStatement();	         
	            ResultSet rs = stmt.executeQuery("Select days,diet_name from diet INNER JOIN patient  ON diet.diet_id =patient.diet_id where patient_id ='" + idi + "';");	
	           	while(rs.next())
	            {
	                d1 = rs.getString("days");
	                dname = rs.getString("diet_name");
	                
	             }
	            conn.close();
	            
	            if(d1.contains("Monday"))
	            {
	            	
	            diet.add(dname);
	            }
	            else
	            {
	            	diet.add("Cheat day");
	            }
	            if(d1.contains("Tuesday"))
	            {
	            	
	            diet.add(dname);
	            }
	            else
	            {
	            	diet.add("Cheat day");
	            }
	            
	            if(d1.contains("Wednesday"))
	            {
	            	
	            diet.add(dname);
	            }
	            else
	            {
	            	diet.add("Cheat day");
	            }
	            
	            if(d1.contains("Thursday"))
	            {
	            	
	            diet.add(dname);
	            }
	            else
	            {
	            	diet.add("Cheat day");
	            }
	            
	            if(d1.contains("Friday"))
	            {
	            	
	            diet.add(dname);
	            }
	            else
	            {
	            	diet.add("Cheat day");
	            }
	            
	            if(d1.contains("Saturday"))
	            {
	            	
	            diet.add(dname);
	            }
	            else
	            {
	            	diet.add("Cheat day");
	            }
	            
	            if(d1.contains("Sunday"))
	            {
	            	
	            diet.add(dname);
	            }
	            else
	            {
	            	diet.add("Cheat day");
	            }
	            
	            
	            
	            String url1 = "jdbc:mysql://localhost/medical";
	            Connection conn1 = DriverManager.getConnection(url,"root","root");
	            Statement stmt1 = conn1.createStatement();	         
	                      
	            ResultSet rs1 = stmt1.executeQuery("Select days,exercise_name from exercise INNER JOIN patient  ON exercise.exercise_id =patient.exercise_id where patient_id ='" + idi + "';");;
	        
	            
	            while(rs1.next())
	            {
	            	
		              e1 = rs1.getString("days");
		              ename = rs1.getString("exercise_name");
		             
	            }
	           
	            conn1.close();
	            
	            if(e1.contains("Monday"))
	            {
	            	
	            exe.add(ename);
	            }
	            else
	            {
	            	exe.add("Rest day");
	            }
	            if(e1.contains("Tuesday"))
	            {
	            	
		            exe.add(ename);
		            }
		            else
		            {
		            	exe.add("Rest day");
		            }
	            
	            if(e1.contains("Wednesday"))
	            {
	            	
		            exe.add(ename);
		            }
		            else
		            {
		            	exe.add("Rest day");
		            }
	            
	            if(e1.contains("Thursday"))
	            	{
	            	
		            exe.add(ename);
		            }
		            else
		            {
		            	exe.add("Rest day");
		            }
	            
	            
	            if(e1.contains("Friday"))
{
	            	
		            exe.add(ename);
		            }
		            else
		            {
		            	exe.add("Rest day");
		            }
	            
	            
	            if(e1.contains("Saturday"))
{
	            	
		            exe.add(ename);
		            }
		            else
		            {
		            	exe.add("Rest day");
		            }
	            
	            
	            if(e1.contains("Sunday"))
{
	            	
		            exe.add(ename);
		            }
		            else
		            {
		            	exe.add("Rest day");
		            }
	            
	             
    } 
	    catch (Exception e2) 
	    {
        System.err.println("Got an exception! ");
        System.err.println(e2.getMessage());
    }
    
   
    
    model.addRow(new Object[]{ diet.get(0), diet.get(1), diet.get(2),diet.get(3),diet.get(4),diet.get(5),diet.get(6)});
 
    model.addRow(new Object[]{ exe.get(0), exe.get(1), exe.get(2),exe.get(3), exe.get(4), exe.get(5), exe.get(6)});
     
       
       add(table.getTableHeader(), BorderLayout.PAGE_START);
       add(table, BorderLayout.CENTER);

       setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       pack();
       setLocationRelativeTo(null);
       
       
      
       
       
       
       
       
 
       setVisible(true); 
   } 
    
    /////////////////////////////////////////////////////
  
    // method actionPerformed() 
    // to get the action performed 
    // by the user and act accordingly 
    public void actionPerformed(ActionEvent e) 
    { 
        if (e.getSource() == sub) 
        { 
          
        			
        		qty1.append("\n\nShowing your appointments and week plan:"); 
				qty1.append("\n\nDoctor Id\tDate\tTime"); 
           
                 
        				
        				try 
        				{
        					
        				        String url = "jdbc:mysql://localhost/medical";
        				        Connection conn = DriverManager.getConnection(url,"root","root");
        				        Statement stmt = conn.createStatement();
        				        ResultSet rs;

        				        rs = stmt.executeQuery("SELECT * FROM appointment where patient_id ='" + iid + "';");
        				        while ( rs.next() )
        				        {
        				        	
        				        	String p = rs.getString("doctor_id");
        				        	String s = rs.getString("date");
        				        	String t = rs.getString("time");
        				        	qty1.append("\n"+ p + "\t" + s + "\t" + t);
        				        }
        				        conn.close();
        				} 
        				catch (Exception e7) 
        				{
        					qty1.append("Got an exception! ");
        					qty1.append(e7.getMessage());
        				}
        				
        			
        			
        }		
        		
  
        else if (e.getSource() == reset)
        { 
            String def = ""; 
             
            tid.setText(def);
    
                    
   
         
        } 
   
   }
    
        
   }














class MyFrameq extends JFrame implements ActionListener { 
	  
    // Components of the Form 
    private Container c;  
    private JLabel id; 
    private JTextArea tid;
    private JTextArea qty1;
    private JButton sub; 
    private JButton reset; 
    private int iid;

  
    public MyFrameq(int idi) 
    { 
    	
    	iid = idi;
        setTitle("View Status"); 
        setBounds(300, 90, 1500, 1500); 
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE); 
        setResizable(true); 
        
        BufferedImage img=null;
		try {
			img = ImageIO.read(new File("C:/Users/Aboli/Desktop/TE/imgs/q6.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        JLabel background = new JLabel(new ImageIcon(img));
        background.setSize(1000,1000);
        
        setContentPane(background);
        setLayout(null);
        
  
        id = new JLabel("Enter query"); 
        id.setFont(new Font("Arial", Font.PLAIN, 30)); 
        id.setSize(300, 50); 
        id.setLocation(700, 100); 
        id.setForeground(Color.BLACK);
        add(id); 
  
        tid = new JTextArea(); 
        tid.setFont(new Font("Arial", Font.PLAIN, 30)); 
        tid.setSize(300, 200); 
        tid.setLocation(1300, 100); 
        tid.setForeground(Color.BLACK);
        add(tid); 
  
        
        
        
        /////////////////////////////////////////////////////////
        
        
       
        
        qty1 = new JTextArea(); 
        qty1.setFont(new Font("Arial", Font.PLAIN, 10)); 
        qty1.setSize(800, 500); 
        qty1.setLocation(700, 450); 
        qty1.setBackground(Color.BLACK);
        qty1.setForeground(Color.WHITE);
        add(qty1); 
        
       
        
        
        
        
        /////////////////////////////////////////////////////////
        
        sub = new JButton("Submit"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 30)); 
        sub.setSize(300, 50); 
        sub.setLocation(700, 350); 
        sub.addActionListener(this); 
        add(sub); 
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 30)); 
        reset.setSize(300, 50); 
        reset.setLocation(1200, 350); 
        reset.addActionListener(this); 
        add(reset);
        
   
       
       
       
 
       setVisible(true); 
   } 
    
    /////////////////////////////////////////////////////
  
    // method actionPerformed() 
    // to get the action performed 
    // by the user and act accordingly 
    public void actionPerformed(ActionEvent e) 
    { 
        if (e.getSource() == sub) 
        { 
        	String query= tid.getText();
        	try 
		    {	    	
		            String url = "jdbc:mysql://localhost/medical";
		            Connection conn = DriverManager.getConnection(url,"root","root");
		            Statement stmt = conn.createStatement();	         
		            
		            stmt.executeUpdate("insert into chatbot(patient_id,query_text) values ( '"  + iid + "','" + query + "');");	           
		            conn.close();
	        } 
		    catch (Exception e1) 
		    {
	            System.err.println("Got an exception! ");
	            System.err.println(e1.getMessage());
	        }
        	
        	if(!query.equalsIgnoreCase("Bye"))
        	{
        	
        		qty1.append("\nPatient>" + query);
        		String reply = getReply(query);
        		qty1.append("\nBaymax>" + reply);
        		tid.setText("");
        
        	}
        	else
        	{
        	
        	qty1.append("\nPatient> Bye!");
        	qty1.append("\nBaymax> Bye! Thank you for talking to me.");
        	}
        		
        			
        			
        }		
        		
  
        else if (e.getSource() == reset)
        { 
            String def = ""; 
             
            tid.setText(def);
            qty1.setText(def);
    
                    
   
         
        } 
   
   }
    
    
    
    public static String getReply(String query)
    {
    	
    	String reply = null;
    	
    	ArrayList<String> diseases = new ArrayList<>(); 
    	
    	try 
	    {	    	
	            String url = "jdbc:mysql://localhost/medical";
	            Connection conn = DriverManager.getConnection(url,"root","root");
	            Statement stmt = conn.createStatement();	         
	            ResultSet rs;
	            rs = stmt.executeQuery("select distinct(disease) from medicalinfo;");	 
	            while(rs.next())
	            {
	            	diseases.add(rs.getString("disease"));
	            }
	            conn.close();
        } 
	    catch (Exception e1) 
	    {
            System.err.println("Got an exception! ");
            System.err.println(e1.getMessage());
        }
    	
    	ArrayList<String> facts = new ArrayList<>();
    	
    	
    	if(query.contains("hello") || query.contains("hi"))
    	{
    		reply = "Hello, I am Baymax, your personal healthcare companion!";
    	}    	
    	else if(query.contains("unwell") || query.contains("sick"))
    	{
    		reply = "Sorry to hear that. Let me help you out";
    	}
    	else if(query.contains("unwell") || query.contains("sick"))
    	{
    		reply = "Sorry to hear that. Let me help you out";
    	}
    	else
    	{
    		
    		for (int i = 0; i < diseases.size(); i++) { 
    			  
                if(query.contains(diseases.get(i))) 
                {
                	if(query.contains("symptoms"))
                	{
                		try 
                	    {	    	
                	            String url = "jdbc:mysql://localhost/medical";
                	            Connection conn = DriverManager.getConnection(url,"root","root");
                	            Statement stmt = conn.createStatement();	         
                	            ResultSet rs;
                	            rs = stmt.executeQuery("select distinct(fact) from medicalinfo where disease ='" + diseases.get(i) + "' and keyword='" + "symptom"+ "';");	 
                	            while(rs.next())
                	            {
                	            	facts.add(rs.getString("fact"));
                	            }
                	            conn.close();
                        } 
                	    catch (Exception e1) 
                	    {
                            System.err.println("Got an exception! ");
                            System.err.println(e1.getMessage());
                        }
                		
                		reply = facts.get(0);
                	}
                	else if(query.contains("treatment"))
                	{
                		
                		try 
                	    {	    	
                	            String url = "jdbc:mysql://localhost/medical";
                	            Connection conn = DriverManager.getConnection(url,"root","root");
                	            Statement stmt = conn.createStatement();	         
                	            ResultSet rs;
                	            rs = stmt.executeQuery("select distinct(fact) from medicalinfo where disease ='" + diseases.get(i) + "' and keyword='" + "treatment"+ "';");	 
                	            while(rs.next())
                	            {
                	            	facts.add(rs.getString("fact"));
                	            }
                	            conn.close();
                        } 
                	    catch (Exception e1) 
                	    {
                            System.err.println("Got an exception! ");
                            System.err.println(e1.getMessage());
                        }
                		
                		reply = facts.get(0);
                	}
                	else if(query.contains("causes"))
                	{
                		
                		try 
                	    {	    	
                	            String url = "jdbc:mysql://localhost/medical";
                	            Connection conn = DriverManager.getConnection(url,"root","root");
                	            Statement stmt = conn.createStatement();	         
                	            ResultSet rs;
                	            rs = stmt.executeQuery("select distinct(fact) from medicalinfo where disease ='" + diseases.get(i) + "' and keyword='" + "cause"+ "';");	 
                	            while(rs.next())
                	            {
                	            	facts.add(rs.getString("fact"));
                	            }
                	            conn.close();
                        } 
                	    catch (Exception e1) 
                	    {
                            System.err.println("Got an exception! ");
                            System.err.println(e1.getMessage());
                        }
                		
                		reply = facts.get(0);
                		
                	}
                	
                }
            } 
    		
    		
    		
    	}
    	
    	
    		
    	
    	
    	return reply;
    	
    }
    
        
   }





//---------------------------------------------------------------------------------------------




//-----------------------------------------------------------------------------------------------------------

public  class Patient 

{

	/**
	 * @param args
	 * @throws IOException 
	 * @throws Exception 
	 */
	@SuppressWarnings("resource")
	public void main(String[] args) throws IOException  
	{
		
		MyFrame10 f = new MyFrame10();
		
		

	}
	
	
	

}
