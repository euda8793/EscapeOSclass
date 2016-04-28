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
