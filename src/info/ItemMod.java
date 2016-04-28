package info;

/**
 * ENUM to specify how an inventory item is modified.
 * @author Stephen
 *
 */
public enum ItemMod {
	DELETE(-2),ADD(1),SELECT(1),DESELECT(1);
	
	private int val = 0;
	
	ItemMod(int i)
	{
		val = i;
	}
	
	public int Val()
	{
		return val;
	}
}
