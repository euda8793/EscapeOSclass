<<<<<<< HEAD
package info;

import java.awt.Point;

public class PlayerInfo {

	/**
	 * Array to keep track of inventory.
	 * 0 indicates that the item is not yet gathered.
	 * 1 indicates that the user has the item.
	 * 2 indicates that the item is selected.
	 * -2 indicates that the item was gathered, but then lost.
	 */
	private int[] inventory = {0,0,0,0,0};
	
	private Point lastClickPos;
	
	/**
	 * How far the player has progressed in the game.
	 */
	private int gameProgression = 0;
	
	/**
	 * Modifies the inventory item accordingly.
	 * @param slot
	 * @param mod
	 */
	public void modifyItem(int slot, ItemMod mod)
	{
		inventory[slot] = mod.Val();
	}
	
	/**
	 * Function to increment the player's progression.
	 */
	public void incrementProgression()
	{
		gameProgression++;
	}
	
	////////////////////////
	//Getters and Setters://
	//********************//
	public int[] getInventory()
	{
		return inventory;
	}
	
	public void setLastClickPos(Point p)
	{
		lastClickPos = p;
	}
	
	public Point getLastClickPos()
	{
		return lastClickPos;
	}
	
	public int getProgression()
	{
		return gameProgression;
	}
}
=======
package info;

import java.awt.Point;

public class PlayerInfo {

	/**
	 * Array to keep track of inventory.
	 * 0 indicates that the item is not yet gathered.
	 * 1 indicates that the user has the item.
	 * 2 indicates that the item is selected.
	 * -2 indicates that the item was gathered, but then lost.
	 */
	private int[] inventory = {0,0,0,0,0,0};
	
	private Point lastClickPos;
	
	/**
	 * Modifies the inventory item accordingly.
	 * @param slot
	 * @param mod
	 */
	public void modifyItem(int slot, ItemMod mod)
	{
		inventory[slot] = mod.Val();
	}
	
	////////////////////////
	//Getters and Setters://
	//********************//
	public int[] getInventory()
	{
		return inventory;
	}
	
	public void setLastClickPos(Point p)
	{
		lastClickPos = p;
	}
	
	public Point getLastClickPos()
	{
		return lastClickPos;
	}
}
>>>>>>> branch 'master' of https://github.com/euda8793/EscapeOSclass.git
