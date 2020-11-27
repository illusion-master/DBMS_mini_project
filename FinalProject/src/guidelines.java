

import java.awt.Color;
import java.awt.Container;


import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
import java.sql.Statement;

import javax.swing.*; 
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;



class MyFrame12 extends JFrame implements ActionListener 
{ 
	  
    // Components of the Form 
    private Container c; 
    private JTextArea a1;
    private JLabel a;
    private JButton b;
    private JButton b1;

    public MyFrame12() throws IOException 
    { 
    	
    	setTitle("Rulebook for Application Usage"); 
    	setBounds(300,90,700,700);
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE); 
        setResizable(true); 
        setBackground(Color.BLACK);
      
        
        
        
        BufferedImage img = ImageIO.read(new File("C:/Users/Aboli/Desktop/TE/imgs/o5.jpg"));
        JLabel background = new JLabel(new ImageIcon(img));
        background.setSize(5000,5000);
        
        setContentPane(background);
        setLayout(null);
 
        
        
        
        
        /////////////////////////////////////////////////////////
        
        a1 = new JTextArea();
        a1.setText("\n1. To Operate as Admin");
        a1.append("\n\tSign up and create an account with password admin\n\tYou can search branch of doctor, disease of patient or cancelled appointments under your clinic.");
        a1.append("\n\n2. To Operate as Doctor");
        a1.append("\n\tSign up and create account with password doctor\n\tClick to see upcoming appointments, patient statistics or medical queries from the patients.");
        a1.append("\n\n3. To Operate as Patient");
        a1.append("\n\tSign up and create account with password patient\n\tClick book to book a new appointment, and enter the details of the slot that you want from the dashboard above the form. \n\tYou can book tickets using either manual entry or a bot. \n\tTo cancel your ticket simply enter your appointment details into cancellation window \n\tTo modify the booking, enter new appoinment details in the modification window.\n\t You can also check your upcoming appointments and your current diet and exercise plan on weekly calender as well. ");
        a1.setFont(new Font("Arial", Font.BOLD, 20)); 
        a1.setBounds(200, 180 , 1600 ,590); 
        a1.setBackground(Color.BLACK);
        a1.setForeground(Color.WHITE);
        a1.setBorder(BorderFactory.createLineBorder(Color.magenta, 10));
        add(a1); 
        
       
        setVisible(true);
    }


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
					if(e.getSource()==b)
					{
						
						server aut = new server(); 
			        	try 
			        	{
							aut.main(new String[0]);
						} catch (InterruptedException e1) 
			        	{
					
							e1.printStackTrace();
						} catch (Exception e1) 
			        	{
							// TODO Auto-generated catch block
							e1.printStackTrace();
			        	}
					}
					
					
					
	}
	
}

    









public class guidelines 
{
	
	public static void main(String[] args) throws IOException
	{
		MyFrame12 f = new MyFrame12();
	}

}
