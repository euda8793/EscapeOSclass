<<<<<<< HEAD
package listeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import info.ItemMod;
import info.PlayerInfo;

/**
 * Class for the buttons on the 
 * @author Stephen
 *
 */
public class ButtonListener implements ActionListener{
	
	/**
	 * Information about the player.
	 */
	private PlayerInfo info;
	
	/**
	 * The number of the item in the inventory. 0-5.
	 */
	private int imageNum;
	
	/**
	 * The button for the item selection.
	 */
	private JButton[] buttons;
	
	/**
	 * The border for when an item is not in the inventory or not selected.
	 */
	private static Border deselectBorder = new LineBorder(Color.BLACK, 4);
	/**
	 * The border for when an item is selected.
	 */
	private static Border selectBorder = new LineBorder(Color.YELLOW, 8);
	
	
	/**
	 * Constructor. Takes the references to the appropriate information.
	 * @param button The buttons of the game.
	 * @param imageNum The number for this button and its image.
	 * @param info The player information.
	 */
	public ButtonListener(JButton[] buttons, int imageNum, PlayerInfo info)
	{
		this.buttons = buttons;//We use this to apply a filter to show that an object is selected.
		this.imageNum = imageNum;
		this.info = info;
		this.buttons[this.imageNum].setBorder(deselectBorder);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int[] inventory = info.getInventory();
		if(inventory[imageNum] == 1)//If the item is unselected but in the inventoy.
		{
			for(int i = 0; i < inventory.length; i++)
			{
				if(inventory[i] == 2)//Selected items.
				{
					info.modifyItem(i, ItemMod.DESELECT);//Deselect any currently selected item.
					buttons[i].setBorder(deselectBorder);
				}
			}
			info.modifyItem(imageNum, ItemMod.SELECT);
			buttons[imageNum].setBorder(selectBorder);
		}
		else if (inventory[imageNum] == 2)//The item is already selected. We now deselect it.
		{
			info.modifyItem(imageNum, ItemMod.DESELECT);
			buttons[imageNum].setBorder(selectBorder);
		}
	}
}
=======
package listeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import info.ItemMod;
import info.PlayerInfo;

/**
 * Class for the buttons on the 
 * @author Stephen
 *
 */
public class ButtonListener implements ActionListener{
	
	/**
	 * Information about the player.
	 */
	private PlayerInfo info;
	
	/**
	 * The number of the item in the inventory. 0-5.
	 */
	private int imageNum;
	
	/**
	 * The button for the item selection.
	 */
	private JButton[] buttons;
	
	/**
	 * The border for when an item is not in the inventory or not selected.
	 */
	private static Border deselectBorder = new LineBorder(Color.BLACK, 4);
	/**
	 * The border for when an item is selected.
	 */
	private static Border selectBorder = new LineBorder(Color.YELLOW, 8);
	
	
	/**
	 * Constructor. Takes the references to the appropriate information.
	 * @param button The buttons of the game.
	 * @param imageNum The number for this button and its image.
	 * @param info The player information.
	 */
	public ButtonListener(JButton[] buttons, int imageNum, PlayerInfo info)
	{
		this.buttons = buttons;//We use this to apply a filter to show that an object is selected.
		this.imageNum = imageNum;
		this.info = info;
		this.buttons[this.imageNum].setBorder(deselectBorder);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		// TODO: update player info and change cursor image.
		int[] inventory = info.getInventory();
		if(inventory[imageNum] == 1)//If the item is unselected but in the inventoy.
		{
			for(int i = 0; i < inventory.length; i++)
			{
				if(inventory[i] == 2)//Selected items.
				{
					info.modifyItem(i, ItemMod.DESELECT);//Deselect any currently selected item.
					buttons[i].setBorder(deselectBorder);
				}
			}
			info.modifyItem(imageNum, ItemMod.SELECT);
			buttons[imageNum].setBorder(selectBorder);
		}
		else if (inventory[imageNum] == 2)//The item is already selected. We now deselect it.
		{
			info.modifyItem(imageNum, ItemMod.DESELECT);
			buttons[imageNum].setBorder(selectBorder);
		}
		//TODO: change the cursor?
	}
}
>>>>>>> branch 'master' of https://github.com/euda8793/EscapeOSclass.git
