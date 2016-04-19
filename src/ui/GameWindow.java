package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class GameWindow extends JFrame{
	
	protected JPanel pan1;
	protected JPanel pan2;
	protected JPanel pan3;
	protected JPanel pan4;
	protected JTextField tf;
	
	private int charIndex;
	
	//custom label
	ILabel lab1;
	
	public GameWindow(String title){
		
		
		
		//JFrame layout
		super(title);
		setSize(1135, 850);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 100, 1135, 840);
		
		//insert panels
		pan1 = new JPanel();
		pan2 = new JPanel();
		pan3 = new JPanel();
		pan4 = new JPanel();
		
		
		//Panels set upt
		lab1 = new ILabel();
		pan2.add(lab1);
		pan2.setBackground(Color.BLACK);
		pan1.add(pan2);
		pan3.setLayout(new FlowLayout(FlowLayout.LEFT));
		pan3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredSoftBevelBorder(), "Inventory", TitledBorder.CENTER, TitledBorder.CENTER,pan3.getFont(), Color.YELLOW));
		pan1.add(pan3);
		pan3.setPreferredSize(new Dimension(1100, 140));
		pan3.setBackground(Color.gray);
		pan3.add(new IButton("PrisonBG.jpg"));
		tf = new JTextField();
		tf.setPreferredSize(new Dimension(1100, 40));
		tf.setEnabled(false);
		tf.setDisabledTextColor(Color.YELLOW);
		tf.setFont(new Font("Verdana", Font.BOLD, 12));
		tf.setBackground(Color.BLACK);
		tf.setBorder(BorderFactory.createEmptyBorder());
		pan4.setLayout(new GridLayout());
		pan4.add(tf);
		pan1.setBackground(Color.BLACK);
		pan1.add(pan4);
		this.add(pan1);
		
		//animate the text at startup
		animateText(tf, "Welcome to Escape OS!");
		
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
		JMenuItem i4 = new JMenuItem("Stuck?");
		i2.add(i4);
		JMenuBar mb = new JMenuBar();
		mb.add(i1);
		mb.add(i2);
		
		this.setJMenuBar(mb);
		
		
		
		this.setVisible(true);
		
	}
	
	//new button class
	private class IButton extends JButton{
		
		boolean clicked;
		
		public IButton(String filename){//place the name of the picture file in here, formatting is handled here.
			
			clicked = false;
			this.setSize(140, 140);
			this.setBackground(Color.gray);
			Image img = (new ImageIcon(filename)).getImage();
			Image newimg = img.getScaledInstance(100, 100,  java.awt.Image.SCALE_FAST);
			this.setIcon(new ImageIcon(newimg));
			this.setMargin(new Insets(0, 0, 0, 0));
			this.setBorder(BorderFactory.createRaisedBevelBorder());

			
			this.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					if(clicked){//deselect button
						
						IButton.this.setBorder(BorderFactory.createRaisedBevelBorder());
						
						clicked = false;
					}else{//select button
						
						IButton.this.setBorder(BorderFactory.createLoweredBevelBorder());
						//code for using the button here
						
						clicked = true;
					
						
						
						
						
						
					}
					
				}
				
			});
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
	
	//animate text to look like its being typed
	private void animateText(JTextField jtf, String tex){
	     
		charIndex = 0;

		 Timer timer = new Timer(80, new ActionListener() {//set the timer to type a letter into the field than wait 80 ms
             @Override
             public void actionPerformed(ActionEvent e) {
                 String labelText = jtf.getText();
                 labelText += tex.charAt(charIndex);
                 jtf.setText(labelText);
                 charIndex++;
                 if (charIndex >= tex.length()) {
                     ((Timer)e.getSource()).stop();
                 }
             }
         });
         timer.start();
	}
	
	
	
	

}


