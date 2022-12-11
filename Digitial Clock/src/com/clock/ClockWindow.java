package com.clock;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

//import   javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClockWindow extends JFrame{
	
	private JLabel headind;
	private JLabel clockLable;
	private Font font= new Font("",Font.BOLD,25);
	
  public ClockWindow() {
	  Image icon = Toolkit.getDefaultToolkit().getImage("E:\\favicon.png");  
	  super.setIconImage(icon);  
	 super.setTitle("Digital Clock");
	 super.setSize(300,300);
	 super.setLocation(200, 200);
	 super.getContentPane().setBackground(Color.ORANGE);
	 this.gui();
	 this.startClock();
	 super.setVisible(true);
  }
  
  public void gui() {
	  headind= new JLabel("Degital clock");
	  clockLable= new JLabel("clock");
	  headind.setFont(font);
	  clockLable.setFont(font);
	  this.setLayout(new GridLayout(2,1));
	  this.add(headind);
	  this.add(clockLable);
  }
  
    public void startClock() {
//	Timer tm= new Timer(1000,new ActionListener() {
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			Date date = new Date();
//			 SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss: a, dd-MM-yy");
//		       String str = formatter.format(date);
//		    clockLable.setText(str);
//		}
//	});
//	tm.start();
	
	Thread t=new Thread() {
		public void run() {
			try {
				while(true) {
					Date date = new Date();
					 SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss: a, dd-MM-yy");
				       String str = formatter.format(date);
				    clockLable.setText(str);
				    Thread.sleep(1000);
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	};
    t.start();
  }
}
