package deprecated;

import java.awt.Point;
import java.awt.Rectangle;

import info.ItemMod;

/**
 * A class that specifies how two scenes are linked.
 * @author Stephen
 *
 */
public class SceneLink
{
	/**
	 * Values that must be satisfied to use this link.
	 * -1 indicates that the corresponding items slot may have any value.
	 * Any other value means that the items slot must have the same value.
	 */
	private int[] inventoryReqs = {-1,-1,-1,-1,-1};
	
	/**
	 * The area that may be clicked to activate the link.
	 * We assume that there are no overlapping areas in any scene that have the same inventory conditions.
	 */
	private Rectangle clickRegion;
	
	/**
	 * The item modification that should be performed, if any.
	 * This is useful if clicking on something adds an item.
	 */
	private ItemMod mod = null;
	
	/**
	 * The slot of the item to be modified.
	 */
	private int modSlot;
	
	/**
	 * The scene that the linker links to.
	 */
	private int linkLabel;
	
	/**
	 * Constructor.
	 */
	public SceneLink(int[] inventoryReqs, Rectangle clickRegion, ItemMod mod, int modSlot, int linkLabel)
	{
		this.inventoryReqs = inventoryReqs;
		this.clickRegion = clickRegion;
		this.mod = mod;
		this.linkLabel = linkLabel;
	}
	
	/**
	 * Function to check if the player can link between scenes given their inventory and clicking location.
	 * @param p The clicked location.
	 * @param inventory The player inventory.
	 * @return -1 if the 
	 */
	public boolean linkValid(Point p, int[] inventory)
	{
		boolean valid = true;
		
		//Check that inventory requirements are matched:
		for(int i = 0; i < inventory.length; i++)
		{
			if(inventoryReqs[i] == -1)
				continue;
			if(inventoryReqs[i] != inventory[i])
				valid = false;
		}
		
		//Check that the point is valid:
		if(!clickRegion.contains(p))
			valid = false;
		
		return valid;
	}
	
	////////////////////////
	//Getters and Setters://
	//********************//
	public int getLinkedScene()
	{
		return linkLabel;
	}
	
	public int getModSlot()
	{
		return modSlot;
	}
	
	public ItemMod getMod()
	{
		return mod;
	}
}
