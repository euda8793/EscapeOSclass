package listeners;

import java.awt.Image;
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
import info.SceneInfo;
import info.SceneLink;
import utility.SceneBuilder;

public class PanelListener implements MouseListener
{
	/**
	 * The set of all the scenes.
	 */
	private ArrayList<SceneInfo> scenes = SceneBuilder.build();	
	
	/**
	 * The label of the current scene that we are in.
	 */
	private int currentScene = 0;
	
	/**
	 * The information of the player.
	 */
	private PlayerInfo info;
	
	/**
	 * The surface that we display the images to.
	 */
	private ImageIcon display;
	
	/**
	 * The buttons for item selection.
	 */
	private JButton[] buttons;
	
	/**
	 * The path to the base name ("E.g. \images\button_ out of \images\button_3") for the button images.
	 * The item images should be set so that we can reference them as:
	 * BUTTON_IMAGE_PATH + [image number]
	 * E.g. buttonImg_0, buttonImg_1, buttonImg_2, ect...
	 */
	private static final String BUTTON_IMAGE_PATH = "";//TODO
	
	/**
	 * Constructor. Sets the initial image on the ImageIcon to be the image of the first scene.
	 */
	public PanelListener(PlayerInfo info, ImageIcon display, JButton[] buttons)
	{
		this.info = info;
		this.display = display;
		this.buttons = buttons;
		for(JButton b : this.buttons)//Second check.
			b.setEnabled(false);
		this.display.setImage(scenes.get(currentScene).getImage());//Sets the image.
	}
	
	/**
	 * Private function to set up a button if an item is added or deleted.
	 * Adds/deletes the item image and enables/disables the button accordingly.
	 * @param slot The slot number of the button.
	 * @param active If the item is now in the inventory.
	 */
	private static void setButton(JButton[] buttons, int slot, boolean active)
	{
		JButton button = buttons[slot];
		
		if(active)
		{
			BufferedImage img = null;
			try {
			    img = ImageIO.read(new File(BUTTON_IMAGE_PATH + new Integer(slot).toString()));
			}
			catch (IOException e) {}
			button.setIcon(new ImageIcon(img));
			button.setEnabled(true);
		}
		else
		{
			button.setIcon(null);
			button.setEnabled(false);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {//TODO: set all buttons to false at the start.
		//Set the last point and the scene link if there is one.:
		info.setLastClickPos(e.getPoint());
		SceneLink link = scenes.get(currentScene).getLink(info);
		
		if(link == null)
			return;
		
		//Else, we have something. The Scene will change and/or the inventory will change.
		currentScene = link.getLinkedScene();
		ItemMod mod = link.getMod();
		if(mod != null)//Modify an item.
		{
			int slot = link.getModSlot();
			info.modifyItem(slot, mod);
			
			//Change the button image:
			if(mod == ItemMod.ADD)
				setButton(buttons, slot,true);
			else if(mod == ItemMod.DELETE)
				setButton(buttons, slot,false);
		}
		
		//Update the image; use the old size:
		Image oldImage = display.getImage();
		display.setImage(scenes.get(currentScene).getImage());
		display.setImage(display.getImage().getScaledInstance(oldImage.getWidth(null), oldImage.getHeight(null), Image.SCALE_FAST));
	}
	
	
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
}
