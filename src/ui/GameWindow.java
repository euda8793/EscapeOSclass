package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameWindow extends JFrame{
	
	JPanel pan1;
	JPanel pan2;
	JPanel pan3;
	JLabel lab1;
	
	
	public GameWindow(String title){
		
		//JFrame layout
		super(title);
		setSize(1135, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 100, 1135, 800);
		
		//insert panels
		pan1 = new JPanel();
		pan2 = new JPanel();
		pan3 = new JPanel();
		
		
		//Label 
		lab1 = new JLabel();
		Image img = (new ImageIcon("PrisonBG.jpg")).getImage();
		Image newimg = img.getScaledInstance(1090, 550,  java.awt.Image.SCALE_FAST);
		lab1.setIcon(new ImageIcon(newimg));
		pan2.add(lab1);
		lab1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
		pan2.setBackground(Color.BLACK);
		pan1.add(pan2);
		pan3.setBorder(BorderFactory.createLoweredBevelBorder());
		pan1.add(pan3);
		pan3.setPreferredSize(new Dimension(1100, 145));
		pan3.setBackground(Color.gray);
		pan1.setBackground(Color.BLACK);
		this.add(pan1);
		
		//Menu
		JMenu i1 = new JMenu("File");
		JMenuItem i3 = new JMenuItem("Exit");
		i1.add(i3);
		JMenu i2 = new JMenu("Help");
		JMenuItem i4 = new JMenuItem("What to do?");
		i2.add(i4);
		JMenuBar mb = new JMenuBar();
		mb.add(i1);
		mb.add(i2);
		
		
		
		this.setJMenuBar(mb);
		
		
		this.setVisible(true);
		
		
		
		
		
	}
	
	
	
	
	

}
