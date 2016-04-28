package listeners;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import info.ItemMod;
import info.PlayerInfo;

/**
 * Class to implement the main logic of the game. Some additional information and methods
 * outside of the game progression are included in here.
 * @author Stephen
 *
 */
public class SpeedListener implements MouseListener
{	
	/**
	 * Player's information.
	 */
	private PlayerInfo info;
	
	/**
	 * Where we are displaying images to.
	 */
	private ImageIcon display;
	
	/**
	 * The buttons that have selectable objects in them.
	 */
	private JButton[] buttons;
	
	/**
	 * The images used in the main display.
	 */
	private ArrayList<BufferedImage> images;
	
	/**
	 * The names of the images used in the display.
	 */
	private static String[] IMAGE_NAMES = {"PrisonBG","PrisonBG","PrisonBG","PrisonBG2","PrisonBG3","PrisonBG4","PrisonBG5"};
	
	/**
	 * The names of the button images to display.
	 */
	private static String[] BUTTON_IMAGE_NAMES = {};
	
	/**
	 * The areas where we have to click to progress.
	 */
	private static Rectangle[] CLICK_AREAS = {};
	
	public SpeedListener(PlayerInfo info, ImageIcon display, JButton[] buttons)
	{
		this.info = info;
		this.display = display;
		this.buttons = buttons;
		for(JButton b : this.buttons)//Second check.
			b.setEnabled(false);
		buildImages();
	}
	
	/**
	 * Method to set up the images for the game.
	 */
	private void buildImages()
	{
		for(String s : IMAGE_NAMES)
		{
			BufferedImage img = null;
			try {
			    img = ImageIO.read(new File(s));
			}
			catch (IOException e) {}
			images.add(img);
		}
	}
	
	public void updateImage()
	{
		Image oldImage = display.getImage();
		display.setImage(images.get(info.getProgression()));
		display.setImage(display.getImage().getScaledInstance(oldImage.getWidth(null), oldImage.getHeight(null), Image.SCALE_FAST));
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		//Main logic of the game:
		switch(info.getProgression()){
			case 0://Click on the note.
				if(CLICK_AREAS[0].contains(e.getPoint()))
				{
					info.modifyItem(0, ItemMod.ADD);
					info.incrementProgression();
					this.activateButton(0);
				}
				break;
			case 1://Read the note.
				//Nothing happens, the user must "read" the note.
				break;
			case 2://Call the warden.
				//Nothing happens, the user must call the warden.
				break;
			case 3://Click on ceiling with spaghetti; new image.
				if(CLICK_AREAS[3].contains(e.getPoint()))
				{
					info.incrementProgression();
				}
				break;
			case 4://Click on mattress; new image.
				if(CLICK_AREAS[4].contains(e.getPoint()))
				{
					info.incrementProgression();
				}
				break;
			case 5://Click near the character with sauce; new image.
				if(CLICK_AREAS[5].contains(e.getPoint()))
				{
					info.incrementProgression();
				}
				break;
			case 6:
				//Game wait and then we're done; displays a final image when the game is done.
				break;
			case 7:
				//Wait here displaying the final image.
				break;
		}
		//Always update after a click:
		updateImage();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mousePressed(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
	
	///////////////////
	//Static Methods://
	///////////////////
	/**
	 * Private function to activate a button and add an image of its item.
	 * @param slot The slot number of the button.
	 * @param active If the item is now in the inventory.
	 */
	public void activateButton(int slot)
	{
		JButton button = buttons[slot];
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(BUTTON_IMAGE_NAMES[slot]));
		}
		catch (IOException e) {}
		button.setIcon(new ImageIcon(img));
		button.setEnabled(true);
	}
}
