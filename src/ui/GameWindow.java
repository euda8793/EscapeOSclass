package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class GameWindow extends JFrame{
	
	JPanel pan1;
	JPanel pan2;
	JPanel pan3;
	
	//custom label
	ILabel lab1;
	
	
	public GameWindow(String title){
		
		//JFrame layout
		super(title);
		setSize(1135, 850);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 100, 1135, 850);
		
		//insert panels
		pan1 = new JPanel();
		pan2 = new JPanel();
		pan3 = new JPanel();
		
		
		//Label 
		lab1 = new ILabel();
		pan2.add(lab1);
		pan2.setBackground(Color.BLACK);
		pan1.add(pan2);
		pan3.setLayout(new FlowLayout(FlowLayout.LEFT));
		pan3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredSoftBevelBorder(), "Inventory", TitledBorder.CENTER, TitledBorder.CENTER,pan3.getFont(), Color.BLACK));
		pan1.add(pan3);
		pan3.setPreferredSize(new Dimension(1100, 195));
		pan3.setBackground(Color.gray);
		pan1.setBackground(Color.BLACK);
		this.add(pan1);
		
		//Menu
		JMenu i1 = new JMenu("File");
		JMenuItem i3 = new JMenuItem("Exit");
		i3.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				Runtime.getRuntime().exit(0);
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
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
	
	//new button class
	private class IButton extends JButton{
		
		public IButton(String filename){//place the name of the picture file in here, formatting is handled here.
			
			this.setSize(140, 140);
			this.setBackground(Color.gray);
			Image img = (new ImageIcon(filename)).getImage();
			Image newimg = img.getScaledInstance(70, 70,  java.awt.Image.SCALE_FAST);
			this.setIcon(new ImageIcon(newimg));
			this.setMargin(new Insets(0, 0, 0, 0));
		}
		
	}
	
	//new label class
	private class ILabel extends JLabel{
		
		public ILabel(){//creates a bordered label, sizes then adds the default image
			
			this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
			Image img = (new ImageIcon("PrisonBG.jpg")).getImage();
			Image newimg = img.getScaledInstance(1090, 550,  java.awt.Image.SCALE_FAST);
			this.setIcon(new ImageIcon(newimg));
		}
		
		public void switchImage(String filename){//set icon's image to another one, takes a string filename
			
			Image img = (new ImageIcon(filename)).getImage();
			Image newimg = img.getScaledInstance(1090, 550,  java.awt.Image.SCALE_FAST);
			this.setIcon(new ImageIcon(newimg));
			
		}
	}
	
	

}


